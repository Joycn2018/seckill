package com.chi.seckill.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author ChiYuhang
 * @since 2021-08-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TOrder对象", description="订单表")
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "消费者id")
    private Long customer;

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "订单中购买商品数量")
    private Integer sales;

    @ApiModelProperty(value = "订单总金额")
    private BigDecimal price;


}
