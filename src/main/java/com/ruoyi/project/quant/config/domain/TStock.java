package com.ruoyi.project.quant.stock.domain;

import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 股票对象 t_stock
 *
 * @author ruoyi
 * @date 2024-04-30
 */
public class TStock extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 股票代码
     */
    @Excel(name = "股票代码")
    private String stockCode;

    /**
     * 股票名称
     */
    @Excel(name = "股票名称")
    private String stockName;
}
