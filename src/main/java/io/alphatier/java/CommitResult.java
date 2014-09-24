package io.alphatier.java;

import java.util.Collection;
import java.util.Map;

public final class CommitResult {
    private final Collection<CommitTask> acceptedTasks;
    private final Map<String,Collection<CommitTask>> rejectedTasks;
    private final LazySnapshot preSnapshot;
    private final LazySnapshot postSnapshot;

    public CommitResult(final Collection<CommitTask> acceptedTasks,
                        final Map<String, Collection<CommitTask>> rejectedTasks, final LazySnapshot preSnapshot,
                        final LazySnapshot postSnapshot) {
        this.acceptedTasks = acceptedTasks;
        this.rejectedTasks = rejectedTasks;
        this.preSnapshot = preSnapshot;
        this.postSnapshot = postSnapshot;
    }

    public Collection<CommitTask> getAcceptedTasks() {
        return acceptedTasks;
    }

    public Map<String, Collection<CommitTask>> getRejectedTasks() {
        return rejectedTasks;
    }

    public LazySnapshot getPreSnapshot() {
        return preSnapshot;
    }

    public LazySnapshot getPostSnapshot() {
        return postSnapshot;
    }
}
