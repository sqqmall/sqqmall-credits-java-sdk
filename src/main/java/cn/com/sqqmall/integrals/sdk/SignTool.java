package cn.com.sqqmall.integrals.sdk;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Map;
import java.util.TreeMap;

public class SignTool {
    /**
     * 获取有序加签数据
     * @param request
     * @return
     */
    public static Map<String,String> getMapToString(String app_secret, HttpServletRequest request){
        //获取请求参数
        Map<String,String[]> params = request.getParameterMap();
        //请求数据降维
        Map<String,String> req_params = new TreeMap<String, String>();//数据有序
        //遍历请求参数
        for(String key:params.keySet()){
            if(!key.equals("sign")){
                req_params.put(key, params.get(key)[0]);
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
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(sourceStr.getBytes("utf-8"));
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
            return buf.toString();
        } catch (Exception e) {
            throw new RuntimeException("没有md5这个算法！");
        }
    }

    /**
     * 验签
     * @param app_secret
     * @param request
     * @return
     * @throws Exception
     */
    public static Boolean verifySignedString(String app_secret,HttpServletRequest request) throws Exception {
        Map<String,String> all_params = getMapToString(app_secret,request);
        String string_to_sign = stringToSign(all_params);
        System.out.println(string_to_sign);
        String signed_str = getMD5SignedString(string_to_sign);
        String user_signed_string = request.getParameter("sign");//获取用户加签字符串
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
