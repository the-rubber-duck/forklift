package rubber.duck.forklift.id.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import rubber.duck.forklift.id.Identity;
import rubber.duck.forklift.id.generators.IdentityGenerator;

/**
 *
 * @author Peter C
 * @param <K>
 * @param <V>
 */
public class IdentityMapWrapper<K extends Identity,V> implements IdentityMap<K,V> {
    
    private final Map<K, V> underlyingMap;
    private final IdentityGenerator generator;

    public IdentityMapWrapper(IdentityGenerator generator, Map<K, V> underlyingMap) {
        this.underlyingMap = underlyingMap;
        this.generator = generator;
    }

    @Override
    public int size() {
        return underlyingMap.size();
    }

    @Override
    public boolean isEmpty() {
        return underlyingMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        Object id = createIdentity(key);
        return underlyingMap.containsKey(id);
    }

    @Override
    public boolean containsValue(Object value) {
        return underlyingMap.containsValue(value);
    }

    @Override
    public V get(Object key) {
        Object id = createIdentity(key);
        return underlyingMap.get(id);
    }

    @Override
    public V put(K key, V value) {
        return underlyingMap.put(key, value);
    }

    @Override
    public V remove(Object key) {
        Object id = createIdentity(key);
        return underlyingMap.remove(id);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        underlyingMap.putAll(m);
    }

    @Override
    public void clear() {
        underlyingMap.clear();
    }

    @Override
    public Set<K> keySet() {
        return underlyingMap.keySet();
    }

    @Override
    public Collection<V> values() {
        return underlyingMap.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return underlyingMap.entrySet();
    }
    
    private Object createIdentity(Object value){
        if (value instanceof Identity){
            return value;
        }
        
        try {
            return generator.create(value);
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException("Unable to generate identity from supplied value. Please ensure the key you're attempting to use matches the representational value of the Identity implementation the generator uses.", ex);
        }
    }
}
