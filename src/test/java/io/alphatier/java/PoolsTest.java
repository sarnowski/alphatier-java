package io.alphatier.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class PoolsTest {

    @Test
    public void createNewPool() {
        Pool pool = Units.POOLS.create();

        assertNotNull("pool", pool.getPool());
    }

    @Test
    public void simpleSnapshot() {
        Pool pool = Units.POOLS.create();

        LazySnapshot lazySnapshot = Units.POOLS.getSnapshot(pool);
        Snapshot snapshot = lazySnapshot.getSnapshot();

        assertEquals("no executors", 0, snapshot.getExecutors().size());
        assertEquals("no tasks", 0, snapshot.getTasks().size());
    }
}
