package cn.source.system.service.impl;

import java.util.List;
import cn.source.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.source.system.mapper.HelpVillageMapper;
import cn.source.system.domain.HelpVillage;
import cn.source.system.service.IHelpVillageService;

/**
 * 互助信息小区Service业务层处理
 * 
 * @author zjx
 * @date 2023-04-18
 */
@Service
public class HelpVillageServiceImpl implements IHelpVillageService 
{
    @Autowired
    private HelpVillageMapper helpVillageMapper;

    /**
     * 查询互助信息小区
     * 
     * @param id 互助信息小区主键
     * @return 互助信息小区
     */
    @Override
    public HelpVillage selectHelpVillageById(Long id)
    {
        return helpVillageMapper.selectHelpVillageById(id);
    }

    /**
     * 查询互助信息小区列表
     * 
     * @param helpVillage 互助信息小区
     * @return 互助信息小区
     */
    @Override
    public List<HelpVillage> selectHelpVillageList(HelpVillage helpVillage)
    {
        return helpVillageMapper.selectHelpVillageList(helpVillage);
    }

    /**
     * 新增互助信息小区
     * 
     * @param helpVillage 互助信息小区
     * @return 结果
     */
    @Override
    public int insertHelpVillage(HelpVillage helpVillage)
    {
        helpVillage.setCreateTime(DateUtils.getNowDate());
        return helpVillageMapper.insertHelpVillage(helpVillage);
    }

    /**
     * 修改互助信息小区
     * 
     * @param helpVillage 互助信息小区
     * @return 结果
     */
    @Override
    public int updateHelpVillage(HelpVillage helpVillage)
    {
        helpVillage.setUpdateTime(DateUtils.getNowDate());
        return helpVillageMapper.updateHelpVillage(helpVillage);
    }

    /**
     * 批量删除互助信息小区
     * 
     * @param ids 需要删除的互助信息小区主键
     * @return 结果
     */
    @Override
    public int deleteHelpVillageByIds(Long[] ids)
    {
        return helpVillageMapper.deleteHelpVillageByIds(ids);
    }

    /**
     * 删除互助信息小区信息
     * 
     * @param id 互助信息小区主键
     * @return 结果
     */
    @Override
    public int deleteHelpVillageById(Long id)
    {
        return helpVillageMapper.deleteHelpVillageById(id);
    }

    /**
     * 查询互助小区
     *
     * @param helpVillage 互助小区
     * @return 互助小区
     */
    @Override
    public HelpVillage selectHelpVillage(HelpVillage helpVillage) {
        return helpVillageMapper.selectHelpVillage(helpVillage);
    }
}
