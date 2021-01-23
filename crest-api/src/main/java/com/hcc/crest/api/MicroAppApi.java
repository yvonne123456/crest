package com.hcc.crest.api;

import com.hcc.crest.request.CardTypeRequest;
import com.hcc.crest.request.Response;
import com.hcc.crest.vo.ServiceCardVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RequestMapping("Card")
@Api(tags = "卡类型",description = "卡类型文档接口")
public interface MicroAppApi {

   @PostMapping("/update")
   @ApiOperation(value = "修改卡类型")
   Response<Void> updateServiceCard (@RequestBody CardTypeRequest cardTypeRequest);


   @GetMapping("/query")
   @ApiOperation(value = "查询卡类型")
   Response<ServiceCardVO> queryServiceCard(@RequestParam String cardType);


   @DeleteMapping("/{id}")
   @ApiOperation(value = "根据id删除卡类型")
   Response<Void> DeleteService(@PathVariable("id")Long id);


}
