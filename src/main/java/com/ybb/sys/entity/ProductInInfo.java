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
public class ProductInInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 进货流水Id
     */
    @TableId(value = "inId", type = IdType.AUTO)
    private Integer inId;

    /**
     * 条码为ID(扫码枪直接获取，进货流水表条码可能重复)
     */
    @TableField("productId")
    private String productId;

    /**
     * 收货单上的商品编号（手动录，编号可以重复）
     */
    @TableField("productNo")
    private String productNo;

    /**
     * 收货单上的商品名称
     */
    @TableField("productName")
    private String productName;

    /**
     * 发货方姓名
     */
    @TableField("providerName")
    private String providerName;

    /**
     * 收货单上的商品颜色
     */
    @TableField("productColor")
    private String productColor;

    /**
     * 收货单上的商品尺码
     */
    @TableField("productSize")
    private String productSize;

    /**
     * 收货单上的商品不同颜色不同尺码对应的数量
     */
    @TableField("productNum")
    private Integer productNum;

    /**
     * 商品进价
     */
    @TableField("productPrice")
    private BigDecimal productPrice;

    /**
     * 商品定价
     */
    @TableField("productSetPrice")
    private BigDecimal productSetPrice;

    /**
     * 收货流水时间
     */
    @TableField("inDate")
    private LocalDateTime inDate;

    /**
     * 快递单号
     */
    @TableField("expressNo")
    private String expressNo;


}
