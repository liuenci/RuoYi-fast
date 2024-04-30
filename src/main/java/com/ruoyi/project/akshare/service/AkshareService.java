package com.ruoyi.project.akshare.service;

import com.ruoyi.project.akshare.domain.Stock;

import java.util.List;

public interface AkshareService {

    /**
     * 股票列表
     * @return
     */
    List<Stock> getStockInfoACodeName();
}
