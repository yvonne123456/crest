package com.hcc.crest.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hcc.crest.entity.ServiceCard;
import com.hcc.crest.entity.ServiceCardType;
import com.hcc.crest.mapper.ServiceCardMapper;
import com.hcc.crest.mapper.ServiceCardTypeMapper;
import com.hcc.crest.request.CardTypeRequest;
import com.hcc.crest.service.CardService;
import com.hcc.crest.service.CardServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Objects;


@Service
public class CardServiceImpl extends ServiceImpl<ServiceCardMapper, ServiceCard> implements CardService {


    @Resource
    private ServiceCardMapper serviceCardMapper;
    @Resource
    private ServiceCardTypeMapper serviceCardMapperType;

    @Resource
    private CardServiceType cardServiceType;

    @Override
    public void updateServiceCard(CardTypeRequest cardTypeRequest) {

        // 获取卡类型
        ServiceCardType serviceCardType = getServiceCardType(cardTypeRequest);


        ServiceCard card = new ServiceCard();
        card.setAppName(cardTypeRequest.getAppName());
        card.setImage(cardTypeRequest.getImage());
        card.setStatus(cardTypeRequest.getStatus());
        card.setRemark(cardTypeRequest.getRemark());
        card.setAppCode(serviceCardType.getAppCode());

        serviceCardMapper.updateServiceCard(card);
    }

    /**
     * 参数校验
     * 获取serviceCardType
     * @param cardTypeRequest
     * @return
     */
    private ServiceCardType getServiceCardType(CardTypeRequest cardTypeRequest) {
        /**
         * 参数校验
         */
        Assert.hasText(cardTypeRequest.getCardType(),"cardType is null");
        Assert.hasText(cardTypeRequest.getAppName(),"appName is null");
        Assert.isNull(cardTypeRequest.getStatus(),"status is null");
        Assert.hasText(cardTypeRequest.getImage(),"image is null");
        Assert.hasText(cardTypeRequest.getRemark(),"remark is null");

        // 查询将要编辑的数据是否存在
        ServiceCardType serviceCardType = serviceCardMapperType.
                queryAppCodeByCardType(cardTypeRequest.getCardType());

        if (Objects.isNull(serviceCardType)) {
            throw new RuntimeException("该数据不存在");
        }
        return serviceCardType;
    }

    @Override
    public void DeleteServiceById(Long id) {
       this.removeById(id);

    }




}
