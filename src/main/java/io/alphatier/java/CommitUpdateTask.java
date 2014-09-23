package io.alphatier.java;

import java.util.Map;

public final class CommitUpdateTask extends CommitTask {
    private final Map<Object,Object> metadata;

    public CommitUpdateTask(final String taskId, final String executorId, final Number executorMetadataVersion,
                            final Number executorTaskIdsVersion, final Number taskMetadataVersion,
                            final Map<Object, Object> metadata) {
        super(taskId, executorId, executorMetadataVersion, executorTaskIdsVersion, taskMetadataVersion);
        this.metadata = metadata;
    }

    public Map<Object, Object> getMetadata() {
        return metadata;
    }
}
