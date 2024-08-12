package cn.source.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.source.system.mapper.IhelpNoticeMapper;
import cn.source.system.domain.IhelpNotice;
import cn.source.system.service.IIhelpNoticeService;

/**
 * 紧急通知Service业务层处理
 * 
 * @author zjx
 * @date 2023-04-20
 */
@Service
public class IhelpNoticeServiceImpl implements IIhelpNoticeService 
{
    @Autowired
    private IhelpNoticeMapper ihelpNoticeMapper;

    /**
     * 查询紧急通知
     * 
     * @param id 紧急通知主键
     * @return 紧急通知
     */
    @Override
    public IhelpNotice selectIhelpNoticeById(Long id)
    {
        return ihelpNoticeMapper.selectIhelpNoticeById(id);
    }

    /**
     * 查询紧急通知列表
     * 
     * @param ihelpNotice 紧急通知
     * @return 紧急通知
     */
    @Override
    public List<IhelpNotice> selectIhelpNoticeList(IhelpNotice ihelpNotice)
    {
        return ihelpNoticeMapper.selectIhelpNoticeList(ihelpNotice);
    }

    /**
     * 新增紧急通知
     * 
     * @param ihelpNotice 紧急通知
     * @return 结果
     */
    @Override
    public int insertIhelpNotice(IhelpNotice ihelpNotice)
    {
        return ihelpNoticeMapper.insertIhelpNotice(ihelpNotice);
    }

    /**
     * 修改紧急通知
     * 
     * @param ihelpNotice 紧急通知
     * @return 结果
     */
    @Override
    public int updateIhelpNotice(IhelpNotice ihelpNotice)
    {
        return ihelpNoticeMapper.updateIhelpNotice(ihelpNotice);
    }

    /**
     * 批量删除紧急通知
     * 
     * @param ids 需要删除的紧急通知主键
     * @return 结果
     */
    @Override
    public int deleteIhelpNoticeByIds(Long[] ids)
    {
        return ihelpNoticeMapper.deleteIhelpNoticeByIds(ids);
    }

    /**
     * 删除紧急通知信息
     * 
     * @param id 紧急通知主键
     * @return 结果
     */
    @Override
    public int deleteIhelpNoticeById(Long id)
    {
        return ihelpNoticeMapper.deleteIhelpNoticeById(id);
    }
}
