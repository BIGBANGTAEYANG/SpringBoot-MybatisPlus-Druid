package com.ybb.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ybb.sys.entity.Userinfo;
import com.ybb.sys.service.UserinfoService;
import io.swagger.annotations.*;
import org.apache.catalina.User;
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
 * @since 2019-01-16
 */
@RestController
@RequestMapping("/sys/userinfo")
@Api("UserInfoController相关接口")
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/saveUserInfo")
    public boolean saveUser(){
        Userinfo userinfo = new Userinfo();
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
    public List<Userinfo> getUserInfoPage(@RequestParam Integer current, @RequestParam Integer size){
        Page<Userinfo> page = new Page<>(current,size);
        IPage<Userinfo> result = userinfoService.page(page);
        return result.getRecords();
    }

}
