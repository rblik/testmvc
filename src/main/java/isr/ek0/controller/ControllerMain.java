package isr.ek0.controller;

import isr.ek0.model.User;
import isr.ek0.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by JBlik on 04.08.2016.
 */
@Controller
public class ControllerMain {

    @Autowired
    private ServiceUser serviceUser;

//    to user view
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView listUsers() {
                ModelAndView modelAndView = new ModelAndView();
        List<User> users = serviceUser.getUsers();
        modelAndView.addObject("users", users).setViewName("users");
        return modelAndView;
    }

//    to user view divided to pages
    @RequestMapping(value = "/users/{pages}", method = RequestMethod.GET)
    public ModelAndView listUsersRestricted(@PathVariable int pages, HttpServletRequest request) {
        request.getSession().setAttribute("pages", pages);
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = serviceUser.getUsers();
        modelAndView.addObject("users", users).setViewName("users");
        return modelAndView;
    }

//    search user
    @RequestMapping(value = "/users/search", method = RequestMethod.POST)
    public ModelAndView searchResultListUsers(@RequestParam("userName") String userName) {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = serviceUser.findUsersByName(userName);
        modelAndView.addObject("users", users).setViewName("users");
        return modelAndView;
    }

//    to create user form
    @RequestMapping(value = "/create/form", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

//    submit creation of user
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView submitCreateUser(@Valid @ModelAttribute("user") User user, BindingResult result) throws UnsupportedEncodingException {

        if (result.hasErrors()) {
            return new ModelAndView("create");
        }
        serviceUser.addUser(user);
        return new ModelAndView("redirect:/users");
    }

//    remove user
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") Integer id) {
        serviceUser.deleteUser(id);
        return "redirect:/users";
    }

//    to edit user form
    @RequestMapping(value = "/edit/form", method = RequestMethod.GET)
    public String editUser(@RequestParam("id") Integer id, Model model) {
        User user = serviceUser.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

//    to submit edition of user
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView submitEditUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("edit");
        }
        serviceUser.editUser(user);
        return new ModelAndView("redirect:/users");
    }
}
