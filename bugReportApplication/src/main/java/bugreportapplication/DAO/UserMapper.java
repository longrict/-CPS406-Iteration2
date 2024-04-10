package bugreportapplication.DAO;

import bugreportapplication.model.User;

public interface UserMapper {
    public User findUser(String userName);

    Boolean addUser(String userName, String password, String email);

    Boolean deleteUser(String userName);
}
