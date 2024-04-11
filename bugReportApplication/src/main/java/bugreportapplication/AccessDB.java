package bugreportapplication;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import bugreportapplication.model.BugReport;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import org.bson.conversions.Bson;
/**
 *
 * @author 
 */
public class AccessDB {
    public static MongoClient connectToDB(){
        String apiKey = System.getenv("API_KEY");
        String uri = "mongodb+srv://"+apiKey+"@cps406bugreportapplicat.gncu5jz.mongodb.net/?retryWrites=true&w=majority&appName=CPS406BugReportApplication";
        return MongoClients.create(uri);
    }
    
    public static void createReport(String title, String Description, String Priority){
        try(MongoClient mongoClient = connectToDB()){
            MongoDatabase database = mongoClient.getDatabase("BugReportApplication");
            MongoCollection<Document> collection = database.getCollection("BugReports");

            Document report = new Document("title", title).append("description", Description)
                    .append("priority", BugReport.PriorityEnum.valueOf(Priority))
                    .append("status", "Unresolved");

            collection.insertOne(report);
        }
    }
    
    public static void editReport(String old_title, String old_description, String old_priority, 
            String new_title, String new_description, String new_priority){
                deleteReport(old_title,old_description,old_priority);
                createReport(new_title,new_description,new_priority);
    }
    
    public static void deleteReport(String title,String description,String priority){
         try(MongoClient mongoClient = connectToDB()){
            MongoDatabase database = mongoClient.getDatabase("BugReportApplication");
            MongoCollection<Document> collection = database.getCollection("BugReports");
            Document report = new Document("title",title).append("description",description).append("priority",priority);
            collection.deleteOne(report);
            mongoClient.close();
        }
    }
    
    public static void resolveReport(String title, String description, String priority) {
        try (MongoClient mongoClient = connectToDB()) {
            MongoDatabase database = mongoClient.getDatabase("BugReportApplication");
            MongoCollection<Document> collection = database.getCollection("BugReports");
            Document report = new Document("title", title).append("description", description)
                    .append("priority", BugReport.PriorityEnum.valueOf(priority)).append("status", "Unresolved");
            Bson updates = Updates.combine(Updates.set("status", "Resolved"));
            collection.updateOne(report, updates);
        }
    }
    
    public static ArrayList<BugReport> getReports() {
        try(MongoClient mongoClient = connectToDB()) {
            MongoDatabase database = mongoClient.getDatabase("BugReportApplication");
            MongoCollection<Document> collection = database.getCollection("BugReports");
            
            // return
            ArrayList<BugReport> reports = new ArrayList<BugReport>();
            
            // iterating over documents
            MongoCursor<Document> cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                Document document = cursor.next();
                String title = document.getString("title");
                String desc = document.getString("description");
                String priority = document.getString("priority");
                String status = document.getString("status");
                BugReport bug = new BugReport(title, desc, priority, status);
                reports.add(bug);
            }
            
            return reports;
        } 
    }
}
