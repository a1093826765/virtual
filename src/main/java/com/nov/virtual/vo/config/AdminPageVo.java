package com.nov.virtual.vo.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * 分页查询(带userId)
 * @author november
 */
@Data
@ApiModel(value = "分页查询参数(带userId)",description="/api/admin/**/query")
public class AdminPageVo {
    @ApiModelProperty(value="页数",name="page",required=true)
    @NonNull
    private Integer page;

    @ApiModelProperty(value="数据行数",name="limit",required=true)
    @NonNull
    private Integer limit;

    @ApiModelProperty(value="用户Id",name="userId",required=true)
    @NonNull
    private long userId;
}
