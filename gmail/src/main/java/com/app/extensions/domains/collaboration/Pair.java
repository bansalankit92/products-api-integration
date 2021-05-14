package com.app.extensions.domains.collaboration;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Pair<K, V> {

    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }

    public static <K, V> Set<Pair<K, V>> setOf(Map<K, V> map) {
        Set<Pair<K, V>> set = new LinkedHashSet<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            set.add(Pair.of(entry.getKey(), entry.getValue()));
        }

        return set;
    }

    public static <K, V> Pair<K, V> create(Map.Entry<K, V> entry) {
        return Pair.of(entry.getKey(), entry.getValue());
    }

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pair) {
            Pair<?, ?> that = (Pair<?, ?>) o;
            return Objects.equals(key, that.key) && Objects.equals(value, that.value);
        }
        return false;
    }

    @Override
    public String toString() {
        return key + " = " + value;
    }

}
