package cn.source.system.service;

import java.util.List;
import cn.source.system.domain.IhelpVolunteer;

/**
 * 志愿者Service接口
 * 
 * @author zjx
 * @date 2023-04-20
 */
public interface IIhelpVolunteerService 
{
    /**
     * 查询志愿者
     * 
     * @param id 志愿者主键
     * @return 志愿者
     */
    IhelpVolunteer selectIhelpVolunteerById(Long id);

    /**
     * 查询志愿者列表
     * 
     * @param ihelpVolunteer 志愿者
     * @return 志愿者集合
     */
    List<IhelpVolunteer> selectIhelpVolunteerList(IhelpVolunteer ihelpVolunteer);

    /**
     * 新增志愿者
     * 
     * @param ihelpVolunteer 志愿者
     * @return 结果
     */
    int insertIhelpVolunteer(IhelpVolunteer ihelpVolunteer);

    /**
     * 修改志愿者
     * 
     * @param ihelpVolunteer 志愿者
     * @return 结果
     */
    int updateIhelpVolunteer(IhelpVolunteer ihelpVolunteer);

    /**
     * 批量删除志愿者
     * 
     * @param ids 需要删除的志愿者主键集合
     * @return 结果
     */
    int deleteIhelpVolunteerByIds(Long[] ids);

    /**
     * 删除志愿者信息
     * 
     * @param id 志愿者主键
     * @return 结果
     */
    int deleteIhelpVolunteerById(Long id);
}
