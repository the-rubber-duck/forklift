package rubber.duck.forklift.pilot.parser;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rubber.duck.forklift.pilot.Pilot;
import rubber.duck.forklift.pilot.http.meta.WorkerMeta;

/**
 * Slower but more convenient PilotProcessor which scans for annotations recursively from a given package.
 * @author Peter C
 */
public class ScanningPilotProcessor extends AbstractProcessor {

    private static final Logger log = LoggerFactory.getLogger(ScanningPilotProcessor.class);

    private final String scanBase;

    public ScanningPilotProcessor(Gson gson, String scanBase) {
        super(gson);
        this.scanBase = scanBase;
    }

    public void parse() throws IOException {
        ClassPath classpath = ClassPath.from(URLClassLoader.getSystemClassLoader());
        ImmutableSet<ClassInfo> classes = classpath.getTopLevelClassesRecursive(scanBase);
        for (ClassInfo classInfo : classes) {
            for (Method method : classInfo.getClass().getMethods()) {
                if (method.isAnnotationPresent(Pilot.class)) {
                    registerMethod(classInfo, method);
                }
            }
        }
    }

    private void registerMethod(ClassInfo classInfo, Method method) {
        log.info("Registering [{}.{}] as pilot worker.", classInfo.getSimpleName(), method.getName());
        Annotation[] annotations = method.getDeclaredAnnotations();
        Pilot pilot = parseAnnotations(annotations);
        WorkerMeta meta = buildMetaData(pilot);
        
    }
}
