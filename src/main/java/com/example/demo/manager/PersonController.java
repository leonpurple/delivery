package com.example.demo.manager;


import com.example.demo.model.Person;
import com.example.demo.service.PersonService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class PersonController {



    @Autowired
    PersonService personService;

    @RequestMapping("/persons")
    public String getAllPersons(@ModelAttribute("persons") Model model) {
        model.addAttribute("persons", personService.getAllPersons());

        //System.out.println(PersonService.getAllPersons());
        return "personManagerView";
    }

    @RequestMapping("/emptyCreatePerson")
    public String emptyCreatePerson() {
        return "createPerson";
    }

    @RequestMapping("/createPerson")
    public String createUser(Person person) {
        personService.createPerson(person);
        return "redirect:persons";
    }

    @RequestMapping("/personCard")
    public String personCard(@RequestParam("idPerson") String id, Model model) {
        Person personFound = personService.getPerson(id);
        if (personFound != null) {
            model.addAttribute("personSendToForm", personFound);
            model.addAttribute("message", "Person found");
        } else {
            model.addAttribute("message", "Person not found");
        }
        return "editPerson";
    }

    @PostMapping("/updatePerson/{idPerson}")
    public String updatePerson(@PathVariable("idPerson") String id, Person person) {
        Person personFound = personService.getPerson(id);
        if (personFound != null) {
            personService.updatePerson(id, person);
            return "redirect:/person/persons";
        }
        return "person/personNotFound"; // TODO implement personNotFound and this template
    }

    @RequestMapping("/deletePerson")
    public String deletePerson(@RequestParam("idPerson") String id) {
        Person personFound = personService.getPerson(id);
        if (personFound != null) {
            personService.deletePerson(id);
            return "redirect:/person/persons";
        }
        return "person/personNotFound"; // TODO implement personNotFound and this template
    }

}
