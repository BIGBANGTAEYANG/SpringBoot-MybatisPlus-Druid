package com.ybb.sys.entity;

import java.math.BigDecimal;
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
public class SellInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 销售流水Id
     */
    @TableId(value = "sellId", type = IdType.AUTO)
    private Integer sellId;

    /**
     * 销售人员编号
     */
    @TableField("sellEmployeeNo")
    private String sellEmployeeNo;

    /**
     * 销售商品Id(使用条码扫描直接减库存)
     */
    @TableField("sellProductId")
    private String sellProductId;

    /**
     * 客户编号
     */
    @TableField("sellCustomerNo")
    private String sellCustomerNo;

    /**
     * 销售数量
     */
    @TableField("sellNum")
    private Integer sellNum;

    /**
     * 销售价格(具体价格以销售填写为准)
     */
    @TableField("sellPrice")
    private BigDecimal sellPrice;

    /**
     * 销售流水时间
     */
    @TableField("sellDate")
    private LocalDateTime sellDate;

    /**
     * 销售备注(如打折)
     */
    @TableField("sellRemark")
    private String sellRemark;


}
