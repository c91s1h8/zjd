package com.demo.common.pojo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author csh
 * @Description: TODO
 * @Date 2023-3-1 9:55
 */
@ApiModel(value="com-demo-common-pojo-domain-TUser")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_user")
public class TUser {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
     * 姓名
     */
    @TableField(value = "name")
    @ApiModelProperty(value="姓名")
    private String name;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";
}