package cn.source.system.service;

import cn.source.system.domain.HouseVillage;

import java.util.List;

/**
 * 房源小区Service接口
 *
 * @author 詹Sir
 * @date 2022-03-27
 */
public interface IHouseVillageService
{
    /**
     * 查询房源小区
     *
     * @param id 房源小区主键
     * @return 房源小区
     */
    HouseVillage selectHouseVillageById(Long id);

    /**
     * 查询房源小区列表
     *
     * @param houseVillage 房源小区
     * @return 房源小区集合
     */
    List<HouseVillage> selectHouseVillageList(HouseVillage houseVillage);

    /**
     * 新增房源小区
     *
     * @param houseVillage 房源小区
     * @return 结果
     */
    int insertHouseVillage(HouseVillage houseVillage);

    /**
     * 修改房源小区
     *
     * @param houseVillage 房源小区
     * @return 结果
     */
    int updateHouseVillage(HouseVillage houseVillage);

    /**
     * 批量删除房源小区
     *
     * @param ids 需要删除的房源小区主键集合
     * @return 结果
     */
    int deleteHouseVillageByIds(Long[] ids);

    /**
     * 删除房源小区信息
     *
     * @param id 房源小区主键
     * @return 结果
     */
    int deleteHouseVillageById(Long id);

    /**
     * 通过小区名称查询房源小区
     *
     * @param houseVillage 房源小区
     * @return 房源小区集合
     */
    HouseVillage selectHouseVillage(HouseVillage houseVillage);
}
