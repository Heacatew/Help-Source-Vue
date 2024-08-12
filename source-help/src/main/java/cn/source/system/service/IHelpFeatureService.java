package cn.source.system.service;

import java.util.List;
import cn.source.system.domain.HelpFeature;

/**
 * 互助信息特征Service接口
 * 
 * @author zjx
 * @date 2023-04-12
 */
public interface IHelpFeatureService 
{
    /**
     * 查询互助信息特征
     * 
     * @param id 互助信息特征主键
     * @return 互助信息特征
     */
    HelpFeature selectHelpFeatureById(Long id);

    /**
     * 查询互助信息特征列表
     * 
     * @param helpFeature 互助信息特征
     * @return 互助信息特征集合
     */
    List<HelpFeature> selectHelpFeatureList(HelpFeature helpFeature);

    /**
     * 新增互助信息特征
     * 
     * @param helpFeature 互助信息特征
     * @return 结果
     */
    int insertHelpFeature(HelpFeature helpFeature);

    /**
     * 修改互助信息特征
     * 
     * @param helpFeature 互助信息特征
     * @return 结果
     */
    int updateHelpFeature(HelpFeature helpFeature);

    /**
     * 批量删除互助信息特征
     * 
     * @param ids 需要删除的互助信息特征主键集合
     * @return 结果
     */
    int deleteHelpFeatureByIds(Long[] ids);

    /**
     * 删除互助信息特征信息
     * 
     * @param id 互助信息特征主键
     * @return 结果
     */
    int deleteHelpFeatureById(Long id);
}
