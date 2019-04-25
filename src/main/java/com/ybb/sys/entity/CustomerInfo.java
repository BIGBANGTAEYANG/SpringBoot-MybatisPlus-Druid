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
public class CustomerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户编号
     */
    @TableId(value = "customerNo", type = IdType.AUTO)
    private Integer customerNo;

    /**
     * 顾客名称
     */
    @TableField("customerName")
    private String customerName;

    /**
     * 客户等级 ，默认为0
     */
    @TableField("customerLevel")
    private Integer customerLevel;

    /**
     * 客户电话
     */
    @TableField("customerPhone")
    private Long customerPhone;

    /**
     * 客户地址
     */
    @TableField("customerAddress")
    private String customerAddress;

    /**
     * 成为客户时间
     */
    @TableField("customerDate")
    private LocalDateTime customerDate;


}
