package ro.ubbcluj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Cosmin on 21-May-17.
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {
    @ModelAttribute(value = "pageTitle")
    public String getPageTitle() {
        return "Learning Management System";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getHomePage() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAccessDeniedPage() {
        return "accessDenied";
    }

}
