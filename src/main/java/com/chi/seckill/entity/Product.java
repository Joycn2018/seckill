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
 * 商品表
 * </p>
 *
 * @author ChiYuhang
 * @since 2021-08-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Product对象", description="商品表")
public class Product implements Serializable {

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

    @ApiModelProperty(value = "提供此商品的商家id")
    private Long storeId;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "出售商品的单价")
    private BigDecimal perPrice;

    @ApiModelProperty(value = "商品详细信息")
    private String detail;

    @ApiModelProperty(value = "商品库存")
    private Integer inventory;

}
