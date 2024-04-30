package com.ruoyi.project.quant.stock.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.quant.stock.domain.TStock;
import com.ruoyi.project.quant.stock.service.ITStockService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 股票Controller
 *
 * @author ruoyi
 * @date 2024-04-30
 */
@Controller
@RequestMapping("/quant/stock")
public class TStockController extends BaseController {
    private String prefix = "quant";

    @Autowired
    private ITStockService tStockService;

    @RequiresPermissions("quant:stock:view")
    @GetMapping()
    public String stock() {
        return prefix + "/list";
    }

    /**
     * 查询股票列表
     */
    @RequiresPermissions("quant:stock:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TStock tStock) {
        startPage();
        List<TStock> list = tStockService.selectTStockList(tStock);
        return getDataTable(list);
    }

    /**
     * 导出股票列表
     */
    @RequiresPermissions("quant:stock:export")
    @Log(title = "股票", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TStock tStock) {
        List<TStock> list = tStockService.selectTStockList(tStock);
        ExcelUtil<TStock> util = new ExcelUtil<TStock>(TStock.class);
        return util.exportExcel(list, "股票数据");
    }

    /**
     * 新增股票
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存股票
     */
    @RequiresPermissions("quant:stock:add")
    @Log(title = "股票", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TStock tStock) {
        return toAjax(tStockService.insertTStock(tStock));
    }

    /**
     * 修改股票
     */
    @RequiresPermissions("quant:stock:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TStock tStock = tStockService.selectTStockById(id);
        mmap.put("tStock", tStock);
        return prefix + "/edit";
    }

    /**
     * 修改保存股票
     */
    @RequiresPermissions("quant:stock:edit")
    @Log(title = "股票", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TStock tStock) {
        return toAjax(tStockService.updateTStock(tStock));
    }

    /**
     * 删除股票
     */
    @RequiresPermissions("quant:stock:remove")
    @Log(title = "股票", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tStockService.deleteTStockByIds(ids));
    }

    @RequiresPermissions("quant:stock:sync")
    @Log(title = "股票数据同步", businessType = BusinessType.UPDATE)
    @PostMapping("/sync")
    @ResponseBody
    public AjaxResult sync() {
        logger.info("开始同步数据中");
        this.tStockService.sync();
        return toAjax(true);
    }
}
