package cn.source.system.mapper;

import cn.source.system.domain.CmsFeedback;

import java.util.List;

/**
 * 意见反馈Mapper接口
 *
 * @author source
 * @date 2022-03-01
 */
public interface CmsFeedbackMapper
{
    /**
     * 查询意见反馈
     *
     * @param id 意见反馈主键
     * @return 意见反馈
     */
    CmsFeedback selectCmsFeedbackById(Long id);

    /**
     * 查询意见反馈列表
     *
     * @param cmsFeedback 意见反馈
     * @return 意见反馈集合
     */
    List<CmsFeedback> selectCmsFeedbackList(CmsFeedback cmsFeedback);

    /**
     * 新增意见反馈
     *
     * @param cmsFeedback 意见反馈
     * @return 结果
     */
    int insertCmsFeedback(CmsFeedback cmsFeedback);

    /**
     * 修改意见反馈
     *
     * @param cmsFeedback 意见反馈
     * @return 结果
     */
    int updateCmsFeedback(CmsFeedback cmsFeedback);

    /**
     * 删除意见反馈
     *
     * @param id 意见反馈主键
     * @return 结果
     */
    int deleteCmsFeedbackById(Long id);

    /**
     * 批量删除意见反馈
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteCmsFeedbackByIds(Long[] ids);
}
