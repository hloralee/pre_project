package springboot.ProjectBoot.dao;


import springboot.ProjectBoot.models.User;

import java.util.List;

public interface UserDAO {
    public List<User> index();
    public User show(int id);
    public void save(User user);
    public void update(User updatedUser);
    public void delete(int id);
}
