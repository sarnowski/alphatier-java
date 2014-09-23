package io.alphatier.java;

public final class CommitKillTask extends CommitTask {
    public CommitKillTask(final String taskId, final String executorId, final Number executorMetadataVersion,
                          final Number executorTaskIdsVersion, final Number taskMetadataVersion) {
        super(taskId, executorId, executorMetadataVersion, executorTaskIdsVersion, taskMetadataVersion);
    }
}
