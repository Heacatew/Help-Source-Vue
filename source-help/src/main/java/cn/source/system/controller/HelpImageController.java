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
import cn.source.system.domain.HelpImage;
import cn.source.system.service.IHelpImageService;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.common.core.page.TableDataInfo;

/**
 * 互助信息图片Controller
 * 
 * @author zjx
 * @date 2023-04-18
 */
@RestController
@RequestMapping("/help/image")
public class HelpImageController extends BaseController
{
    @Autowired
    private IHelpImageService helpImageService;

    /**
     * 查询互助信息图片列表
     */
    @PreAuthorize("@ss.hasPermi('help:image:list')")
    @GetMapping("/list")
    public TableDataInfo list(HelpImage helpImage)
    {
        startPage();
        List<HelpImage> list = helpImageService.selectHelpImageList(helpImage);
        return getDataTable(list);
    }

    /**
     * 导出互助信息图片列表
     */
    @PreAuthorize("@ss.hasPermi('help:image:export')")
    @Log(title = "互助信息图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HelpImage helpImage)
    {
        List<HelpImage> list = helpImageService.selectHelpImageList(helpImage);
        ExcelUtil<HelpImage> util = new ExcelUtil<HelpImage>(HelpImage.class);
        util.exportExcel(response, list, "互助信息图片数据");
    }

    /**
     * 获取互助信息图片详细信息
     */
    @PreAuthorize("@ss.hasPermi('help:image:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(helpImageService.selectHelpImageById(id));
    }

    /**
     * 新增互助信息图片
     */
    @PreAuthorize("@ss.hasPermi('help:image:add')")
    @Log(title = "互助信息图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HelpImage helpImage)
    {
        return toAjax(helpImageService.insertHelpImage(helpImage));
    }

    /**
     * 修改互助信息图片
     */
    @PreAuthorize("@ss.hasPermi('help:image:edit')")
    @Log(title = "互助信息图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HelpImage helpImage)
    {
        return toAjax(helpImageService.updateHelpImage(helpImage));
    }

    /**
     * 删除互助信息图片
     */
    @PreAuthorize("@ss.hasPermi('help:image:remove')")
    @Log(title = "互助信息图片", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(helpImageService.deleteHelpImageByIds(ids));
    }
}
