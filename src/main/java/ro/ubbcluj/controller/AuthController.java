package ro.ubbcluj.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ro.ubbcluj.dao.UserDAO;
import ro.ubbcluj.domain.PasswordChange;
import ro.ubbcluj.domain.User;
import ro.ubbcluj.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Cosmin on 18-Jun-17.
 */
@Controller
public class AuthController {

    @Autowired
    private UserDAO userDAO;

    @ModelAttribute(value = "pageTitle")
    public String getPageTitle() {
        return "Login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Model model) {
        model.addAttribute("loginForm", new User());
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }


    @RequestMapping(value = "/my-account", method = RequestMethod.GET)
    public String myAccount(Model model) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user", userDAO.getUserByEmail(email));
        return "userDetails";
    }

    @RequestMapping(value = "/my-account/change-password", method = RequestMethod.GET)
    public String getChangePasswordPage(Model model) {
        model.addAttribute("passwordChange", new PasswordChange());
        return "changePassword";
    }

    @RequestMapping(value = "/my-account/change-password", method = RequestMethod.POST)
    public String changePassword(@ModelAttribute("passwordChange") PasswordChange passwordChange,
                                 RedirectAttributes redirectAttributes) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userDAO.getUserByEmail(email);
        if (StringUtils.isNotEmpty(passwordChange.getCurrentPassword()) &&
                StringUtils.isNotEmpty(passwordChange.getNewPassword()) &&
                StringUtils.isNotEmpty(passwordChange.getConfirmPassword())) {
            if (user.getPassword().equals(passwordChange.getCurrentPassword())) {
                if (passwordChange.getNewPassword().equals(passwordChange.getConfirmPassword())) {
                    user.setPassword(passwordChange.getNewPassword());
                    userDAO.editUser(user);
                    redirectAttributes.addFlashAttribute("infoMessage", "Password updated");
                    return "redirect:/my-account";
                }
            }
        }
        redirectAttributes.addFlashAttribute("infoMessage", "Try again");
        return "redirect:/my-account/change-password";

    }

}
