package io.alphatier.java;

import java.util.Collection;

public final class Snapshot {
    private final Collection<Executor> executors;
    private final Collection<Task> tasks;

    public Snapshot(final Collection<Executor> executors, final Collection<Task> tasks) {
        this.executors = executors;
        this.tasks = tasks;
    }

    public Collection<Executor> getExecutors() {
        return executors;
    }

    public Collection<Task> getTasks() {
        return tasks;
    }
}
