package io.alphatier.java;

import java.util.Map;

public final class Task {
    private final String id;
    private final String executorId;
    private final String schedulerId;
    private final LifecyclePhase lifecyclePhase;
    private final Map<String,Number> resources;
    private final Map<Object,Object> metadata;
    private final Number metadataVersion;

    public Task(final String id, final String executorId, final String schedulerId, final LifecyclePhase lifecyclePhase,
                final Map<String, Number> resources, final Map<Object, Object> metadata,
                final Number metadataVersion) {
        this.id = id;
        this.executorId = executorId;
        this.schedulerId = schedulerId;
        this.lifecyclePhase = lifecyclePhase;
        this.resources = resources;
        this.metadata = metadata;
        this.metadataVersion = metadataVersion;
    }

    public String getId() {
        return id;
    }

    public String getExecutorId() {
        return executorId;
    }

    public String getSchedulerId() {
        return schedulerId;
    }

    public LifecyclePhase getLifecyclePhase() {
        return lifecyclePhase;
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
}
