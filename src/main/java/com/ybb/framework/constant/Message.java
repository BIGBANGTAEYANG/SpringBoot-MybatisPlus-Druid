package com.ybb.framework.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private boolean returnStatus;
    private int returnCode;
    private String returnMsg;
    private Object data;

    // 通用异常
    public static Message SERVER_EXCEPTION = new Message(false,500,"服务端异常",null);

    // 业务异常
    public static Message PARAMETER_ISNULL = new Message(false,500201,"输入参数为空",null);
    public static Message NOT_FIND_DATA = new Message(false,500202,"查找不到对应数据",null);
    public static Message SESSION_NOT_EXIST =  new Message(false,500203,"不存在session数据",null);

    //登录注册
    public static Message USER_NOT_EXIST = new Message(false,500101,"用户不存在",null);
    public static Message USER_PASSWORD_ERR = new Message(false,500102,"登录密码错误",null);
    public static Message USERNAME_REPEAT = new Message(false,500103,"用户名重复",null);





    public static Message SUCCESS(Object data){
        return new Message(true,200,"成功",data);
    }

}
