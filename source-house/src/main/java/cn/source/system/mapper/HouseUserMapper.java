package cn.source.system.mapper;

import cn.source.system.domain.HouseUser;

import java.util.List;

/**
 * 出租信息Mapper接口
 *
 * @author 詹Sir
 * @date 2022-03-27
 */
public interface HouseUserMapper
{
    /**
     * 查询出租信息
     *
     * @param id 出租信息主键
     * @return 出租信息
     */
    HouseUser selectHouseUserById(Long id);

    /**
     * 查询出租信息列表
     *
     * @param houseUser 出租信息
     * @return 出租信息集合
     */
    List<HouseUser> selectHouseUserList(HouseUser houseUser);

    /**
     * 新增出租信息
     *
     * @param houseUser 出租信息
     * @return 结果
     */
    int insertHouseUser(HouseUser houseUser);

    /**
     * 修改出租信息
     *
     * @param houseUser 出租信息
     * @return 结果
     */
    int updateHouseUser(HouseUser houseUser);

    /**
     * 删除出租信息
     *
     * @param id 出租信息主键
     * @return 结果
     */
    int deleteHouseUserById(Long id);

    /**
     * 批量删除出租信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteHouseUserByIds(Long[] ids);
}
