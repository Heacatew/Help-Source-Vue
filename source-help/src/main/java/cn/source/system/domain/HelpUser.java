package cn.source.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.source.common.annotation.Excel;
import cn.source.common.core.domain.BaseEntity;

/**
 * 互助进度信息对象 help_user
 * 
 * @author zjx
 * @date 2023-04-18
 */
public class HelpUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 互助id */
    @Excel(name = "互助id")
    private Long helpId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 发布id */
    @Excel(name = "发布id")
    private Long publishId;

    /** 预置 */
    private BigDecimal actualPrice;

    /** 互助状态 */
    @Excel(name = "互助状态")
    private Integer state;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHelpId(Long helpId) 
    {
        this.helpId = helpId;
    }

    public Long getHelpId() 
    {
        return helpId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setPublishId(Long publishId) 
    {
        this.publishId = publishId;
    }

    public Long getPublishId() 
    {
        return publishId;
    }
    public void setActualPrice(BigDecimal actualPrice) 
    {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getActualPrice() 
    {
        return actualPrice;
    }
    public void setState(Integer state) 
    {
        this.state = state;
    }

    public Integer getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("helpId", getHelpId())
            .append("userId", getUserId())
            .append("publishId", getPublishId())
            .append("actualPrice", getActualPrice())
            .append("state", getState())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
