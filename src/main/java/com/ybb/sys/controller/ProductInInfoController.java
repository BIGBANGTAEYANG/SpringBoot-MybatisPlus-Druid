package com.ybb.sys.controller;


import com.ybb.sys.service.ProductInInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
public class ProductInInfoController {

    @Autowired
    private ProductInInfoService productInInfoService;


}
