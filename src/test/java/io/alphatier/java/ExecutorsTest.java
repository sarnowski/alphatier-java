package io.alphatier.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class ExecutorsTest {
    @Test
    public void registerExecutor() {
        Pool pool = Units.POOLS.create();

        // TODO add and check tasks
        ExecutorRegistration registration = new ExecutorRegistration(
                "test-executor",
                new HashMap<String,Number>() {{
                    put("cpu", 8);
                    put("memory", 1024);
                    put("disk", 512);
                }},
                new HashMap<Object,Object>() {{
                    put("foo", "bar");
                }},
                4,
                new ArrayList<Task>() {{
                    add(new Task(
                            "test-task",
                            "test-executor",
                            "some-scheduler",
                            LifecyclePhase.CREATED,
                            new HashMap<String, Number>() {{
                                put("cpu", 1);
                                put("memory", 128);
                                put("disk", 64);
                            }},
                            new HashMap<Object, Object>() {{
                                put("work", "maybe");
                            }},
                            12
                    ));
                }},
                7
        );
        Units.EXECUTORS.register(pool, registration);

        Snapshot snapshot = Units.POOLS.getSnapshot(pool).getSnapshot();
        assertEquals("one executor", 1, snapshot.getExecutors().size());

        Executor executor = snapshot.getExecutors().get("test-executor");
        assertNotNull("executor", executor);

        assertEquals("id", "test-executor", executor.getId());
        assertEquals("status", Status.REGISTERED, executor.getStatus());
        assertEquals("metadata[foo]", "bar", executor.getMetadata().get("foo"));
        assertEquals("metadataVersion", 4, executor.getMetadataVersion());
        assertEquals("resources[cpu]", 8, executor.getResources().get("cpu"));
        assertEquals("resources[memory]", 1024, executor.getResources().get("memory"));
        assertEquals("resources[disk]", 512, executor.getResources().get("disk"));
        assertEquals("taskIds", 1, executor.getTaskIds().size());
        assertEquals("taskIds[0]", "test-task", executor.getTaskIds().iterator().next());
        assertEquals("taskIdsVersion", 7, executor.getTaskIdsVersion());

        Task task = snapshot.getTasks().get("test-task");
        assertNotNull("task", task);

        assertEquals("id", "test-task", task.getId());
        assertEquals("executorId", "test-executor", task.getExecutorId());
        assertEquals("schedulerId", "some-scheduler", task.getSchedulerId());
        assertEquals("lifecyclePhase", LifecyclePhase.CREATED, task.getLifecyclePhase());
        assertEquals("resources[cpu]", 1, task.getResources().get("cpu"));
        assertEquals("resources[memory]", 128, task.getResources().get("memory"));
        assertEquals("resources[disk]", 64, task.getResources().get("disk"));
        assertEquals("metadata[work]", "maybe", task.getMetadata().get("work"));
        assertEquals("metadataVersion", 12, task.getMetadataVersion());
    }
}
