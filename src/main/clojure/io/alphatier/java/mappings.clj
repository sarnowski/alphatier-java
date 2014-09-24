(ns io.alphatier.java.mappings
  (:import (io.alphatier.java Snapshot Executor Status Task LifecyclePhase LazySnapshot CommitResult Commit
                              CommitCreateTask CommitUpdateTask CommitKillTask CommitTask ExecutorRegistration))
  (:require [io.alphatier.schedulers :as schedulers]
            [io.alphatier.pools :as pools]))

(def to-Status
  {:registered Status/REGISTERED
   :unregistered Status/UNREGISTERED})

(defn to-Executor [executor]
  (Executor. (:id executor)
             (to-Status (:status executor))
             (:resources executor)
             (:metadata executor)
             (:metadata-version executor)
             (:task-ids executor)
             (:task-ids-version executor)))

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
  (Task.(:id task)
        (:executor-id task)
        (to-LifecyclePhase (:lifecycle-phase task))
        (:resources task)
        (:metadata task)
        (:metadata-version task)))

(defn to-Snapshot [snapshot]
  (Snapshot. (doall (map to-Executor (:executors snapshot)))
             (doall (map to-Task (:tasks snapshot)))))

(defn to-LazySnapshot [snapshot]
  (reify LazySnapshot
    (getSnapshot [_]
      (if snapshot
        (to-Snapshot snapshot)
        nil))))

(defn from-Snapshot [snapshot]
  (throw (UnsupportedOperationException. "from-Snapshot")))

(defn to-original [value]
  (:original (meta value)))

(defn to-CommitResult [result]
  (CommitResult.  (doall (map to-original (:accepted-tasks result)))
                  (doall (into {} (map (fn [[c t]] [c (to-original t)]) (:rejected-tasks result))))
                  (to-LazySnapshot (:pre-snapshot result))
                  (to-LazySnapshot (:post-snapshot result))))

(defn- from-CommitTaskBase [^CommitTask task]
  {:id (.getTaskId task)
   :metadata-version (.getMetadataVersion task)
   :executor-metadata-version (.getExecutorMetadataVersion task)
   :executor-task-ids-version (.getExecutorTaskIdsVersion task)})

(defmulti from-CommitTask class)

(defmethod from-CommitTask CommitCreateTask [task]
  (with-meta
    (merge
      (from-CommitTaskBase task)
      {:action :create
       :executor-id (.getExecutorId task)
       :resources (into {} (.getResources task))
       :metadata (into {} (.getMetadata task))})
    {:original task}))

(defmethod from-CommitTask CommitUpdateTask [task]
  (with-meta
    (merge
      (from-CommitTaskBase task)
      {:action :update
       :metadata (into {} (.getMetadata task))})
    {:original task}))

(defmethod from-CommitTask CommitKillTask [task]
  (with-meta
    (merge
      (from-CommitTaskBase task)
      {:action :kill})
    {:original task}))

(defn from-Commit [^Commit commit]
  (with-meta
    (schedulers/map->Commit {:scheduler-id (.getSchedulerId commit)
                             :tasks (map from-CommitTask (.getTasks commit))
                             :allow-partial-commit (.isAllowPartialCommit commit)})
    {:original commit}))

(defn from-Task [^Task task]
  (pools/map->Task {:id (.getId task)
                    :executor-id (.getExecutorId task)
                    :lifecycle-phase (from-LifecyclePhase (.getLifecyclePhase task))
                    :resources (into {} (.getResources task))
                    :metadata (into {} (.getMetadata task))
                    :metadata-version (.getMetadataVersion task)}))

(defn from-ExecutorRegistration [^ExecutorRegistration reg]
  {:id (.getId reg)
   :resources (into {} (.getResources reg))
   :metadata (into {} (.getMetadata reg))
   :metadata-version (.getMetadataVersion reg)
   :tasks (map from-Task (.getTasks reg))
   :task-ids-version (.getTaskIdsVersion reg)})
