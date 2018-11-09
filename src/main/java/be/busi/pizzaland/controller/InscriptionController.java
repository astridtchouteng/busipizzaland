package be.busi.pizzaland.controller;


import be.busi.pizzaland.dataAccess.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/inscription")
public class InscriptionController {

    // je dois utiliser User et pas UserEntity
    @ModelAttribute("user")
    public UserEntity userEntity(){
        return new UserEntity();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String inscription() {

        return "integrated:inscriptionUser";
    }

    @RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
    public String enregistrer() {

        return "integrated:welcome";
    }
}
