package bugreportapplication.DAO;

import bugreportapplication.model.User;

public interface UserMapper {
    public User findUserByName(String userName);

    User findUserByEmail(String email);

    Boolean addUser(String userName, String password, String email);

    Boolean deleteUser(String userName);
}
