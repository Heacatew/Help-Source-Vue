package cn.source.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.source.system.mapper.IhelpVolunteerMapper;
import cn.source.system.domain.IhelpVolunteer;
import cn.source.system.service.IIhelpVolunteerService;

/**
 * 志愿者Service业务层处理
 * 
 * @author zjx
 * @date 2023-04-20
 */
@Service
public class IhelpVolunteerServiceImpl implements IIhelpVolunteerService 
{
    @Autowired
    private IhelpVolunteerMapper ihelpVolunteerMapper;

    /**
     * 查询志愿者
     * 
     * @param id 志愿者主键
     * @return 志愿者
     */
    @Override
    public IhelpVolunteer selectIhelpVolunteerById(Long id)
    {
        return ihelpVolunteerMapper.selectIhelpVolunteerById(id);
    }

    /**
     * 查询志愿者列表
     * 
     * @param ihelpVolunteer 志愿者
     * @return 志愿者
     */
    @Override
    public List<IhelpVolunteer> selectIhelpVolunteerList(IhelpVolunteer ihelpVolunteer)
    {
        return ihelpVolunteerMapper.selectIhelpVolunteerList(ihelpVolunteer);
    }

    /**
     * 新增志愿者
     * 
     * @param ihelpVolunteer 志愿者
     * @return 结果
     */
    @Override
    public int insertIhelpVolunteer(IhelpVolunteer ihelpVolunteer)
    {
        return ihelpVolunteerMapper.insertIhelpVolunteer(ihelpVolunteer);
    }

    /**
     * 修改志愿者
     * 
     * @param ihelpVolunteer 志愿者
     * @return 结果
     */
    @Override
    public int updateIhelpVolunteer(IhelpVolunteer ihelpVolunteer)
    {
        return ihelpVolunteerMapper.updateIhelpVolunteer(ihelpVolunteer);
    }

    /**
     * 批量删除志愿者
     * 
     * @param ids 需要删除的志愿者主键
     * @return 结果
     */
    @Override
    public int deleteIhelpVolunteerByIds(Long[] ids)
    {
        return ihelpVolunteerMapper.deleteIhelpVolunteerByIds(ids);
    }

    /**
     * 删除志愿者信息
     * 
     * @param id 志愿者主键
     * @return 结果
     */
    @Override
    public int deleteIhelpVolunteerById(Long id)
    {
        return ihelpVolunteerMapper.deleteIhelpVolunteerById(id);
    }
}
