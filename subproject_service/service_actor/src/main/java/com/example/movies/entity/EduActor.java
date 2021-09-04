package com.example.movies.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 演员
 * </p>
 *
 * @author 许昊天
 * @since 2021-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduActor对象", description="演员")
public class EduActor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "演员ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "演员姓名")
    private String name;

    @ApiModelProperty(value = "演员简介")
    private String intro;

    @ApiModelProperty(value = "演员资历,一句话说明演员")
    private String career;

    @ApiModelProperty(value = "头衔 1高级演员 2首席演员")
    private Integer level;

    @ApiModelProperty(value = "演员头像")
    private String avatar;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
