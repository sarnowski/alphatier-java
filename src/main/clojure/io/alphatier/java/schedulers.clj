(ns io.alphatier.java.schedulers
  (:import (io.alphatier.java Pool Commit CommitRejectedException)
           (clojure.lang ExceptionInfo))
  (:require [io.alphatier.schedulers :as schedulers]
            [io.alphatier.java.mappings :as mappings])
  (:gen-class
    :name io.alphatier.java.InternalSchedulers
    :implements [io.alphatier.java.Schedulers]))

(defn -commit [_ ^Pool pool ^Commit commit]
  (try
    (let [commit (mappings/from-Commit commit)]
      (mappings/to-CommitResult
        (schedulers/commit (.getPool pool) commit :force false)))
    (catch ExceptionInfo e
      (throw (CommitRejectedException.
               (.getMessage e)
               (mappings/to-CommitResult (ex-data e)))))))

(defn -forcedCommit [_ ^Pool pool ^Commit commit]
  (mappings/to-CommitResult
    (let [commit (mappings/from-Commit commit)]
      (schedulers/commit (.getPool pool) commit :force true))))
