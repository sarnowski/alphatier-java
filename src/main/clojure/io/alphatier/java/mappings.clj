(ns io.alphatier.java.mappings
  (:import (io.alphatier.java Snapshot Executor Status Task LifecyclePhase LazySnapshot CommitResult Commit
                              CommitCreateAction CommitUpdateAction CommitKillAction CommitAction ExecutorRegistration
                              ConstraintType))
  (:require [io.alphatier.schedulers :as schedulers]
            [io.alphatier.pools :as pools]
            [clojure.core.memoize :as memoize]))

(defn with-default [default value]
  (if (nil? value)
    default
    value))

(defn to-map
  ([key value] (to-map key value (complement nil?)))
  ([key value test] (if (test value) {key value} {})))

(def to-Status
  {:registered Status/REGISTERED
   :unregistered Status/UNREGISTERED})

(def from-Status
  {Status/REGISTERED :registered
   Status/UNREGISTERED :unregistered})

(defn to-Executor [executor]
  (Executor. (:id executor)
             (to-Status (:status executor))
             (:resources executor)
             (:metadata executor)
             (:metadata-version executor)
             (:task-ids executor)
             (:task-ids-version executor)))

(defn from-Executor [^Executor executor]
  {:id (.getId executor)
   :status (from-Status (.getStatus executor))
   :resources (.getResources executor)
   :metadata (.getMetadata executor)
   :metadata-version (.getMetadataVersion executor)
   :task-ids (.getTaskIds executor)
   :task-ids-version (.getTaskIdsVersion executor)})

(def to-LifecyclePhase
  {:create LifecyclePhase/CREATE
   :creating LifecyclePhase/CREATING
   :created LifecyclePhase/CREATED
   :kill LifecyclePhase/KILL
   :killing LifecyclePhase/KILLING })

(def from-LifecyclePhase
  {LifecyclePhase/CREATE :create
   LifecyclePhase/CREATING :creating
   LifecyclePhase/CREATED :created
   LifecyclePhase/KILL :kill
   LifecyclePhase/KILLING :killing})

(defn to-Task [task]
  (Task. (:id task)
         (:executor-id task)
         (:scheduler-id task)
         (to-LifecyclePhase (:lifecycle-phase task))
         (:resources task)
         (:metadata task)
         (:metadata-version task)))

(defn from-Task [^Task task]
  {:id (.getId task)
   :executor-id (.getExecutorId task)
   :scheduler-id (.getSchedulerId task)
   :lifecycle-phase (from-LifecyclePhase (.getLifecyclePhase task))
   :resources (.getResources task)
   :metadata (.getMetadata task)
   :metadata-version (.getMetadataVersion task)})

(defn- to-Snapshot' [snapshot]
  (Snapshot. (doall (into {} (map (fn [[k v]] [k (to-Executor v)]) (:executors snapshot))))
             (doall (into {} (map (fn [[k v]] [k (to-Task v)]) (:tasks snapshot))))))

(def to-Snapshot
  (memoize/lru to-Snapshot'))

(defn to-LazySnapshot [snapshot]
  (reify LazySnapshot
    (getSnapshot [_]
      (if snapshot
        (to-Snapshot snapshot)
        nil))))

(defn from-Snapshot [^Snapshot snapshot]
  {:executors (into {} (map (fn [[k v]] [k (from-Executor v)]) (.getExecutors snapshot)))
   :tasks (into {} (map (fn [[k v]] [k (from-Task v)]) (.getTasks snapshot)))})

(defn to-original [value]
  (:original (meta value)))

(defn to-CommitResult [result]
  (CommitResult.  (doall (map to-original (:accepted-actions result)))
                  (doall (into {} (map (fn [[c t]] [(name c) (to-original t)]) (:rejected-actions result))))
                  (to-LazySnapshot (:pre-snapshot result))
                  (to-LazySnapshot (:post-snapshot result))))

(defn- from-CommitTaskBase [^CommitAction task]
  (merge {:id (.getTaskId task)}
         (to-map :executor-metadata-version (.getExecutorMetadataVersion task))
         (to-map :executor-task-ids-version (.getExecutorTaskIdsVersion task))))

(defmulti from-CommitTask class)

(defmethod from-CommitTask CommitCreateAction [task]
  (with-meta
    (merge
      (from-CommitTaskBase task)
      {:type :create
       :executor-id (.getExecutorId task)
       :resources (into {} (.getResources task))
       :metadata (into {} (.getMetadata task))})
    {:original task}))

(defmethod from-CommitTask CommitUpdateAction [task]
  (with-meta
    (merge
      (from-CommitTaskBase task)
      {:type :update
       :metadata (into {} (.getMetadata task))}
      (to-map :metadata-version (.getMetadataVersion task)))
    {:original task}))

(defmethod from-CommitTask CommitKillAction [task]
  (with-meta
    (merge
      (from-CommitTaskBase task)
      {:type :kill}
      (to-map :metadata-version (.getMetadataVersion task)))
    {:original task}))

(defn from-Commit [^Commit commit]
  (with-meta
    (pools/map->Commit {:scheduler-id (.getSchedulerId commit)
                        :actions (map from-CommitTask (.getActions commit))
                        :allow-partial-commit (.isAllowPartialCommit commit)})
    {:original commit}))

(defn from-Task [^Task task]
  (pools/map->Task {:id (.getId task)
                    :executor-id (.getExecutorId task)
                    :scheduler-id (.getSchedulerId task)
                    :lifecycle-phase (from-LifecyclePhase (.getLifecyclePhase task))
                    :resources (into {} (.getResources task))
                    :metadata (into {} (.getMetadata task))
                    :metadata-version (.getMetadataVersion task)}))

(def from-ConstraintType
  {ConstraintType/PRE :pre
   ConstraintType/POST :post})
