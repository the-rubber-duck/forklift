package rubber.duck.forklift.pilot.http.meta;

/**
 *
 * @author Peter C
 */
public class ArgumentMeta {
    private final String name;
    private final ArgumentType type;

    public ArgumentMeta(String name, ArgumentType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public ArgumentType getType() {
        return type;
    }
}
