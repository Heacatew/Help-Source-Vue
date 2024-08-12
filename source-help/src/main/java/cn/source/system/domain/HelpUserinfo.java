package cn.source.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.source.common.annotation.Excel;
import cn.source.common.core.domain.BaseEntity;

/**
 * 互助用户常用信息对象 help_userinfo
 * 
 * @author zjx
 * @date 2023-04-18
 */
public class HelpUserinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 联系人姓名 */
    @Excel(name = "联系人姓名")
    private String ownerName;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String owerPhone;

    /** 经度 */
    @Excel(name = "经度")
    private String longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private String latitude;

    /** 小区id */
    @Excel(name = "小区id")
    private Long villageId;

    /** 小区名称 */
    @Excel(name = "小区名称")
    private String villageName;

    /** 类型 */
    @Excel(name = "类型")
    private Integer askType;

    /** 保留类型 */
    private String stepType;

    /** 备注 */
    @Excel(name = "备注")
    private String backup;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setOwnerName(String ownerName) 
    {
        this.ownerName = ownerName;
    }

    public String getOwnerName() 
    {
        return ownerName;
    }
    public void setOwerPhone(String owerPhone) 
    {
        this.owerPhone = owerPhone;
    }

    public String getOwerPhone() 
    {
        return owerPhone;
    }
    public void setLongitude(String longitude) 
    {
        this.longitude = longitude;
    }

    public String getLongitude() 
    {
        return longitude;
    }
    public void setLatitude(String latitude) 
    {
        this.latitude = latitude;
    }

    public String getLatitude() 
    {
        return latitude;
    }
    public void setVillageId(Long villageId) 
    {
        this.villageId = villageId;
    }

    public Long getVillageId() 
    {
        return villageId;
    }
    public void setVillageName(String villageName) 
    {
        this.villageName = villageName;
    }

    public String getVillageName() 
    {
        return villageName;
    }
    public void setAskType(Integer askType) 
    {
        this.askType = askType;
    }

    public Integer getAskType() 
    {
        return askType;
    }
    public void setStepType(String stepType) 
    {
        this.stepType = stepType;
    }

    public String getStepType() 
    {
        return stepType;
    }
    public void setBackup(String backup) 
    {
        this.backup = backup;
    }

    public String getBackup() 
    {
        return backup;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("address", getAddress())
            .append("ownerName", getOwnerName())
            .append("owerPhone", getOwerPhone())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("villageId", getVillageId())
            .append("villageName", getVillageName())
            .append("askType", getAskType())
            .append("stepType", getStepType())
            .append("backup", getBackup())
            .toString();
    }
}
