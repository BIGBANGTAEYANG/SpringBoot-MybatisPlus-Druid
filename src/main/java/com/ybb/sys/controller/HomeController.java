package com.ybb.sys.controller;

import com.ybb.framework.constant.Message;
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
public class HomeController {

    @Autowired
    UserInfoService userinfoService;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/charts")
    public String charts(){
        return "charts";
    }

    @RequestMapping("/tables")
    public String tables(){
        return "tables";
    }

    @RequestMapping("/index")
    public String index(HttpSession httpSession){
        String page = "";
        String userName = httpSession.getAttribute("userName")==null?"":httpSession.getAttribute("userName").toString();
        if (null==userName||"".equals(userName)){
            page =  "login";
        }else{
            String passWord = httpSession.getAttribute("passWord")==null?"":httpSession.getAttribute("passWord").toString();
            List<UserInfo> userInfoList = userinfoService.findUserByUserName(userName);
            if(userInfoList.size()>0&&userInfoList.get(0).getPassWord().equals(passWord)) {
                page = "index";
            }else{
                page = "login";
            }
        }
        return page;
    }

    @ResponseBody
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public Message userLogin(HttpSession httpSession,@RequestParam String userName,@RequestParam String passWord){
        Message message = null;
        try {
            List<UserInfo> userInfoList = userinfoService.findUserByUserName(userName);
            if(userInfoList.size()>0&&userInfoList.get(0).getPassWord().equals(passWord)){
                httpSession.setAttribute("userName",userName);
                httpSession.setAttribute("passWord",passWord);
                message = Message.SUCCESS(null);
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
