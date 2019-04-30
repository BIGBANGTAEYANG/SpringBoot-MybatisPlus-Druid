package com.ybb.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ybb.framework.SuperController;
import com.ybb.framework.constant.Message;
import com.ybb.framework.constant.PageCons;
import com.ybb.framework.constant.SessionConstant;
import com.ybb.sys.entity.ProductInInfo;
import com.ybb.sys.entity.UseLog;
import com.ybb.sys.service.ProductInInfoService;
import com.ybb.sys.service.UseLogService;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;


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

    @Autowired
    private UseLogService useLogService;

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/productInAdd",method = RequestMethod.POST)
    public Message productInAdd(@RequestBody Map<String,Object> map){
        try {
            String inDate = map.get("inDate").toString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm a", Locale.ENGLISH);
            Date date = dateFormat.parse(inDate);


            ProductInInfo productInInfo = new ProductInInfo();
            productInInfo.setExpressNo(map.get("expressNo").toString())
            .setProductColor(map.get("productColor").toString())
            .setProductId(map.get("productId").toString()).setProductNo(map.get("productNo").toString()).setProductName(map.get("productName").toString())
            .setProductNum(Integer.parseInt(map.get("productNum").toString())).setProductPrice(new BigDecimal(map.get("productPrice").toString()))
            .setProductSetPrice(new BigDecimal(map.get("productSetPrice").toString())).setProductSize(map.get("productSize").toString())
            .setProviderName(map.get("providerName").toString()).setInDate(new Timestamp(date.getTime()));
            boolean flag = productInInfoService.save(productInInfo);
            if(flag){
                useLogService.save(UseLogInsert(productInInfo.toString(),Message.SUCCESS(null).toString(),request.getRequestURI()));
                return Message.SUCCESS(null);
            }else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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
