package io.alphatier.java;

public final class Pool {
    private final Object pool;

    Pool(final Object pool) {
        this.pool = pool;
    }

    Object getPool() {
        return pool;
    }
}
