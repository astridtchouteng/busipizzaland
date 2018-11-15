package be.busi.pizzaland.dataAccess.util;

import be.busi.pizzaland.dataAccess.entity.*;
import be.busi.pizzaland.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class ProviderConverter {

    @Autowired
    private PasswordEncoder encodeur;

    public User userEntityToUserModel(UserEntity userEntity) {

        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setFirstname(userEntity.getFirstname());
        user.setEmail(userEntity.getEmail());
        user.setAdresse(userEntity.getAdresse());
        user.setSexe(userEntity.getSexe());
        user.setPassword(userEntity.getPassword());
        user.setAccountNonExpired(userEntity.isAccountNonExpired());
        user.setAccountNonLocked(userEntity.isAccountNonLocked());
        user.setCredentialsNonExpired(userEntity.isCredentialsNonExpired());
        user.setEnabled(userEntity.isEnabled());

        user.setRole(roleEntityToRole(userEntity.getRole()));

        return user;
    }

    public UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();

        if(user.getId() != null){
            userEntity.setId(user.getId());
        }
        userEntity.setUsername(user.getUsername());
        userEntity.setFirstname(user.getFirstname());
        userEntity.setAdresse(user.getAdresse());
        userEntity.setEmail(user.getEmail());
        userEntity.setSexe(user.getSexe());
        userEntity.setPassword(encodeur.encode(user.getPassword()));
        userEntity.setAccountNonExpired(user.isAccountNonExpired());
        userEntity.setAccountNonLocked(user.isAccountNonLocked());
        userEntity.setCredentialsNonExpired(user.isCredentialsNonExpired());
        userEntity.setEnabled(user.isEnabled());

        userEntity.setRole(roleToRoleEntity(user.getRole()));

        return userEntity;
    }

    public Role roleEntityToRole(RoleEntity roleEntity) {
        Role role = new Role();
        role.setId(roleEntity.getId());
        role.setNameRole(roleEntity.getRole());
        return role;
    }

    public RoleEntity roleToRoleEntity(Role role) {
        RoleEntity roleEntity = new RoleEntity();
        if(role.getId() != null) {
            roleEntity.setId(role.getId());
        }
        roleEntity.setRole(role.getNameRole());
        return roleEntity;
    }

    public Categorie categorieEntityToCategorie(CategorieEntity categorieEntity) {

        Categorie categorie = new Categorie();
        categorie.setId(categorieEntity.getId());
        categorie.setCategorie(categorieEntity.getCategorieEnum());
        return categorie;
    }

    public CategorieEntity categorieToCategorieEntity(Categorie categorie){

        CategorieEntity categorieEntity = new CategorieEntity();
        categorieEntity.setId(categorie.getId());
        categorieEntity.setCategorieEnum(categorie.getCategorie());
        return categorieEntity;
    }

    public PizzaEntity pizzaModelToPizzaEntity(Pizza pizza) {

        PizzaEntity pizzaEntity = new PizzaEntity();

         if(pizza.getId() != null) pizzaEntity.setId(pizza.getId());
        pizzaEntity.setCategorie(categorieToCategorieEntity(pizza.getCategorie()));
        pizzaEntity.setNom(pizza.getNom());
        pizzaEntity.setPrix(pizza.getPrix());
        pizzaEntity.setDescription(pizza.getDescription());

        return pizzaEntity;
    }

    public Pizza pizzaEntityToPizzaModel(PizzaEntity pizzaEntity) {

        Pizza pizza = new Pizza();
        pizza.setId(pizzaEntity.getId());
        pizza.setCategorie(categorieEntityToCategorie(pizzaEntity.getCategorie()));
        pizza.setNom(pizzaEntity.getNom());
        pizza.setPrix (pizzaEntity.getPrix());
        pizza.setDescription(pizzaEntity.getDescription());

        return pizza;
    }

    public CommandeEntity CommandeToComandeEntity(Commande commande) {

        CommandeEntity commandeEntity = new CommandeEntity();
        if(commande.getId() != null) commandeEntity.setId(commande.getId());
        commandeEntity.setEtat(etatCommandeToEtatCommandeEntity(commande.getEtatCommande()));
        commandeEntity.setUser(userModelToUserEntity(commande.getUser()));
        return commandeEntity;
    }

    public Commande commandeEntityToCommande(CommandeEntity commandeEntity) {

        Commande commande = new Commande();
        commande.setEtatCommande(etatCommandeEntityToEtatCommande(commandeEntity.getEtat()));
        commande.setUser(userEntityToUserModel(commandeEntity.getUser()));
        commande.setId(commandeEntity.getId());
        return commande;
    }

    public Ingredient ingredientEntityToIngredient(IngredientEntity ingredientEntity) {

        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientEntity.getId());
        ingredient.setNom(ingredientEntity.getNom());
        ingredient.setStock(ingredientEntity.getStock());
        return ingredient;
    }

    public IngredientEntity ingredientToIngredientEntity(Ingredient ingredient) {
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setId(ingredient.getId());
        ingredientEntity.setNom(ingredient.getNom());
        ingredientEntity.setStock(ingredient.getStock());
        return ingredientEntity;
    }

    public EtatCommandeEntity etatCommandeToEtatCommandeEntity(EtatCommande etatCommande){

        EtatCommandeEntity etatCommandeEntity = new EtatCommandeEntity();
        if(etatCommande.getId() != null)
             etatCommandeEntity.setId(etatCommande.getId());
        etatCommandeEntity.setEtatCommande(etatCommande.getEtatCommandeEnum());
        return etatCommandeEntity;
    }

    public EtatCommande etatCommandeEntityToEtatCommande(EtatCommandeEntity etatCommandeEntity){

        EtatCommande etatCommande = new EtatCommande();
        etatCommande.setId(etatCommandeEntity.getId());
        etatCommande.setEtatCommandeEnum(etatCommandeEntity.getEtatCommande());
        return etatCommande;
    }


}
