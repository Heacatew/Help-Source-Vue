package cn.source.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.source.common.annotation.Excel;
import cn.source.common.core.domain.BaseEntity;

/**
 * 互助信息特征对象 help_feature
 * 
 * @author zjx
 * @date 2023-04-12
 */
public class HelpFeature extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long helpId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String feature;

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
    public void setFeature(String feature) 
    {
        this.feature = feature;
    }

    public String getFeature() 
    {
        return feature;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("helpId", getHelpId())
            .append("feature", getFeature())
            .toString();
    }
}
