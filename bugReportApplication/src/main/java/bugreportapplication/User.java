package bugreportapplication;

import lombok.Data;

import java.util.ArrayList;

@Data
public class User {
    private String userName;
    private String email;
    private String password;
    private ArrayList<bugReport> bugReports;
}
