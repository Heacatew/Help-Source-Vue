package cn.source.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.source.system.mapper.HelpImageMapper;
import cn.source.system.domain.HelpImage;
import cn.source.system.service.IHelpImageService;

/**
 * 互助信息图片Service业务层处理
 * 
 * @author zjx
 * @date 2023-04-18
 */
@Service
public class HelpImageServiceImpl implements IHelpImageService 
{
    @Autowired
    private HelpImageMapper helpImageMapper;

    /**
     * 查询互助信息图片
     * 
     * @param id 互助信息图片主键
     * @return 互助信息图片
     */
    @Override
    public HelpImage selectHelpImageById(Long id)
    {
        return helpImageMapper.selectHelpImageById(id);
    }

    /**
     * 查询互助信息图片列表
     * 
     * @param helpImage 互助信息图片
     * @return 互助信息图片
     */
    @Override
    public List<HelpImage> selectHelpImageList(HelpImage helpImage)
    {
        return helpImageMapper.selectHelpImageList(helpImage);
    }

    /**
     * 新增互助信息图片
     * 
     * @param helpImage 互助信息图片
     * @return 结果
     */
    @Override
    public int insertHelpImage(HelpImage helpImage)
    {
        return helpImageMapper.insertHelpImage(helpImage);
    }

    /**
     * 修改互助信息图片
     * 
     * @param helpImage 互助信息图片
     * @return 结果
     */
    @Override
    public int updateHelpImage(HelpImage helpImage)
    {
        return helpImageMapper.updateHelpImage(helpImage);
    }

    /**
     * 批量删除互助信息图片
     * 
     * @param ids 需要删除的互助信息图片主键
     * @return 结果
     */
    @Override
    public int deleteHelpImageByIds(Long[] ids)
    {
        return helpImageMapper.deleteHelpImageByIds(ids);
    }

    /**
     * 删除互助信息图片信息
     * 
     * @param id 互助信息图片主键
     * @return 结果
     */
    @Override
    public int deleteHelpImageById(Long id)
    {
        return helpImageMapper.deleteHelpImageById(id);
    }
}
