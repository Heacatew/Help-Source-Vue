package cn.source.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.source.common.annotation.Excel;
import cn.source.common.core.domain.BaseEntity;

/**
 * 互助信息详情对象 help_task
 * 
 * @author zjx
 * @date 2023-04-12
 */
public class HelpTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 0互助/1助人 */
    @Excel(name = "类型",readConverterExp="0=互助,1=助人")
    private Integer type;


    /** 0物资,1人力 */
    @Excel(name = "助人类型",readConverterExp="0=物资,1=人力")
    private Integer roomType;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 0：待审核，1：待出租,2:已出租,3:已下架 */
    // @Excel(name = "状态",readConverterExp="0=待审核,1=待出租,2=已出租,3=已下架")
    private Integer state;

    /** 描述 */
    @Excel(name = "描述")
    private String introduce;

    /** 联系人姓名 */
    @Excel(name = "联系人姓名")
    private String ownerName;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String owerPhone;

    /** 小区id */
    @Excel(name = "小区id")
    private Long villageId;

    /** 小区名称 */
    @Excel(name = "小区名称")
    private String villageName;

    /** 小区城市 */
    private String villageCity;

    /** 详细地址，小区楼栋 */
    @Excel(name = "详细地址")
    private String address;

    /** 房牌号 */
    @Excel(name = "房牌号")
    private String houseNo;

    // @Excel(name = "房源代号")
    private String code;

    /** 发布人id */
    @Excel(name = "发布人id")
    private Long publishId;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createName;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updateName;

    /**  */
    private String houseHall;


    /** 封面图路径 */
    @Excel(name = "封面图路径")
    private String faceUrl;

    /** 代理人姓名 */
    @Excel(name = "代理人姓名")
    private String agentName;

    /** 代理人电话 */
    @Excel(name = "代理人电话")
    private String agentPhone;

    /** 代理人id */
    @Excel(name = "代理人id")
    private Long agentUserId;

    /** 代理人头像 */
    @Excel(name = "代理人头像")
    private String agentAvatar;


    private List<HelpImage> imageList;

    private List<HelpFeature> featureList;

    private HelpVillage village;

    /** 接收房源亮点查询条件  */
    private String feature;

    /** 是否点赞,true为点赞了  */
    private boolean heart;

    /** 精度  */
    private String longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private String latitude;

    /** 互助标题 */
    @Excel(name = "互助标题")
    private String asktitle;

    /** 求助类型 */
    @Excel(name = "求助类型")
    private Long asktype;


    /** 付款方式 */
    private String payType;

    /** 房间号 */
    private String roomCode;

    /** 房屋面积 */
    private Long roomArea;

    /** 朝向 */
    private String direction;

    @Excel(name = "装修")
    private String decoration;

    /** 租金 */
    @Excel(name = "租金")
    private BigDecimal price;
    /** 居室 */
    private String houseNum;

    /** 卫生间 */
    private String toiletNum;

    // @Excel(name = "户型")
    private String houseCode;

    /** 整套面积 */
    @Excel(name = "整套面积")
    private BigDecimal houseArea;

    /** 楼层 */
    private String floor;

    /** 楼房类型 */
    private String stepType;

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }


    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setHouseNum(String houseNum) 
    {
        this.houseNum = houseNum;
    }

    public String getHouseNum() 
    {
        return houseNum;
    }
    public void setToiletNum(String toiletNum) 
    {
        this.toiletNum = toiletNum;
    }

    public String getToiletNum() 
    {
        return toiletNum;
    }
    public void setHouseArea(BigDecimal houseArea) 
    {
        this.houseArea = houseArea;
    }

    public BigDecimal getHouseArea() 
    {
        return houseArea;
    }
    public void setRoomType(Integer roomType) 
    {
        this.roomType = roomType;
    }

    public Integer getRoomType() 
    {
        return roomType;
    }
    public void setRoomCode(String roomCode) 
    {
        this.roomCode = roomCode;
    }

    public String getRoomCode() 
    {
        return roomCode;
    }
    public void setRoomArea(Long roomArea) 
    {
        this.roomArea = roomArea;
    }

    public Long getRoomArea() 
    {
        return roomArea;
    }
    public void setDirection(String direction) 
    {
        this.direction = direction;
    }

    public String getDirection() 
    {
        return direction;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public List<HelpImage> getImageList() {
        return imageList;
    }

    public void setImageList(List<HelpImage> imageList) {
        this.imageList = imageList;
    }

    public List<HelpFeature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<HelpFeature> featureList) {
        this.featureList = featureList;
    }

    public void setFloor(String floor)
    {
        this.floor = floor;
    }

    public String getFloor() 
    {
        return floor;
    }
    public void setStepType(String stepType) 
    {
        this.stepType = stepType;
    }

    public String getStepType() 
    {
        return stepType;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setIntroduce(String introduce) 
    {
        this.introduce = introduce;
    }

    public String getIntroduce() 
    {
        return introduce;
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
    public void setVillageId(Long villageId) 
    {
        this.villageId = villageId;
    }

    public void setVillage(HelpVillage village) {
        this.village = village;
    }
    public HelpVillage getVillage() {
        return village;
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
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setHouseNo(String houseNo) 
    {
        this.houseNo = houseNo;
    }

    public String getHouseNo() 
    {
        return houseNo;
    }
    public void setPayType(String payType) 
    {
        this.payType = payType;
    }

    public String getPayType() 
    {
        return payType;
    }
    public void setPublishId(Long publishId) 
    {
        this.publishId = publishId;
    }

    public Long getPublishId() 
    {
        return publishId;
    }
    public void setState(Integer state) 
    {
        this.state = state;
    }

    public Integer getState() 
    {
        return state;
    }
    public void setCreateName(String createName) 
    {
        this.createName = createName;
    }

    public String getCreateName() 
    {
        return createName;
    }
    public void setUpdateName(String updateName) 
    {
        this.updateName = updateName;
    }

    public String getUpdateName() 
    {
        return updateName;
    }
    public void setHouseHall(String houseHall) 
    {
        this.houseHall = houseHall;
    }

    public String getHouseHall() 
    {
        return houseHall;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setFaceUrl(String faceUrl) 
    {
        this.faceUrl = faceUrl;
    }

    public String getFaceUrl() 
    {
        return faceUrl;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public String getDecoration() 
    {
        return decoration;
    }
    public void setAgentName(String agentName) 
    {
        this.agentName = agentName;
    }

    public String getAgentName() 
    {
        return agentName;
    }
    public void setAgentPhone(String agentPhone) 
    {
        this.agentPhone = agentPhone;
    }

    public String getAgentPhone() 
    {
        return agentPhone;
    }
    public void setAgentUserId(Long agentUserId) 
    {
        this.agentUserId = agentUserId;
    }

    public Long getAgentUserId() 
    {
        return agentUserId;
    }
    public void setAgentAvatar(String agentAvatar) 
    {
        this.agentAvatar = agentAvatar;
    }

    public String getAgentAvatar() 
    {
        return agentAvatar;
    }

    public String getVillageCity() {
        return villageCity;
    }

    public void setVillageCity(String villageCity) {
        this.villageCity = villageCity;
    }

    public boolean isHeart() {
        return heart;
    }

    public void setHeart(boolean heart) {
        this.heart = heart;
    }

    public void setLongitude(String longitude) {
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
    public void setAsktitle(String asktitle) 
    {
        this.asktitle = asktitle;
    }

    public String getAsktitle() 
    {
        return asktitle;
    }
    public void setAsktype(Long asktype) 
    {
        this.asktype = asktype;
    }

    public Long getAsktype() 
    {
        return asktype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("houseNum", getHouseNum())
            .append("toiletNum", getToiletNum())
            .append("houseArea", getHouseArea())
            .append("roomType", getRoomType())
            .append("roomCode", getRoomCode())
            .append("roomArea", getRoomArea())
            .append("direction", getDirection())
            .append("price", getPrice())
            .append("floor", getFloor())
            .append("stepType", getStepType())
            .append("startDate", getStartDate())
            .append("introduce", getIntroduce())
            .append("ownerName", getOwnerName())
            .append("owerPhone", getOwerPhone())
            .append("villageId", getVillageId())
            .append("villageName", getVillageName())
            .append("address", getAddress())
            .append("houseNo", getHouseNo())
            .append("payType", getPayType())
            .append("publishId", getPublishId())
            .append("state", getState())
            .append("createTime", getCreateTime())
            .append("createName", getCreateName())
            .append("updateTime", getUpdateTime())
            .append("updateName", getUpdateName())
            .append("remark", getRemark())
            .append("houseHall", getHouseHall())
            .append("code", getCode())
            .append("faceUrl", getFaceUrl())
            .append("decoration", getDecoration())
            .append("agentName", getAgentName())
            .append("agentPhone", getAgentPhone())
            .append("agentUserId", getAgentUserId())
            .append("agentAvatar", getAgentAvatar())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("asktitle", getAsktitle())
            .append("asktype", getAsktype())
                .append("villageCity", getVillageCity())
            .toString();
    }
}
