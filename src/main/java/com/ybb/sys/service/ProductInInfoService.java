package com.ybb.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ybb.sys.entity.ProductInInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ybb.sys.entity.UserInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WQ
 * @since 2019-04-25
 */
public interface ProductInInfoService extends IService<ProductInInfo> {

    IPage<ProductInInfo> dataTableProductInInfoService(String search, int start, int length, String orderColumn, String orderSort);

}
