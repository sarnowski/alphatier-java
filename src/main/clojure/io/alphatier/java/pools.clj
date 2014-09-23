(ns io.alphatier.java.pools
  (:import (io.alphatier.java Pool Snapshot))
  (:require [io.alphatier.pools :as pools])
  (:gen-class
    :name "io.alphatier.java.ClojurePools"
    :implements [io.alphatier.java.Pools]))

(defn -create []
  (Pool. (pools/create)))

(defn -createWithSnapshot [^Snapshot snapshot]
  (Pool. (pools/create-with-state (.getSnapshot snapshot))))

(defn get-snapshot [^Pool pool]
  (Snapshot. (pools/get-snapshot (.getPool pool))))
