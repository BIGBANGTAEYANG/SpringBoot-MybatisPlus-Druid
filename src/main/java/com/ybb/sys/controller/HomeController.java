package com.ybb.sys.controller;

import com.ybb.framework.SuperController;
import com.ybb.framework.constant.Message;
import com.ybb.framework.constant.SessionConstant;
import com.ybb.sys.entity.UserInfo;
import com.ybb.sys.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class HomeController extends SuperController{

    @Autowired
    UserInfoService userinfoService;

    @RequestMapping("/")
    public String login(){
        return pageController();
    }

    @RequestMapping("/register")
    public String register(){
        return pageController();
    }

    @RequestMapping("/charts")
    public String charts(){
        return pageController();
    }

    @RequestMapping("/tables")
    public String tables(){
        return pageController();
    }

    @RequestMapping("/index")
    public String index(){
        return pageController();
    }

    @ResponseBody
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public Message userLogin(HttpSession httpSession,@RequestParam String userName,@RequestParam String passWord){
        Message message = null;
        try {
            List<UserInfo> userInfoList = userinfoService.findUserByUserName(userName);
            if(userInfoList.size()>0&&userInfoList.get(0).getPassWord().equals(passWord)){
                httpSession.setAttribute(SessionConstant.USER_NAME,userName);
                httpSession.setAttribute(SessionConstant.USER_PASSWORD,passWord);
                message = Message.SUCCESS("/index");
            }else if (!userInfoList.get(0).getPassWord().equals(passWord)){
                message = Message.USER_PASSWORD_ERR;
            }else {
                message = Message.USER_NOT_EXIST;
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = Message.SERVER_EXCEPTION;
        }
        return message;
    }
}
