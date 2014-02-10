package rubber.duck.forklift.id.collections;

import java.util.Map;
import rubber.duck.forklift.id.Identity;
import rubber.duck.forklift.id.generators.IdentityGenerator;

/**
 *
 * @author Peter C
 */
public class IdentityMaps {
    
    public static <K extends Identity,V> IdentityMap<K,V> create(IdentityGenerator generator, Map<K, V> map){
        return new IdentityMapWrapper(generator, map);
    }
}
