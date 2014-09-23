package io.alphatier.java;

import java.util.List;

public interface PostConstraint {
    List<CommitTask> check(Commit commit, Snapshot preSnapshot, Snapshot postSnapshot);
}
