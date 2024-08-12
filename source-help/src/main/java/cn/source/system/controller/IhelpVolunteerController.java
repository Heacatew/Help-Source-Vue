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
import cn.source.system.domain.IhelpVolunteer;
import cn.source.system.service.IIhelpVolunteerService;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.common.core.page.TableDataInfo;

/**
 * 志愿者Controller
 * 
 * @author zjx
 * @date 2023-04-20
 */
@RestController
@RequestMapping("/help/volunteer")
public class IhelpVolunteerController extends BaseController
{
    @Autowired
    private IIhelpVolunteerService ihelpVolunteerService;

    /**
     * 查询志愿者列表
     */
    @PreAuthorize("@ss.hasPermi('help:volunteer:list')")
    @GetMapping("/list")
    public TableDataInfo list(IhelpVolunteer ihelpVolunteer)
    {
        startPage();
        List<IhelpVolunteer> list = ihelpVolunteerService.selectIhelpVolunteerList(ihelpVolunteer);
        return getDataTable(list);
    }

    /**
     * 导出志愿者列表
     */
    @PreAuthorize("@ss.hasPermi('help:volunteer:export')")
    @Log(title = "志愿者", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, IhelpVolunteer ihelpVolunteer)
    {
        List<IhelpVolunteer> list = ihelpVolunteerService.selectIhelpVolunteerList(ihelpVolunteer);
        ExcelUtil<IhelpVolunteer> util = new ExcelUtil<IhelpVolunteer>(IhelpVolunteer.class);
        util.exportExcel(response, list, "志愿者数据");
    }

    /**
     * 获取志愿者详细信息
     */
    @PreAuthorize("@ss.hasPermi('help:volunteer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(ihelpVolunteerService.selectIhelpVolunteerById(id));
    }

    /**
     * 新增志愿者
     */
    @PreAuthorize("@ss.hasPermi('help:volunteer:add')")
    @Log(title = "志愿者", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody IhelpVolunteer ihelpVolunteer)
    {
        return toAjax(ihelpVolunteerService.insertIhelpVolunteer(ihelpVolunteer));
    }

    /**
     * 修改志愿者
     */
    @PreAuthorize("@ss.hasPermi('help:volunteer:edit')")
    @Log(title = "志愿者", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody IhelpVolunteer ihelpVolunteer)
    {
        return toAjax(ihelpVolunteerService.updateIhelpVolunteer(ihelpVolunteer));
    }

    /**
     * 删除志愿者
     */
    @PreAuthorize("@ss.hasPermi('help:volunteer:remove')")
    @Log(title = "志愿者", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ihelpVolunteerService.deleteIhelpVolunteerByIds(ids));
    }
}
