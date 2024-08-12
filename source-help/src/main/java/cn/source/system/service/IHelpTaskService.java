package cn.source.system.service;

import java.util.List;
import java.util.Map;

import cn.source.system.domain.HelpTask;

/**
 * 互助信息详情Service接口
 * 
 * @author zjx
 * @date 2023-04-12
 */
public interface IHelpTaskService 
{
    /**
     * 查询互助信息详情
     * 
     * @param id 互助信息详情主键
     * @return 互助信息详情
     */
    HelpTask selectHelpTaskById(Long id);

    /**
     * 查询互助信息详情列表
     * 
     * @param helpTask 互助信息详情
     * @return 互助信息详情集合
     */
    List<HelpTask> selectHelpTaskList(HelpTask helpTask);

    /**
     * 查询互助信息详情列表
     *
     * @param helpTask api互助信息详情
     * @return api互助信息详情
     */
    List<HelpTask> findHelpTaskList(HelpTask helpTask);

    /**
     * api新增互助信息详情
     *
     * @param helpTask 互助信息详情
     * @return 结果
     */
    int apiInsertHelpTask(HelpTask helpTask);

    /**
     * api查询互助信息相关详情信息
     *
     * @param helpTask 互助信息
     * @return 互助信息
     */
    HelpTask selectDetailHelpTask(HelpTask helpTask);

    /**
     * 导入房源
     */
    String importHelp(List<HelpTask> helpList, Boolean isUpdateSupport);

    /**
     * 新增互助信息详情
     * 
     * @param helpTask 互助信息详情
     * @return 结果
     */
    int insertHelpTask(HelpTask helpTask);

    /**
     * 修改互助信息详情
     * 
     * @param helpTask 互助信息详情
     * @return 结果
     */
    int updateHelpTask(HelpTask helpTask);

    /**
     * 设置互助经纪人
     */
    int updateHelpAgent(Long[] ids,Long userId);


    /**
     * 批量修改房源详情
     *
     * @param ids 需要删除的房源详情主键集合
     */
    int updateHelpTaskByIds(Long[] ids,Integer state);


    /**
     * 批量删除互助信息详情
     * 
     * @param ids 需要删除的互助信息详情主键集合
     * @return 结果
     */
    int deleteHelpTaskByIds(Long[] ids);

    /**
     * 删除互助信息详情信息
     * 
     * @param id 互助信息详情主键
     * @return 结果
     */
    int deleteHelpTaskById(Long id);

    /**
     * 收藏/取消收藏
     */
    String saveHeart(boolean heart,Long userId,String helpId);

    /**
     * 查询收藏数据
     */
    Long selectHelpHeart(Map<String,Object> helpMap);

    /**
     * 获取收藏互助信息列表
     */
    List<HelpTask> findHelpHeartList(Long userId);

    /**
     * 更新状态数据
     */
    int updateHelpTaskById(Long id,Integer state);
}
