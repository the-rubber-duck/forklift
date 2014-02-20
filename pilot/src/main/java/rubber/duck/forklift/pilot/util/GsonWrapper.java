package rubber.duck.forklift.pilot.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import rubber.duck.forklift.pilot.server.meta.ArgumentMeta;
import rubber.duck.forklift.pilot.server.meta.ArgumentType;

/**
 * 
 * @author Peter C
 */
public class GsonWrapper {
    
    private final Gson gson;

    GsonWrapper() {
        this.gson = new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapter(ArgumentMeta.class, new ArgumentMetaTransformer())
                .create();
    }
    
    public Gson gson(){
        return gson;
    }
}

class ArgumentMetaTransformer implements JsonDeserializer<ArgumentMeta> {

    @Override
    public ArgumentMeta deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonObject object = je.getAsJsonObject();
        String name = object.get("name").getAsString();
        JsonElement element = object.get("type");
        ArgumentType argType = jdc.deserialize(element, ArgumentType.class);
        return new ArgumentMeta(name, argType);
    }
}
