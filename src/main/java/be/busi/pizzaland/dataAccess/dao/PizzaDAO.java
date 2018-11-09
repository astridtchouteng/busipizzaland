package be.busi.pizzaland.dataAccess.dao;

import be.busi.pizzaland.dataAccess.repository.PizzaRepository;
import be.busi.pizzaland.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class PizzaDAO {

    @Autowired
    private PizzaRepository pizzaRepository;


    public Set<Pizza> getAll() {

        return null;
    }

    /*public Pizza save(Pizza pizza) {

        pizzaRepository.save(pizza);
    }*/
}
