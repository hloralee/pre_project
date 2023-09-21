package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user, Car car);
   public List<Car> listCars();
   List<User> listUsers();
   public User findUserViaCar(Car car);
}
