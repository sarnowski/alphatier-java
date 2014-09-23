package io.alphatier.java;

import java.util.Collection;
import java.util.Collections;

public final class Commit {
    private final String schedulerId;
    private final Collection<CommitTask> tasks;
    private final boolean allowPartialCommit;

    public Commit(final String schedulerId, final Collection<CommitTask> tasks, final boolean allowPartialCommit) {
        this.schedulerId = schedulerId;
        this.tasks = Collections.unmodifiableCollection(tasks);
        this.allowPartialCommit = allowPartialCommit;
    }

    public String getSchedulerId() {
        return schedulerId;
    }

    public Collection<CommitTask> getTasks() {
        return tasks;
    }

    public boolean isAllowPartialCommit() {
        return allowPartialCommit;
    }
}
