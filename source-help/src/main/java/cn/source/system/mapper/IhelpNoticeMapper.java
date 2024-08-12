package cn.source.system.mapper;

import java.util.List;
import cn.source.system.domain.IhelpNotice;

/**
 * 紧急通知Mapper接口
 * 
 * @author zjx
 * @date 2023-04-20
 */
public interface IhelpNoticeMapper 
{
    /**
     * 查询紧急通知
     * 
     * @param id 紧急通知主键
     * @return 紧急通知
     */
    IhelpNotice selectIhelpNoticeById(Long id);

    /**
     * 查询紧急通知列表
     * 
     * @param ihelpNotice 紧急通知
     * @return 紧急通知集合
     */
    List<IhelpNotice> selectIhelpNoticeList(IhelpNotice ihelpNotice);

    /**
     * 新增紧急通知
     * 
     * @param ihelpNotice 紧急通知
     * @return 结果
     */
    int insertIhelpNotice(IhelpNotice ihelpNotice);

    /**
     * 修改紧急通知
     * 
     * @param ihelpNotice 紧急通知
     * @return 结果
     */
    int updateIhelpNotice(IhelpNotice ihelpNotice);

    /**
     * 删除紧急通知
     * 
     * @param id 紧急通知主键
     * @return 结果
     */
    int deleteIhelpNoticeById(Long id);

    /**
     * 批量删除紧急通知
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteIhelpNoticeByIds(Long[] ids);
}
