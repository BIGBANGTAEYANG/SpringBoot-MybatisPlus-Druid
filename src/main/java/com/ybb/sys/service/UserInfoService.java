package com.ybb.sys.service;

import com.ybb.sys.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WQ
 * @since 2019-04-25
 */
public interface UserInfoService extends IService<UserInfo> {

    List<UserInfo> findUserByUserName(String userName);

}
