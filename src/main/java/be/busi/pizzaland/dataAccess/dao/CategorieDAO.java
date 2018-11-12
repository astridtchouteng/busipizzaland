package be.busi.pizzaland.dataAccess.dao;

import be.busi.pizzaland.dataAccess.util.ProviderConverter;
import be.busi.pizzaland.dataAccess.entity.CategorieEntity;
import be.busi.pizzaland.dataAccess.repository.CategorieRepository;
import be.busi.pizzaland.model.CategorieEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategorieDAO {

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private ProviderConverter providerConverter;

    public CategorieEnum save(CategorieEnum categorie){

        CategorieEntity categorieEntity = providerConverter.categorieEnumToCategorie(categorie);
        CategorieEntity categorieSaved = categorieRepository.save(categorieEntity);
        return providerConverter.categorieEntityToCategorieEnum(categorieSaved);
    }

    public Set<CategorieEnum> getAll() {

        Set<CategorieEntity> categorieEntities = categorieRepository.findAll().stream().collect(Collectors.toSet());

        return categorieEntities.stream().map(categorieEntity ->
                providerConverter.categorieEntityToCategorieEnum(categorieEntity)).collect(Collectors.toSet());
    }
}
