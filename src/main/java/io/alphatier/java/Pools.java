package io.alphatier.java;

public interface Pools {
    Pool create();

    // TODO  createWithSnapshot currently not implemented

    LazySnapshot getSnapshot(Pool pool);
}
