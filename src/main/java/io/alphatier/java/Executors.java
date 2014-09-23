package io.alphatier.java;

import java.util.Map;

public interface Executors {
    void register(Pool pool, ExecutorRegistration registration);
    void update(Pool pool, String executorId, Map<Object,Object> metadata);
    void unregister(Pool pool, String executorId);
    void updateTask(Pool pool, String taskId, LifecyclePhase lifecyclePhase, Map<Object,Object> metadata);
    void killTask(Pool pool, String taskId);
}
