package io.alphatier.java;

import java.util.Collection;
import java.util.Map;

public final class ExecutorRegistration {
    private final String id;
    private final Map<String,Number> resources;
    private final Map<Object,Object> metadata;
    private final Number metadataVersion;
    private final Collection<Task> tasks;
    private final Number taskIdsVersion;

    public ExecutorRegistration(final String id, final Map<String, Number> resources, final Map<Object, Object> metadata,
                                final Number metadataVersion, final Collection<Task> tasks,
                                final Number taskIdsVersion) {
        this.id = id;
        this.resources = resources;
        this.metadata = metadata;
        this.metadataVersion = metadataVersion;
        this.tasks = tasks;
        this.taskIdsVersion = taskIdsVersion;
    }

    public String getId() {
        return id;
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

    public Collection<Task> getTasks() {
        return tasks;
    }

    public Number getTaskIdsVersion() {
        return taskIdsVersion;
    }

    @Override
    public String toString() {
        return "ExecutorRegistration{" +
                "id='" + id + '\'' +
                ", resources=" + resources +
                ", metadata=" + metadata +
                ", metadataVersion=" + metadataVersion +
                ", tasks=" + tasks +
                ", taskIdsVersion=" + taskIdsVersion +
                '}';
    }
}
