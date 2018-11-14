package be.busi.pizzaland.controller;


import be.busi.pizzaland.dataAccess.dao.RoleDAO;
import be.busi.pizzaland.dataAccess.dao.UserDAO;
import be.busi.pizzaland.dataAccess.entity.UserEntity;
import be.busi.pizzaland.exception.UserExistsException;
import be.busi.pizzaland.model.Constants;
import be.busi.pizzaland.model.Role;
import be.busi.pizzaland.model.RoleEnum;
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
import java.util.Arrays;
import java.util.Set;

@Controller
@RequestMapping(value = "/inscription")
@SessionAttributes({Constants.CURRENT_USER})
public class InscriptionController {
    @Autowired
    private UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String inscription(Model model) {

        model.addAttribute(Constants.CURRENT_USER,new User());
        return "integrated:inscriptionUser";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String enregistrer(Model model,
                              @Valid  @ModelAttribute(value = Constants.CURRENT_USER) User user,
                              final BindingResult errors) {

        if(errors.hasErrors()){
            return "integrated:inscriptionUser";
        }

        Role role = new Role();
        role.setNameRole(RoleEnum.ROLE_USER);
        user.setRole(role);
        userDAO.save(user);

        return "redirect:/home";
    }
}
