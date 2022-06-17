package ru.pdasilem.spring_boot_new.dao;

import org.springframework.stereotype.Repository;
import ru.pdasilem.spring_boot_new.model.UserModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserModel> getAllUsers(){
        return entityManager.createQuery("from UserModel", UserModel.class).getResultList();
    }

    @Override
    public UserModel getUserById(Long id) {
        return entityManager.find(UserModel.class, id);
    }

    @Override
    public void saveUser(UserModel userModel) {
        entityManager.persist(userModel);
    }

    @Override
    public void updateUSerById(Long id, UserModel newUser) {
        entityManager.merge(newUser);
    }

    @Override
    public void deleteUSerById(Long id) {
        UserModel userModel = entityManager.find(UserModel.class, id);
        entityManager.remove(userModel);
    }
}

