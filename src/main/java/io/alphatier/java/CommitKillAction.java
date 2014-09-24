package io.alphatier.java;

public final class CommitKillAction extends CommitAction {
    public CommitKillAction(final String taskId, final Number taskMetadataVersion, final Number executorMetadataVersion,
                            final Number executorTaskIdsVersion) {
        super(taskId, taskMetadataVersion, executorMetadataVersion, executorTaskIdsVersion);
    }
}
