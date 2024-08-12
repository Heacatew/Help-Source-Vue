package cn.source.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.source.system.mapper.HelpUserinfoMapper;
import cn.source.system.domain.HelpUserinfo;
import cn.source.system.service.IHelpUserinfoService;

/**
 * 互助用户常用信息Service业务层处理
 * 
 * @author zjx
 * @date 2023-04-18
 */
@Service
public class HelpUserinfoServiceImpl implements IHelpUserinfoService 
{
    @Autowired
    private HelpUserinfoMapper helpUserinfoMapper;

    /**
     * 查询互助用户常用信息
     * 
     * @param id 互助用户常用信息主键
     * @return 互助用户常用信息
     */
    @Override
    public HelpUserinfo selectHelpUserinfoById(Long id)
    {
        return helpUserinfoMapper.selectHelpUserinfoById(id);
    }

    /**
     * 查询互助用户常用信息列表
     * 
     * @param helpUserinfo 互助用户常用信息
     * @return 互助用户常用信息
     */
    @Override
    public List<HelpUserinfo> selectHelpUserinfoList(HelpUserinfo helpUserinfo)
    {
        return helpUserinfoMapper.selectHelpUserinfoList(helpUserinfo);
    }

    /**
     * 新增互助用户常用信息
     * 
     * @param helpUserinfo 互助用户常用信息
     * @return 结果
     */
    @Override
    public int insertHelpUserinfo(HelpUserinfo helpUserinfo)
    {
        return helpUserinfoMapper.insertHelpUserinfo(helpUserinfo);
    }

    /**
     * 修改互助用户常用信息
     * 
     * @param helpUserinfo 互助用户常用信息
     * @return 结果
     */
    @Override
    public int updateHelpUserinfo(HelpUserinfo helpUserinfo)
    {
        return helpUserinfoMapper.updateHelpUserinfo(helpUserinfo);
    }

    /**
     * 批量删除互助用户常用信息
     * 
     * @param ids 需要删除的互助用户常用信息主键
     * @return 结果
     */
    @Override
    public int deleteHelpUserinfoByIds(Long[] ids)
    {
        return helpUserinfoMapper.deleteHelpUserinfoByIds(ids);
    }

    /**
     * 删除互助用户常用信息信息
     * 
     * @param id 互助用户常用信息主键
     * @return 结果
     */
    @Override
    public int deleteHelpUserinfoById(Long id)
    {
        return helpUserinfoMapper.deleteHelpUserinfoById(id);
    }
}
