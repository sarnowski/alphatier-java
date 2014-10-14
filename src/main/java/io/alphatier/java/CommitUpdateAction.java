package io.alphatier.java;

import java.util.Map;

public final class CommitUpdateAction extends CommitAction {

    private final Map<Object,Object> metadata;
    private final Number metadataVersion;

    public CommitUpdateAction(final String taskId, final Number taskMetadataVersion, final Number executorMetadataVersion,
                              final Number executorTaskIdsVersion, final Map<Object, Object> metadata) {
        super(taskId, executorMetadataVersion, executorTaskIdsVersion);
        this.metadata = metadata;
        this.metadataVersion = taskMetadataVersion;
    }

    public Map<Object, Object> getMetadata() {
        return metadata;
    }

    public Number getMetadataVersion() {
        return metadataVersion;
    }

    @Override
    public String toString() {
        return "CommitUpdateAction{" +
                "taskId='" + getTaskId() + '\'' +
                ", metadata=" + metadata +
                ", metadataVersion=" + getMetadataVersion() +
                ", executorMetadataVersion=" + getExecutorMetadataVersion() +
                ", executorTaskIdsVersion=" + getExecutorTaskIdsVersion() +
                '}';
    }
}
