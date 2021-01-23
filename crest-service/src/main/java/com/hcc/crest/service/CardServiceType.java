package com.hcc.crest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hcc.crest.entity.ServiceCard;
import com.hcc.crest.entity.ServiceCardType;

public interface CardServiceType extends IService<ServiceCardType> {

    ServiceCard queryServiceCard(String cardType);

}
