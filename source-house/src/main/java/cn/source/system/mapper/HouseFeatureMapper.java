package cn.source.system.mapper;

import cn.source.system.domain.HouseFeature;

import java.util.List;

/**
 * 房源特色Mapper接口
 *
 * @author 詹Sir
 * @date 2022-03-27
 */
public interface HouseFeatureMapper
{
    /**
     * 查询房源特色
     *
     * @param id 房源特色主键
     * @return 房源特色
     */
    HouseFeature selectHouseFeatureById(Long id);

    /**
     * 查询房源特色列表
     *
     * @param houseFeature 房源特色
     * @return 房源特色集合
     */
    List<HouseFeature> selectHouseFeatureList(HouseFeature houseFeature);

    /**
     * 新增房源特色
     *
     * @param houseFeature 房源特色
     * @return 结果
     */
    int insertHouseFeature(HouseFeature houseFeature);

    /**
     * 修改房源特色
     *
     * @param houseFeature 房源特色
     * @return 结果
     */
    int updateHouseFeature(HouseFeature houseFeature);

    /**
     * 删除房源特色
     *
     * @param id 房源特色主键
     * @return 结果
     */
    int deleteHouseFeatureById(Long id);

    /**
     * 批量删除房源特色
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteHouseFeatureByIds(Long[] ids);
}
