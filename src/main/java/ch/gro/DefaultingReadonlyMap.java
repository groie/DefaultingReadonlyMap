package ch.gro;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by gro on 17/09/15.
 */
public class DefaultingReadonlyMap<K,V> implements Map<K,V> {

    private List<Map<K,V>> maps = new ArrayList<>();

    public DefaultingReadonlyMap(Map<K,V> defaultMap, Map<K,V> fallbackMap) {
        maps.add(defaultMap);
        maps.add(fallbackMap);
    }

    @Override
    public int size() {
        HashSet<K> union = new HashSet<>();
        maps.stream().map(Map::keySet).forEach(union::addAll);
        return union.size();
    }

    @Override
    public boolean isEmpty() {
        return maps.stream().allMatch(Map::isEmpty);
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

}
