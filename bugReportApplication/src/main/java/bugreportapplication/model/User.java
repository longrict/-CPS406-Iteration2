package bugreportapplication.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bson.Document;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
// Handles what a User is and functions related to the user object
public class User {
    @NonNull
    private String userName;

    @NonNull
    private String email;

    @NonNull
    private String password;

    private ArrayList<BugReport> bugReports;

    public Document toDocument() {
        return new Document().append("userName", this.userName)
                .append("email", this.email)
                .append("password", password)
                .append("bugReports", bugReports);
    }

    public void subscribe(BugReport report) {
        bugReports.add(report);
    }
}
