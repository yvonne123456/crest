package com.hcc.crest.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hcc.crest.entity.ServiceCard;
import org.apache.ibatis.annotations.Param;



public interface ServiceCardMapper extends BaseMapper<ServiceCard> {

   int updateServiceCard(ServiceCard serviceCard);

   ServiceCard queryByAppCode(@Param("appCode") String appCode);

}