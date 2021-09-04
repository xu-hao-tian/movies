package com.example.movies.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 影视
 * </p>
 *
 * @author 许昊天
 * @since 2021-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduMovies对象", description="影视")
public class EduMovies implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "影视ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "影视演员ID")
    private String actorId;

    @ApiModelProperty(value = "影视专业ID")
    private String subjectId;

    @ApiModelProperty(value = "影视专业父级ID")
    private String subjectParentId;

    @ApiModelProperty(value = "影视标题")
    private String title;

    @ApiModelProperty(value = "影视销售价格，设置为0则可免费观看")
    private BigDecimal price;

    @ApiModelProperty(value = "总段数")
    private Integer videoNum;

    @ApiModelProperty(value = "影视封面图片路径")
    private String cover;

    @ApiModelProperty(value = "销售数量")
    private Long buyCount;

    @ApiModelProperty(value = "浏览数量")
    private Long viewCount;

    @ApiModelProperty(value = "乐观锁")
    private Long version;

    @ApiModelProperty(value = "影视状态 Draft未发布  Normal已发布")
    private String status;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;


}
