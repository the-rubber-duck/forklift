package rubber.duck.forklift.pilot.parser;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rubber.duck.forklift.hourglass.ImmutableTimer;
import rubber.duck.forklift.hourglass.Timer;
import rubber.duck.forklift.pilot.PilotUrl;
import rubber.duck.forklift.pilot.server.meta.WorkerMeta;
import rubber.duck.forklift.pilot.server.worker.DefaultPilotWorker;
import rubber.duck.forklift.pilot.server.worker.PilotWorker;

/**
 * Slower but more convenient PilotProcessor which scans for annotations recursively from a given package.
 * @author Peter C
 */
public abstract class ScanningPilotProcessor extends AbstractProcessor {

    private static final Logger log = LoggerFactory.getLogger(ScanningPilotProcessor.class);

    private final String scanBase;

    public ScanningPilotProcessor(Gson gson, String scanBase) {
        super(gson);
        this.scanBase = scanBase;
    }
    
    @Override
    public Set<PilotWorker> process() throws IOException {
        Timer timer = new ImmutableTimer();
        Set<PilotWorker> foundWorkers = new HashSet<>();
        
        ClassPath classpath = ClassPath.from(URLClassLoader.getSystemClassLoader());
        ImmutableSet<ClassInfo> classes = classpath.getTopLevelClassesRecursive(scanBase);
        
        for (ClassInfo classInfo : classes) {
            for (Method method : classInfo.getClass().getMethods()) {
                if (method.isAnnotationPresent(PilotUrl.class)) {
                    foundWorkers.add(registerMethod(classInfo, method));
                }
            }
        }
        
        log.info("Pilot scanner completed in [{} ms], and found [{}] workers.", timer.millis(), foundWorkers.size());
        return foundWorkers;
    }

    private PilotWorker registerMethod(ClassInfo classInfo, Method method) {
        log.info("Registering [{}.{}] as pilot worker.", classInfo.getSimpleName(), method.getName());
        Annotation[] annotations = method.getDeclaredAnnotations();
        PilotUrl pilot = parseAnnotations(annotations);
        WorkerMeta meta = buildMetaData(pilot);
        PilotWorker worker = new DefaultPilotWorker(meta, method, meta);
        throw new IllegalArgumentException("askdjaklsdjalsd");
    }
}
