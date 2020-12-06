package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * 分页查询参数
 * @author november
 */
@Data
@ApiModel(value = "分页查询参数",description="/api/**/query")
public class PageVo {

    @ApiModelProperty(value="页数",name="page",required=true)
    @NonNull
    private Integer page;

    @ApiModelProperty(value="数据行数",name="limit",required=true)
    @NonNull
    private Integer limit;
}
