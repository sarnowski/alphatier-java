package io.alphatier.java;

public abstract class CommitTask {
    private final String taskId;

    private final Number metadataVersion;
    private final Number executorMetadataVersion;
    private final Number executorTaskIdsVersion;

    protected CommitTask(final String taskId, final Number metadataVersion, final Number executorMetadataVersion,
                         final Number executorTaskIdsVersion) {
        this.taskId = taskId;
        this.metadataVersion = metadataVersion;
        this.executorMetadataVersion = executorMetadataVersion;
        this.executorTaskIdsVersion = executorTaskIdsVersion;
    }

    public String getTaskId() {
        return taskId;
    }

    public Number getMetadataVersion() {
        return metadataVersion;
    }

    public Number getExecutorMetadataVersion() {
        return executorMetadataVersion;
    }

    public Number getExecutorTaskIdsVersion() {
        return executorTaskIdsVersion;
    }
}
