package bugreportapplication.Service;

import bugreportapplication.model.BugReport;

/**
 * User Related Methods
 */
public interface UserService {
    Boolean login(String userName, String password);

    Boolean register(String userName, String password, String email);

    Boolean delete(String userName);
}
