package rubber.duck.forklift.pilot.parser;

import java.io.IOException;
import java.util.Set;
import rubber.duck.forklift.pilot.server.worker.PilotWorker;

/**
 *
 * @author Peter C
 */
public interface PilotProcessor {
    Set<PilotWorker> process() throws IOException;
}
