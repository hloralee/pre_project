package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    public List<User> index();
    public User show(int id);
    public void save(User user);
    public void update(User updatedUser);
    public void delete(int id);
}
