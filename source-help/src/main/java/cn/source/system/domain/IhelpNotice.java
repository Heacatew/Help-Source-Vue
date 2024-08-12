package cn.source.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.source.common.annotation.Excel;
import cn.source.common.core.domain.BaseEntity;

/**
 * 紧急通知对象 ihelp_notice
 * 
 * @author zjx
 * @date 2023-04-20
 */
public class IhelpNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 创建时间 */
    private Date addtime;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 简介 */
    @Excel(name = "简介")
    private String introduction;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishtime;

    /** 封面 */
    @Excel(name = "封面")
    private String picture;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 最近点击时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最近点击时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date clicktime;

    /** 点击次数 */
    @Excel(name = "点击次数")
    private Long clicknum;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAddtime(Date addtime) 
    {
        this.addtime = addtime;
    }

    public Date getAddtime() 
    {
        return addtime;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setIntroduction(String introduction) 
    {
        this.introduction = introduction;
    }

    public String getIntroduction() 
    {
        return introduction;
    }
    public void setPublishtime(Date publishtime) 
    {
        this.publishtime = publishtime;
    }

    public Date getPublishtime() 
    {
        return publishtime;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setClicktime(Date clicktime) 
    {
        this.clicktime = clicktime;
    }

    public Date getClicktime() 
    {
        return clicktime;
    }
    public void setClicknum(Long clicknum) 
    {
        this.clicknum = clicknum;
    }

    public Long getClicknum() 
    {
        return clicknum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("addtime", getAddtime())
            .append("title", getTitle())
            .append("introduction", getIntroduction())
            .append("publishtime", getPublishtime())
            .append("picture", getPicture())
            .append("content", getContent())
            .append("clicktime", getClicktime())
            .append("clicknum", getClicknum())
            .toString();
    }
}
