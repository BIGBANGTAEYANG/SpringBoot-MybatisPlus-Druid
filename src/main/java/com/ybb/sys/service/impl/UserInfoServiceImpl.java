package com.ybb.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ybb.sys.entity.UserInfo;
import com.ybb.sys.mapper.UserInfoMapper;
import com.ybb.sys.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WQ
 * @since 2019-04-25
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findUserByUserName(String userName) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName",userName);
        return userInfoMapper.selectList(queryWrapper);
    }

    @Override
    public IPage<UserInfo> dataTableUserInfoService(String search, int start, int length, String orderColumnName, String orderSort) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        IPage<UserInfo> page = new Page<>(start,length);
        if(orderSort.equals("asc")){
            queryWrapper.orderByAsc(orderColumnName);
        }else{
            queryWrapper.orderByDesc(orderColumnName);
        }
        queryWrapper.like("userName",search).or().like("passWord",search);
        return userInfoMapper.selectPage(page,queryWrapper);
    }
}
