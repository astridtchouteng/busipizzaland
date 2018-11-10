package be.busi.pizzaland.controller;

import be.busi.pizzaland.Service.CategorieService;
import be.busi.pizzaland.dataAccess.dao.PizzaDAO;
import be.busi.pizzaland.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/pizza")
public class PizzaController {


    @Autowired
    private PizzaDAO pizzaDAO;

    @Autowired
    private  CategorieService categorieService;

    @GetMapping
    public String home(Model model) {

        model.addAttribute("pizza", new Pizza());
        model.addAttribute("categories", categorieService.getCategories());
        return "integrated:createPizza";
    }

    @PostMapping
    public String enregitrer(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult errors) {

        if(errors.hasErrors()) {
            System.out.println(errors.getAllErrors());
            return "redirect./errors";
        }

        Pizza pizzaToBeSaved = pizza;
        pizzaToBeSaved = pizzaDAO.save(pizza);

        return "redirect:/welcome";
    }
}
