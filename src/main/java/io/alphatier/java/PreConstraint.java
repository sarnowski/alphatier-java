package io.alphatier.java;

import java.util.List;

public interface PreConstraint {
    List<CommitAction> check(Commit commit, LazySnapshot preSnapshot);
}
