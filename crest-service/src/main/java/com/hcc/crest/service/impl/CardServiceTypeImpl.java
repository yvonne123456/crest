package com.hcc.crest.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hcc.crest.entity.ServiceCard;
import com.hcc.crest.entity.ServiceCardType;
import com.hcc.crest.mapper.ServiceCardMapper;
import com.hcc.crest.mapper.ServiceCardTypeMapper;
import com.hcc.crest.service.CardServiceType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class CardServiceTypeImpl extends ServiceImpl<ServiceCardTypeMapper, ServiceCardType> implements CardServiceType {

    @Resource
    private  ServiceCardTypeMapper serviceCardTypeMapper;

    @Resource
    private ServiceCardMapper serviceCardMapper;

    @Override
    public ServiceCard queryServiceCard(String cardType) {

        if (StringUtils.isBlank(cardType)) {
            throw new RuntimeException("非法的参数");
        }

        ServiceCardType serviceCardType = serviceCardTypeMapper
                .queryAppCodeByCardType(cardType);

        if (Objects.isNull(serviceCardType)) {
            throw new RuntimeException("非法的参数");
        }

        String appCode = serviceCardType.getAppCode();


        ServiceCard serviceCard = serviceCardMapper.queryByAppCode(appCode);

        if (Objects.isNull(serviceCard)) {
            throw new RuntimeException("非法的参数");
        }

        return serviceCard;
    }

}
