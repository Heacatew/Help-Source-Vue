package cn.source.system.controller;

import cn.source.common.annotation.Log;
import cn.source.common.constant.HttpStatus;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.page.TableDataInfo;
import cn.source.common.enums.BusinessType;
import cn.source.common.utils.StringUtils;
import cn.source.system.domain.HelpTask;
import cn.source.system.domain.HelpVillage;
import cn.source.system.enums.HelpStatus;
import cn.source.system.service.IHelpFeatureService;
import cn.source.system.service.IHelpTaskService;
import cn.source.system.service.IHelpVillageService;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: cms api控制类
 * @author: 詹Sir
 */
@RestController
@RequestMapping("/api/helpApi")
public class HelpApiController extends BaseController {

    @Autowired
    private IHelpVillageService helpVillageService;

    @Autowired
    private IHelpTaskService helpTaskService;

    /**
     * @Description: 获取小区列表
     */
    @GetMapping("/findVillageList")
    public TableDataInfo findVillageList(HelpVillage helpVillage)
    {
        startPage();
        List<HelpVillage> list = helpVillageService.selectHelpVillageList(helpVillage);
        return getDataTable(list);
    }

    /**
     * @Description: 获取互助信息列表
     */
    @GetMapping("/findHelpTaskList")
    public TableDataInfo findHelpTaskList(HelpTask helpTask)
    {
        startPage();
        List<HelpTask> list = helpTaskService.findHelpTaskList(helpTask);
        return getDataTable(list);
    }


    /**
     * @Description: 添加互助信息信息
     */
    @PostMapping("/saveHelp")
    public AjaxResult saveHelp(@RequestBody HelpTask helpTask)
    {
        String msg = "互助信息添加成功";
        helpTaskService.apiInsertHelpTask(helpTask);
        AjaxResult ajaxResult = new AjaxResult(HttpStatus.SUCCESS,msg,helpTask);
        return ajaxResult;
    }

    /**
     * @Description: 修改互助信息信息
     */
    @PostMapping("/updateHelp")
    public AjaxResult updateHelp(@RequestBody HelpTask helpTask)
    {
        String msg = "互助信息修改成功";
        helpTaskService.updateHelpTask(helpTask);
        AjaxResult ajaxResult = new AjaxResult(HttpStatus.SUCCESS,msg,helpTask);
        return ajaxResult;
    }

    /**
     * @Description: 获取互助信息信息by id
     */
    @GetMapping("/findHelpById")
    public AjaxResult findHelpById(@RequestParam Long id)
    {
        String msg = "互助信息查找成功";
        HelpTask helpTask = helpTaskService.selectHelpTaskById(id);
        helpTask = helpTaskService.selectDetailHelpTask(helpTask);
        AjaxResult ajaxResult = new AjaxResult(HttpStatus.SUCCESS,msg,helpTask);
        return ajaxResult;
    }

    /**
     * @Description: 收藏/取消收藏
     */
    @PostMapping("/saveHeart")
    public AjaxResult saveHeart(@RequestBody JSONObject json)
    {
        boolean heart = json.getBoolean("heart");
        Long userId = json.getLong("userId");
        String helpId = json.getString("helpId");
        String msg = helpTaskService.saveHeart(heart,userId,helpId);
        AjaxResult ajaxResult = new AjaxResult(HttpStatus.SUCCESS,msg);
        return ajaxResult;
    }

    /**
     * @Description: 判断是否收藏
     */
    @GetMapping("/selectHelpHeart")
    public AjaxResult selectHelpHeart(Long userId,String helpId)
    {
        String msg = "是否收藏";
        Map<String,Object> helpMap=new HashMap<String,Object>();
        helpMap.put("helpId",helpId);
        helpMap.put("userId",userId);
        // 判断是否点赞
        Long id = helpTaskService.selectHelpHeart(helpMap);
        AjaxResult ajaxResult = new AjaxResult(HttpStatus.SUCCESS,msg, StringUtils.isNotNull(id));
        return ajaxResult;
    }

    /**
     * @Description: 获取收藏互助信息列表
     */
    @GetMapping("/findHelpHeartList")
    public TableDataInfo findHelpHeartList(Long userId)
    {
        startPage();
        List<HelpTask> list = helpTaskService.findHelpHeartList(userId);
        return getDataTable(list);
    }

    /**
     * 完成委托
     */
    @PostMapping("/handlePush")
    public AjaxResult handlePush(@RequestBody JSONObject json)
    {
        String helpId = json.getString("helpId");
        System.out.println(helpId);
        return toAjax(helpTaskService.updateHelpTaskById(Long.parseLong(helpId), HelpStatus.SALEED.getCode()));
    }

}
