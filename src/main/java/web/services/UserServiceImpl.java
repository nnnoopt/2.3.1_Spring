package web.services;

import org.springframework.stereotype.Service;
import web.dao.UserDaoHibernateImpl;
import web.models.User;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDaoHibernateImpl userDaoHibernate;

    public UserServiceImpl(UserDaoHibernateImpl userDaoHibernate) {
        this.userDaoHibernate = userDaoHibernate;
    }

    @Override
    public List<User> getUsers() {
        return userDaoHibernate.getUsers();
    }

    @Override
    public User readUser(long id) {
        return userDaoHibernate.readUser(id);
    }

    @Override
    public User deleteUser(long id) {
        User user = null;
        try {
            user = userDaoHibernate.deleteUser(id);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void createUser(User user) {
        userDaoHibernate.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDaoHibernate.updateUser(user);
    }
}
