package com.nov.virtual.bean;

import lombok.Data;

/**
 * 用户登录信息
 * @author november
 */
@Data
public class UserVirtualBean {
    private Long userId;

    private String token;

    private String ip;
}
