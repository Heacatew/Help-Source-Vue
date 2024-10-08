package cn.source.system.service;

import cn.source.system.domain.CmsFeedback;

import java.util.List;

/**
 * 意见反馈Service接口
 *
 * @author source
 * @date 2022-03-01
 */
public interface ICmsFeedbackService
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
     * 批量删除意见反馈
     *
     * @param ids 需要删除的意见反馈主键集合
     * @return 结果
     */
    int deleteCmsFeedbackByIds(Long[] ids);

    /**
     * 删除意见反馈信息
     *
     * @param id 意见反馈主键
     * @return 结果
     */
    int deleteCmsFeedbackById(Long id);
}
