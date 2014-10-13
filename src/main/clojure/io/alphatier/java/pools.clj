(ns io.alphatier.java.pools
  (:import (io.alphatier.java Pool Snapshot LazySnapshot))
  (:require [io.alphatier.pools :as pools]
            [io.alphatier.java.mappings :as mappings])
  (:gen-class
    :name io.alphatier.java.InternalPools
    :implements [io.alphatier.java.Pools]))

(defn -create [_]
  (Pool. (pools/create)))

(defn -createWithSnapshot [_ ^Snapshot snapshot]
  (Pool. (pools/create-with-snapshot (mappings/from-Snapshot snapshot))))

(defn -getSnapshot [_ ^Pool pool]
  (mappings/to-LazySnapshot
    (pools/get-snapshot (.getPool pool))))
