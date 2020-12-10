package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * 搜索数参
 * @author november
 */
@Data
@ApiModel(value = "搜索参数",description="/api/admin/**/search")
public class SearchVo {

    @NonNull
    @ApiModelProperty(value="搜索信息",name="title",required=true)
    private String title;

    @ApiModelProperty(value="页数",name="page",required=true)
    @NonNull
    private Integer page;

    @ApiModelProperty(value="数据行数",name="limit",required=true)
    @NonNull
    private Integer limit;
}
