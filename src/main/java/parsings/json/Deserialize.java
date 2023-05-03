package parsings.json;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Deserialize {
    
    public static void main(String[] args) {
        // Deserialize data from file
        Gson gson = new Gson();
        Actor actor = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/parsing_data/actor.json"))) {
            actor = gson.fromJson(br, Actor.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(actor);
        
        // Modify the actor object
        actor.setDescription("English actress and model");
        actor.getTags().add("Harry Potter");
        
        // Serialize data to file
        try (FileWriter writer = new FileWriter("src/main/resources/parsing_data/actor.json")) {
            gson.toJson(actor, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
