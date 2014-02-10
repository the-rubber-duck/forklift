package rubber.duck.forklift.id.cards;

import rubber.duck.forklift.id.Identity;

/**
 *
 * @author Peter C
 */
public class BasicIdentity implements Identity<Integer> {
    
    private final int id;

    public BasicIdentity(int id) {
        this.id = id;
    }

    @Override
    public Integer getRepresentation() {
        return id;
    }

    @Override
    public boolean match(Identity matches) {
        if (matches instanceof BasicIdentity){
            return (id == (Integer) matches.getRepresentation());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BasicIdentity other = (BasicIdentity) obj;
        return (this.id == other.id);
    }
}
