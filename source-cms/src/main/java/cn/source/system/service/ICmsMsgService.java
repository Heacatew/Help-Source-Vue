package cn.source.system.service;

import cn.source.system.domain.CmsMsg;

import java.util.List;

/**
 * 消息管理Service接口
 *
 * @author 詹Sir
 * @date 2022-04-03
 */
public interface ICmsMsgService
{
    /**
     * 查询消息管理
     *
     * @param id 消息管理主键
     * @return 消息管理
     */
    CmsMsg selectCmsMsgById(Long id);

    /**
     * 查询消息管理列表
     *
     * @param cmsMsg 消息管理
     * @return 消息管理集合
     */
    List<CmsMsg> selectCmsMsgList(CmsMsg cmsMsg);

    /**
     * 新增消息管理
     *
     * @param cmsMsg 消息管理
     * @return 结果
     */
    int insertCmsMsg(CmsMsg cmsMsg);

    /**
     * 修改消息管理
     *
     * @param cmsMsg 消息管理
     * @return 结果
     */
    int updateCmsMsg(CmsMsg cmsMsg);

    /**
     * 批量删除消息管理
     *
     * @param ids 需要删除的消息管理主键集合
     * @return 结果
     */
    int deleteCmsMsgByIds(Long[] ids);

    /**
     * 删除消息管理信息
     *
     * @param id 消息管理主键
     * @return 结果
     */
    int deleteCmsMsgById(Long id);
}
