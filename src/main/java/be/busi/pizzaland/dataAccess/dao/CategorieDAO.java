package be.busi.pizzaland.dataAccess.dao;

import be.busi.pizzaland.dataAccess.Util.ProviderConverter;
import be.busi.pizzaland.dataAccess.entity.CategorieEntity;
import be.busi.pizzaland.dataAccess.repository.CategorieRepository;
import be.busi.pizzaland.model.CategorieEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategorieDAO {

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private ProviderConverter providerConverter;

    public CategorieEnum save(CategorieEnum categorie){

        CategorieEntity categorieEntity = providerConverter.categorieEnumToCategorieEntity(categorie);
        CategorieEntity categorieSaved = categorieRepository.save(categorieEntity);
        return providerConverter.categorieEntityToCategorieEnum(categorieSaved);
    }
}
