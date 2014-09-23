package io.alphatier.java;

public interface Schedulers {
    CommitResult commit(Pool pool, Commit commit) throws CommitRejectedException;
    CommitResult forcedCommit(Pool pool, Commit commit);
}
