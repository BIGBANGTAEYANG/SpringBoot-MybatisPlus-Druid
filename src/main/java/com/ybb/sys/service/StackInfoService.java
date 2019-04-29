package com.ybb.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ybb.sys.entity.StackInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WQ
 * @since 2019-04-25
 */
public interface StackInfoService extends IService<StackInfo> {

    IPage<StackInfo> dataTableStackInfoService(String search, int start, int length, String orderColumnName, String orderSort);
}
