package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {

    void createUser(User user);
    User readUser(long id);
    void updateUser(User user);

    
    List<User> getUsers();

}
