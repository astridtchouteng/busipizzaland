package be.busi.pizzaland;

import be.busi.pizzaland.dataAccess.entity.*;
import be.busi.pizzaland.model.CategorieEnum;
import be.busi.pizzaland.model.EtatCommande;
import be.busi.pizzaland.model.EtatCommandeEnum;
import be.busi.pizzaland.model.RoleEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import be.busi.pizzaland.dataAccess.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PizzalandApplication {

    @Autowired
    private PortionRepository portionRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private EtatCommandeRepository etatCommandeRepository;

    public static void main(String[] args) {

        SpringApplication.run(PizzalandApplication.class, args);
    }

    /*@Bean
    CommandLineRunner runIt(){

        return args ->{

            RoleEntity roleuser = new RoleEntity();
            roleuser.setRole(RoleEnum.ROLE_USER);

            roleRepository.save(roleuser);

            CategorieEntity categorieEntity = new CategorieEntity();
            categorieEntity.setCategorieEnum(CategorieEnum.VEGETARIENNE);
            categorieRepository.save(categorieEntity);

            CategorieEntity categorieEntity1 = new CategorieEntity();
            categorieEntity1.setCategorieEnum(CategorieEnum.FROMAGE);
            categorieRepository.save(categorieEntity1);

            CategorieEntity categorieEntity2 = new CategorieEntity();
            categorieEntity2.setCategorieEnum(CategorieEnum.EXOTIQUE);

            CategorieEntity categorieEntity3 = new CategorieEntity();
            categorieEntity3.setCategorieEnum(CategorieEnum.CUSTOMISEE);

            categorieRepository.save(categorieEntity);
            categorieRepository.save(categorieEntity1);
            categorieRepository.save(categorieEntity2);
            categorieRepository.save(categorieEntity3);

            PizzaEntity pizzaEntity = new PizzaEntity();
            pizzaEntity.setCategorie(categorieEntity2);
            pizzaEntity.setDescription("La pizza hawaïenne est une variété de pizza qui se compose généralement de fromage et d'une base de tomate avec des morceaux de jambon et d'ananas");
            pizzaEntity.setNom("Pizza Hawaienne");
            pizzaEntity.setPrix(12.5);

            PizzaEntity pizzaEntity1 = new PizzaEntity();
            pizzaEntity1.setCategorie(categorieEntity2);
            pizzaEntity1.setNom("Pizza Maurice");
            pizzaEntity1.setPrix(6);

            PizzaEntity pizzaEntity2 = new PizzaEntity();
            pizzaEntity2.setCategorie(categorieEntity);
            pizzaEntity2.setNom("Légumes de l'été");
            pizzaEntity2.setPrix(7.5);

            PizzaEntity pizzaEntity3 = new PizzaEntity();
            pizzaEntity3.setNom("Roulée aux légumes");
            pizzaEntity3.setCategorie(categorieEntity);
            pizzaEntity3.setPrix(8);


            PizzaEntity pizzaEntity4 = new PizzaEntity();
            pizzaEntity4.setNom("Quatres fromages");
            pizzaEntity4.setCategorie(categorieEntity1);
            pizzaEntity4.setPrix(9);


            pizzaRepository.save(pizzaEntity);
            pizzaRepository.save(pizzaEntity1);
            pizzaRepository.save(pizzaEntity2);
            pizzaRepository.save(pizzaEntity3);
            pizzaRepository.save(pizzaEntity4);


            IngredientEntity fromage = new IngredientEntity();
            fromage.setNom("Fromage");
            fromage.setStock(15);

            IngredientEntity ognons = new IngredientEntity();
            ognons.setNom("Ognons");
            ognons.setStock(10);

            IngredientEntity mozarella = new IngredientEntity();
            mozarella.setNom("Mozarella");
            mozarella.setStock(10);

            IngredientEntity tomate = new IngredientEntity();
            tomate.setNom("Tomate");
            tomate.setStock(10);

            IngredientEntity olive = new IngredientEntity();
            olive.setNom("Olive");
            olive.setStock(10);

            IngredientEntity jambon = new IngredientEntity();
            jambon.setStock(10);
            jambon.setNom("Jambon");

            IngredientEntity champigon = new IngredientEntity();
            champigon.setNom("Champignon");
            champigon.setStock(10);

            IngredientEntity lardon = new IngredientEntity();
            lardon.setStock(10);
            lardon.setNom("Lardon");

            IngredientEntity ananas = new IngredientEntity();
            ananas.setStock(10);
            ananas.setNom("Ananas");

            IngredientEntity aubergine = new IngredientEntity();
            aubergine.setStock(10);
            aubergine.setNom("Aubergine");

            IngredientEntity courgette = new IngredientEntity();
            courgette.setStock(10);
            courgette.setNom("Courgette");

            ingredientRepository.save(fromage);
            ingredientRepository.save(tomate);
            ingredientRepository.save(ananas);
            ingredientRepository.save(ognons);
            ingredientRepository.save(olive);
            ingredientRepository.save(champigon);
            ingredientRepository.save(jambon);
            ingredientRepository.save(lardon);
            ingredientRepository.save(aubergine);
            ingredientRepository.save(courgette);
            ingredientRepository.save(mozarella);

            System.out.println(fromage.getId());

            PortionId portionId = new PortionId();
            portionId.setIngredientEntity(fromage.getId());
            portionId.setPizzaEntity(pizzaEntity.getId());

            PortionEntity portionEntity = new PortionEntity();
            portionEntity.setPrimaryKey(portionId);
            portionEntity.setPortion(2);
            fromage.setStock(fromage.getStock() - portionEntity.getPortion());
            ingredientRepository.save(fromage);

            PortionId portionId1 = new PortionId();
            portionId1.setIngredientEntity(tomate.getId());
            portionId1.setPizzaEntity(pizzaEntity.getId());

            PortionEntity portionEntity1 = new PortionEntity();
            portionEntity1.setPrimaryKey(portionId1);
            portionEntity1.setPortion(1);
            tomate.setStock(tomate.getStock() - portionEntity1.getPortion());
            ingredientRepository.save(tomate);

            PortionId portionId2 = new PortionId();
            portionId2.setIngredientEntity(jambon.getId());
            portionId2.setPizzaEntity(pizzaEntity.getId());

            PortionEntity portionEntity2 = new PortionEntity();
            portionEntity2.setPrimaryKey(portionId2);
            portionEntity2.setPortion(2);
            jambon.setStock(jambon.getStock() - portionEntity2.getPortion());
            ingredientRepository.save(jambon);

            PortionId portionId3 = new PortionId();
            portionId3.setIngredientEntity(ananas.getId());
            portionId3.setPizzaEntity(pizzaEntity.getId());

            PortionEntity portionEntity3 = new PortionEntity();
            portionEntity3.setPrimaryKey(portionId3);
            portionEntity3.setPortion(3);
            ananas.setStock(ananas.getStock() - portionEntity3.getPortion());
            ingredientRepository.save(ananas);

            portionRepository.save(portionEntity);
            portionRepository.save(portionEntity1);
            portionRepository.save(portionEntity2);
            portionRepository.save(portionEntity3);

            PortionId portionId4 = new PortionId();
            portionId4.setIngredientEntity(fromage.getId());
            portionId4.setPizzaEntity(pizzaEntity1.getId());

            PortionEntity portionMaurice = new PortionEntity();
            portionMaurice.setPrimaryKey(portionId4);
            portionMaurice.setPortion(2);
            fromage.setStock(fromage.getStock() - portionMaurice.getPortion());
            ingredientRepository.save(fromage);

            PortionId portionId5 = new PortionId();
            portionId5.setIngredientEntity(tomate.getId());
            portionId5.setPizzaEntity(pizzaEntity1.getId());

            PortionEntity portionMaurice1 = new PortionEntity();
            portionMaurice1.setPrimaryKey(portionId5);
            portionMaurice1.setPortion(1);
            tomate.setStock(tomate.getStock() - portionMaurice1.getPortion());
            ingredientRepository.save(tomate);

            PortionId portionId6 = new PortionId();
            portionId6.setIngredientEntity(jambon.getId());
            portionId6.setPizzaEntity(pizzaEntity1.getId());

            PortionEntity portionMaurice2 = new PortionEntity();
            portionMaurice2.setPrimaryKey(portionId6);
            portionMaurice2.setPortion(2);
            jambon.setStock(jambon.getStock() - portionMaurice2.getPortion());
            ingredientRepository.save(jambon);


            portionRepository.save(portionMaurice);
            portionRepository.save(portionMaurice1);
            portionRepository.save(portionMaurice2);

            PortionId portionId7 = new PortionId();
            portionId7.setIngredientEntity(ognons.getId());
            portionId7.setPizzaEntity(pizzaEntity2.getId());


            PortionEntity portionLegumesEte = new PortionEntity();
            portionLegumesEte.setPrimaryKey(portionId7);
            portionLegumesEte.setPortion(2);
            ognons.setStock(ognons.getStock() - portionLegumesEte.getPortion());
            ingredientRepository.save(ognons);

            PortionId portionId8 = new PortionId();
            portionId8.setIngredientEntity(aubergine.getId());
            portionId8.setPizzaEntity(pizzaEntity2.getId());

            PortionEntity portionLegumesEte2 = new PortionEntity();
            portionLegumesEte2.setPrimaryKey(portionId8);
            portionLegumesEte2.setPortion(1);
            aubergine.setStock(aubergine.getStock() - portionLegumesEte2.getPortion());
            ingredientRepository.save(aubergine);

            PortionId portionId9 = new PortionId();
            portionId9.setIngredientEntity(courgette.getId());
            portionId9.setPizzaEntity(pizzaEntity2.getId());

            PortionEntity portionLegumesEte1 = new PortionEntity();
            portionLegumesEte1.setPrimaryKey(portionId9);
            portionLegumesEte1.setPortion(2);
            courgette.setStock(courgette.getStock() - portionLegumesEte1.getPortion());
            ingredientRepository.save(courgette);


            portionRepository.save(portionLegumesEte);
            portionRepository.save(portionLegumesEte1);
            portionRepository.save(portionLegumesEte2);

            PortionId portionId10 = new PortionId();
            portionId10.setIngredientEntity(jambon.getId());
            portionId10.setPizzaEntity(pizzaEntity3.getId());


            PortionEntity portionRoulee = new PortionEntity();
            portionRoulee.setPrimaryKey(portionId10);
            portionRoulee.setPortion(2);
            jambon.setStock(jambon.getStock() - portionRoulee.getPortion());
            ingredientRepository.save(jambon);

            PortionId portionId11 = new PortionId();
            portionId11.setIngredientEntity(mozarella.getId());
            portionId11.setPizzaEntity(pizzaEntity3.getId());

            PortionEntity portionRoulee1 = new PortionEntity();
            portionRoulee1.setPrimaryKey(portionId11);
            portionRoulee1.setPortion(1);
            mozarella.setStock(mozarella.getStock() - portionRoulee1.getPortion());
            ingredientRepository.save(mozarella);

            PortionId portionId12 = new PortionId();
            portionId12.setIngredientEntity(fromage.getId());
            portionId12.setPizzaEntity(pizzaEntity3.getId());

            PortionEntity portionRoulee2 = new PortionEntity();
            portionRoulee2.setPrimaryKey(portionId12);
            portionRoulee2.setPortion(2);
            fromage.setStock(fromage.getStock() - portionRoulee2.getPortion());
            ingredientRepository.save(fromage);

            portionRepository.save(portionRoulee2);
            portionRepository.save(portionRoulee1);
            portionRepository.save(portionRoulee);

            PortionId portionId13 = new PortionId();
            portionId13.setIngredientEntity(mozarella.getId());
            portionId13.setPizzaEntity(pizzaEntity4.getId());

            PortionEntity portionFromage = new PortionEntity();
            portionFromage.setPrimaryKey(portionId13);
            portionFromage.setPortion(2);
            mozarella.setStock(mozarella.getStock() - portionFromage.getPortion());
            ingredientRepository.save(mozarella);

            PortionId portionId14 = new PortionId();
            portionId14.setIngredientEntity(champigon.getId());
            portionId14.setPizzaEntity(pizzaEntity4.getId());

            PortionEntity portionFromage1 = new PortionEntity();
            portionFromage1.setPrimaryKey(portionId14);
            portionFromage1.setPortion(1);
            champigon.setStock(champigon.getStock() - portionFromage1.getPortion());
            ingredientRepository.save(champigon);

            PortionId portionId15 = new PortionId();
            portionId15.setIngredientEntity(jambon.getId());
            portionId15.setPizzaEntity(pizzaEntity4.getId());

            PortionEntity portionFromage2 = new PortionEntity();
            portionFromage2.setPrimaryKey(portionId15);
            portionFromage2.setPortion(2);
            jambon.setStock(jambon.getStock() - portionFromage2.getPortion());
            ingredientRepository.save(jambon);

            PortionId portionId16 = new PortionId();
            portionId16.setIngredientEntity(olive.getId());
            portionId16.setPizzaEntity(pizzaEntity4.getId());

            PortionEntity portionFromage3 = new PortionEntity();
            portionFromage3.setPrimaryKey(portionId16);
            portionFromage3.setPortion(3);
            olive.setStock(olive.getStock() - portionFromage3.getPortion());
            ingredientRepository.save(olive);


            portionRepository.save(portionFromage);
            portionRepository.save(portionFromage1);
            portionRepository.save(portionFromage2);
            portionRepository.save(portionFromage3);


            EtatCommandeEntity paye = new EtatCommandeEntity();
            paye.setEtatCommande(EtatCommandeEnum.PAYE);

            EtatCommandeEntity nonPaye = new EtatCommandeEntity();
            nonPaye.setEtatCommande(EtatCommandeEnum.NON_PAYE);

            EtatCommandeEntity livraison = new EtatCommandeEntity();
            livraison.setEtatCommande(EtatCommandeEnum.LIVRAISON);

            EtatCommandeEntity livree = new EtatCommandeEntity();
            livree.setEtatCommande(EtatCommandeEnum.LIVREE);

            EtatCommandeEntity preparation = new EtatCommandeEntity();
            preparation.setEtatCommande(EtatCommandeEnum.PREPARATION);

            etatCommandeRepository.save(paye);
            etatCommandeRepository.save(nonPaye);
            etatCommandeRepository.save(livraison);
            etatCommandeRepository.save(livree);
            etatCommandeRepository.save(preparation);

            PromotionEntity promotionEntity = new PromotionEntity();
            promotionEntity.setCodePromo("java");
            promotionEntity.setDateDebut(LocalDateTime.now());
            promotionEntity.setDateFin(LocalDateTime.now().plusDays(2));

            promotionRepository.save(promotionEntity);

        };
    }*/
}
