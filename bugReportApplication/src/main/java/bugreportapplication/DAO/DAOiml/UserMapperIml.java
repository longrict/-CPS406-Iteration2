package bugreportapplication.DAO.DAOiml;

import bugreportapplication.AccessDB;
import bugreportapplication.DAO.UserMapper;
import bugreportapplication.model.User;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class UserMapperIml implements UserMapper {

    @Override
    /**
     * if a user is already registered, return true.
     */
    public User findUser(String userName) {
        try(MongoClient mongoClient = AccessDB.connectToDB()){
            MongoDatabase database = mongoClient.getDatabase("BugReportApplication");
            Document user = database.getCollection("users").find(new Document("userName", userName)).first();
            if (user == null) return null;
            return new User(user.getString("userName"), user.getString("email"), user.getString("password"));
        }
    }


    @Override
    public Boolean addUser(String userName, String password, String email) {
        try(MongoClient mongoClient = AccessDB.connectToDB()){
            MongoDatabase database = mongoClient.getDatabase("BugReportApplication");
            if (findUser(userName) != null) return false;
            database.getCollection("users").insertOne(new User(userName, email, password).toDocument());
        }
        return true;
    }

    @Override
    public Boolean deleteUser(String userName) {
        try(MongoClient mongoClient = AccessDB.connectToDB()){
            MongoDatabase database = mongoClient.getDatabase("BugReportApplication");
            if (findUser(userName) == null) return false;
            database.getCollection("users").deleteOne(new Document("userName", userName));
        }
        return true;
    }
}
