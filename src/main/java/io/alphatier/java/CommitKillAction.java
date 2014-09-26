package io.alphatier.java;

public final class CommitKillAction extends CommitAction {
    public CommitKillAction(final String taskId, final Number taskMetadataVersion, final Number executorMetadataVersion,
                            final Number executorTaskIdsVersion) {
        super(taskId, taskMetadataVersion, executorMetadataVersion, executorTaskIdsVersion);
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
