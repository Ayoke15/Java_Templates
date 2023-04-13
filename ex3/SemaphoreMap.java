package ex3;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SemaphoreMap<K, V> implements Map<K, V>{

    private Map<K, V> map = new HashMap<>();
    private Semaphore sem = new Semaphore(2);

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return map.get(key);
    }

    @Override
    public V put(K key, V value) {
        try {
            sem.acquire();
            V result = map.put(key, value);
            sem.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public V remove(Object key) {
        try {
            sem.acquire();
            V result = map.remove(key);
            sem.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        try {
            sem.acquire();
            map.putAll(m);
            sem.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clear() {
        try {
            sem.acquire();
            map.clear();
            sem.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return map.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }
}
