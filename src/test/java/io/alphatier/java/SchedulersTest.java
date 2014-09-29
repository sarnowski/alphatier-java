package io.alphatier.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class SchedulersTest {
    @Test
    public void commit() throws CommitRejectedException {
        Pool pool = Units.POOLS.create();

        // TODO both constraints are currently buggy :-( (maybe impl or mapping)
        Units.CONSTRAINTS.del(pool, "optimistic-locking", ConstraintType.PRE);
        Units.CONSTRAINTS.del(pool, "no-resource-overbooking", ConstraintType.POST);

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
                            "test-task-1",
                            "test-executor",
                            "test-scheduler",
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
                    add(new Task(
                            "test-task-2",
                            "test-executor",
                            "test-scheduler",
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

        CommitResult result = Units.SCHEDULERS.commit(pool, new Commit(
                "test-scheduler",
                new ArrayList<CommitAction>() {{
                    add(new CommitCreateAction(
                            "test-task-3",
                            "test-executor",
                            1,
                            4,
                            7,
                            new HashMap<String, Number>() {{
                                put("cpu", 2);
                                put("memory", 100);
                                put("disk", 10);
                            }},
                            new HashMap<Object, Object>() {{
                                put("work", "probably");
                            }}
                    ));
                    add(new CommitUpdateAction(
                            "test-task-1",
                            null,
                            null,
                            null,
                            new HashMap<Object, Object>() {{
                                put("work", "definitely");
                            }}
                    ));
                    add(new CommitKillAction(
                            "test-task-2",
                            null,
                            null,
                            null
                    ));
                }},
                false
        ));

        assertEquals("acceptedActions", 3, result.getAcceptedActions().size());
        assertEquals("rejectedActions", 0, result.getRejectedActions().size());
        Snapshot snapshot = Units.POOLS.getSnapshot(pool).getSnapshot();

        assertNotNull("test-task-1", snapshot.getTasks().get("test-task-1"));
        Task testTask1 = snapshot.getTasks().get("test-task-1");
        assertEquals("metadata[work]", "definitely", testTask1.getMetadata().get("work"));

        assertNotNull("test-task-2", snapshot.getTasks().get("test-task-2"));
        Task testTask2 = snapshot.getTasks().get("test-task-2");
        assertEquals("lifecyclePhase", LifecyclePhase.KILL, testTask2.getLifecyclePhase());

        assertNotNull("test-task-3", snapshot.getTasks().get("test-task-3"));
        Task testTask3 = snapshot.getTasks().get("test-task-3");
        assertEquals("id", "test-task-3", testTask3.getId());
        assertEquals("executorId", "test-executor", testTask3.getExecutorId());
        assertEquals("schedulerId", "test-scheduler", testTask3.getSchedulerId());
        assertEquals("lifecyclePhase", LifecyclePhase.CREATE, testTask3.getLifecyclePhase());
        assertEquals("metadata[work]", "probably", testTask3.getMetadata().get("work"));
    }
}
