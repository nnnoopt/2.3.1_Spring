package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.models.User;
import web.services.UserService;

@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(@ModelAttribute("flashMessage") String flashAttribute, Model model){
        model.addAttribute("users", userService.getUsers());
        return "index";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("user") User user){
        return "edit";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes){
        userService.createUser(user);
        redirectAttributes.addFlashAttribute("flashMessage", "User created successfully.");
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateUserGet(@PathVariable("id") Long id, Model model) {
        User user = userService.readUser(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateUserPost(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
