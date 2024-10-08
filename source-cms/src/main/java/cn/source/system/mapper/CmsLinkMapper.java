package cn.source.system.mapper;

import cn.source.system.domain.CmsLink;

import java.util.List;

/**
 * 友情链接Mapper接口
 *
 * @author 詹Sir
 * @date 2022-03-12
 */
public interface CmsLinkMapper
{
    /**
     * 查询友情链接
     *
     * @param id 友情链接主键
     * @return 友情链接
     */
    CmsLink selectCmsLinkById(Long id);

    /**
     * 查询友情链接列表
     *
     * @param cmsLink 友情链接
     * @return 友情链接集合
     */
    List<CmsLink> selectCmsLinkList(CmsLink cmsLink);

    /**
     * 新增友情链接
     *
     * @param cmsLink 友情链接
     * @return 结果
     */
    int insertCmsLink(CmsLink cmsLink);

    /**
     * 修改友情链接
     *
     * @param cmsLink 友情链接
     * @return 结果
     */
    int updateCmsLink(CmsLink cmsLink);

    /**
     * 删除友情链接
     *
     * @param id 友情链接主键
     * @return 结果
     */
    int deleteCmsLinkById(Long id);

    /**
     * 批量删除友情链接
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteCmsLinkByIds(Long[] ids);
}
