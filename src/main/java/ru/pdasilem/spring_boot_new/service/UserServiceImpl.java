package ru.pdasilem.spring_boot_new.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pdasilem.spring_boot_new.dao.UserDao;
import ru.pdasilem.spring_boot_new.model.UserModel;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public UserModel getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void updateUserById(long id, UserModel newUser) {
        userDao.updateUSerById(id, newUser);
    }

    @Override
    @Transactional
    public void saveUser(UserModel userModel) {
        userDao.saveUser(userModel);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userDao.deleteUSerById(id);
    }
}
