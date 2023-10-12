package ru.kata.spring.boot_security.demo.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;


import javax.persistence.*;
import java.util.List;
import java.util.Optional;


@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);

        return query.getResultList();
    }

    public User findByEmail(String email) {
        String jpql = "SELECT u FROM User u where u.email=:param1";
        List<User> user = entityManager.createQuery(jpql, User.class)
                .setParameter("param1", email).getResultList();
        if (user.isEmpty()) {
            return null;
        }

        return user.get(0);
    }

    @Override
    public List<User> show(Long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            return null;
        }
        return List.of(user);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User update(User updatedUser) {
        return entityManager.merge(updatedUser);
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);

        entityManager.remove(user);
    }

}

