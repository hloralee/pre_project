package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user, Car car) {
      user.setCar(car);
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<Car> listCars() {
      TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @Override
   public User findUserViaCar(Car car) {
      List<User> users = sessionFactory.getCurrentSession().createQuery("from User where car.model = :param1 and car.series = :param2")
              .setParameter("param1", car.getModel())
              .setParameter("param2", car.getSeries())
              .getResultList();

      return users.get(0);
   }

}
