package com.mycompany.springjpa.controllers;

import com.mycompany.springjpa.entities.Trainer;
import com.mycompany.springjpa.services.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class TrainersController {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "index";
    }

    TrainerService tServ = new TrainerService();
    
    @RequestMapping(value = "/trainerlist", method = RequestMethod.GET)
    public String getTrainers(ModelMap model) {
        model.addAttribute("list", tServ.getTrainers());
        return "trainerlist";
    }

    @RequestMapping(value = "/trainerlist/addTrainer", method = RequestMethod.GET)
    public String addTrainer(ModelMap model,
            @RequestParam("name") String name,
            @RequestParam("surname") String lname,
            @RequestParam("subject") String subject
    ) {
        Trainer tr = new Trainer(name, lname, subject);
        tServ.InsertTrainer(tr);
        model.addAttribute("list", tServ.getTrainers());
        return "trainerlist";
    }

    @RequestMapping(value = "/trainerlist/delete/{id}", method = RequestMethod.GET)
    public String deleteTrainer(ModelMap model, @PathVariable Integer id) {
        tServ.DeleteTrainer(id);
        model.addAttribute("list", tServ.getTrainers());
        model.addAttribute("id", "This is the id from the path: " + id);
        return "trainerlist";
    }
    
    @RequestMapping(value = "/trainerlist/update/{id}", method = RequestMethod.GET)
    public String updateTrainer(ModelMap model, @PathVariable Integer id,
            @RequestParam("name") String name,
            @RequestParam("surname") String lname,
            @RequestParam("subject") String subject
    ) {
        tServ.UpdateTrainer(id, name, lname, subject);
        model.addAttribute("list", tServ.getTrainers());
        model.addAttribute("id", "This is the id from the path: " + id);
        return "trainerlist";
    }

}
