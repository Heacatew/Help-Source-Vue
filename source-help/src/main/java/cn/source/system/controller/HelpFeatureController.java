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
import cn.source.system.domain.HelpFeature;
import cn.source.system.service.IHelpFeatureService;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.common.core.page.TableDataInfo;

/**
 * 互助信息特征Controller
 * 
 * @author zjx
 * @date 2023-04-12
 */
@RestController
@RequestMapping("/help/feature")
public class HelpFeatureController extends BaseController
{
    @Autowired
    private IHelpFeatureService helpFeatureService;

    /**
     * 查询互助信息特征列表
     */
    @PreAuthorize("@ss.hasPermi('help:feature:list')")
    @GetMapping("/list")
    public TableDataInfo list(HelpFeature helpFeature)
    {
        startPage();
        List<HelpFeature> list = helpFeatureService.selectHelpFeatureList(helpFeature);
        return getDataTable(list);
    }

    /**
     * 导出互助信息特征列表
     */
    @PreAuthorize("@ss.hasPermi('help:feature:export')")
    @Log(title = "互助信息特征", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HelpFeature helpFeature)
    {
        List<HelpFeature> list = helpFeatureService.selectHelpFeatureList(helpFeature);
        ExcelUtil<HelpFeature> util = new ExcelUtil<HelpFeature>(HelpFeature.class);
        util.exportExcel(response, list, "互助信息特征数据");
    }

    /**
     * 获取互助信息特征详细信息
     */
    @PreAuthorize("@ss.hasPermi('help:feature:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(helpFeatureService.selectHelpFeatureById(id));
    }

    /**
     * 新增互助信息特征
     */
    @PreAuthorize("@ss.hasPermi('help:feature:add')")
    @Log(title = "互助信息特征", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HelpFeature helpFeature)
    {
        return toAjax(helpFeatureService.insertHelpFeature(helpFeature));
    }

    /**
     * 修改互助信息特征
     */
    @PreAuthorize("@ss.hasPermi('help:feature:edit')")
    @Log(title = "互助信息特征", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HelpFeature helpFeature)
    {
        return toAjax(helpFeatureService.updateHelpFeature(helpFeature));
    }

    /**
     * 删除互助信息特征
     */
    @PreAuthorize("@ss.hasPermi('help:feature:remove')")
    @Log(title = "互助信息特征", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(helpFeatureService.deleteHelpFeatureByIds(ids));
    }
}
