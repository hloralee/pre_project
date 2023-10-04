package springboot.ProjectBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.ProjectBoot.dao.UserDAO;
import springboot.ProjectBoot.models.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> index() {
        return userDAO.index();
    }
    @Transactional(readOnly = true)
    @Override
    public User show(int id) {
        return userDAO.show(id);
    }
    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);
    }
    @Transactional
    @Override
    public void update(User updatedUser) {
        userDAO.update(updatedUser);
    }
    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}
