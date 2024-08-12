package cn.source.system.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.source.common.core.domain.entity.SysRole;
import cn.source.common.core.domain.entity.SysUser;
import cn.source.common.core.domain.model.LoginUser;
import cn.source.common.exception.ServiceException;
import cn.source.common.utils.DateUtils;
import cn.source.common.utils.SecurityUtils;
import cn.source.common.utils.StringUtils;
import cn.source.common.utils.uuid.CodeUtil;
import cn.source.system.domain.HelpVillage;
import cn.source.system.enums.HelpStatus;
import cn.source.system.service.IHelpVillageService;
import cn.source.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.source.system.mapper.HelpTaskMapper;
import cn.source.system.domain.HelpTask;
import cn.source.system.service.IHelpTaskService;

/**
 * 互助信息详情Service业务层处理
 * 
 * @author zjx
 * @date 2023-04-12
 */
@Service
public class HelpTaskServiceImpl implements IHelpTaskService 
{
    @Autowired
    private HelpTaskMapper helpTaskMapper;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private IHelpVillageService helpVillageService;

    /**
     * 数据权限过滤关键字
     */
    public static final String DATA_SCOPE = "dataScope";

    /**
     * 仅本人数据权限
     */
    public static final String DATA_SCOPE_SELF = "5";

    /**
     * 查询互助信息详情
     * 
     * @param id 互助信息详情主键
     * @return 互助信息详情
     */
    @Override
    public HelpTask selectHelpTaskById(Long id)
    {
        return helpTaskMapper.selectHelpTaskById(id);
    }

    /**
     * 查询互助信息详情列表
     * 
     * @param helpTask 互助信息详情
     * @return 互助信息详情
     */
    @Override
    public List<HelpTask> selectHelpTaskList(HelpTask helpTask)
    {
        // 获取当前的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (StringUtils.isNotNull(loginUser))
        {
            SysUser currentUser = loginUser.getUser();
            System.out.println(currentUser.isAdmin());
            // 如果是超级管理员，则不过滤数据
            if (StringUtils.isNotNull(currentUser) && !currentUser.isAdmin())
            {
                for (SysRole role : currentUser.getRoles())
                {
                    String dataScope = role.getDataScope();
                    // 仅有查询自己的数据权限时，将本人的房源，与负责的房源(经纪人)都查询出来
                    if (DATA_SCOPE_SELF.equals(dataScope))
                    {
                        String appendSql = StringUtils.format("help.agent_User_Id = {} ", currentUser.getUserId());
                        appendSql += StringUtils.format(" OR help.publish_id = {} ", currentUser.getUserId());
                        helpTask.getParams().put(DATA_SCOPE, " AND (" + appendSql + ")");
                    }
                }
            }
        }
        return helpTaskMapper.selectHelpTaskList(helpTask);
    }

    /**
     * 查询房源详情列表
     *
     * @param helpTask 互助信息详情
     * @return 互助信息详情
     */
    @Override
    public List<HelpTask> findHelpTaskList(HelpTask helpTask)
    {
        return helpTaskMapper.selectHelpTaskList(helpTask);
    }

    /**
     * 新增互助信息详情
     * 
     * @param helpTask 互助信息详情
     * @return 结果
     */
    @Override
    public int insertHelpTask(HelpTask helpTask)
    {
        helpTask.setCreateTime(DateUtils.getNowDate());
        return helpTaskMapper.insertHelpTask(helpTask);
    }

    /**
     * 修改互助信息详情
     * 
     * @param helpTask 互助信息详情
     * @return 结果
     */
    @Override
    public int updateHelpTask(HelpTask helpTask)
    {
        helpTask.setUpdateTime(DateUtils.getNowDate());
        if(StringUtils.isNotNull(helpTask.getFeatureList()) && helpTask.getFeatureList().size()>0){
            // 先删除，再插入
            helpTaskMapper.deleteHelpFeatureByHelpId(helpTask.getId());
            helpTaskMapper.insertHelpFeature(helpTask);
        }
        if(StringUtils.isNotNull(helpTask.getImageList()) && helpTask.getImageList().size()>0){
            // 先删除，再插入
            helpTaskMapper.deleteHelpImageByHelpId(helpTask.getId());
            helpTask.setFaceUrl(helpTask.getImageList().get(0).getImgUrl());
            helpTaskMapper.insertHelpImage(helpTask);
        }
        return helpTaskMapper.updateHelpTask(helpTask);
    }

