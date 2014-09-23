(ns io.alphatier.java.schedulers
  (:import (io.alphatier.java Pool Commit))
  (:require [io.alphatier.schedulers :as schedulers])
  (:gen-class
    :name "io.alphatier.java.ClojureSchedulers"
    :implements [io.alphatier.java.Schedulers]))

(defn -commit [^Pool pool ^Commit commit]
  (schedulers/commit (.getPool pool) commit :force false))

(defn -forcedCommit [^Pool pool ^Commit commit]
  (schedulers/commit (.getPool pool) commit :force true))
