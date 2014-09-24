package io.alphatier.java;

import java.util.Map;

public final class Snapshot {
    private final Map<String,Executor> executors;
    private final Map<String,Task> tasks;

    public Snapshot(final Map<String,Executor> executors, final Map<String,Task> tasks) {
        this.executors = executors;
        this.tasks = tasks;
    }

    public Map<String,Executor> getExecutors() {
        return executors;
    }

    public Map<String,Task> getTasks() {
        return tasks;
    }
}
