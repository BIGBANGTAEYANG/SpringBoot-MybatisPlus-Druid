package com.ybb.framework;

import com.ybb.framework.constant.Message;
import com.ybb.framework.constant.SessionConstant;
import com.ybb.sys.entity.UseLog;
import com.ybb.sys.entity.UserInfo;
import com.ybb.sys.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public abstract class SuperController {

    @Autowired
    UserInfoService userinfoService;

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected HttpSession httpSession;


    protected String pageController(){
        String page = request.getRequestURI();
        String userName = httpSession.getAttribute(SessionConstant.USER_NAME)==null?"":httpSession.getAttribute(SessionConstant.USER_NAME).toString();
        if (null==userName||"".equals(userName)){
            page =  "login";
        }else{
            String passWord = httpSession.getAttribute(SessionConstant.USER_PASSWORD)==null?"":httpSession.getAttribute(SessionConstant.USER_PASSWORD).toString();
            List<UserInfo> userInfoList = userinfoService.findUserByUserName(userName);
            if(userInfoList.size()>0&&userInfoList.get(0).getPassWord().equals(passWord)) {
                UseLogInsert(page, Message.SUCCESS(page).toString(),page);
            }else{
                page = "login";
            }
        }
        return page;
    }

    public UseLog UseLogInsert(String inMessage,String outMessage,String interfaceName) {
        UseLog useLog = new UseLog();
        useLog.setUserName(httpSession.getAttribute(SessionConstant.USER_NAME).toString());
        useLog.setInterfaceName(interfaceName);
        useLog.setUseTime(new Date());
        useLog.setInMessage(inMessage.toString());
        useLog.setOutMessage(outMessage);
        return useLog;
    }


}
