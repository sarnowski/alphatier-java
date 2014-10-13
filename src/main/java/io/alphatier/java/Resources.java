package io.alphatier.java;

import clojure.lang.PersistentArrayMap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class Resources implements Map<Object, Number> {

    private final Map<Object, Number> delegate;

    private Resources(Map<Object, Number> delegate) {
        this.delegate = delegate;
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return delegate.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return delegate.containsValue(value);
    }

    @Override
    public Number get(Object key) {
        return delegate.get(key);
    }

    @Deprecated
    @Override
    public Number put(Object key, Number value) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public Number remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public void putAll(Map<?, ? extends Number> m) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Object> keySet() {
        return delegate.keySet();
    }

    @Override
    public Collection<Number> values() {
        return delegate.values();
    }

    @Override
    public Set<Entry<Object, Number>> entrySet() {
        return delegate.entrySet();
    }

    @SuppressWarnings("unchecked")
    public static Resources of(final Map<String, Object> resources) {
        return new Resources((Map<Object, Number>) PersistentArrayMap.create(resources));
    }

}
