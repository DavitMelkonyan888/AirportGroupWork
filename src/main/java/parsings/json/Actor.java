package parsings.json;

import java.util.List;

class Actor {
    private String name;
    private String artist;
    private String description;
    private List<String> tags;
    
    public Actor () {
    }
    
    public Actor (String name, String artist, String description, List <String> tags) {
        this.name = name;
        this.artist = artist;
        this.description = description;
        this.tags = tags;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<String> getTags() {
        return tags;
    }
    
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    
    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", description='" + description + '\'' +
                ", tags=" + tags +
                '}';
    }
}