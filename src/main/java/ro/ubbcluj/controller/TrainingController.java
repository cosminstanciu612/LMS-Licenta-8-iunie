package ro.ubbcluj.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ro.ubbcluj.domain.Department;
import ro.ubbcluj.domain.Training;
import ro.ubbcluj.domain.TrainingDomain;
import ro.ubbcluj.domain.User;
import ro.ubbcluj.service.TrainingService;
import ro.ubbcluj.util.DepartmentEditor;
import ro.ubbcluj.util.TrainingDomainEditor;

/**
 * Created by Cosmin on 21-Apr-17.
 */
@Controller
@RequestMapping(value = "/training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @ModelAttribute(value = "pageTitle")
    public String getPageTitle() {
        return "Trainings";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(TrainingDomain.class, new TrainingDomainEditor(trainingService));
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getTrainingById(Model model, @PathVariable("id") int id) {
        Training training = trainingService.getTrainingById(id);
        model.addAttribute("training", training);
        model.addAttribute("trainer", trainingService.getTrainerByTraining(training));
        return "trainingDetails";
    }
//    @RequestMapping(value = "/TESTMAIL")
//    public void sendMailTest() {
//        trainingService.addParticipant();
//    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllTrainings(Model model) {
        model.addAttribute("trainings", trainingService.getAllTrainings());
        return "trainingsList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addTrainingForm(Model model) {
        model.addAttribute("trainingForm", new Training());
        model.addAttribute("domains", trainingService.getAllDomains());
        return "trainingAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(RedirectAttributes redirectAttributes, @ModelAttribute("trainingForm") Training training, BindingResult bindingResult) {
        trainingService.addTraining(training);
        redirectAttributes.addFlashAttribute("newTrainingAdded", training.getSubject());
        return "redirect:/training/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editTrainingForm(Model model, @PathVariable("id") String id) {
        model.addAttribute("trainingForm", trainingService.getTrainingById(Integer.parseInt(id)));
        model.addAttribute("domains", trainingService.getAllDomains());
        return "trainingEdit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editTraining(RedirectAttributes redirectAttributes, @ModelAttribute("trainingForm") Training training, BindingResult bindingResult) {
        trainingService.editTraining(training);
        redirectAttributes.addFlashAttribute("newTrainingAdded", training.getSubject());
        return "redirect:/training/all";
    }

    @RequestMapping(value = "/add-user/{trainingId}", method = RequestMethod.GET)
    public String addUser(@PathVariable("trainingId") String trainingId, Model model) {
        trainingService.addParticipantToTraining(trainingId);
        return "redirect:/training/" + trainingId;
    }


}
