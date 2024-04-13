package bugreportapplication;
import static com.mongodb.client.model.Filters.eq;

import bugreportapplication.model.BugReport;
import bugreportapplication.model.User;
import org.bson.Document;
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

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author David Liu, Longric Tran, Refath Ahmed, Tao Wang, Vito Carnovale (Group #33)
 *
 * Represents an AccessDB class for functions related to changing bug reports on the MongoDB
 */
public class AccessDB {

    /**
     * creates a MongoClient to allow for further interaction with the MongoDB
     *
     * @return          an instance of MongoClient
     */
    public static MongoClient connectToDB(){
        String apiKey = System.getenv("API_KEY");
        String uri = "mongodb+srv://"+apiKey+"@cps406bugreportapplicat.gncu5jz.mongodb.net/?retryWrites=true&w=majority&appName=CPS406BugReportApplication";
        return MongoClients.create(uri);
    }

    /**
     * creates uploads a bug report onto the MongoDB
     *
     * @param title        a title for the bug report; summary or maybe bug number
     * @param Description  a description for the bug report
     * @param Priority     a priority designated to the bug report; High, Medium or Low
     */
    public static void createReport(String title, String Description, String Priority){
        try(MongoClient mongoClient = connectToDB()){
            MongoDatabase database = mongoClient.getDatabase("BugReportApplication");
            MongoCollection<Document> collection = database.getCollection("BugReports");

            // get time based on time zone
            ZonedDateTime easternDateTime = ZonedDateTime.now(ZoneId.of("America/Toronto"));
            
            // date in form YYYY-MM-DD
            String formattedDate = easternDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
            
            // create document to be uploaded onto database
            Document report = new Document("title", title).append("description", Description)
                    .append("priority", BugReport.PriorityEnum.valueOf(Priority))
                    .append("status", "Unresolved")
                    .append("date",formattedDate);

            collection.insertOne(report);

            // send appropriate email to users notifying them of the creation of this report
            notifyUsers("BugReport: "+title+" has been opened!","A bug report named "+title+" has been opened.");
            mongoClient.close();
        }
    }

    /**
     * edits an existing bug report on the MongoDB
     *
     */
    public static void editReport(String old_title, String old_description, String old_priority, 
            String new_title, String new_description, String new_priority){
                deleteReport(old_title,old_description,old_priority);
                createReport(new_title,new_description,new_priority);
    }


    /**
     * edits an existing bug report on the MongoDB
     *
     * @param title        a title for the bug report to be deleted; summary or maybe bug number
     * @param Description  a description for the bug report that is to be deleted
     * @param Priority     a priority designated to the bug report that is to be deleted; High, Medium or Low
     */
    public static void deleteReport(String title,String description,String priority){
         try(MongoClient mongoClient = connectToDB()){
            MongoDatabase database = mongoClient.getDatabase("BugReportApplication");
            MongoCollection<Document> collection = database.getCollection("BugReports");

            // find specific bug report that is to be deleted based on those properties
            Document report = new Document("title",title).append("description",description).append("priority",priority);
            collection.deleteOne(report);

            // send appropriate email to users notifying them of the deletion of this report
            notifyUsers("BugReport: "+title+" has been deleted!","A bug report named "+title+" has been deleted");
            mongoClient.close();
        }
    }


    /**
     * sends an email to users about an event regarding a specific bug report
     *
     * @param subjectLine  subject line for the email that is to be sent
     * @param message      body of the email
     */
    public static void notifyUsers(String subjectLine,String message) {
        try(MongoClient mongoClient = connectToDB()){
            MongoDatabase database = mongoClient.getDatabase("BugReportApplication");
            MongoCollection<Document> collection = database.getCollection("users");
            
            // Find all documents in the collection
            try (MongoCursor<Document> cursor = collection.find().iterator()) {
                ArrayList<String> userEmails = new ArrayList<>();
                while (cursor.hasNext()) {
                    Document user = cursor.next();
                    // Process each document here
                    userEmails.add(user.getString("email"));
                }

                // send email to every user
                for (String userEmail : userEmails) {
                    SendEmailTLS.send(userEmail, subjectLine, message);
                }
            }
            mongoClient.close();
        }
    }


    /**
     * moves an existing bug report into the resolved state
     *
     * @param title        the title of the bug report that is to be resolved
     * @param description  the description of the bug report that is to be resolved
     * @param priority     the priority designated to the bug report that is to be resolved; High, Medium or Low
     */
    public static void resolveReport(String title, String description, String priority) {
        try (MongoClient mongoClient = connectToDB()) {
            MongoDatabase database = mongoClient.getDatabase("BugReportApplication");
            MongoCollection<Document> collection = database.getCollection("BugReports");
            Document report = new Document("title", title).append("description", description)
                    .append("priority", BugReport.PriorityEnum.valueOf(priority)).append("status", "Unresolved");
            Bson updates = Updates.combine(Updates.set("status", "Resolved"));
            collection.updateOne(report, updates);
            notifyUsers("BugReport: "+title+" has been resolved!","A bug report named "+title+" has been resolved");
            mongoClient.close();
        }
    }

    /**
     * creates a list of all bug reports on the database
     *
     * @return priority    an ArrayList of BugReport objects that represent all bug reports on the database
     */
    public static ArrayList<BugReport> getReports() {
        try(MongoClient mongoClient = connectToDB()) {
            MongoDatabase database = mongoClient.getDatabase("BugReportApplication");
            MongoCollection<Document> collection = database.getCollection("BugReports");
            
            // list of bug reports to be returned
            ArrayList<BugReport> reports = new ArrayList<BugReport>();
            
            // iterating over documents and collecting their details
            MongoCursor<Document> cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                Document document = cursor.next();
                String title = document.getString("title");
                String desc = document.getString("description");
                String priority = document.getString("priority");
                String status = document.getString("status");
                String date = document.getString("date");

                // create new bug report object and insert into return arraylist
                BugReport bug = new BugReport(title, desc, priority, status,date);
                reports.add(bug);
            }
            mongoClient.close();
            return reports;
        } 
    }
}
