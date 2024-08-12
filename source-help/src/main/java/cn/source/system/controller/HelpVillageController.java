package cn.source.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.source.common.annotation.Log;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.enums.BusinessType;
import cn.source.system.domain.HelpVillage;
import cn.source.system.service.IHelpVillageService;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.common.core.page.TableDataInfo;

/**
 * 互助信息小区Controller
 * 
 * @author zjx
 * @date 2023-04-18
 */
@RestController
@RequestMapping("/help/village")
public class HelpVillageController extends BaseController
{
    @Autowired
    private IHelpVillageService helpVillageService;

    /**
     * 查询互助信息小区列表
     */
    @PreAuthorize("@ss.hasPermi('help:village:list')")
    @GetMapping("/list")
    public TableDataInfo list(HelpVillage helpVillage)
    {
        startPage();
        List<HelpVillage> list = helpVillageService.selectHelpVillageList(helpVillage);
        return getDataTable(list);
    }

    /**
     * 导出互助信息小区列表
     */
    @PreAuthorize("@ss.hasPermi('help:village:export')")
    @Log(title = "互助信息小区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HelpVillage helpVillage)
    {
        List<HelpVillage> list = helpVillageService.selectHelpVillageList(helpVillage);
        ExcelUtil<HelpVillage> util = new ExcelUtil<HelpVillage>(HelpVillage.class);
        util.exportExcel(response, list, "互助信息小区数据");
    }

    /**
     * 获取互助信息小区详细信息
     */
    @PreAuthorize("@ss.hasPermi('help:village:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(helpVillageService.selectHelpVillageById(id));
    }

    /**
     * 新增互助信息小区
     */
    @PreAuthorize("@ss.hasPermi('help:village:add')")
    @Log(title = "互助信息小区", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HelpVillage helpVillage)
    {
        return toAjax(helpVillageService.insertHelpVillage(helpVillage));
    }

    /**
     * 修改互助信息小区
     */
    @PreAuthorize("@ss.hasPermi('help:village:edit')")
    @Log(title = "互助信息小区", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HelpVillage helpVillage)
    {
        return toAjax(helpVillageService.updateHelpVillage(helpVillage));
    }

    /**
     * 删除互助信息小区
     */
    @PreAuthorize("@ss.hasPermi('help:village:remove')")
    @Log(title = "互助信息小区", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(helpVillageService.deleteHelpVillageByIds(ids));
    }
}
