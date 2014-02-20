package rubber.duck.forklift.pilot.format;

import rubber.duck.forklift.pilot.server.ServerResponse;

/**
 *
 * @author Peter C
 */
public interface ResponseFormat {
    
    String formatResponse(ServerResponse data);
}
