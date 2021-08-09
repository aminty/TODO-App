package repo.impl;

import base.repo.impl.BaseRepoImpl;
import entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repo.UserRepo;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepoImpl extends BaseRepoImpl<User> implements UserRepo {
    public UserRepoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public User find(int id) {
        return null;
    }

    @Override
    public User[] findAllById(int[] ids) {
        return new User[0];
    }

    @Override
    public void insert(User entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public boolean isExist(User entity) {
        List<User> users=entityManager.createQuery("from User",User.class).getResultList();
        if (users!=null)
        for (User user :users) {
            if (user.getUsername().equals(entity.getUsername()))
                return false;
        }
        return true;
    }

    @Override
    public Boolean existsById(int id) {
        return null;
    }

    @Override
    public User authentication(User entity) {
        List<User> users=entityManager.createQuery("from User",User.class).getResultList();
        if (users!=null)
            for (User user :users) {
                if (user.getUsername().equals(entity.getUsername()) &&
                        user.getPassword().equals(entity.getPassword())){
                    return user;
                }
            }
        return null;
    }
}
