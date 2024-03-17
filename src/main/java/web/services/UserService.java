package web.services;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User readUser(long id);

    User deleteUser(long parseUnsignedInt);

    void createOrUpdateUser(User user);
}