    /**
     * 设置房源经纪人
     * @param userId 选中经纪人ID
     */
    @Override
    public int updateHelpAgent(Long[] ids,Long userId)
    {
        Map<String,Object> helpMap=new HashMap<String,Object>();
        helpMap.put("ids",ids);
        SysUser sysUser = userService.selectUserById(userId);
        helpMap.put("agentUserId",userId);
        helpMap.put("agentName",sysUser.getNickName());
        helpMap.put("agentPhone",sysUser.getPhonenumber());
        helpMap.put("agentAvatar",sysUser.getAvatar());
        return helpTaskMapper.updateHelpAgent(helpMap);
    }
    @Override
    public int updateHelpTaskById(Long id,Integer state)
    {
        Map<String,Object> helpMap=new HashMap<String,Object>();
        helpMap.put("ids",new Long[]{id});
        helpMap.put("state",state);
        return helpTaskMapper.updateHelpTaskByIds(helpMap);
    }
    /**
     * 修改互助详情
     *
     * @param ids,state 互助详情
     * @return 结果
     */
    @Override
    public int updateHelpTaskByIds(Long[] ids,Integer state)
    {
        Map<String,Object> helpMap=new HashMap<String,Object>();
        helpMap.put("ids",ids);
        System.out.println(ids);
        helpMap.put("state",state);
        return helpTaskMapper.updateHelpTaskByIds(helpMap);
    }

    /**
     * 批量删除互助信息详情
     * 
     * @param ids 需要删除的互助信息详情主键
     * @return 结果
     */
    @Override
    public int deleteHelpTaskByIds(Long[] ids)
    {
        return helpTaskMapper.deleteHelpTaskByIds(ids);
    }

    /**
     * 删除互助信息详情信息
     * 
     * @param id 互助信息详情主键
     * @return 结果
     */
    @Override
    public int deleteHelpTaskById(Long id)
    {
        return helpTaskMapper.deleteHelpTaskById(id);
    }

    /**
     * API新增互助信息详情
     *
     * @param helpTask 互助信息详情
     * @return 结果
     */
    @Override
    public int apiInsertHelpTask(HelpTask helpTask)
    {
        return insertHelp(helpTask);
    }

    /**
     * 查询互助信息相关详情信息
     *
     * @param helpTask 互助信息
     * @return 互助信息详情
     */
    @Override
    public HelpTask selectDetailHelpTask(HelpTask helpTask) {
        helpTask.setVillage(helpVillageService.selectHelpVillageById(helpTask.getVillageId()));
         helpTask.setImageList(helpTaskMapper.selectHelpImage(helpTask));
         helpTask.setFeatureList(helpTaskMapper.selectHelpFeature(helpTask));
        return helpTask;
    }


