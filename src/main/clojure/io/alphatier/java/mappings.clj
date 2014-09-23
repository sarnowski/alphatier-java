(ns io.alphatier.java.mappings
  (:import (io.alphatier.java Snapshot Executor Status Task LifecyclePhase LazySnapshot CommitResult Commit
                              CommitCreateTask CommitUpdateTask CommitKillTask CommitTask))
  (:require [io.alphatier.schedulers :as schedulers]))

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

(defn- to-original [value]
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
       :resources (.getResources task)
       :metadata (.getMetadata task)})
    {:original task}))

(defmethod from-CommitTask CommitUpdateTask [task]
  (with-meta
    (merge
      (from-CommitTaskBase task)
      {:action :update
       :metadata (.getMetadata task)})
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
