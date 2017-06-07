package ro.ubbcluj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Cosmin on 21-May-17.
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET)
    public String getHomePage() {
        return "home";
    }

}
