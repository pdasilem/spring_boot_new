package ru.pdasilem.spring_boot_new.dao;

import ru.pdasilem.spring_boot_new.model.UserModel;

import java.util.List;

public interface UserDao {
    List<UserModel> getAllUsers();
    UserModel getUserById(Long id);
    void saveUser(UserModel userModel);
    void deleteUSerById(Long id);
    void updateUSerById(Long id, UserModel newUser);
}
