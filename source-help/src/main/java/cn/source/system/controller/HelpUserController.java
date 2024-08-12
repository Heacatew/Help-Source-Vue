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
import cn.source.system.domain.HelpUser;
import cn.source.system.service.IHelpUserService;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.common.core.page.TableDataInfo;

/**
 * 互助进度信息Controller
 * 
 * @author zjx
 * @date 2023-04-18
 */
@RestController
@RequestMapping("/help/helpuser")
public class HelpUserController extends BaseController
{
    @Autowired
    private IHelpUserService helpUserService;

    /**
     * 查询互助进度信息列表
     */
    @PreAuthorize("@ss.hasPermi('help:helpuser:list')")
    @GetMapping("/list")
    public TableDataInfo list(HelpUser helpUser)
    {
        startPage();
        List<HelpUser> list = helpUserService.selectHelpUserList(helpUser);
        return getDataTable(list);
    }

    /**
     * 导出互助进度信息列表
     */
    @PreAuthorize("@ss.hasPermi('help:helpuser:export')")
    @Log(title = "互助进度信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HelpUser helpUser)
    {
        List<HelpUser> list = helpUserService.selectHelpUserList(helpUser);
        ExcelUtil<HelpUser> util = new ExcelUtil<HelpUser>(HelpUser.class);
        util.exportExcel(response, list, "互助进度信息数据");
    }

    /**
     * 获取互助进度信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('help:helpuser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(helpUserService.selectHelpUserById(id));
    }

    /**
     * 新增互助进度信息
     */
    @PreAuthorize("@ss.hasPermi('help:helpuser:add')")
    @Log(title = "互助进度信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HelpUser helpUser)
    {
        return toAjax(helpUserService.insertHelpUser(helpUser));
    }

    /**
     * 修改互助进度信息
     */
    @PreAuthorize("@ss.hasPermi('help:helpuser:edit')")
    @Log(title = "互助进度信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HelpUser helpUser)
    {
        return toAjax(helpUserService.updateHelpUser(helpUser));
    }

    /**
     * 删除互助进度信息
     */
    @PreAuthorize("@ss.hasPermi('help:helpuser:remove')")
    @Log(title = "互助进度信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(helpUserService.deleteHelpUserByIds(ids));
    }
}
