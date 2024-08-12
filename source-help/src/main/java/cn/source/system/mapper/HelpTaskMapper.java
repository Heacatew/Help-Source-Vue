package cn.source.system.mapper;

import java.util.List;
import java.util.Map;

import cn.source.system.domain.HelpTask;

import cn.source.system.domain.HelpFeature;
import cn.source.system.domain.HelpImage;
import cn.source.system.domain.HelpTask;

/**
 * 互助信息详情Mapper接口
 * 
 * @author zjx
 * @date 2023-04-12
 */
public interface HelpTaskMapper 
{
    /**
     * 查询互助信息详情
     * 
     * @param id 互助信息详情主键
     * @return 互助信息详情
     */
    HelpTask selectHelpTaskById(Long id);

    /**
     * 按代号查询互助信息详情
     *
     * @param code 代号
     * @return 房源详情
     */
    HelpTask selectHelpTaskByCode(String code);

    /**
     * 查询互助信息详情列表
     * 
     * @param helpTask 互助信息详情
     * @return 互助信息详情集合
     */
    List<HelpTask> selectHelpTaskList(HelpTask helpTask);

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
    int updateHelpAgent(Map<String,Object> helpMap);


    /**
     * 修改互助详情
     *
     * @param helpMap 互助详情
     * @return 结果
     */
    int updateHelpTaskByIds(Map<String,Object> helpMap);


    /**
     * 删除互助信息详情
     * 
     * @param id 互助信息详情主键
     * @return 结果
     */
    int deleteHelpTaskById(Long id);

    /**
     * 批量删除互助信息详情
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteHelpTaskByIds(Long[] ids);

    /**
     * 新增互助信息图片
     *
     * @param helpTask 互助信息详情
     * @return 结果
     */
    int insertHelpImage(HelpTask helpTask);

    /**
     * 删除互助信息图片
     *
     * @param id 互助信息详情主键
     * @return 结果
     */
    int deleteHelpImageByHelpId(Long id);

    /**
     * 删除收藏记录
     *
     * @param id 互助信息详情主键
     * @return 结果
     */
    int deleteHelpHeartByHelpId(Long id);

    /**
     * 新增互助信息特色
     *
     * @param helpTask 互助信息详情
     * @return 结果
     */
    int insertHelpFeature(HelpTask helpTask);

    /**
     * 删除互助信息亮点
     *
     * @param id 互助信息详情主键
     * @return 结果
     */
    int deleteHelpFeatureByHelpId(Long id);

    /**
     * 查询互助信息图片详情
     *
     * @param helpTask 互助信息详情
     * @return 互助信息详情
     */
    List<HelpImage> selectHelpImage(HelpTask helpTask);

    /**
     * 查询互助信息亮点详情
     *
     * @param helpTask 互助信息详情
     * @return 互助信息详情
     */
    List<HelpFeature> selectHelpFeature(HelpTask helpTask);
    /**
     * 互助信息收藏
     */
    int saveHeart(Map<String,Object> helpMap);

    /**
     * 互助信息取消收藏
     */
    int cancelHeart(Map<String,Object> helpMap);

    /**
     * 查询收藏数据
     */
    Long selectHelpHeart(Map<String,Object> helpMap);

    /**
     * 获取收藏互助信息列表
     */
    List<HelpTask> findHelpHeartList(Long userId);
}
