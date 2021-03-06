package be.busi.pizzaland.controller;


import be.busi.pizzaland.service.ValidatorService;
import be.busi.pizzaland.dataAccess.dao.UserDAO;
import be.busi.pizzaland.model.Constants;
import be.busi.pizzaland.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/inscription")
@SessionAttributes({Constants.CURRENT_USER})
public class InscriptionController {

    @Autowired
    private UserDAO userDAO;

    private Map<String, String> erreurs = new HashMap<>();

    @Autowired
    private ValidatorService validatorService;

    @RequestMapping(method = RequestMethod.GET)
    public String inscription(Model model) {
        model.addAttribute("erreurs",new HashMap<>());
        model.addAttribute(Constants.CURRENT_USER,new User());
        return "integrated:inscriptionUser";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String enregistrer(Model model,
                              @Valid @ModelAttribute(value = Constants.CURRENT_USER)/*@Validated*/ User user,
                              final BindingResult errors) {

        try{
            validatorService.validationMotsDePasse(user.getPassword(), user.getConfirmPassword());
            erreurs.put("password","");
        }catch (Exception e){
            erreurs.put("password", e.getMessage());
            model.addAttribute("erreurs",erreurs);
            return "integrated:inscriptionUser";
        }

        if(errors.hasErrors()){
            return "integrated:inscriptionUser";
        }

        userDAO.save(user);
        return "redirect:/home";
    }
}
