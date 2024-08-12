package cn.source.system.service.impl;

import java.util.List;
import cn.source.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.source.system.mapper.HelpUserMapper;
import cn.source.system.domain.HelpUser;
import cn.source.system.service.IHelpUserService;

/**
 * 互助进度信息Service业务层处理
 * 
 * @author zjx
 * @date 2023-04-18
 */
@Service
public class HelpUserServiceImpl implements IHelpUserService 
{
    @Autowired
    private HelpUserMapper helpUserMapper;

    /**
     * 查询互助进度信息
     * 
     * @param id 互助进度信息主键
     * @return 互助进度信息
     */
    @Override
    public HelpUser selectHelpUserById(Long id)
    {
        return helpUserMapper.selectHelpUserById(id);
    }

    /**
     * 查询互助进度信息列表
     * 
     * @param helpUser 互助进度信息
     * @return 互助进度信息
     */
    @Override
    public List<HelpUser> selectHelpUserList(HelpUser helpUser)
    {
        return helpUserMapper.selectHelpUserList(helpUser);
    }

    /**
     * 新增互助进度信息
     * 
     * @param helpUser 互助进度信息
     * @return 结果
     */
    @Override
    public int insertHelpUser(HelpUser helpUser)
    {
        helpUser.setCreateTime(DateUtils.getNowDate());
        return helpUserMapper.insertHelpUser(helpUser);
    }

    /**
     * 修改互助进度信息
     * 
     * @param helpUser 互助进度信息
     * @return 结果
     */
    @Override
    public int updateHelpUser(HelpUser helpUser)
    {
        helpUser.setUpdateTime(DateUtils.getNowDate());
        return helpUserMapper.updateHelpUser(helpUser);
    }

    /**
     * 批量删除互助进度信息
     * 
     * @param ids 需要删除的互助进度信息主键
     * @return 结果
     */
    @Override
    public int deleteHelpUserByIds(Long[] ids)
    {
        return helpUserMapper.deleteHelpUserByIds(ids);
    }

    /**
     * 删除互助进度信息信息
     * 
     * @param id 互助进度信息主键
     * @return 结果
     */
    @Override
    public int deleteHelpUserById(Long id)
    {
        return helpUserMapper.deleteHelpUserById(id);
    }
}
