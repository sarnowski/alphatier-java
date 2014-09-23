(ns io.alphatier.java.pools
  (:import (io.alphatier.java Pool Snapshot LazySnapshot))
  (:require [io.alphatier.pools :as pools]
            [io.alphatier.java.mappings :as mappings])
  (:gen-class
    :name "io.alphatier.java.ClojurePools"
    :implements [io.alphatier.java.Pools]))

(defn -create []
  (Pool. (pools/create)))

(defn -createWithSnapshot [^Snapshot snapshot]
  (Pool. (pools/create-with-state
           (mappings/from-Snapshot snapshot))))

(defn -getSnapshot [^Pool pool]
  (mappings/to-LazySnapshot
    (pools/get-snapshot (.getPool pool))))
