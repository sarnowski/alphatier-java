package io.alphatier.java;

import org.junit.Test;

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
                null,
                null
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
    }
}