    /**
     * @Description: 将保存房源的方法统一到此方法中
     * @author: 詹Sir
     */
    public int insertHelp(HelpTask helpTask){
        // 待审核
        helpTask.setState(HelpStatus.SALEING.getCode());
        helpTask.setCreateTime(DateUtils.getNowDate());
        if(StringUtils.isNull(helpTask.getPublishId())){
            helpTask.setPublishId(SecurityUtils.getUserId());
        }
        if(StringUtils.isNull(helpTask.getStartDate())){
            helpTask.setStartDate(new Date());
        }
        if(StringUtils.isEmpty(helpTask.getVillageName())){
            HelpVillage helpVillage = helpVillageService.selectHelpVillageById(helpTask.getVillageId());
            helpTask.setVillageName(helpVillage.getName());
        }
        if(StringUtils.isNull(helpTask.getVillageId())){
            HelpVillage helpVillage = new HelpVillage();
            helpVillage.setName(helpTask.getVillageName());
            helpVillage = helpVillageService.selectHelpVillage(helpVillage);
            helpTask.setVillageId(helpVillage.getId());
        }
        helpTask.setCode(CodeUtil.getCodeByUUId());
        // 封面图设置默认值
        helpTask.setFaceUrl("http://memeai.cn:10800/loading.png");
        helpTaskMapper.insertHelpTask(helpTask);
        if(StringUtils.isNotNull(helpTask.getFeatureList()) && helpTask.getFeatureList().size()>0){
            helpTaskMapper.insertHelpFeature(helpTask);
        }
        if(StringUtils.isNotNull(helpTask.getImageList()) && helpTask.getImageList().size()>0){
            helpTask.setFaceUrl(helpTask.getImageList().get(0).getImgUrl());
            helpTaskMapper.insertHelpImage(helpTask);
        }
        return helpTaskMapper.updateHelpTask(helpTask);
    }
    /**
     * 导入互助信息数据
     *
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    @Override
    public String importHelp(List<HelpTask> helpList, Boolean isUpdateSupport)
    {
        if (StringUtils.isNull(helpList) || helpList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int execlSortNo = 1;
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (HelpTask helpTask : helpList)
        {
            execlSortNo++;
            try{
                if(StringUtils.isNull(helpTask.getType())){
                    failureNum++;
                    failureMsg.append("<br/>Execl第 "+execlSortNo+" 行类型不能为空,需填写整租/合租");
                }
                if(StringUtils.isEmpty(helpTask.getHouseNum())){
                    failureNum++;
                    failureMsg.append("<br/>Execl第 "+execlSortNo+" 行居室不能为空");
                }
                if(StringUtils.isEmpty(helpTask.getHouseHall())){
                    failureNum++;
                    failureMsg.append("<br/>Execl第 "+execlSortNo+" 行厅室不能为空");
                }
                if(StringUtils.isEmpty(helpTask.getCode())){
                    successNum++;
                    successMsg.append("<br/>Execl第 "+execlSortNo+" 行新增成功");
                    insertHelp(helpTask);
                }else{
                    HelpTask help = helpTaskMapper.selectHelpTaskByCode(helpTask.getCode());
                    if(StringUtils.isNotNull(help) && isUpdateSupport){
                        successNum++;
                        successMsg.append("<br/>Execl第 "+execlSortNo+" 行更新成功");
                        helpTask.setId(help.getId());
                        updateHelpTask(helpTask);
                    }else{
                        failureNum++;
                        failureMsg.append("<br/>Execl第 "+execlSortNo+" 行房源已存在，如需覆盖请勾选确认更新");
                    }
                }
            }catch (Exception e){
                failureNum++;
                String msg = "<br/>Execl第 "+execlSortNo+" 行导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0){
            failureMsg.insert(0, "很抱歉，导入出现错误！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }else{
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    /**
     * 收藏/取消收藏
     */
    @Override
    public String saveHeart(boolean heart,Long userId,String helpId)
    {
        String msg = "收藏成功";
        Map<String,Object> helpMap=new HashMap<String,Object>();
        helpMap.put("helpId",helpId);
        helpMap.put("userId",userId);
        if(!heart){
            // 收藏
            helpTaskMapper.saveHeart(helpMap);
        }else {
            // 取消收藏
            helpTaskMapper.cancelHeart(helpMap);
            msg = "取消收藏";
        }
        return msg;
    }

    /**
     * 查询收藏数据
     */
    @Override
    public Long selectHelpHeart(Map<String,Object> helpMap)
    {
        return helpTaskMapper.selectHelpHeart(helpMap);
    }


    /**
     * 获取收藏互助信息列表
     */
    @Override
    public List<HelpTask> findHelpHeartList(Long userId)
    {
        return helpTaskMapper.findHelpHeartList(userId);
    }
}
