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
import cn.source.system.domain.IhelpGoodsapply;
import cn.source.system.service.IIhelpGoodsapplyService;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.common.core.page.TableDataInfo;

/**
 * 物资供应Controller
 * 
 * @author zjx
 * @date 2023-04-20
 */
@RestController
@RequestMapping("/help/goodsapply")
public class IhelpGoodsapplyController extends BaseController
{
    @Autowired
    private IIhelpGoodsapplyService ihelpGoodsapplyService;

    /**
     * 查询物资供应列表
     */
    @PreAuthorize("@ss.hasPermi('help:goodsapply:list')")
    @GetMapping("/list")
    public TableDataInfo list(IhelpGoodsapply ihelpGoodsapply)
    {
        startPage();
        List<IhelpGoodsapply> list = ihelpGoodsapplyService.selectIhelpGoodsapplyList(ihelpGoodsapply);
        return getDataTable(list);
    }

    /**
     * 导出物资供应列表
     */
    @PreAuthorize("@ss.hasPermi('help:goodsapply:export')")
    @Log(title = "物资供应", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, IhelpGoodsapply ihelpGoodsapply)
    {
        List<IhelpGoodsapply> list = ihelpGoodsapplyService.selectIhelpGoodsapplyList(ihelpGoodsapply);
        ExcelUtil<IhelpGoodsapply> util = new ExcelUtil<IhelpGoodsapply>(IhelpGoodsapply.class);
        util.exportExcel(response, list, "物资供应数据");
    }

    /**
     * 获取物资供应详细信息
     */
    @PreAuthorize("@ss.hasPermi('help:goodsapply:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(ihelpGoodsapplyService.selectIhelpGoodsapplyById(id));
    }

    /**
     * 新增物资供应
     */
    @PreAuthorize("@ss.hasPermi('help:goodsapply:add')")
    @Log(title = "物资供应", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody IhelpGoodsapply ihelpGoodsapply)
    {
        return toAjax(ihelpGoodsapplyService.insertIhelpGoodsapply(ihelpGoodsapply));
    }

    /**
     * 修改物资供应
     */
    @PreAuthorize("@ss.hasPermi('help:goodsapply:edit')")
    @Log(title = "物资供应", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody IhelpGoodsapply ihelpGoodsapply)
    {
        return toAjax(ihelpGoodsapplyService.updateIhelpGoodsapply(ihelpGoodsapply));
    }

    /**
     * 删除物资供应
     */
    @PreAuthorize("@ss.hasPermi('help:goodsapply:remove')")
    @Log(title = "物资供应", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ihelpGoodsapplyService.deleteIhelpGoodsapplyByIds(ids));
    }
}
