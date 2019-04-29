package com.ybb.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ybb.framework.SuperController;
import com.ybb.framework.constant.Message;
import com.ybb.framework.constant.PageCons;
import com.ybb.sys.entity.ProductInInfo;
import com.ybb.sys.entity.UserInfo;
import com.ybb.sys.service.ProductInInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WQ
 * @since 2019-04-25
 */
@RestController
@RequestMapping("/sys/product-in-info")
@Api("ProductInInfoController相关接口")
public class ProductInInfoController extends SuperController{

    @Autowired
    private ProductInInfoService productInInfoService;

    @RequestMapping(value = "/productInAdd",method = RequestMethod.POST)
    public Message productInAdd(@RequestBody ProductInInfo productInInfo){
        try {
            if(productInInfoService.save(productInInfo)){
                return Message.SUCCESS(null);
            }else {
                throw new Exception();
            }
        } catch (Exception e) {
            return Message.SERVER_EXCEPTION;
        }
    }


    @RequestMapping("/getProductPage")
    public PageCons getProductInfoPage(PageCons pageCons, @RequestParam("search[value]") String search, @RequestParam("order[0][column]") String orderColumn, @RequestParam("order[0][dir]") String orderSort){
        try {
            String orderColumnName = request.getParameter("columns[" + orderColumn + "][name]");
            IPage<ProductInInfo> result = productInInfoService.dataTableProductInInfoService(search,pageCons.getStart(),pageCons.getLength(),orderColumnName,orderSort);
            pageCons.setData(result.getRecords());
            pageCons.setRecordsTotal(Long.valueOf(result.getTotal()));
            pageCons.setRecordsFiltered(Long.valueOf(result.getTotal()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageCons;
    }
}
