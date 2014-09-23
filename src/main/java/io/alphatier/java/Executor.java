package io.alphatier.java;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public final class Executor {
    private final String id;
    private final Status status;
    private final Map<String,Long> resources;
    private final Map<Object,Object> metadata;
    private final BigInteger metadataVersion;
    private final Collection<String> taskIds;
    private final BigInteger taskIdsVersion;

    Executor(final String id, final Status status, final Map<String, Long> resources,
                    final Map<Object, Object> metadata, final BigInteger metadataVersion,
                    final Collection<String> taskIds, final BigInteger taskIdsVersion) {
        this.id = id;
        this.status = status;
        this.resources = Collections.unmodifiableMap(resources);
        this.metadata = Collections.unmodifiableMap(metadata);
        this.metadataVersion = metadataVersion;
        this.taskIds = Collections.unmodifiableCollection(taskIds);
        this.taskIdsVersion = taskIdsVersion;
    }

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
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

    public Collection<String> getTaskIds() {
        return taskIds;
    }

    public BigInteger getTaskIdsVersion() {
        return taskIdsVersion;
    }
}
