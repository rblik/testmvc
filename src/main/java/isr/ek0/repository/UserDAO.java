package isr.ek0.repository;

import isr.ek0.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by JBlik on 05.08.2016.
 */
@Repository
@Transactional
public class UserDAO {
    public UserDAO() {
    }

    @Autowired
    SessionFactory sessionFactory;

    public List<User> getUsers() {
        return (List<User>) sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void editUser(User user) {
        Query query = sessionFactory.getCurrentSession().createQuery("update User u set u.name = :name, u.age =:age, u.admin=:admin where u.id =:id");
        query.setString("name", user.getName());
        query.setInteger("age", user.getAge());
        query.setBoolean("admin", user.getAdmin());
        query.setInteger("id", user.getId());
        query.executeUpdate();
    }

    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.load(User.class, id));
    }

    public User getUserById(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    public List<User> findUsersByName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.like("name", userName + "%"));
        return criteria.list();
    }
}
