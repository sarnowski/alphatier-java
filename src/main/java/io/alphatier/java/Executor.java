package io.alphatier.java;

import java.util.Collection;
import java.util.Map;

public final class Executor {
    private final String id;
    private final Status status;
    private final Map<String,Number> resources;
    private final Map<Object,Object> metadata;
    private final Number metadataVersion;
    private final Collection<String> taskIds;
    private final Number taskIdsVersion;

    Executor(final String id, final Status status, final Map<String, Number> resources,
                    final Map<Object, Object> metadata, final Number metadataVersion,
                    final Collection<String> taskIds, final Number taskIdsVersion) {
        this.id = id;
        this.status = status;
        this.resources = resources;
        this.metadata = metadata;
        this.metadataVersion = metadataVersion;
        this.taskIds = taskIds;
        this.taskIdsVersion = taskIdsVersion;
    }

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public Map<String, Number> getResources() {
        return resources;
    }

    public Map<Object, Object> getMetadata() {
        return metadata;
    }

    public Number getMetadataVersion() {
        return metadataVersion;
    }

    public Collection<String> getTaskIds() {
        return taskIds;
    }

    public Number getTaskIdsVersion() {
        return taskIdsVersion;
    }
}
