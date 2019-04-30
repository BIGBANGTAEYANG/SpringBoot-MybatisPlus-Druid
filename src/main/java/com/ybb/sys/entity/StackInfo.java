package com.ybb.sys.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

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
public class StackInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 条码为ID(扫码枪直接获取，库存表条码不能重复)
     */
    @TableId("productId")
    private String productId;

    /**
     * 库存商品编码
     */
    @TableField("productNo")
    private String productNo;

    /**
     * 库存商品名称
     */
    @TableField("productName")
    private String productName;

    /**
     * 库存商品发货商名称
     */
    @TableField("providerName")
    private String providerName;

    /**
     * 库存商品颜色
     */
    @TableField("productColor")
    private String productColor;

    /**
     * 库存商品尺码
     */
    @TableField("productSize")
    private String productSize;

    /**
     * 库存商品数量
     */
    @TableField("productNum")
    private Integer productNum;

    /**
     * 进价(初始价格以进货流水表为准)
     */
    @TableField("productPrice")
    private BigDecimal productPrice;

    /**
     * 商品定价
     */
    @TableField("productSetPrice")
    private BigDecimal productSetPrice;

    /**
     * 入库时间
     */
    @TableField("inStackDate")
    private String inStackDate;

    /**
     * 最后更新库存时间(进货，退货，销售都会更新数据）
     */
    @TableField("updateStackDate")
    private String updateStackDate;


}
