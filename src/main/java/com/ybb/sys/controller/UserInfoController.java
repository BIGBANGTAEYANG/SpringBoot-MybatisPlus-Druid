package com.ybb.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ybb.framework.constant.Message;
import com.ybb.sys.entity.UserInfo;
import com.ybb.sys.service.UserInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WQ
 * @since 2019-04-25
 */
@RestController
@RequestMapping("/sys/user-info")
@Api("UserInfoController相关接口")
public class UserInfoController {

    @Autowired
    private UserInfoService userinfoService;

    @RequestMapping("/saveUserInfo")
    public boolean saveUser(){
        UserInfo userinfo = new UserInfo();
        userinfo.setPassWord("666");
        userinfo.setUserName("wq");
        boolean returnData  = userinfoService.save(userinfo);
        return returnData;
    }

    @ApiOperation(value = "分页查询",notes = "分页查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current",value = "当前页数",dataType = "Integer",paramType = "int",example = "0"),
            @ApiImplicitParam(name = "size",value = "每页数量",dataType = "Integer",paramType = "int",example = "10")
    })
    @ApiResponses({
            @ApiResponse(code=400,message = "请求参数错误"),
            @ApiResponse(code=404,message="请求路径没错误")
    })
    @RequestMapping("/getUserPage")
    public Message getUserInfoPage(@RequestParam Integer current, @RequestParam Integer size){
        IPage<UserInfo> result = null;
        try {
            if(current==0){
                throw new Exception();
            }
            Page<UserInfo> page = new Page<>(current,size);
            result = userinfoService.page(page);
            return Message.SUCCESS(result.getRecords());
        } catch (Exception e) {
            return Message.PARAMETER_ISNULL;
        }
    }
}


