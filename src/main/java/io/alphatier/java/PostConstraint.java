package io.alphatier.java;

import java.util.List;

public interface PostConstraint {
    List<CommitAction> check(Commit commit, LazySnapshot preSnapshot, LazySnapshot postSnapshot);
}
