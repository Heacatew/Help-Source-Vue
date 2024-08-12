package cn.source.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.source.common.annotation.Excel;
import cn.source.common.core.domain.BaseEntity;

/**
 * 物资供应对象 ihelp_goodsapply
 * 
 * @author zjx
 * @date 2023-04-20
 */
public class IhelpGoodsapply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addtime;

    /** 申请编号 */
    @Excel(name = "申请编号")
    private String applyno;

    /** 物资名称 */
    @Excel(name = "物资名称")
    private String goodsname;

    /** 物资种类 */
    @Excel(name = "物资种类")
    private String goodskind;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applydate;

    /** 申请原因 */
    @Excel(name = "申请原因")
    private String applyreason;

    /** 账号 */
    @Excel(name = "账号")
    private String account;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 是否审核 */
    @Excel(name = "是否审核")
    private String isexamine;

    /** 审核回复 */
    @Excel(name = "审核回复")
    private String examreply;

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
    public void setApplyno(String applyno) 
    {
        this.applyno = applyno;
    }

    public String getApplyno() 
    {
        return applyno;
    }
    public void setGoodsname(String goodsname) 
    {
        this.goodsname = goodsname;
    }

    public String getGoodsname() 
    {
        return goodsname;
    }
    public void setGoodskind(String goodskind) 
    {
        this.goodskind = goodskind;
    }

    public String getGoodskind() 
    {
        return goodskind;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }
    public void setApplydate(Date applydate) 
    {
        this.applydate = applydate;
    }

    public Date getApplydate() 
    {
        return applydate;
    }
    public void setApplyreason(String applyreason) 
    {
        this.applyreason = applyreason;
    }

    public String getApplyreason() 
    {
        return applyreason;
    }
    public void setAccount(String account) 
    {
        this.account = account;
    }

    public String getAccount() 
    {
        return account;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setIsexamine(String isexamine) 
    {
        this.isexamine = isexamine;
    }

    public String getIsexamine() 
    {
        return isexamine;
    }
    public void setExamreply(String examreply) 
    {
        this.examreply = examreply;
    }

    public String getExamreply() 
    {
        return examreply;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("addtime", getAddtime())
            .append("applyno", getApplyno())
            .append("goodsname", getGoodsname())
            .append("goodskind", getGoodskind())
            .append("number", getNumber())
            .append("applydate", getApplydate())
            .append("applyreason", getApplyreason())
            .append("account", getAccount())
            .append("name", getName())
            .append("isexamine", getIsexamine())
            .append("examreply", getExamreply())
            .toString();
    }
}
