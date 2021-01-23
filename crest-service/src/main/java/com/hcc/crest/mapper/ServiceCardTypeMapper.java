package com.hcc.crest.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hcc.crest.entity.ServiceCardType;
import org.apache.ibatis.annotations.Param;

public interface ServiceCardTypeMapper extends BaseMapper<ServiceCardType> {

    ServiceCardType queryAppCodeByCardType(@Param("cardType") String cardType);

}