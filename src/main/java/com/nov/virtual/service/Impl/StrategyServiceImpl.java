package com.nov.virtual.service.Impl;

import com.nov.virtual.config.HadoopConfig;
import com.nov.virtual.service.FileService;
import com.nov.virtual.service.StrategyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

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
        String[] currencys = {"ETH","BTC","ADA", "LTC", "XRP"};
        String res="";
        for(String currency:currencys){
            String str = fileService.queryTxtFilePath(currency, HadoopConfig.CP_OUTPUT_FILE);
            String[] split = str.split(",");
            for(String a:split){
                if(a.substring(0,1).equals("0")){
                    DecimalFormat df = new DecimalFormat("0.00%");
                    res+=currency+"的涨幅几率为："+df.format(Double.parseDouble(a.substring(1)))+"\n";
                }
            }
        }
        return res;
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
        String[] currencys = {"ETH","BTC","ADA", "LTC", "XRP"};
        String res="";
        for(String currency:currencys){
            String str = fileService.queryTxtFilePath(currency, HadoopConfig.CP_OUTPUT_FILE);
            String[] split = str.split(",");
            for(String a:split){
                if(a.substring(0,1).equals("1")){
                    DecimalFormat df = new DecimalFormat("0.00%");
                    res+=currency+"的降幅几率为："+df.format(Double.parseDouble(a.substring(1)))+"\n";
                }
            }
        }
        return res;
    }
}
