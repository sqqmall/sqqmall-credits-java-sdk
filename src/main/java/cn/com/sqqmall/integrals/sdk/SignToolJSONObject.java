package cn.com.sqqmall.integrals.sdk;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Map;
import java.util.TreeMap;

public class SignToolJSONObject {
    /**
     * 获取有序加签数据
     * @param app_secret
     * @param params
     * @return
     */
    public static Map<String,String> getMapToString(String app_secret, JSONObject params){
        //请求数据降维
        Map<String,String> req_params = new TreeMap<String, String>();//数据有序
        //遍历请求参数
        for(String key:params.keySet()){
            if(!key.equals("sign")){
                                   req_params.put(key,
                        trimFirstAndLastChar(JSONObject.toJSONString(params.get(key),
                        SerializerFeature.WriteMapNullValue),"\""));
            }
        }
        //app_secret 添加
        req_params.put("app_secret",app_secret);
        return req_params;
    }

    /**
     * 参与加签的字符串
     * @param all_params
     * @return
     */
    public static String stringToSign(Map<String, String> all_params){
        String to_sign_string = "";
        for(String key:all_params.keySet()){
            to_sign_string += all_params.get(key);
        }
        return to_sign_string;
    }

    public static String getMD5SignedString(String sourceStr){
        try {
            // 获得MD5摘要算法的 MessageDigest对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(sourceStr.getBytes("utf-8"));
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                int tmp = md[i];
                if (tmp < 0)
                    tmp += 256;
                if (tmp < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(tmp));
            }
            return buf.toString();// 32位加密
        } catch (Exception e) {
            throw new RuntimeException("没有md5这个算法！");
        }
    }

    /**
     * 验签
     * @param app_secret
     * @param req
     * @return
     * @throws Exception
     */
    public static Boolean verifySignedString(String app_secret,JSONObject req) throws Exception {
        Map<String,String> all_params = getMapToString(app_secret,req);
        String string_to_sign = stringToSign(all_params);
        System.out.println(string_to_sign);
        String signed_str = getMD5SignedString(string_to_sign);
        System.out.println(signed_str);
        String user_signed_string = req.get("sign").toString();//获取用户加签字符串
        System.out.println(user_signed_string);
        if(signed_str==null){
            throw new Exception("本地加签字符串不能为空!");
        }else if(user_signed_string==null){
            throw new Exception("用户加签字符串不能为空!");
        }else if(!signed_str.equals(user_signed_string)){
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * 去除首尾指定字符
     * @param str   字符串
     * @param element   指定字符
     * @return
     */
    public static String trimFirstAndLastChar(String str, String element){
        boolean beginIndexFlag = true;
        boolean endIndexFlag = true;
        do{
            int beginIndex = str.indexOf(element) == 0 ? 1 : 0;
            int endIndex = str.lastIndexOf(element) + 1 == str.length() ? str.lastIndexOf(element) : str.length();
            str = str.substring(beginIndex, endIndex);
            beginIndexFlag = (str.indexOf(element) == 0);
            endIndexFlag = (str.lastIndexOf(element) + 1 == str.length());
        } while (beginIndexFlag || endIndexFlag);
        return str;
    }

}
