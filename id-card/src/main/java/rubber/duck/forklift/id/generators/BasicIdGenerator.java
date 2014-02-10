package rubber.duck.forklift.id.generators;

import rubber.duck.forklift.id.Identity;
import rubber.duck.forklift.id.cards.BasicIdentity;

/**
 *
 * @author Peter C
 */
public class BasicIdGenerator implements IdentityGenerator<Integer> {
    private int last = 0;

    public BasicIdGenerator() {}
    public BasicIdGenerator(int last) {
        this.last = last;
    }

    @Override
    public <T> Identity<Integer> generate(T type) {
        Identity<Integer> id = new BasicIdentity(this.last);
        this.last++;
        return id;
    }

    @Override
    public Identity<Integer> create(Integer representation) {
        return new BasicIdentity(representation);
    }
}
