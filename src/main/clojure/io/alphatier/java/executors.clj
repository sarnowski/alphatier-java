(ns io.alphatier.java.executors
  (:require [io.alphatier.executors :as executors]
            [io.alphatier.java.mappings :as mappings])
  (:gen-class
    :name "io.alphatier.java.ClojureExecutors"
    :implements [io.alphatier.java.Executors])
  (:import (io.alphatier.java ExecutorRegistration Pool LifecyclePhase)))

(defn -register [_ ^Pool pool ^ExecutorRegistration registration]
  (executors/register (.getPool pool)
                      (.getId registration)
                      (.getResources registration)
                      :metadata (into {} (.getMetadata registration))
                      :metadata-version (.getMetadataVersion registration)
                      :tasks (map mappings/from-Task (.getTasks registration))
                      :task-ids-version (.getTaskIdsVersion registration)))

(defn -update [_ ^Pool pool ^String executor-id metadata]
  (executors/update (.getPool pool) executor-id (into {} metadata)))

(defn -unregister [_ ^Pool pool ^String executor-id]
  (executors/unregister (.getPool pool) executor-id))

(defn -updateTask [_ ^Pool pool ^String task-id ^LifecyclePhase lifecycle-phase metadata]
  (executors/update-task (.getPool pool)
                         task-id
                         (mappings/from-LifecyclePhase lifecycle-phase)
                         (into {} metadata)))

(defn -killTask [_ ^Pool pool ^String task-id]
  (executors/kill-task (.getPool pool) task-id))
