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
import cn.source.system.domain.HelpUserinfo;
import cn.source.system.service.IHelpUserinfoService;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.common.core.page.TableDataInfo;

/**
 * 互助用户常用信息Controller
 * 
 * @author zjx
 * @date 2023-04-18
 */
@RestController
@RequestMapping("/help/helpuserinfo")
public class HelpUserinfoController extends BaseController
{
    @Autowired
    private IHelpUserinfoService helpUserinfoService;

    /**
     * 查询互助用户常用信息列表
     */
    @PreAuthorize("@ss.hasPermi('help:helpuserinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(HelpUserinfo helpUserinfo)
    {
        startPage();
        List<HelpUserinfo> list = helpUserinfoService.selectHelpUserinfoList(helpUserinfo);
        return getDataTable(list);
    }

    /**
     * 导出互助用户常用信息列表
     */
    @PreAuthorize("@ss.hasPermi('help:helpuserinfo:export')")
    @Log(title = "互助用户常用信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HelpUserinfo helpUserinfo)
    {
        List<HelpUserinfo> list = helpUserinfoService.selectHelpUserinfoList(helpUserinfo);
        ExcelUtil<HelpUserinfo> util = new ExcelUtil<HelpUserinfo>(HelpUserinfo.class);
        util.exportExcel(response, list, "互助用户常用信息数据");
    }

    /**
     * 获取互助用户常用信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('help:helpuserinfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(helpUserinfoService.selectHelpUserinfoById(id));
    }

    /**
     * 新增互助用户常用信息
     */
    @PreAuthorize("@ss.hasPermi('help:helpuserinfo:add')")
    @Log(title = "互助用户常用信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HelpUserinfo helpUserinfo)
    {
        return toAjax(helpUserinfoService.insertHelpUserinfo(helpUserinfo));
    }

    /**
     * 修改互助用户常用信息
     */
    @PreAuthorize("@ss.hasPermi('help:helpuserinfo:edit')")
    @Log(title = "互助用户常用信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HelpUserinfo helpUserinfo)
    {
        return toAjax(helpUserinfoService.updateHelpUserinfo(helpUserinfo));
    }

    /**
     * 删除互助用户常用信息
     */
    @PreAuthorize("@ss.hasPermi('help:helpuserinfo:remove')")
    @Log(title = "互助用户常用信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(helpUserinfoService.deleteHelpUserinfoByIds(ids));
    }
}
