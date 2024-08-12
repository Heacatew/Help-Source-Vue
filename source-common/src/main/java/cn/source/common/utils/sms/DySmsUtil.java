package cn.source.common.utils.sms;

import com.alibaba.fastjson2.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;


import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;

/**
 * @Description: 云信短信接口
 * @author: zy
 * @date: 2021年03月30日 11:43
 */

public class DySmsUtil {

    private final static Logger logger= LoggerFactory.getLogger(DySmsUtil.class);
      //sms短信平台

//    }
    //腾讯云短信平台
    public static boolean sendSms(String phone, JSONObject paramJson,String accessKeyId
            ,String accessKeySecret,String accessKeytemplate){
        boolean result = true;
        try {

        }catch (Exception e){
            result = false;
            logger.info("短信接口返回异常----------------"+e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("co1de", "1");
        sendSms("1", obj,null,null,null);
    }
}
