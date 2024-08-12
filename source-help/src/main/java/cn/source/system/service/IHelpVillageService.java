package cn.source.system.service;

import java.util.List;
import cn.source.system.domain.HelpVillage;

/**
 * 互助信息小区Service接口
 * 
 * @author zjx
 * @date 2023-04-18
 */
public interface IHelpVillageService 
{
    /**
     * 查询互助信息小区
     * 
     * @param id 互助信息小区主键
     * @return 互助信息小区
     */
    HelpVillage selectHelpVillageById(Long id);

    /**
     * 查询互助信息小区列表
     * 
     * @param helpVillage 互助信息小区
     * @return 互助信息小区集合
     */
    List<HelpVillage> selectHelpVillageList(HelpVillage helpVillage);

    /**
     * 新增互助信息小区
     * 
     * @param helpVillage 互助信息小区
     * @return 结果
     */
    int insertHelpVillage(HelpVillage helpVillage);

    /**
     * 修改互助信息小区
     * 
     * @param helpVillage 互助信息小区
     * @return 结果
     */
    int updateHelpVillage(HelpVillage helpVillage);

    /**
     * 批量删除互助信息小区
     * 
     * @param ids 需要删除的互助信息小区主键集合
     * @return 结果
     */
    int deleteHelpVillageByIds(Long[] ids);

    /**
     * 删除互助信息小区信息
     * 
     * @param id 互助信息小区主键
     * @return 结果
     */
    int deleteHelpVillageById(Long id);

    /**
     * 通过小区名称查询互助信息小区
     *
     * @param helpVillage 互助信息小区
     * @return 互助信息小区集合
     */
    HelpVillage selectHelpVillage(HelpVillage helpVillage);


}
