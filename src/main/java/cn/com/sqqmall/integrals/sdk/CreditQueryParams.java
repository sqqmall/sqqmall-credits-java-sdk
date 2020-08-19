package cn.com.sqqmall.integrals.sdk;

public class CreditQueryParams {
    private String app_key; //接口app_key，应用的唯一标识
    private String uid;//用户标识，唯一且不可变
    private String sign;//MD5签名
    public void setApp_key(String app_key){
        this.app_key = app_key;
    }
    public void setUid(String uid){
        this.uid = uid;
    }
    public void setSign(String sign){
        this.sign = sign;
    }
    public String getApp_key(){
        return app_key;
    }
    public String getUid(){
        return uid;
    }
    public String getSign(){
        return sign;
    }
}
