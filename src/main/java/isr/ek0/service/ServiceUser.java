package isr.ek0.service;

import isr.ek0.model.User;
import isr.ek0.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JBlik on 04.08.2016.
 */

@Service
public class ServiceUser {

    public ServiceUser() {
    }

    @Autowired
    private UserDAO userDAO;

    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    public void editUser(User user) {
        userDAO.editUser(user);
    }

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    public List<User> findUsersByName(String userName) {
        return userDAO.findUsersByName(userName);
    }

    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

}
