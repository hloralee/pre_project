package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleRepository;
import ru.kata.spring.boot_security.demo.dao.UserDAO;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.*;


@Service
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, RoleRepository roleService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDAO = userDAO;
        this.roleRepository = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> index() {
        return userDAO.index();
    }
    @Transactional(readOnly = true)
    @Override
    public User show(Long id) {
        return userDAO.show(id);
    }
    @Transactional
    @Override
    public boolean save(User user) {
        User users = userDAO.findByEmail(user.getEmail());

        if (users != null) {
            return false;
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDAO.save(user);
        return true;
    }
    @Transactional
    @Override
    public void update(User updatedUser) {
        if (updatedUser.getPassword() == null) {
            updatedUser.setPassword(show(updatedUser.getId()).getPassword());
        } else {
            updatedUser.setPassword(bCryptPasswordEncoder.encode(updatedUser.getPassword()));
        }
        userDAO.update(updatedUser);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDAO.findByEmail(email);

        if (user == null)
            throw new UsernameNotFoundException("User not found!");

        return user;
    }
}
