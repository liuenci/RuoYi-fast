package com.ruoyi.project.quant.stock.service;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.quant.stock.mapper.TStockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ruoyi.project.quant.stock.domain.TStock;
import com.ruoyi.common.utils.text.Convert;

/**
 * 股票Service业务层处理
 *
 * @author ruoyi
 * @date 2024-04-30
 */
@Service
@RequiredArgsConstructor
public class TStockServiceImpl implements ITStockService {

    private final TStockMapper tStockMapper;

    /**
     * 查询股票
     *
     * @param id 股票主键
     * @return 股票
     */
    @Override
    public TStock selectTStockById(Long id) {
        return tStockMapper.selectTStockById(id);
    }

    /**
     * 查询股票列表
     *
     * @param tStock 股票
     * @return 股票
     */
    @Override
    public List<TStock> selectTStockList(TStock tStock) {
        return tStockMapper.selectTStockList(tStock);
    }

    /**
     * 新增股票
     *
     * @param tStock 股票
     * @return 结果
     */
    @Override
    public int insertTStock(TStock tStock) {
        tStock.setCreateTime(DateUtils.getNowDate());
        return tStockMapper.insertTStock(tStock);
    }

    /**
     * 修改股票
     *
     * @param tStock 股票
     * @return 结果
     */
    @Override
    public int updateTStock(TStock tStock) {
        tStock.setUpdateTime(DateUtils.getNowDate());
        return tStockMapper.updateTStock(tStock);
    }

    /**
     * 批量删除股票
     *
     * @param ids 需要删除的股票主键
     * @return 结果
     */
    @Override
    public int deleteTStockByIds(String ids) {
        return tStockMapper.deleteTStockByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除股票信息
     *
     * @param id 股票主键
     * @return 结果
     */
    @Override
    public int deleteTStockById(Long id) {
        return tStockMapper.deleteTStockById(id);
    }

    /**
     * 同步股票信息
     */
    @Override
    public void sync() {

    }


}
