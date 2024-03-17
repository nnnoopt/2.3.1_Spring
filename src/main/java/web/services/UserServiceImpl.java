package web.services;

import org.springframework.stereotype.Service;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User readUser(long id) {
        return null;
    }

    @Override
    public User deleteUser(long parseUnsignedInt) {
        return null;
    }

    @Override
    public void createOrUpdateUser(User user) {

    }
}
