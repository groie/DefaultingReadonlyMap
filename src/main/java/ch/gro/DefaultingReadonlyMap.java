package ch.gro;

import java.util.*;

/**
 * An Implementation of a Map that can be composed of multiple maps for read only purposes.
 *
 * All writing methods will throw a NoModificationAllowedException
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
        return maps.stream().anyMatch(map -> map.containsKey(key));
    }

    @Override
    public boolean containsValue(Object value) {
        return maps.stream().anyMatch(map -> map.containsValue(value));
    }

    @Override
    public V get(Object key) {
        Optional<Map<K, V>> mapWithKey = maps.stream().filter(map -> map.containsKey(key)).findFirst();
        return mapWithKey.orElse(null).get(key);
    }

    @Override
    public V put(K key, V value) {
        throw new NoModificationAllowedException();
    }

    @Override
    public V remove(Object key) {
        throw new NoModificationAllowedException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new NoModificationAllowedException();
    }

    @Override
    public void clear() {
        throw new NoModificationAllowedException();
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
