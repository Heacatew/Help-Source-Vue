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
//    public static boolean sendSms(String phone, JSONObject paramJson,String accessKeyId
//            ,String accessKeySecret,String accessKeytemplate){
//        boolean result = true;
//        String url = "http://api.sms.cn/sms";
//        try {
//            String str = HttpUtils.sendPost(url,
//                    "ac=send&uid=" +accessKeyId+
//                            "&pwd=" +accessKeySecret+
//                            "&template=" +accessKeytemplate+
//                            "&mobile="+phone+"&content="+paramJson);
//            logger.info("短信接口返回的数据----------------"+str);
//        }catch (Exception e){
//            result = true;
//            logger.info("短信接口返回异常----------------"+e.getMessage());
//        }
//        return result;
//    }
    //腾讯云短信平台
    public static boolean sendSms(String phone, JSONObject paramJson,String accessKeyId
            ,String accessKeySecret,String accessKeytemplate){
        boolean result = true;
        String url = "sms.tencentcloudapi.com";
        try {
            //实例化一个Credential，也就是认证对象，参数是密钥对；你要使用肯定要进行认证
            Credential credential = new Credential("AKIDxkIZaK2UfYAVaOvBAtLWQ42oMfiW4MOA", "XpsfCTVHo58vSjkV0GG1WlkV0GH3artf");
            //HttpProfile这是http的配置文件操作，比如设置请求类型(post,get)或者设置超时时间了、还有指定域名了
            HttpProfile httpProfile = new HttpProfile();
            //这个setEndpoint可以省略的
            httpProfile.setEndpoint(url);
            //实例化一个客户端配置对象,这个配置可以进行签名（使用私钥进行加密的过程），对方可以利用公钥进行解密
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            //实例化要请求产品(以sms为例)的client对象
            SmsClient smsClient = new SmsClient(credential, "ap-beijing", clientProfile);
            //实例化request封装请求信息
            SendSmsRequest request = new SendSmsRequest();
            String[] phoneNumber = {"+86"+phone};
            request.setPhoneNumberSet(phoneNumber);     //设置手机号
            request.setSmsSdkAppid("1400643913");
            request.setSign("野生地瓜公众号");
            request.setTemplateID("1762220");
            String verificationCode = paramJson.get("code").toString();
            String[] templateParamSet = {verificationCode};
            request.setTemplateParamSet(templateParamSet);
            //发送短信
            SendSmsResponse response = smsClient.SendSms(request);
            logger.info(SendSmsResponse.toJsonString(response));

        }catch (Exception e){
            result = false;
            logger.info("短信接口返回异常----------------"+e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("code", "1234");
        sendSms("19953642212", obj,null,null,null);
    }
}
