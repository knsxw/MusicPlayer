package musicplayer;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MusicPlayer {
    
    public static void main(String[] args) {
        MongoClientURI uri = new MongoClientURI("mongodb://root:byteburst@freaks.dev/?authSource=admin");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("audioDatabase");
        MongoCollection<org.bson.Document> users = db.getCollection("users");
        LoginForm startForm = new LoginForm(users);
        startForm.setVisible(true);
        startForm.setLocationRelativeTo(null);
    }
    
}
