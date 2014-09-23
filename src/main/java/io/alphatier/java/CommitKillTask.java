package io.alphatier.java;

import java.math.BigInteger;

public final class CommitKillTask extends CommitTask {
    public CommitKillTask(final String taskId, final String executorId, final BigInteger executorMetadataVersion,
                          final BigInteger executorTaskIdsVersion, final BigInteger taskMetadataVersion) {
        super(taskId, executorId, executorMetadataVersion, executorTaskIdsVersion, taskMetadataVersion);
    }
}
