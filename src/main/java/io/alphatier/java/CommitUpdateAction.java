package io.alphatier.java;

import java.util.Map;

public final class CommitUpdateAction extends CommitAction {
    private final Map<Object,Object> metadata;

    public CommitUpdateAction(final String taskId, final Number taskMetadataVersion, final Number executorMetadataVersion,
                              final Number executorTaskIdsVersion, final Map<Object, Object> metadata) {
        super(taskId, taskMetadataVersion, executorMetadataVersion, executorTaskIdsVersion);
        this.metadata = metadata;
    }

    public Map<Object, Object> getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return "CommitCreateAction{" +
                "taskId='" + getTaskId() + '\'' +
                ", metadata=" + metadata +
                ", metadataVersion=" + getMetadataVersion() +
                ", executorMetadataVersion=" + getExecutorMetadataVersion() +
                ", executorTaskIdsVersion=" + getExecutorTaskIdsVersion() +
                '}';
    }
}
