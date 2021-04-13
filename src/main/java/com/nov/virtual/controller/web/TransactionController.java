package com.nov.virtual.controller.web;

import com.alibaba.fastjson.JSONObject;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.client.ApiHttp;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.config.APIConfiguration;
import com.nov.virtual.sql.model.*;
import com.nov.virtual.sql.service.CurrencyService;
import com.nov.virtual.sql.service.HoldCurrencyService;
import com.nov.virtual.sql.service.OrderService;
import com.nov.virtual.sql.service.UserVirtualService;
import com.nov.virtual.utils.UserContextUtil;
import com.nov.virtual.enums.ResultCodeEnum;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.BuyVo;
import com.nov.virtual.vo.SellVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**
 * 用户交易api
 *
 * @author november
 */
@Api(value = "用户交易Controller", tags = {"用户交易接口"})
@RestController
@RequestMapping(value = "/api/web/transaction", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {

    @Autowired
    private UserVirtualService userVirtualService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    HoldCurrencyService holdCurrencyService;

    /**
     * 用户买币
     *
     * @param buyVo
     * @return
     */
    @ApiOperation(value = "用户买币", notes = "此接口进行用户买币操作")
    @PostMapping("/buy")
    @Transactional
    public ResultUtils buy(@Validated @RequestBody BuyVo buyVo) {
        System.out.println(buyVo.getMoney()+"  "+buyVo.getCurrencyName());

        //获取最新价格
        String money = getNewPrice(buyVo.getCurrencyName());

        UserVirtual user = UserContextUtil.getUserVirtualBean().getUserVirtual();

        // 余额=钱包-购买价格
        double lastMoney = Double.parseDouble(user.getMoney()) - buyVo.getMoney();

        //判断余额是否充足
        if (lastMoney >= 0) {

            //币数
            double currencyNum = buyVo.getMoney() / Double.parseDouble(money);
            DecimalFormat dcmFmt = new DecimalFormat("0.0000000000");
            String amountStr = dcmFmt.format(currencyNum);

            //查询货币Id
            Currency currency = getCurrency(buyVo.getCurrencyName());

            //生成订单
            Order order = new Order();
            order.setOrderUserid(user.getUserid());
            order.setOrderTypeid(1);
            order.setOrderStatusid(1);
            order.setOrderprice(String.valueOf(buyVo.getMoney()));
            String orderNum=UserContextUtil.getUserVirtualBean().getUserVirtual().getUserid()+""+System.currentTimeMillis();
            order.setOrdernumber(orderNum);
            order.setOrderCurrencynum(amountStr);
            order.setOrderCurrencyid(currency.getCurrencyid());
            order.setOrderbuytime(new Date());

            //修改金额
            user.setMoney(String.valueOf(lastMoney));

            //持有货币
            List<HoldCurrency> holdCurrencyList = getHoldCurrency(user.getUserid(), currency.getCurrencyid());
            if (holdCurrencyList.size() > 0) {
                //已有持有,修改持有货币
                HoldCurrency holdCurrency = holdCurrencyList.get(0);
                holdCurrency.setHoldcurrencymoney(String.valueOf(Double.parseDouble(holdCurrency.getHoldcurrencymoney()) + buyVo.getMoney()));
                holdCurrency.setHoldcurrencynum(String.valueOf(Double.parseDouble(holdCurrency.getHoldcurrencynum()) + Double.parseDouble(amountStr)));
                holdCurrencyService.updateByKey(holdCurrency);
            } else {
                //未有持有，添加持有货币
                HoldCurrency holdCurrency = new HoldCurrency();
                holdCurrency.setHoldcurrencyCurrencyid(currency.getCurrencyid());
                holdCurrency.setHoldcurrencymoney(String.valueOf(buyVo.getMoney()));
                holdCurrency.setHoldcurrencynum(amountStr);
                holdCurrency.setHoldcurrencyUserid(user.getUserid());
                holdCurrencyService.save(holdCurrency);
            }

            orderService.save(order);
            userVirtualService.updateByKey(user);
            return ResultUtils.success();
        } else {
            return ResultUtils.fail(ResultCodeEnum.USER_NOT_MONEY);
        }
    }

    /**
     * 用户卖币
     *
     * @param sellVo
     * @return
     */
    @ApiOperation(value = "用户卖币", notes = "此接口进行用户卖币操作")
    @PostMapping("/sell")
    @Transactional
    public ResultUtils sell(@Validated @RequestBody SellVo sellVo) {
        System.out.println(sellVo.getCurrencyNum()+"  "+sellVo.getCurrencyName());
        UserVirtual user = UserContextUtil.getUserVirtualBean().getUserVirtual();

        //查询货币Id
        Currency currency = getCurrency(sellVo.getCurrencyName());

        //持有货币
        List<HoldCurrency> holdCurrencyList = getHoldCurrency(user.getUserid(), currency.getCurrencyid());

        //判断是否存在货币
        if (holdCurrencyList.size() > 0) {
            HoldCurrency holdCurrency = holdCurrencyList.get(0);
            //持有货币-double
            double holdCurrencyNum = Double.parseDouble(holdCurrency.getHoldcurrencynum());
            double currencyNum=Double.parseDouble(sellVo.getCurrencyNum());

            //判断是否有足够的货币
            if (holdCurrencyNum >= currencyNum) {
                //获取最新价格
                String money = getNewPrice(sellVo.getCurrencyName());

                //卖币价格
                double sellMoney = Double.parseDouble(money) * currencyNum;
                //余额=用户余额+卖币价格
                double lastMoney = Double.parseDouble(user.getMoney()) + sellMoney;

                //生成订单
                Order order = new Order();
                order.setOrderUserid(user.getUserid());
                order.setOrderTypeid(2);
                order.setOrderStatusid(1);
                order.setOrderprice(String.valueOf(sellMoney));
                order.setOrdernumber("xxxxxx");
                order.setOrderCurrencynum(String.valueOf(sellVo.getCurrencyNum()));
                order.setOrderCurrencyid(currency.getCurrencyid());
                order.setOrderbuytime(new Date());

                //剩余货币价值
                double moneyPrice = Double.parseDouble(holdCurrency.getHoldcurrencymoney()) / Double.parseDouble(holdCurrency.getHoldcurrencynum()) * currencyNum;

                holdCurrency.setHoldcurrencymoney(String.valueOf(Double.parseDouble(holdCurrency.getHoldcurrencymoney()) - moneyPrice));
                holdCurrency.setHoldcurrencynum(String.valueOf(Double.parseDouble(holdCurrency.getHoldcurrencynum()) - currencyNum));

                //修改金额
                user.setMoney(String.valueOf(lastMoney));

                holdCurrencyService.updateByKey(holdCurrency);
                orderService.save(order);
                userVirtualService.updateByKey(user);
                return ResultUtils.success();
            }
        }
        return ResultUtils.fail(ResultCodeEnum.USER_NOT_CURRENCY_NUM);
    }

    /**
     * 获取持有货币
     *
     * @param userId
     * @param currencyId
     * @return
     */
    private List<HoldCurrency> getHoldCurrency(long userId, Integer currencyId) {
        HoldCurrencyExample holdCurrencyExample = new HoldCurrencyExample();
        HoldCurrencyExample.Criteria holdCurrencyExampleCriteria = holdCurrencyExample.createCriteria();
        holdCurrencyExampleCriteria.andHoldcurrencyUseridEqualTo(userId);
        holdCurrencyExampleCriteria.andHoldcurrencyCurrencyidEqualTo(currencyId);
        return holdCurrencyService.getHoldCurrencyByExample(holdCurrencyExample);
    }

    /**
     * 获取最新价格
     *
     * @return
     */
    private String getNewPrice(String currencyName) {
        ApiHttp apiHttp = new ApiHttp(new APIConfiguration("https://www.okex.com"), new OkHttpClient());
        String result = apiHttp.get("/api/index/v3/" + currencyName + "-USD/constituents");
        JSONObject jsonObject = (JSONObject) JSONObject.parse(result);
        jsonObject = (JSONObject) JSONObject.parse(jsonObject.getString("data"));
        return jsonObject.getString("last");
    }

    /**
     * 查询货币ID
     *
     * @param currencyName
     * @return
     */
    private Currency getCurrency(String currencyName) {
        CurrencyExample currencyExample = new CurrencyExample();
        CurrencyExample.Criteria currencyExampleCriteria = currencyExample.createCriteria();
        currencyExampleCriteria.andCurrencynameEqualTo(currencyName);
        return currencyService.getCurrencyByExample(currencyExample).get(0);
    }
}
