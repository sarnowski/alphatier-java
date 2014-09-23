package io.alphatier.java;

import java.math.BigInteger;

public abstract class CommitTask {
    private final String taskId;
    private final String executorId;

    private final BigInteger executorMetadataVersion;
    private final BigInteger executorTaskIdsVersion;
    private final BigInteger taskMetadataVersion;

    protected CommitTask(final String taskId, final String executorId, final BigInteger executorMetadataVersion,
                         final BigInteger executorTaskIdsVersion, final BigInteger taskMetadataVersion) {
        this.taskId = taskId;
        this.executorId = executorId;
        this.executorMetadataVersion = executorMetadataVersion;
        this.executorTaskIdsVersion = executorTaskIdsVersion;
        this.taskMetadataVersion = taskMetadataVersion;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getExecutorId() {
        return executorId;
    }

    public BigInteger getExecutorMetadataVersion() {
        return executorMetadataVersion;
    }

    public BigInteger getExecutorTaskIdsVersion() {
        return executorTaskIdsVersion;
    }

    public BigInteger getTaskMetadataVersion() {
        return taskMetadataVersion;
    }
}
