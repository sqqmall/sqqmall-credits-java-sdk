package cn.com.sqqmall.integrals.sdk;

public class UserWhiteListParams {
    private String app_key;
    private String uid;
    private String phone;
    private int type;//增加白名单 1 移除白名单 2
    private String timestamp;
    private String sign;

    public void setApp_key(String app_key){
        this.app_key = app_key;
    }

    public void setUid(String uid){
        this.uid = uid;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
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

    public String getPhone(){
        return phone;
    }

    public String getTimestamp(){
        return timestamp;
    }

    public String getSign(){
        return sign;
    }

    public void setType(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }
}
