package io.alphatier.java;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public final class ExecutorRegistration {
    private final String id;
    private final Map<String,Long> resources;
    private final Map<Object,Object> metadata;
    private final BigInteger metadataVersion;
    private final Collection<Task> tasks;
    private final BigInteger taskIdsVersion;

    public ExecutorRegistration(final String id, final Map<String, Long> resources, final Map<Object, Object> metadata,
                                final BigInteger metadataVersion, final Collection<Task> tasks,
                                final BigInteger taskIdsVersion) {
        this.id = id;
        this.resources = Collections.unmodifiableMap(resources);
        this.metadata = Collections.unmodifiableMap(metadata);
        this.metadataVersion = metadataVersion;
        this.tasks = Collections.unmodifiableCollection(tasks);
        this.taskIdsVersion = taskIdsVersion;
    }

    public String getId() {
        return id;
    }

    public Map<String, Long> getResources() {
        return resources;
    }

    public Map<Object, Object> getMetadata() {
        return metadata;
    }

    public BigInteger getMetadataVersion() {
        return metadataVersion;
    }

    public Collection<Task> getTasks() {
        return tasks;
    }

    public BigInteger getTaskIdsVersion() {
        return taskIdsVersion;
    }
}
