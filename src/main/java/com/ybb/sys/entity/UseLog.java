package com.ybb.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author WQ
 * @since 2019-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UseLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "logNo", type = IdType.AUTO)
    private Integer logNo;

    /**
     * 用户名称
     */
    @TableField("userName")
    private String userName;

    /**
     * 访问接口
     */
    @TableField("interfaceName")
    private String interfaceName;

    /**
     * 接口入参
     */
    @TableField("inMessage")
    private String inMessage;

    /**
     * 接口出参
     */
    @TableField("outMessage")
    private String outMessage;

    /**
     * 使用接口时间
     */
    @TableField("useTime")
    private LocalDateTime useTime;


}
