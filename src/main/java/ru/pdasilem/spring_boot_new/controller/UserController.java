package ru.pdasilem.spring_boot_new.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pdasilem.spring_boot_new.model.UserModel;
import ru.pdasilem.spring_boot_new.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final String REDIRECT_USERS_PATH = "redirect:/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String printUsers(Model model){
        model.addAttribute("userModels", userService.getAllUsers());
        return "users/users";
    }

    //создается пустой объект user
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") UserModel userModel) {
        return "users/new";
    }
    //создается объект user и в него подтягиваются данные в соответствии с полями
    @PostMapping()
    public String createUser(@ModelAttribute("user") UserModel userModel) {
        userService.saveUser(userModel);
        return REDIRECT_USERS_PATH;
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") UserModel userModel, @PathVariable("id") long id) {
        userService.updateUserById(id, userModel);
        return REDIRECT_USERS_PATH;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return REDIRECT_USERS_PATH;
    }
}
