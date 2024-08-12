package cn.source.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.source.system.mapper.HelpFeatureMapper;
import cn.source.system.domain.HelpFeature;
import cn.source.system.service.IHelpFeatureService;

/**
 * 互助信息特征Service业务层处理
 * 
 * @author zjx
 * @date 2023-04-12
 */
@Service
public class HelpFeatureServiceImpl implements IHelpFeatureService 
{
    @Autowired
    private HelpFeatureMapper helpFeatureMapper;

    /**
     * 查询互助信息特征
     * 
     * @param id 互助信息特征主键
     * @return 互助信息特征
     */
    @Override
    public HelpFeature selectHelpFeatureById(Long id)
    {
        return helpFeatureMapper.selectHelpFeatureById(id);
    }

    /**
     * 查询互助信息特征列表
     * 
     * @param helpFeature 互助信息特征
     * @return 互助信息特征
     */
    @Override
    public List<HelpFeature> selectHelpFeatureList(HelpFeature helpFeature)
    {
        return helpFeatureMapper.selectHelpFeatureList(helpFeature);
    }

    /**
     * 新增互助信息特征
     * 
     * @param helpFeature 互助信息特征
     * @return 结果
     */
    @Override
    public int insertHelpFeature(HelpFeature helpFeature)
    {
        return helpFeatureMapper.insertHelpFeature(helpFeature);
    }

    /**
     * 修改互助信息特征
     * 
     * @param helpFeature 互助信息特征
     * @return 结果
     */
    @Override
    public int updateHelpFeature(HelpFeature helpFeature)
    {
        return helpFeatureMapper.updateHelpFeature(helpFeature);
    }

    /**
     * 批量删除互助信息特征
     * 
     * @param ids 需要删除的互助信息特征主键
     * @return 结果
     */
    @Override
    public int deleteHelpFeatureByIds(Long[] ids)
    {
        return helpFeatureMapper.deleteHelpFeatureByIds(ids);
    }

    /**
     * 删除互助信息特征信息
     * 
     * @param id 互助信息特征主键
     * @return 结果
     */
    @Override
    public int deleteHelpFeatureById(Long id)
    {
        return helpFeatureMapper.deleteHelpFeatureById(id);
    }
}
