package com.nov.virtual.bean.ResultJsonData;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * page返回
 * @author november
 */
@Data
public class PageJsonData {
    private Integer page;
    private Integer pageSize;
    private JSONArray jsonArray;

    public PageJsonData(Integer page, Integer pageSize, JSONArray jsonArray) {
        this.page = page;
        this.pageSize = pageSize;
        this.jsonArray = jsonArray;
    }

    public JSONObject toJson() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("page",page);
        jsonObject.put("pageSize",pageSize);
        jsonObject.put("list",jsonArray);
        return jsonObject;
    }
}
