package rubber.duck.forklift.pilot.format;

import com.google.gson.Gson;
import rubber.duck.forklift.pilot.http.ServerResponse;

/**
 *
 * @author Peter C
 */
public class JsonFormat implements ResponseFormat {
    
    private final Gson gson;

    public JsonFormat(Gson gson) {
        this.gson = gson;
    }
    
    @Override
    public String formatResponse(ServerResponse data) {
        return gson.toJson(data);
    }
}
