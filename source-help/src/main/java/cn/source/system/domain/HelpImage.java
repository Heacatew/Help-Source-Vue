package cn.source.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.source.common.annotation.Excel;
import cn.source.common.core.domain.BaseEntity;

/**
 * 互助信息图片对象 help_image
 * 
 * @author zjx
 * @date 2023-04-18
 */
public class HelpImage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 图片id */
    private Long helpId;

    /** 图片名称 */
    @Excel(name = "图片名称")
    private String imageName;

    /** 相对路径 */
    @Excel(name = "相对路径")
    private String imagePath;

    /** 绝对路径 */
    @Excel(name = "绝对路径")
    private String imgUrl;

    /** 图片大小 */
    @Excel(name = "图片大小")
    private BigDecimal imageSize;

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
    public void setImageName(String imageName) 
    {
        this.imageName = imageName;
    }

    public String getImageName() 
    {
        return imageName;
    }
    public void setImagePath(String imagePath) 
    {
        this.imagePath = imagePath;
    }

    public String getImagePath() 
    {
        return imagePath;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }
    public void setImageSize(BigDecimal imageSize) 
    {
        this.imageSize = imageSize;
    }

    public BigDecimal getImageSize() 
    {
        return imageSize;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("helpId", getHelpId())
            .append("imageName", getImageName())
            .append("imagePath", getImagePath())
            .append("imgUrl", getImgUrl())
            .append("imageSize", getImageSize())
            .toString();
    }
}
