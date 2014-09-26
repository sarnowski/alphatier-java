package io.alphatier.java;

import java.util.Collection;

public final class Commit {
    private final String schedulerId;
    private final Collection<CommitAction> actions;
    private final boolean allowPartialCommit;

    public Commit(final String schedulerId, final Collection<CommitAction> actions, final boolean allowPartialCommit) {
        this.schedulerId = schedulerId;
        this.actions = actions;
        this.allowPartialCommit = allowPartialCommit;
    }

    public String getSchedulerId() {
        return schedulerId;
    }

    public Collection<CommitAction> getActions() {
        return actions;
    }

    public boolean isAllowPartialCommit() {
        return allowPartialCommit;
    }

    @Override
    public String toString() {
        return "Commit{" +
                "schedulerId='" + schedulerId + '\'' +
                ", actions=" + actions +
                ", allowPartialCommit=" + allowPartialCommit +
                '}';
    }
}
