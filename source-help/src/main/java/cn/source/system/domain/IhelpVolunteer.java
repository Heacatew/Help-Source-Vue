package cn.source.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.source.common.annotation.Excel;
import cn.source.common.core.domain.BaseEntity;

/**
 * 志愿者对象 ihelp_volunteer
 * 
 * @author zjx
 * @date 2023-04-20
 */
public class IhelpVolunteer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 创建时间 */
    private Date addtime;

    /** 志愿账号 */
    @Excel(name = "志愿账号")
    private String volunacc;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 志愿姓名 */
    @Excel(name = "志愿姓名")
    private String volunname;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long year;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 手机 */
    @Excel(name = "手机")
    private String phone;

    /** 照片 */
    @Excel(name = "照片")
    private String picture;

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
    public void setVolunacc(String volunacc) 
    {
        this.volunacc = volunacc;
    }

    public String getVolunacc() 
    {
        return volunacc;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setVolunname(String volunname) 
    {
        this.volunname = volunname;
    }

    public String getVolunname() 
    {
        return volunname;
    }
    public void setYear(Long year) 
    {
        this.year = year;
    }

    public Long getYear() 
    {
        return year;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("addtime", getAddtime())
            .append("volunacc", getVolunacc())
            .append("password", getPassword())
            .append("volunname", getVolunname())
            .append("year", getYear())
            .append("gender", getGender())
            .append("phone", getPhone())
            .append("picture", getPicture())
            .toString();
    }
}
