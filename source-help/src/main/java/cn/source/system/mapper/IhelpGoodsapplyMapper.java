package cn.source.system.mapper;

import java.util.List;
import cn.source.system.domain.IhelpGoodsapply;

/**
 * 物资供应Mapper接口
 * 
 * @author zjx
 * @date 2023-04-20
 */
public interface IhelpGoodsapplyMapper 
{
    /**
     * 查询物资供应
     * 
     * @param id 物资供应主键
     * @return 物资供应
     */
    IhelpGoodsapply selectIhelpGoodsapplyById(Long id);

    /**
     * 查询物资供应列表
     * 
     * @param ihelpGoodsapply 物资供应
     * @return 物资供应集合
     */
    List<IhelpGoodsapply> selectIhelpGoodsapplyList(IhelpGoodsapply ihelpGoodsapply);

    /**
     * 新增物资供应
     * 
     * @param ihelpGoodsapply 物资供应
     * @return 结果
     */
    int insertIhelpGoodsapply(IhelpGoodsapply ihelpGoodsapply);

    /**
     * 修改物资供应
     * 
     * @param ihelpGoodsapply 物资供应
     * @return 结果
     */
    int updateIhelpGoodsapply(IhelpGoodsapply ihelpGoodsapply);

    /**
     * 删除物资供应
     * 
     * @param id 物资供应主键
     * @return 结果
     */
    int deleteIhelpGoodsapplyById(Long id);

    /**
     * 批量删除物资供应
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteIhelpGoodsapplyByIds(Long[] ids);
}
