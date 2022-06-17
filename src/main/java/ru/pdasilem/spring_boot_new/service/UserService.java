package ru.pdasilem.spring_boot_new.service;

import ru.pdasilem.spring_boot_new.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> getAllUsers();
    UserModel getUserById(long id);
    void updateUserById(long id, UserModel newUser);
    void deleteUserById(long id);
    void saveUser(UserModel userModel);
}
