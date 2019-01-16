package com.ybb.sys.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2019-01-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Employeeinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工自增ID
     */
    @TableId(value = "employeeNo", type = IdType.AUTO)
    private Integer employeeNo;

    /**
     * 员工姓名
     */
    @TableField("employeeName")
    private String employeeName;

    /**
     * 性别 0 女 1 男
     */
    @TableField("employeeSex")
    private Integer employeeSex;

    /**
     * 年纪
     */
    @TableField("employeeAge")
    private Integer employeeAge;

    /**
     * 身份证
     */
    @TableField("idCard")
    private String idCard;

    /**
     * 底薪
     */
    @TableField("basicSalary")
    private BigDecimal basicSalary;

    /**
     * 员工角色
     */
    @TableField("employeeRole")
    private String employeeRole;


}
