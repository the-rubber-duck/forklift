package rubber.duck.forklift.pilot.server;

/**
 *
 * @author Peter C
 */
public interface ServerResponse {
    
    Object getReply();
    int getHttpStatus();
}