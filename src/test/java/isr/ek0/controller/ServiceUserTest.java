package isr.ek0.controller;

import isr.ek0.model.User;
import isr.ek0.service.ServiceUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by JBlik on 04.08.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-servlet.xml")
@WebAppConfiguration
public class ServiceUserTest {

    @Autowired
    ServiceUser serviceUser;

    @Test
    public void testingService() {
        User user = new User("Test", 25, false);
        serviceUser.addUser(user);
        assertNotNull(serviceUser.getUsers());
        int previousSize = serviceUser.getUsers().size();
        user = serviceUser.findUsersByName("Test").get(0);
        assertNotNull(user);
        serviceUser.deleteUser(user.getId());
        int presentSize = serviceUser.getUsers().size();
        assertTrue(presentSize<previousSize);
    }
}