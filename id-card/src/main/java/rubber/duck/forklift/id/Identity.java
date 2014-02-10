package rubber.duck.forklift.id;

/**
 *
 * @author Peter C
 * @param <R>
 */
public interface Identity<R> {
    
    R getRepresentation();
    boolean match(Identity matches);
}