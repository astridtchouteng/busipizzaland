package be.busi.pizzaland.dataAccess.dao;

import be.busi.pizzaland.dataAccess.repository.PromotionRepository;
import be.busi.pizzaland.dataAccess.util.ProviderConverter;
import be.busi.pizzaland.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class PromotionDAO {

    @Autowired
    private ProviderConverter providerConverter;
    @Autowired
    private PromotionRepository promotionRepository;

    public Promotion getPromotionActual(LocalDateTime localDateTime){
        Promotion promotion =
                  promotionRepository.findAll()
                                     .stream()
                                     .map(promotionEntity ->
                                             providerConverter.promotionEntityToPromotion(promotionEntity))
                                     .filter(promo ->
                                         promo.getDateFin().isAfter(localDateTime))
                                     .findFirst().get();
                return promotion;
    }
}
