package io.alphatier.java;

public final class CommitKillTask extends CommitTask {
    public CommitKillTask(final String taskId, final Number taskMetadataVersion, final Number executorMetadataVersion,
                          final Number executorTaskIdsVersion) {
        super(taskId, taskMetadataVersion, executorMetadataVersion, executorTaskIdsVersion);
    }
}
