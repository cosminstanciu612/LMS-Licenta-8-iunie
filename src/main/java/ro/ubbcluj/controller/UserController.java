package ro.ubbcluj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ro.ubbcluj.domain.Department;
import ro.ubbcluj.domain.Training;
import ro.ubbcluj.domain.User;
import ro.ubbcluj.service.TrainingService;
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


    @Autowired
    private TrainingService trainingService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Department.class, new DepartmentEditor(userService));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("departments", userService.getAllDepartments());
        return USERS_LIST;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getUserById(Model model, @PathVariable(value = "userId") int userId) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        model.addAttribute("trainingsParticipated", trainingService.getTrainingsByParticipant(user));
        return USERS_DETAILS;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUserForm(Model model) {
        model.addAttribute("departments", userService.getAllDepartments());
        model.addAttribute("userForm", new User());
        return "userAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(RedirectAttributes redirectAttributes, @ModelAttribute("userForm") User user, BindingResult bindingResult) {
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
    public String getEditUser(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("userEdit", userService.getUserById(Integer.parseInt(id)));
        model.addAttribute("departments", userService.getAllDepartments());
        return "userEdit";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("userEdit") User user, RedirectAttributes redirectAttributes) {
        userService.editUser(user);
        redirectAttributes.addFlashAttribute("User modified");
        return "redirect:/user/all";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchUsers(@RequestParam(value = "searchTerm") String searchTerm,
                              @RequestParam(value = "department") String department,
                              Model model) {
        model.addAttribute("selectedDepartment", department);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("users", userService.searchUsers(searchTerm, department));
        model.addAttribute("departments", userService.getAllDepartments());
        return "usersList";

    }

    @RequestMapping(value = "/add-training/{userId}", method = RequestMethod.GET)
    public String getNotAssignedTrainings(@PathVariable("userId") String userId, Model model) {
        model.addAttribute("userId", userId);
        model.addAttribute("trainings", trainingService.getTrainingsWithoutTrainer(userService.getAllTrainers()));
        model.addAttribute("trainingsWithoutTrainer", true);
        return "trainingsList";
    }

    @RequestMapping(value = "/add-training/{userId}/{trainingId}", method = RequestMethod.GET)
    public String addTrainingToTrainer(@PathVariable("userId") String userId, @PathVariable("trainingId") String trainingId) {
        User user = userService.getUserById(Integer.parseInt(userId));
        Training training = trainingService.getTrainingById(Integer.parseInt(trainingId));
        user.getTrainingsHeld().add(training);
        userService.editUser(user);
        return "redirect:/user/edit/" + userId;
    }

    @RequestMapping(value = "/delete-training/{userId}/{trainingId}", method = RequestMethod.GET)
    public String deleteTrainingFromTrainer(@PathVariable("userId") String userId, @PathVariable("trainingId") String trainingId) {
        Training training =trainingService.getTrainingById(Integer.parseInt(trainingId));
        User user = userService.getUserById(Integer.parseInt(userId));
        user.getTrainingsHeld().remove(training);
        userService.editUser(user);
        return "redirect:/user/edit/" + userId;
    }
}
