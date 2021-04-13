package com.nov.virtual.Service.Impl;

import com.nov.virtual.Service.FileService;
import com.nov.virtual.Service.StrategyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: november
 * @CreateTime: 2021/4/7 11:36 上午
 * @UpdateTIme:
 */
@Service
@Slf4j
public class StrategyServiceImpl implements StrategyService {
    @Autowired
    FileService fileService;

    /**
     * Created by IntelliJ IDEA.
     *
     * @return
     * @Description: 买币策略
     * @author november
     * @CreateTime: 2021/4/7 11:35 上午
     * @UpdateTIme:
     */
    @Override
    public String strategyBuy() {
        return null;
    }

    /**
     * Created by IntelliJ IDEA.
     *
     * @return
     * @Description: 卖币策略
     * @author november
     * @CreateTime: 2021/4/7 11:35 上午
     * @UpdateTIme:
     */
    @Override
    public String strategySell() {
        return null;
    }
}
