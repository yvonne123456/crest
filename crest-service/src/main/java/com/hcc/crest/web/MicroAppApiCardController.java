package com.hcc.crest.web;


import com.hcc.crest.api.MicroAppApi;
import com.hcc.crest.entity.ServiceCard;
import com.hcc.crest.request.CardTypeRequest;
import com.hcc.crest.request.Response;
import com.hcc.crest.request.ResponseUtils;
import com.hcc.crest.service.CardService;
import com.hcc.crest.service.CardServiceType;
import com.hcc.crest.vo.ServiceCardVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class MicroAppApiCardController implements MicroAppApi {

    @Resource
    private CardService cardService;

    @Resource
    private CardServiceType cardServiceType;

    /**
     * 更新卡类型
     *
     * @param cardTypeRequest
     * @return
     */

    @Override
    public Response<Void> updateServiceCard(@RequestBody CardTypeRequest cardTypeRequest) {

        try {
            cardService.updateServiceCard(cardTypeRequest);
            return ResponseUtils.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.fail(e.getMessage());
        }

    }

    /**
     * 查询卡类型
     *
     * @param cardType
     * @return
     */
    @Override
    public Response<ServiceCardVO> queryServiceCard(@RequestParam String cardType) {
        try {
            ServiceCard serviceCard = cardServiceType.queryServiceCard(cardType);
            ServiceCardVO serviceCardVO = new ServiceCardVO();
            serviceCardVO.setAppCode(serviceCard.getAppCode());
            serviceCardVO.setAppName(serviceCard.getAppName());
            serviceCardVO.setRemark(serviceCardVO.getRemark());
            serviceCardVO.setImage(serviceCard.getImage());
            serviceCardVO.setStatus(serviceCard.getStatus());
            return ResponseUtils.success(serviceCardVO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.fail(e.getMessage());
        }


    }

    /**
     * 删除卡类型
     *
     * @param id
     * @return
     */
    @Override
    public Response<Void> DeleteService(@PathVariable("id") Long id) {
        try {
            cardService.DeleteServiceById(id);
            return ResponseUtils.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.fail(e.getMessage());
        }

    }


}



