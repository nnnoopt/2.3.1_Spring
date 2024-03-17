package web.dao;

import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void createUser(User user) {

    }

    @Override
    public User readUser(long id) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}
