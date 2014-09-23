package io.alphatier.java;

import java.util.List;

public interface PreConstraint {
    List<CommitTask> check(Commit commit, LazySnapshot preSnapshot);
}
