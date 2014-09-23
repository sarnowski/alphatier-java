(ns io.alphatier.java.constraints
  (:require [io.alphatier.constraints :as constraints]
            [io.alphatier.java.mappings :as mappings])
  (:gen-class
    :name "io.alphatier.java.ClojureConstraints"
    :implements [io.alphatier.java.Constraints])
  (:import (io.alphatier.java Pool PreConstraint)))

(defmulti -add class)

(defn -add PreConstraint [^Pool pool ^String name ^PreConstraint constraint]
  (constraints/add pool :pre name (fn [commit pre-snapshot]
                                    (map mappings/from-CommitTask
                                         (.check constraint
                                                 (mappings/to-original commit)
                                                 (mappings/to-LazySnapshot pre-snapshot))))))

(defn -add PreConstraint [^Pool pool ^String name ^PreConstraint constraint]
  (constraints/add pool :post name (fn [commit pre-snapshot]
                                       (map mappings/from-CommitTask
                                            (.check constraint
                                                    (mappings/to-original commit)
                                                    (mappings/to-LazySnapshot pre-snapshot)
                                                    (mappings/to-LazySnapshot post-snapshot))))))

(defn -del [^Pool pool ^String name]
  (constraints/del pool name))
