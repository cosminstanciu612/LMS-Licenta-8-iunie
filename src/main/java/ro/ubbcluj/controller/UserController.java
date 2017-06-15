package ro.ubbcluj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ro.ubbcluj.domain.Department;
import ro.ubbcluj.domain.User;
import ro.ubbcluj.service.UserService;
import ro.ubbcluj.util.DepartmentEditor;

import java.util.*;

/**
 * Created by Cosmin on 16-Apr-17.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final String USERS_LIST = "usersList";
    private final String USERS_DETAILS = "userDetails";

    @ModelAttribute(value = "pageTitle")
    public String getPageTitle() {
        return "Contacts";
    }

//    @ModelAttribute(value = "infoMessage")
//    public String getInfoMessage() {
//        return userService.getInfoMessage();
//    }
//

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Department.class, new DepartmentEditor(userService));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return USERS_LIST;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getUserById(Model model, @PathVariable(value = "userId") int userId) {
        model.addAttribute("user", userService.getUserById(userId));
        return USERS_DETAILS;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUserForm(Model model) {
//        model.addAttribute("departments", userService.getAllDepartments());
        model.addAttribute("departments", new ArrayList<Department>()); //todo: create DepartmentDAO
        model.addAttribute("userForm", new User());
        return "userAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(RedirectAttributes redirectAttributes, @ModelAttribute("userForm") User user, BindingResult bindingResult) {
//        TODO: check why the department is not added to the new user !
        userService.addUser(user);
        redirectAttributes.addFlashAttribute("newUserAdded", user.getEmail());
        return "redirect:/user/all";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") String id, RedirectAttributes redirectAttributes) {
        User deletedUser = userService.deleteUser(id);
        if (deletedUser != null) {
            userService.setInfoMessage("Deleted user " + deletedUser.getEmail());
        } else
            userService.setInfoMessage("No user found");
        redirectAttributes.addFlashAttribute("infoMessage", userService.getInfoMessage());
        return "redirect:/user/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEditUser(Model model, @PathVariable(value = "id") String id ) {
        model.addAttribute("userEdit", userService.getUserById(Integer.parseInt(id)));
//        model.addAttribute("departments", userService.getAllDepartments());
        model.addAttribute("departments", new ArrayList<Department>()); //todo: create deparmentDAO
        return "userEdit";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("userEdit") User user, RedirectAttributes redirectAttributes) {
        userService.editUser(user);
        redirectAttributes.addFlashAttribute("User modified");
        return "redirect:/user/all";
    }
}
