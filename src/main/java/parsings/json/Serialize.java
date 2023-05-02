package parsings.json;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Serialize {
    
    public static void main(String[] args) {
        Actor actor = new Actor();
        actor.setName("Emma Watson");
        actor.setArtist("Paul Walker");
        actor.setDescription(null);
        actor.setTags(new ArrayList <>(List.of(new String[] {"oil", "famous"})));
        
        Gson gson = new Gson();
        
        try (FileWriter writer = new FileWriter("C:\\Users\\Davit\\IdeaProjects\\xmljson\\src\\main\\resources\\actor1.json")) {
            gson.toJson(actor, writer);
            System.out.println("Serialization successful.");
        } catch (IOException e) {
            System.err.println("Serialization failed: " + e.getMessage());
        }
    }
    
}
