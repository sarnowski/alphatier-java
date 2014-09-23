package io.alphatier.java;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Map;

public final class CommitCreateTask extends CommitTask {
    private final Map<String,Long> resources;
    private final Map<Object,Object> metadata;

    public CommitCreateTask(final String taskId, final String executorId, final BigInteger executorMetadataVersion,
                            final BigInteger executorTaskIdsVersion, final BigInteger taskMetadataVersion,
                            final Map<String, Long> resources, final Map<Object, Object> metadata) {
        super(taskId, executorId, executorMetadataVersion, executorTaskIdsVersion, taskMetadataVersion);
        this.resources = Collections.unmodifiableMap(resources);
        this.metadata = Collections.unmodifiableMap(metadata);
    }

    public Map<String, Long> getResources() {
        return resources;
    }

    public Map<Object, Object> getMetadata() {
        return metadata;
    }
}
