package com.nov.virtual.bean.resultJsonData;

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
    private long dataSize;

    public PageJsonData(Integer page, Integer pageSize, JSONArray jsonArray, long dataSize) {
        this.page = page;
        this.pageSize = pageSize;
        this.jsonArray = jsonArray;
        this.dataSize = dataSize;
    }

    public JSONObject toJson() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("page",page);
        jsonObject.put("pageSize",pageSize);
        jsonObject.put("dataSize",dataSize);
        jsonObject.put("list",jsonArray);
        return jsonObject;
    }
}
