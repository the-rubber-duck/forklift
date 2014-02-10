package rubber.duck.forklift.id.generators;

import rubber.duck.forklift.id.Identity;

/**
 *
 * @author Peter C
 */
public interface IdentityGenerator<R> {
    
    <T> Identity<R> generate(T type);
    Identity<R> create(R representation);
}