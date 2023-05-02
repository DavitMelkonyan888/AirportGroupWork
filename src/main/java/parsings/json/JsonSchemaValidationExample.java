package parsings.json;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JsonSchemaValidationExample {
    public static void main(String[] args) {
        try {
            // Load the JSON Schema from file
            Schema schema = SchemaLoader.load(new JSONObject(new String(Files.readAllBytes(new File("C:\\Users\\Davit\\IdeaProjects\\xmljson\\src\\main\\resources\\actor_scheme.json").toPath()))));
            
            // Load the JSON document from file
            JSONObject actorJson = new JSONObject(new JSONTokener(String.valueOf(new File("C:\\Users\\Davit\\IdeaProjects\\xmljson\\src\\main\\resources\\actors.json"))));
            
            // Validate the JSON document against the schema
            schema.validate(actorJson);
            
            System.out.println("Validation successful!");
        } catch (ValidationException e) {
            // Handle validation errors
            System.err.println("Validation error(s):");
            e.getAllMessages().forEach(System.err::println);
        } catch (IOException e) {
            // Handle I/O errors
            System.err.println("Error loading file:");
            e.printStackTrace();
        }
    }
}
