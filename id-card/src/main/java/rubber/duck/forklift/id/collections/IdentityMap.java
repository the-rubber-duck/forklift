package rubber.duck.forklift.id.collections;

import java.util.Map;
import rubber.duck.forklift.id.Identity;

/**
 *
 * @author Peter C
 * @param <K>
 * @param <V>
 */
public interface IdentityMap<K extends Identity, V> extends Map<K, V> {
    
}
