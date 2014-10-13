package io.alphatier.java;

public interface Constraints {
    void add(Pool pool, String name, PreConstraint constraint);
    void add(Pool pool, String name, PostConstraint constraint);
    void del(Pool pool, String name, ConstraintType type);

    Pool withDefaults(Pool pool);
}
