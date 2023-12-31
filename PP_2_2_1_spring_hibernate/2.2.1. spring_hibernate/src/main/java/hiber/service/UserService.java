package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user, Car car);
    public List<Car> listCars();
    List<User> listUsers();
    public User findUserViaCar(Car car);
}
