package cn.source.system.mapper;

import java.util.List;
import cn.source.system.domain.HelpImage;

/**
 * 互助信息图片Mapper接口
 * 
 * @author zjx
 * @date 2023-04-18
 */
public interface HelpImageMapper 
{
    /**
     * 查询互助信息图片
     * 
     * @param id 互助信息图片主键
     * @return 互助信息图片
     */
    HelpImage selectHelpImageById(Long id);

    /**
     * 查询互助信息图片列表
     * 
     * @param helpImage 互助信息图片
     * @return 互助信息图片集合
     */
    List<HelpImage> selectHelpImageList(HelpImage helpImage);

    /**
     * 新增互助信息图片
     * 
     * @param helpImage 互助信息图片
     * @return 结果
     */
    int insertHelpImage(HelpImage helpImage);

    /**
     * 修改互助信息图片
     * 
     * @param helpImage 互助信息图片
     * @return 结果
     */
    int updateHelpImage(HelpImage helpImage);

    /**
     * 删除互助信息图片
     * 
     * @param id 互助信息图片主键
     * @return 结果
     */
    int deleteHelpImageById(Long id);

    /**
     * 批量删除互助信息图片
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteHelpImageByIds(Long[] ids);
}
