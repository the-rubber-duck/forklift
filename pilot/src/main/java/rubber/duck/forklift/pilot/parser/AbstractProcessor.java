package rubber.duck.forklift.pilot.parser;

import com.google.gson.Gson;
import java.lang.annotation.Annotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rubber.duck.forklift.pilot.PilotUrl;
import rubber.duck.forklift.pilot.server.meta.WorkerMeta;

/**
 *
 * @author Peter C
 */
public abstract class AbstractProcessor implements PilotProcessor {
    
    private static final Logger log = LoggerFactory.getLogger(AbstractProcessor.class);
    
    protected final Gson gson;

    AbstractProcessor(Gson gson) {
        this.gson = gson;
    }
    
    protected PilotUrl parseAnnotations(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof PilotUrl){
                return (PilotUrl) annotation;
            }
        }
        throw new IllegalArgumentException("Pilot Annotation not present on method! False-positive for method {isAnnotationPresent} recorded.");
    }
    
    protected WorkerMeta buildMetaData(PilotUrl pilot){
        String meta = pilot.description();
        log.debug("Building meta data from method description [{}]", meta);
        return gson.fromJson(meta, WorkerMeta.class);
    }
}
