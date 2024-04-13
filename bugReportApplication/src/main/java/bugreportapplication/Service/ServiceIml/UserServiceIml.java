package bugreportapplication.Service.ServiceIml;

import bugreportapplication.DAO.DAOiml.UserMapperIml;
import bugreportapplication.DTO.Result;
import bugreportapplication.Service.UserService;
import bugreportapplication.model.User;

public class UserServiceIml implements UserService {
    @Override
    public Boolean login(String userName, String password) {
        UserMapperIml userMapper = new UserMapperIml();
        User user = userMapper.findUserByName(userName);
        return user != null && password.equals(user.getPassword());
    }

    @Override
    public Result register(String userName, String password, String email) {
        UserMapperIml userMapper = new UserMapperIml();

        //Authentication
        if (userMapper.findUserByName(userName) != null) return new Result("Duplicate userName", false);
        if (userMapper.findUserByEmail(email) != null) return new Result("Duplicate email", false);

        userMapper.addUser(userName, password, email);
        return new Result("Successfully registered", true);
    }

    @Override
    public Boolean delete(String userName) {
        UserMapperIml userMapper = new UserMapperIml();
        return userMapper.deleteUser(userName);
    }
    
    public Boolean changePassword(String userName, String oldPassword, String newPassword) {
        UserMapperIml userMapper = new UserMapperIml();
        User user = userMapper.findUserByName(userName);
        if (user != null) {
            if (oldPassword.equals(user.getPassword())) {
                delete(userName);
                register(userName, newPassword, user.getEmail());
                return true;
            }
            return false;
        } else {
            return false; 
        }
    }
}
