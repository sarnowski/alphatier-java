(ns io.alphatier.java.schedulers
  (:import (io.alphatier.java Pool Commit CommitRejectedException)
           (clojure.lang ExceptionInfo))
  (:require [io.alphatier.schedulers :as schedulers]
            [io.alphatier.java.mappings :as mappings])
  (:gen-class
    :name "io.alphatier.java.ClojureSchedulers"
    :implements [io.alphatier.java.Schedulers]))

(defn -commit [_ ^Pool pool ^Commit commit]
  (try
    (mappings/to-CommitResult
      (schedulers/commit (.getPool pool)
                         (mappings/from-Commit commit)
                         :force false))
    (catch ExceptionInfo e
      (throw (CommitRejectedException.
               (mappings/to-CommitResult (ex-data e)))))))

(defn -forcedCommit [_ ^Pool pool ^Commit commit]
  (mappings/to-CommitResult
    (schedulers/commit (.getPool pool)
                       (mappings/from-Commit commit)
                       :force true)))
