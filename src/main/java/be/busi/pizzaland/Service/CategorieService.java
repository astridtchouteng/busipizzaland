package be.busi.pizzaland.Service;

import be.busi.pizzaland.model.CategorieEnum;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.util.*;

@Service
public class CategorieService {

    Set<CategorieEnum> categories = new HashSet<>();

}
