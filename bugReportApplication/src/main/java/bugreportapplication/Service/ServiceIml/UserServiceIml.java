package bugreportapplication.Service.ServiceIml;

import bugreportapplication.DAO.DAOiml.UserMapperIml;
import bugreportapplication.DTO.Result;
import bugreportapplication.Service.UserService;
import bugreportapplication.model.User;

public class UserServiceIml implements UserService {
    // Logs in a user
    //  Given user information, check if the user exists in the database and 
    //  return true if they are
    @Override
    public Boolean login(String userName, String password) {
        UserMapperIml userMapper = new UserMapperIml();
        User user = userMapper.findUserByName(userName);
        return user != null && password.equals(user.getPassword());
    }
    
    // Adds a user to the database
    //  Given user information adds the user to the database, returns a result
    //  based on if the registration was successful or wasn't (due to duplicates)
    @Override
    public Result register(String userName, String password, String email) {
        UserMapperIml userMapper = new UserMapperIml();

        //Authentication --> Checks for duplicates
        if (userMapper.findUserByName(userName) != null) return new Result("Duplicate userName", false);
        if (userMapper.findUserByEmail(email) != null) return new Result("Duplicate email", false);

        // Makes a user and returns the result
        userMapper.addUser(userName, password, email);
        return new Result("Successfully registered", true);
    }

    // Deletes user from the db, if it was succesful return true
    @Override
    public Boolean delete(String userName) {
        UserMapperIml userMapper = new UserMapperIml();
        return userMapper.deleteUser(userName);
    }
}
