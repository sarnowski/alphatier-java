package io.alphatier.java;

import java.util.Map;

public final class CommitUpdateTask extends CommitTask {
    private final Map<Object,Object> metadata;

    public CommitUpdateTask(final String taskId, final Number taskMetadataVersion, final Number executorMetadataVersion,
                            final Number executorTaskIdsVersion, final Map<Object, Object> metadata) {
        super(taskId, taskMetadataVersion, executorMetadataVersion, executorTaskIdsVersion);
        this.metadata = metadata;
    }

    public Map<Object, Object> getMetadata() {
        return metadata;
    }
}
