package ro.ubbcluj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/reports")
public class ReportsController {

    @ModelAttribute(value = "pageTitle")
    public String getPageTitle() {
        return "Reports";
    }
}
