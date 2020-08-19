package cn.com.sqqmall.integrals.sdk;

public class IntegralsQueryNotifyParams {
    private String app_key;//接口appKey，应用的唯一标识
    private String uid;//用户唯一性标识，对应唯一一个用户且不可变
    private String sign;

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
