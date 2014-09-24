package io.alphatier.java;

import java.util.Collection;
import java.util.Map;

public final class CommitResult {
    private final Collection<CommitAction> acceptedActions;
    private final Map<String,Collection<CommitAction>> rejectedActions;
    private final LazySnapshot preSnapshot;
    private final LazySnapshot postSnapshot;

    public CommitResult(final Collection<CommitAction> acceptedActions,
                        final Map<String, Collection<CommitAction>> rejectedActions, final LazySnapshot preSnapshot,
                        final LazySnapshot postSnapshot) {
        this.acceptedActions = acceptedActions;
        this.rejectedActions = rejectedActions;
        this.preSnapshot = preSnapshot;
        this.postSnapshot = postSnapshot;
    }

    public Collection<CommitAction> getAcceptedActions() {
        return acceptedActions;
    }

    public Map<String, Collection<CommitAction>> getRejectedActions() {
        return rejectedActions;
    }

    public LazySnapshot getPreSnapshot() {
        return preSnapshot;
    }

    public LazySnapshot getPostSnapshot() {
        return postSnapshot;
    }
}
