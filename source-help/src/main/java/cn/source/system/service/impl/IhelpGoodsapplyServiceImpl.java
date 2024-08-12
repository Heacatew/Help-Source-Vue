package cn.source.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.source.system.mapper.IhelpGoodsapplyMapper;
import cn.source.system.domain.IhelpGoodsapply;
import cn.source.system.service.IIhelpGoodsapplyService;

/**
 * 物资供应Service业务层处理
 * 
 * @author zjx
 * @date 2023-04-20
 */
@Service
public class IhelpGoodsapplyServiceImpl implements IIhelpGoodsapplyService 
{
    @Autowired
    private IhelpGoodsapplyMapper ihelpGoodsapplyMapper;

    /**
     * 查询物资供应
     * 
     * @param id 物资供应主键
     * @return 物资供应
     */
    @Override
    public IhelpGoodsapply selectIhelpGoodsapplyById(Long id)
    {
        return ihelpGoodsapplyMapper.selectIhelpGoodsapplyById(id);
    }

    /**
     * 查询物资供应列表
     * 
     * @param ihelpGoodsapply 物资供应
     * @return 物资供应
     */
    @Override
    public List<IhelpGoodsapply> selectIhelpGoodsapplyList(IhelpGoodsapply ihelpGoodsapply)
    {
        return ihelpGoodsapplyMapper.selectIhelpGoodsapplyList(ihelpGoodsapply);
    }

    /**
     * 新增物资供应
     * 
     * @param ihelpGoodsapply 物资供应
     * @return 结果
     */
    @Override
    public int insertIhelpGoodsapply(IhelpGoodsapply ihelpGoodsapply)
    {
        return ihelpGoodsapplyMapper.insertIhelpGoodsapply(ihelpGoodsapply);
    }

    /**
     * 修改物资供应
     * 
     * @param ihelpGoodsapply 物资供应
     * @return 结果
     */
    @Override
    public int updateIhelpGoodsapply(IhelpGoodsapply ihelpGoodsapply)
    {
        return ihelpGoodsapplyMapper.updateIhelpGoodsapply(ihelpGoodsapply);
    }

    /**
     * 批量删除物资供应
     * 
     * @param ids 需要删除的物资供应主键
     * @return 结果
     */
    @Override
    public int deleteIhelpGoodsapplyByIds(Long[] ids)
    {
        return ihelpGoodsapplyMapper.deleteIhelpGoodsapplyByIds(ids);
    }

    /**
     * 删除物资供应信息
     * 
     * @param id 物资供应主键
     * @return 结果
     */
    @Override
    public int deleteIhelpGoodsapplyById(Long id)
    {
        return ihelpGoodsapplyMapper.deleteIhelpGoodsapplyById(id);
    }
}
