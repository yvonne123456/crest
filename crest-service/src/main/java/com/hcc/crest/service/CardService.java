package com.hcc.crest.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hcc.crest.entity.ServiceCard;
import com.hcc.crest.request.CardTypeRequest;

public interface CardService extends IService<ServiceCard> {


    void updateServiceCard(CardTypeRequest cardTypeRequest);

    void DeleteServiceById(Long id);
}
