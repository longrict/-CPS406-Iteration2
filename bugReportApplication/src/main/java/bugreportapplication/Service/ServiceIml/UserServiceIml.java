package bugreportapplication.Service.ServiceIml;

import bugreportapplication.DAO.DAOiml.UserMapperIml;
import bugreportapplication.Service.UserService;
import bugreportapplication.model.User;

public class UserServiceIml implements UserService {
    @Override
    public Boolean login(String userName, String password) {
        UserMapperIml userMapper = new UserMapperIml();
        User user = userMapper.findUser(userName);
        return user != null && password.equals(user.getPassword());
    }

    @Override
    public Boolean register(String userName, String password, String email) {
        UserMapperIml userMapper = new UserMapperIml();
        User user = userMapper.findUser(userName);

        if (user != null) return false;

        return userMapper.addUser(userName, password, email);
    }

    @Override
    public Boolean delete(String userName) {
        UserMapperIml userMapper = new UserMapperIml();
        return userMapper.deleteUser(userName);
    }
}
