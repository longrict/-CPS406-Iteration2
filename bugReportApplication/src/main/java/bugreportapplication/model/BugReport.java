/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package bugreportapplication.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.Document;

import java.util.ArrayList;

/**
 *
 * @author sonma
 */

@Data
//might not be needed
public class BugReport {
    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private PriorityEnum priority;
    public enum PriorityEnum {
        High,Low,Medium
    }
    
    // Constructors
    public BugReport() {
        this.title = "Title Template";
        this.description = "Desc Template";
        this.priority = PriorityEnum.High;
        this.status = "Unresolved";
    }
    
    public BugReport(String title, String description, String priority, String status) {
        this.title = title;
        this.description = description;
        this.priority = PriorityEnum.valueOf(priority);
        this.status = status;
    }
    
    // getter for name
    public String getTitle() {
        return title;
    }
    
    public String getDesc() {
        return description;
    }
    
    public String getPriority() {
        return priority.toString();
    }
    
    public String getStatus() {
        return status;
    }

    @NonNull
    private String status;

    private ArrayList<User> users;

    public Document toDocument() {
        return new Document().append("title", title)
                .append("description", description)
                .append("priority", priority)
                .append("status", status)
                .append("users", users);
    }

    public void subscribe(User user) {
        user.subscribe(this);
        users.add(user);
    }
}

