package io.alphatier.java;

import java.util.List;

public interface PostConstraint {
    List<CommitTask> check(Commit commit, LazySnapshot preSnapshot, LazySnapshot postSnapshot);
}
