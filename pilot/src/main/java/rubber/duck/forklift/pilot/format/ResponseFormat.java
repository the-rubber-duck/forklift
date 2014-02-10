package rubber.duck.forklift.pilot.format;

import rubber.duck.forklift.pilot.http.ServerResponse;

/**
 *
 * @author Peter C
 */
public interface ResponseFormat {
    
    String formatResponse(ServerResponse data);
}
