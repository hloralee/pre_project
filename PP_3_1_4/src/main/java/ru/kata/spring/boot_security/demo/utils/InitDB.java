package ru.kata.spring.boot_security.demo.utils;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dao.RoleRepository;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitDB {

    private final RoleRepository roleRepository;
    private final UserService userService;

    public InitDB(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @PostConstruct
    private void fillDb() {
        Role roleAdmin = new Role(1L, "ROLE_ADMIN");
        Role roleUser = new Role(2L, "ROLE_USER");

        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        User user = new User("hloralee@gmail.com", "Ramil", "Sinyakaev", 30, "1234");
        user.addRoles(roleAdmin);
        user.addRoles(roleUser);

        userService.save(user);
    }
}
