package com.ybb.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ybb.framework.constant.Message;
import com.ybb.sys.entity.UserInfo;
import com.ybb.sys.service.UserInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
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


    @RequestMapping("/userRegister")
    public Message userRegister(@RequestParam String userName,@RequestParam String passWord){
        Message message = null;
        try {
            if(userinfoService.findUserByUserName(userName).size()>0){
                    message = Message.USERNAME_REPEAT;
            }else{
                UserInfo userinfo = new UserInfo();
                userinfo.setPassWord(passWord);
                userinfo.setUserName(userName);
                userinfoService.save(userinfo);
                message = Message.SUCCESS(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = Message.SERVER_EXCEPTION;
        }
        return message;
    }



    @RequestMapping(value = "/userNameSearch",method = RequestMethod.POST)
    public Message userNameSearch(@RequestParam String userName){
        return Message.SUCCESS(userinfoService.findUserByUserName(userName).size());
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
    public Message getUserInfoPage(@RequestParam Integer start, @RequestParam Integer length){
        IPage<UserInfo> result = null;
        try {
            Page<UserInfo> page = new Page<>(start,length);
            result = userinfoService.page(page);
            return Message.SUCCESS(result.getRecords());
        } catch (Exception e) {
            e.printStackTrace();
            return Message.PARAMETER_ISNULL;
        }
    }
}


