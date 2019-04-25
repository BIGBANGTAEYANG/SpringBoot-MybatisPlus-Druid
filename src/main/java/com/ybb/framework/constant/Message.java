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

    public static Message SERVER_EXCEPTION = new Message(false,500100,"服务端异常",null);
    public static Message PARAMETER_ISNULL = new Message(false,500101,"输入参数为空",null);
    // 业务异常
    public static Message USER_NOT_EXSIST = new Message(false,500102,"用户不存在",null);
    public static Message SESSION_NOT_EXSIST =  new Message(false,500103,"不存在离线session数据",null);
    public static Message NOT_FIND_DATA = new Message(false,500104,"查找不到对应数据",null);

    public static Message SUCCESS(Object data){
        return new Message(true,200,"success",data);
    }

}
