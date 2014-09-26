package io.alphatier.java;

import java.util.Map;

public final class CommitCreateAction extends CommitAction {
    private final String executorId;
    private final Map<String,Number> resources;
    private final Map<Object,Object> metadata;

    public CommitCreateAction(final String taskId, final String executorId, final Number taskMetadataVersion,
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

    @Override
    public String toString() {
        return "CommitCreateAction{" +
                "taskId='" + getTaskId() + '\'' +
                ", executorId='" + executorId + '\'' +
                ", resources=" + resources +
                ", metadata=" + metadata +
                ", metadataVersion=" + getMetadataVersion() +
                ", executorMetadataVersion=" + getExecutorMetadataVersion() +
                ", executorTaskIdsVersion=" + getExecutorTaskIdsVersion() +
                '}';
    }
}
