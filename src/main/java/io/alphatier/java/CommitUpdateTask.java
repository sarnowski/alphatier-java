package io.alphatier.java;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Map;

public final class CommitUpdateTask extends CommitTask {
    private final Map<Object,Object> metadata;

    public CommitUpdateTask(final String taskId, final String executorId, final BigInteger executorMetadataVersion,
                            final BigInteger executorTaskIdsVersion, final BigInteger taskMetadataVersion,
                            final Map<Object, Object> metadata) {
        super(taskId, executorId, executorMetadataVersion, executorTaskIdsVersion, taskMetadataVersion);
        this.metadata = Collections.unmodifiableMap(metadata);
    }

    public Map<Object, Object> getMetadata() {
        return metadata;
    }
}
