package io.alphatier.java;

import io.alphatier.java.ClojurePools;
import io.alphatier.java.ClojureSchedulers;
import io.alphatier.java.ClojureExecutors;
import io.alphatier.java.ClojureConstraints;

public class Units {
    public static final Pools POOLS = new ClojurePools();
    public static final Schedulers SCHEDULERS = new ClojureSchedulers();
    public static final Executors EXECUTORS = new ClojureExecutors();
    public static final Constraints CONSTRAINTS = new ClojureConstraints();
}
