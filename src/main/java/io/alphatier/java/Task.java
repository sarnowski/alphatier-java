package io.alphatier.java;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Map;

public final class Task {
    private final String id;
    private final String executorId;
    private final LifecyclePhase lifecyclePhase;
    private final Map<String,Long> resources;
    private final Map<Object,Object> metadata;
    private final BigInteger metadataVersion;

    Task(final String id, final String executorId, final LifecyclePhase lifecyclePhase,
                final Map<String, Long> resources, final Map<Object, Object> metadata,
                final BigInteger metadataVersion) {
        this.id = id;
        this.executorId = executorId;
        this.lifecyclePhase = lifecyclePhase;
        this.resources = Collections.unmodifiableMap(resources);
        this.metadata = Collections.unmodifiableMap(metadata);
        this.metadataVersion = metadataVersion;
    }

    public String getId() {
        return id;
    }

    public String getExecutorId() {
        return executorId;
    }

    public LifecyclePhase getLifecyclePhase() {
        return lifecyclePhase;
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
}
