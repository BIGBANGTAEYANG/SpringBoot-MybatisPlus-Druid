package com.ybb.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ybb.framework.SuperController;
import com.ybb.framework.constant.PageCons;
import com.ybb.sys.entity.ProductInInfo;
import com.ybb.sys.entity.StackInfo;
import com.ybb.sys.service.StackInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/sys/stack-info")
public class StackInfoController extends SuperController{


    @Autowired
    StackInfoService stackInfoService;

    @RequestMapping("/getStackPage")
    public PageCons getStackInfoPage(PageCons pageCons, @RequestParam("search[value]") String search, @RequestParam("order[0][column]") String orderColumn, @RequestParam("order[0][dir]") String orderSort){
        try {
            String orderColumnName = request.getParameter("columns[" + orderColumn + "][name]");
            IPage<StackInfo> result = stackInfoService.dataTableStackInfoService(search,pageCons.getStart(),pageCons.getLength(),orderColumnName,orderSort);
            pageCons.setData(result.getRecords());
            pageCons.setRecordsTotal(Long.valueOf(result.getTotal()));
            pageCons.setRecordsFiltered(Long.valueOf(result.getTotal()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageCons;
    }

}
