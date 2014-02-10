package rubber.duck.forklift.pilot.http.meta;

/**
 *
 * @author Peter C
 */
public class WorkerMeta {
    private final String container;
    private final String url;
    private final ArgumentMeta[] arguments;

    public WorkerMeta(String container, String url, ArgumentMeta... arguments) {
        this.container = container;
        this.url = url;
        this.arguments = arguments;
    }

    public String getContainer() {
        return container;
    }

    public String getUrl() {
        return url;
    }

    public ArgumentMeta[] getArguments() {
        return arguments;
    }
}
