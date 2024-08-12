package cn.source.system.service;

import java.util.List;
import cn.source.system.domain.HelpUser;

/**
 * 互助进度信息Service接口
 * 
 * @author zjx
 * @date 2023-04-18
 */
public interface IHelpUserService 
{
    /**
     * 查询互助进度信息
     * 
     * @param id 互助进度信息主键
     * @return 互助进度信息
     */
    HelpUser selectHelpUserById(Long id);

    /**
     * 查询互助进度信息列表
     * 
     * @param helpUser 互助进度信息
     * @return 互助进度信息集合
     */
    List<HelpUser> selectHelpUserList(HelpUser helpUser);

    /**
     * 新增互助进度信息
     * 
     * @param helpUser 互助进度信息
     * @return 结果
     */
    int insertHelpUser(HelpUser helpUser);

    /**
     * 修改互助进度信息
     * 
     * @param helpUser 互助进度信息
     * @return 结果
     */
    int updateHelpUser(HelpUser helpUser);

    /**
     * 批量删除互助进度信息
     * 
     * @param ids 需要删除的互助进度信息主键集合
     * @return 结果
     */
    int deleteHelpUserByIds(Long[] ids);

    /**
     * 删除互助进度信息信息
     * 
     * @param id 互助进度信息主键
     * @return 结果
     */
    int deleteHelpUserById(Long id);
}
