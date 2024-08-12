package cn.source.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.source.common.core.domain.entity.SysUser;
import cn.source.system.service.ISysUserService;
import com.github.pagehelper.PageHelper;
import cn.source.system.enums.HelpStatus;
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
import cn.source.system.domain.HelpTask;
import cn.source.system.service.IHelpTaskService;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 互助信息详情Controller
 * 
 * @author zjx
 * @date 2023-04-12
 */
@RestController
@RequestMapping("/help/task")
public class HelpTaskController extends BaseController
{
    @Autowired
    private IHelpTaskService helpTaskService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询互助信息详情列表
     */
    @PreAuthorize("@ss.hasPermi('help:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(HelpTask helpTask)
    {
        startPage();
        List<HelpTask> list = helpTaskService.selectHelpTaskList(helpTask);
        return getDataTable(list);
    }

    /**
     * 导出互助信息详情列表
     */
    @PreAuthorize("@ss.hasPermi('help:task:export')")
    @Log(title = "互助信息详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HelpTask helpTask)
    {
        List<HelpTask> list = helpTaskService.selectHelpTaskList(helpTask);
        ExcelUtil<HelpTask> util = new ExcelUtil<HelpTask>(HelpTask.class);
        util.exportExcel(response, list, "互助信息详情数据");
    }

    /**
     * 获取互助信息详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('help:task:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(helpTaskService.selectHelpTaskById(id));
    }

    /**
     * 新增互助信息详情
     */
    @PreAuthorize("@ss.hasPermi('help:task:add')")
    @Log(title = "互助信息详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HelpTask helpTask)
    {
        return toAjax(helpTaskService.insertHelpTask(helpTask));
    }

    /**
     * 修改互助信息详情
     */
    @PreAuthorize("@ss.hasPermi('help:task:edit')")
    @Log(title = "互助信息详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HelpTask helpTask)
    {
        return toAjax(helpTaskService.updateHelpTask(helpTask));
    }

    /**
     * 删除互助信息详情
     */
    @PreAuthorize("@ss.hasPermi('help:task:remove')")
    @Log(title = "互助信息详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(helpTaskService.deleteHelpTaskByIds(ids));
    }

    /**
     * 导出互助详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:helpTask:export')")
    @Log(title = "房源模板", businessType = BusinessType.EXPORT)
    @PostMapping("/templete")
    public void templete(HttpServletResponse response, HelpTask helpTask)
    {
        ExcelUtil<HelpTask> util = new ExcelUtil<HelpTask>(HelpTask.class);
        util.exportExcel(response, null, "房源模板");
    }

    /**
     * 互助管理
     */
    @Log(title = "互助管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<HelpTask> util = new ExcelUtil<HelpTask>(HelpTask.class);
        List<HelpTask> houseList = util.importExcel(file.getInputStream());
        String message = helpTaskService.importHelp(houseList,updateSupport);
        return AjaxResult.success(message);
    }
    /**
     * 审核
     */
    @PreAuthorize("@ss.hasPermi('system:helpTask:more')")
    @Log(title = "审核", businessType = BusinessType.UPDATE)
    @PutMapping("handleAudit/{ids}")
    public AjaxResult handleAudit(@PathVariable Long[] ids)
    {
        return toAjax(helpTaskService.updateHelpTaskByIds(ids, HelpStatus.SALEING.getCode()));
    }

    /**
     * 完成委托
     */
    @PreAuthorize("@ss.hasPermi('system:helpTask:more')")
    @Log(title = "房源出租", businessType = BusinessType.UPDATE)
    @PutMapping("handlePush/{ids}")
    public AjaxResult handlePush(@PathVariable Long[] ids)
    {
        return toAjax(helpTaskService.updateHelpTaskByIds(ids,HelpStatus.SALEED.getCode()));
    }

    /**
     * 下架
     */
    @PreAuthorize("@ss.hasPermi('system:helpTask:more')")
    @Log(title = "房源下架", businessType = BusinessType.UPDATE)
    @PutMapping("handleClose/{ids}")
    public AjaxResult handleClose(@PathVariable Long[] ids)
    {
        return toAjax(helpTaskService.updateHelpTaskByIds(ids,HelpStatus.CLOSE.getCode()));
    }

    /**
     * 上架
     */
    @PreAuthorize("@ss.hasPermi('system:helpTask:more')")
    @Log(title = "房源上架", businessType = BusinessType.UPDATE)
    @PutMapping("handleOpen/{ids}")
    public AjaxResult handleOpen(@PathVariable Long[] ids)
    {
        return toAjax(helpTaskService.updateHelpTaskByIds(ids,HelpStatus.SALEING.getCode()));
    }

    /**
     * 查询用户列表
     */
    @GetMapping("/userList")
    public TableDataInfo userList(SysUser user)
    {
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 批量选择用户授权
     */
    @Log(title = "房源授权", businessType = BusinessType.GRANT)
    @PutMapping("/authUser/{ids}")
    public AjaxResult authUser(@PathVariable Long[] ids,Long userId)
    {
        return toAjax(helpTaskService.updateHelpAgent(ids,userId));
    }
}
