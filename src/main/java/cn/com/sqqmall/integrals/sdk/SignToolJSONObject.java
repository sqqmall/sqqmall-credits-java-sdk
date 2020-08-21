package cn.com.sqqmall.integrals.sdk;

import com.alibaba.fastjson.JSONObject;

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
                    req_params.put(key, params.get(key).toString());
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

    /**
     * 获取加签字符串
     * @param string
     * @return
     * @throws Exception
     */
    public static String getMD5SignedString(String string) throws Exception {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(string.getBytes());
            return new BigInteger(1,md.digest()).toString(16);
        }catch (Exception e){
            throw new Exception("MD5加密出错!");
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
        String user_signed_string = req.get("sign").toString();//获取用户加签字符串
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

}
