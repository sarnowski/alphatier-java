package io.alphatier.java;

public abstract class CommitAction {
    private final String taskId;

    private final Number executorMetadataVersion;
    private final Number executorTaskIdsVersion;

    protected CommitAction(final String taskId, final Number executorMetadataVersion,
            final Number executorTaskIdsVersion) {
        this.taskId = taskId;
        this.executorMetadataVersion = executorMetadataVersion;
        this.executorTaskIdsVersion = executorTaskIdsVersion;
    }

    public String getTaskId() {
        return taskId;
    }

    public Number getExecutorMetadataVersion() {
        return executorMetadataVersion;
    }

    public Number getExecutorTaskIdsVersion() {
        return executorTaskIdsVersion;
    }
}
