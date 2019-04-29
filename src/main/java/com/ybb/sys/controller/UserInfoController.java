package com.ybb.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ybb.framework.SuperController;
import com.ybb.framework.constant.Message;
import com.ybb.framework.constant.PageCons;
import com.ybb.sys.entity.UserInfo;
import com.ybb.sys.service.UserInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class UserInfoController extends SuperController{

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

    @RequestMapping("/getUserPage")
    public PageCons getUserInfoPage(PageCons pageCons,@RequestParam("search[value]") String search,@RequestParam("order[0][column]") String orderColumn, @RequestParam("order[0][dir]") String orderSort){
        try {
            String orderColumnName = request.getParameter("columns[" + orderColumn + "][name]");
            IPage<UserInfo> result = userinfoService.dataTableUserInfoService(search,pageCons.getStart(),pageCons.getLength(),orderColumnName,orderSort);
            pageCons.setData(result.getRecords());
            pageCons.setRecordsTotal(Long.valueOf(result.getTotal()));
            pageCons.setRecordsFiltered(Long.valueOf(result.getTotal()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageCons;
    }
}


