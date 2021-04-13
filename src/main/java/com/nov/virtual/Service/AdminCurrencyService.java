package com.nov.virtual.Service;

import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.admin.currency.InsertCurrencyVo;
import com.nov.virtual.vo.config.PageVo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: november
 * @CreateTime: 2021/4/10 3:24 下午
 * @UpdateTIme:
 */
public interface AdminCurrencyService {
    /**
     *
     * Created by IntelliJ IDEA.
     * @Description: 分页货币查询
     * @author november
     * @CreateTime: 2021/4/10 3:25 下午
     * @UpdateTIme:
     * @param
     * @return
     */
    ResultUtils queryCurrency(PageVo pageVo);

    /**
     *
     * Created by IntelliJ IDEA.
     * @Description: 添加货币
     * @author november
     * @CreateTime: 2021/4/10 3:25 下午
     * @UpdateTIme:
     * @param
     * @return
     */
    ResultUtils insertCurrency(InsertCurrencyVo insertCurrencyVo);

    /**
     *
     * Created by IntelliJ IDEA.
     * @Description: 删除货币
     * @author november
     * @CreateTime: 2021/4/10 3:25 下午
     * @UpdateTIme:
     * @param
     * @return
     */
    ResultUtils deleteCurrency(InsertCurrencyVo insertCurrencyVo);

    /**
     *
     * Created by IntelliJ IDEA.
     * @Description: 修改货币
     * @author november
     * @CreateTime: 2021/4/10 3:25 下午
     * @UpdateTIme:
     * @param
     * @return
     */
    ResultUtils updateCurrency(InsertCurrencyVo insertCurrencyVo);
}
