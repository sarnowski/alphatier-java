package io.alphatier.java;

import java.util.Collection;

public final class Snapshot {
    private final Object snapshot;

    private volatile Collection<Executor> cachedExecutors;
    private volatile Collection<Task> cachedTasks;

    Snapshot(final Object snapshot) {
        this.snapshot = snapshot;
    }

    Object getSnapshot() {
        return snapshot;
    }

    public Collection<Executor> getExecutors() {
        // TODO lazy map executors and cache
        return cachedExecutors;
    }

    public Collection<Task> getTasks() {
        // TODO lazy map tasks and cache
        return cachedTasks;
    }
}
