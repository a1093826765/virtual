package com.nov.virtual.bean;

import com.nov.virtual.sql.model.UserVirtual;
import lombok.Data;

/**
 * 用户登录信息
 * @author november
 */
@Data
public class UserVirtualBean {
    private UserVirtual userVirtual;

    private String token;

    private String ip;
}
