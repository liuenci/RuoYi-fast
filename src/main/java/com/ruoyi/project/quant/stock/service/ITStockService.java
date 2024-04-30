package com.ruoyi.project.quant.stock.service;

import java.util.List;

import com.ruoyi.project.quant.stock.domain.TStock;

/**
 * 股票Service接口
 *
 * @author ruoyi
 * @date 2024-04-30
 */
public interface ITStockService {
    /**
     * 查询股票
     *
     * @param id 股票主键
     * @return 股票
     */
    TStock selectTStockById(Long id);

    /**
     * 查询股票列表
     *
     * @param tStock 股票
     * @return 股票集合
     */
    List<TStock> selectTStockList(TStock tStock);

    /**
     * 新增股票
     *
     * @param tStock 股票
     * @return 结果
     */
    int insertTStock(TStock tStock);

    /**
     * 修改股票
     *
     * @param tStock 股票
     * @return 结果
     */
    int updateTStock(TStock tStock);

    /**
     * 批量删除股票
     *
     * @param ids 需要删除的股票主键集合
     * @return 结果
     */
    int deleteTStockByIds(String ids);

    /**
     * 删除股票信息
     *
     * @param id 股票主键
     * @return 结果
     */
    int deleteTStockById(Long id);

    /**
     * 同步股票信息
     */
    void sync();
}
