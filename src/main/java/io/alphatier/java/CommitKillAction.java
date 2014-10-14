package io.alphatier.java;

public final class CommitKillAction extends CommitAction {

    private final Number metadataVersion;

    public CommitKillAction(final String taskId, final Number taskMetadataVersion, final Number executorMetadataVersion,
                            final Number executorTaskIdsVersion) {
        super(taskId, executorMetadataVersion, executorTaskIdsVersion);
        this.metadataVersion = taskMetadataVersion;
    }

    public Number getMetadataVersion() {
        return metadataVersion;
    }

    @Override
    public String toString() {
        return "CommitKillAction{" +
                "taskId='" + getTaskId() + '\'' +
                ", metadataVersion=" + getMetadataVersion() +
                ", executorMetadataVersion=" + getExecutorMetadataVersion() +
                ", executorTaskIdsVersion=" + getExecutorTaskIdsVersion() +
                '}';
    }
}
