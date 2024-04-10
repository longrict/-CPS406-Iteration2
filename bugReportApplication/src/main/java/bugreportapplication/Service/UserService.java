package bugreportapplication.Service;

import bugreportapplication.DTO.Result;

/**
 * User Related Methods
 */
public interface UserService {
    Boolean login(String userName, String password);

    Result register(String userName, String password, String email);

    Boolean delete(String userName);
}
