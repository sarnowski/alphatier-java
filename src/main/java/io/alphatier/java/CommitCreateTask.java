package io.alphatier.java;

import java.util.Map;

public final class CommitCreateTask extends CommitTask {
    private final String executorId;
    private final Map<String,Number> resources;
    private final Map<Object,Object> metadata;

    public CommitCreateTask(final String taskId, final String executorId, final Number taskMetadataVersion,
                            final Number executorMetadataVersion, final Number executorTaskIdsVersion,
                            final Map<String, Number> resources, final Map<Object, Object> metadata) {
        super(taskId, taskMetadataVersion, executorMetadataVersion, executorTaskIdsVersion);
        this.executorId = executorId;
        this.resources = resources;
        this.metadata = metadata;
    }

    public String getExecutorId() {
        return executorId;
    }

    public Map<String, Number> getResources() {
        return resources;
    }

    public Map<Object, Object> getMetadata() {
        return metadata;
    }
}
