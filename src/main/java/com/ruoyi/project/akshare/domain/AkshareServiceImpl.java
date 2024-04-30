package com.ruoyi.project.akshare.domain;

import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.project.akshare.service.AkshareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AkshareServiceImpl implements AkshareService {
    private static final String prefix = "http://47.94.147.70:9090/api/public";
    /**
     * 股票列表
     * @return
     */
    @Override
    public List<Stock> getStockInfoACodeName() {
        String json = HttpUtils.sendGet(prefix + "/stock_info_a_code_name");
        return null;
    }
}
