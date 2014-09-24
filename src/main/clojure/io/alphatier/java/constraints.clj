(ns io.alphatier.java.constraints
  (:require [io.alphatier.constraints :as constraints]
            [io.alphatier.java.mappings :as mappings])
  (:gen-class
    :name "io.alphatier.java.ClojureConstraints"
    :implements [io.alphatier.java.Constraints])
  (:import (io.alphatier.java Pool PreConstraint PostConstraint)))

(defmulti -add class)

(defmethod -add PreConstraint [_ ^Pool pool ^String name ^PreConstraint constraint]
  (constraints/add pool :pre name (fn [commit pre-snapshot]
                                    (map mappings/from-CommitTask
                                         (.check constraint
                                                 (mappings/to-original commit)
                                                 (mappings/to-LazySnapshot pre-snapshot))))))

(defmethod -add PostConstraint [_ ^Pool pool ^String name ^PostConstraint constraint]
  (constraints/add pool :post name (fn [commit pre-snapshot post-snapshot]
                                       (map mappings/from-CommitTask
                                            (.check constraint
                                                    (mappings/to-original commit)
                                                    (mappings/to-LazySnapshot pre-snapshot)
                                                    (mappings/to-LazySnapshot post-snapshot))))))

(defn -del [_ ^Pool pool ^String name]
  (constraints/del pool name))
