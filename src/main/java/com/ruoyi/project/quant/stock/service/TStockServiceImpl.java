package com.ruoyi.project.quant.stock.service;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.akshare.domain.Stock;
import com.ruoyi.project.akshare.service.AkshareService;
import com.ruoyi.project.quant.stock.mapper.TStockMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Service;
import com.ruoyi.project.quant.stock.domain.TStock;
import com.ruoyi.common.utils.text.Convert;
import org.springframework.transaction.annotation.Transactional;

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
    private final AkshareService akshareService;

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
    @Transactional(rollbackFor = Exception.class)
    public void sync() {
        List<Stock> stocks = this.akshareService.getStockInfoACodeName();

        List<TStock> tStocks = this.selectTStockList(new TStock());
        List<TStock> insertList = stocks
                .stream()
                .filter(s -> tStocks.stream().noneMatch(t -> s.getCode().equals(t.getStockCode())))
                .map(e -> TStock.builder()
                        .stockCode(e.getCode())
                        .stockName(e.getName())
                        .build())
                .collect(Collectors.toList());
        this.batchInsert(insertList);
    }

    @Override
    public int batchInsert(List<TStock> stocks) {

        List<List<TStock>> batches = ListUtils.partition(stocks, 200);
        // 执行批量插入操作，调用 batchInsert SQL 映射中的方法，传入当前批次的列表
        batches.forEach(this.tStockMapper::batchInsert);
        return stocks.size();
    }
}
