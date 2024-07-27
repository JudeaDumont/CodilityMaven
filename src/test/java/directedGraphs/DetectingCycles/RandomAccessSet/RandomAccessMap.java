package directedGraphs.DetectingCycles.RandomAccessSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomAccessMap<K, V> {
    private final Map<K, V> map;
    private final List<V> list;

    // Default constructor
    public RandomAccessMap() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    // Constructor that takes an existing Map
    public RandomAccessMap(Map<K, V> initialMap) {
        this();
        for (Map.Entry<K, V> entry : initialMap.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    public V put(K key, V value) {
        if (!map.containsKey(key)) {
            list.add(value);
        } else {
            list.set(list.indexOf(map.get(key)), value);
        }
        return map.put(key, value);
    }

    public V remove(K key) {
        V value = map.remove(key);
        if (value != null) {
            list.remove(value);
        }
        return value;
    }

    public V at(int i) {
        if (list.isEmpty()) {
            return null;
        }
        if(i>=list.size()) {
            throw new IndexOutOfBoundsException();
        }
        return list.get(i);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public boolean containsValue(V value) {
        return map.containsValue(value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public void clear() {
        map.clear();
        list.clear();
    }
}