package cn.source.system.mapper;

import cn.source.system.domain.HouseImage;

import java.util.List;

/**
 * 房源图片Mapper接口
 *
 * @author 詹Sir
 * @date 2022-03-27
 */
public interface HouseImageMapper
{
    /**
     * 查询房源图片
     *
     * @param id 房源图片主键
     * @return 房源图片
     */
    HouseImage selectHouseImageById(Long id);

    /**
     * 查询房源图片列表
     *
     * @param houseImage 房源图片
     * @return 房源图片集合
     */
    List<HouseImage> selectHouseImageList(HouseImage houseImage);

    /**
     * 新增房源图片
     *
     * @param houseImage 房源图片
     * @return 结果
     */
    int insertHouseImage(HouseImage houseImage);

    /**
     * 修改房源图片
     *
     * @param houseImage 房源图片
     * @return 结果
     */
    int updateHouseImage(HouseImage houseImage);

    /**
     * 删除房源图片
     *
     * @param id 房源图片主键
     * @return 结果
     */
    int deleteHouseImageById(Long id);

    /**
     * 批量删除房源图片
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteHouseImageByIds(Long[] ids);
}
