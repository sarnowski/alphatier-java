package io.alphatier.java;

import io.alphatier.java.InternalPools;
import io.alphatier.java.InternalSchedulers;
import io.alphatier.java.InternalExecutors;
import io.alphatier.java.InternalConstraints;

public class Units {
    public static final Pools POOLS = new InternalPools();
    public static final Schedulers SCHEDULERS = new InternalSchedulers();
    public static final Executors EXECUTORS = new InternalExecutors();
    public static final Constraints CONSTRAINTS = new InternalConstraints();
}
