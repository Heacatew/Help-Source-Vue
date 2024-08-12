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
import cn.source.system.domain.IhelpNotice;
import cn.source.system.service.IIhelpNoticeService;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.common.core.page.TableDataInfo;

/**
 * 紧急通知Controller
 * 
 * @author zjx
 * @date 2023-04-20
 */
@RestController
@RequestMapping("/help/notice")
public class IhelpNoticeController extends BaseController
{
    @Autowired
    private IIhelpNoticeService ihelpNoticeService;

    /**
     * 查询紧急通知列表
     */
    @PreAuthorize("@ss.hasPermi('help:notice:list')")
    @GetMapping("/list")
    public TableDataInfo list(IhelpNotice ihelpNotice)
    {
        startPage();
        List<IhelpNotice> list = ihelpNoticeService.selectIhelpNoticeList(ihelpNotice);
        return getDataTable(list);
    }

    /**
     * 导出紧急通知列表
     */
    @PreAuthorize("@ss.hasPermi('help:notice:export')")
    @Log(title = "紧急通知", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, IhelpNotice ihelpNotice)
    {
        List<IhelpNotice> list = ihelpNoticeService.selectIhelpNoticeList(ihelpNotice);
        ExcelUtil<IhelpNotice> util = new ExcelUtil<IhelpNotice>(IhelpNotice.class);
        util.exportExcel(response, list, "紧急通知数据");
    }

    /**
     * 获取紧急通知详细信息
     */
    @PreAuthorize("@ss.hasPermi('help:notice:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(ihelpNoticeService.selectIhelpNoticeById(id));
    }

    /**
     * 新增紧急通知
     */
    @PreAuthorize("@ss.hasPermi('help:notice:add')")
    @Log(title = "紧急通知", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody IhelpNotice ihelpNotice)
    {
        return toAjax(ihelpNoticeService.insertIhelpNotice(ihelpNotice));
    }

    /**
     * 修改紧急通知
     */
    @PreAuthorize("@ss.hasPermi('help:notice:edit')")
    @Log(title = "紧急通知", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody IhelpNotice ihelpNotice)
    {
        return toAjax(ihelpNoticeService.updateIhelpNotice(ihelpNotice));
    }

    /**
     * 删除紧急通知
     */
    @PreAuthorize("@ss.hasPermi('help:notice:remove')")
    @Log(title = "紧急通知", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ihelpNoticeService.deleteIhelpNoticeByIds(ids));
    }
}
