package io.alphatier.java;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public final class CommitResult {
    private final Collection<CommitTask> acceptedTasks;
    private final Map<String,Collection<CommitTask>> rejectedTasks;
    private final Snapshot preSnapshot;
    private final Snapshot postSnapshot;

    CommitResult(final Collection<CommitTask> acceptedTasks,
                        final Map<String, Collection<CommitTask>> rejectedTasks, final Snapshot preSnapshot,
                        final Snapshot postSnapshot) {
        this.acceptedTasks = Collections.unmodifiableCollection(acceptedTasks);
        this.rejectedTasks = Collections.unmodifiableMap(rejectedTasks);
        this.preSnapshot = preSnapshot;
        this.postSnapshot = postSnapshot;
    }

    public Collection<CommitTask> getAcceptedTasks() {
        return acceptedTasks;
    }

    public Map<String, Collection<CommitTask>> getRejectedTasks() {
        return rejectedTasks;
    }

    public Snapshot getPreSnapshot() {
        return preSnapshot;
    }

    public Snapshot getPostSnapshot() {
        return postSnapshot;
    }
}
