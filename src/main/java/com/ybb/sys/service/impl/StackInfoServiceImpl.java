package com.ybb.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ybb.sys.entity.StackInfo;
import com.ybb.sys.entity.UserInfo;
import com.ybb.sys.mapper.StackInfoMapper;
import com.ybb.sys.service.StackInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WQ
 * @since 2019-04-25
 */
@Service
public class StackInfoServiceImpl extends ServiceImpl<StackInfoMapper, StackInfo> implements StackInfoService {

    @Autowired
    StackInfoMapper stackInfoMapper;

    @Override
    public IPage<StackInfo> dataTableStackInfoService(String search, int start, int length, String orderColumnName, String orderSort) {
        QueryWrapper<StackInfo> queryWrapper = new QueryWrapper<>();
        IPage<StackInfo> page = new Page<>(start,length);
        if(orderSort.equals("asc")){
            queryWrapper.orderByAsc(orderColumnName);
        }else{
            queryWrapper.orderByDesc(orderColumnName);
        }
        queryWrapper.like("userName",search).or().like("passWord",search);
        return stackInfoMapper.selectPage(page,queryWrapper);
    }
}
