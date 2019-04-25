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
public class BackInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 退货流水Id
     */
    @TableId(value = "backId", type = IdType.AUTO)
    private Integer backId;

    /**
     * 退货商品编号
     */
    @TableField("backProductId")
    private String backProductId;

    /**
     * 退货数量
     */
    @TableField("backProductNum")
    private Integer backProductNum;

    /**
     * 员工编号(退货员工)
     */
    @TableField("backEmployeeNo")
    private Integer backEmployeeNo;

    /**
     * 退货单号
     */
    @TableField("backExpressNo")
    private String backExpressNo;

    /**
     * 退货时间
     */
    @TableField("backDate")
    private LocalDateTime backDate;


}
