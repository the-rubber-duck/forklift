package rubber.duck.forklift.pilot.parser;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Peter C
 */
public class PilotProcessor extends AbstractProcessor {
    
    private static final Logger log = LoggerFactory.getLogger(PilotProcessor.class);

    public PilotProcessor(Gson gson) {
        super(gson);
    }
    
    
}
