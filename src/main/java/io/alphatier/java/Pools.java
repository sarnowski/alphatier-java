package io.alphatier.java;

public interface Pools {
    Pool create();

    Pool createWithSnapshot(Snapshot snapshot);

    LazySnapshot getSnapshot(Pool pool);
}
