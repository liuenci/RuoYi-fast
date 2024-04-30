package com.ruoyi.project.quant.stock.mapper;

import java.util.List;

import com.ruoyi.project.quant.stock.domain.TStock;

/**
 * 股票Mapper接口
 *
 * @author ruoyi
 * @date 2024-04-30
 */
public interface TStockMapper {
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
     * 删除股票
     *
     * @param id 股票主键
     * @return 结果
     */
    int deleteTStockById(Long id);

    /**
     * 批量删除股票
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteTStockByIds(String[] ids);

    /**
     * 批量插入股票信息
     * @param stocks
     * @return
     */
    int batchInsert(List<TStock> stocks);
}
