package cn.source.system.service;

import java.util.List;
import cn.source.system.domain.HelpUserinfo;

/**
 * 互助用户常用信息Service接口
 * 
 * @author zjx
 * @date 2023-04-18
 */
public interface IHelpUserinfoService 
{
    /**
     * 查询互助用户常用信息
     * 
     * @param id 互助用户常用信息主键
     * @return 互助用户常用信息
     */
    HelpUserinfo selectHelpUserinfoById(Long id);

    /**
     * 查询互助用户常用信息列表
     * 
     * @param helpUserinfo 互助用户常用信息
     * @return 互助用户常用信息集合
     */
    List<HelpUserinfo> selectHelpUserinfoList(HelpUserinfo helpUserinfo);

    /**
     * 新增互助用户常用信息
     * 
     * @param helpUserinfo 互助用户常用信息
     * @return 结果
     */
    int insertHelpUserinfo(HelpUserinfo helpUserinfo);

    /**
     * 修改互助用户常用信息
     * 
     * @param helpUserinfo 互助用户常用信息
     * @return 结果
     */
    int updateHelpUserinfo(HelpUserinfo helpUserinfo);

    /**
     * 批量删除互助用户常用信息
     * 
     * @param ids 需要删除的互助用户常用信息主键集合
     * @return 结果
     */
    int deleteHelpUserinfoByIds(Long[] ids);

    /**
     * 删除互助用户常用信息信息
     * 
     * @param id 互助用户常用信息主键
     * @return 结果
     */
    int deleteHelpUserinfoById(Long id);
}
