package cn.source.system.enums;

/**
 * 操作人类别
 *
 * @author 詹Sir
 */
public enum HelpStatus
    {
        AUDIT(0, "待审核") , SALEING(1, "未完成"), SALEED(2, "已完成"), CLOSE(3, "已取消");
        private final Integer code;
        private final String info;

        HelpStatus(Integer code, String info)
        {
            this.code = code;
            this.info = info;
        }

        public Integer getCode()
        {
            return code;
        }

        public String getInfo()
        {
            return info;
        }
    }
