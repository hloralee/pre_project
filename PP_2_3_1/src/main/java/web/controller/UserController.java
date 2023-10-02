package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService carService) {
        this.userService = carService;
    }

    @GetMapping("/user")
    public String showAllOrId(@RequestParam(value = "id", required = false) Integer id, ModelMap model) {
        if (id == null) {
            model.addAttribute("users", userService.index());
        } else {
            model.addAttribute("users", userService.show(id));
            return "/id";
        }
        return "/user";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("users") User user) {
        return "/new";
    }

    @PostMapping()
    public String createUpdate(@RequestParam(value = "id", required = false) Integer id,
                         @ModelAttribute("users") User user) {
        if (id == null) {
            userService.save(user);
        } else {
            userService.update(user);
        }
        return "redirect:/user";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("users") User user) {
        userService.delete(user.getId());
        return "redirect:/user";
    }
}
