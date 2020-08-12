package cn.com.sqqmall.credits.sdk;

public class CreditAddParams {
    private String app_key; //接口app_key，应用的唯一标识
    private String uid;//用户标识，唯一且不可变
    private String integrals;//本次扣减的积分,例如“10.28”
    private String phone;//手机号
    private String event_num;//增加积分事件编号，不同业务类型建议自行定义前缀，比如线下订单消费积分：Order-102020102001，防止重复
    private String timestamp;//1970-01-01开始的时间戳，毫秒为单位。
    private String desc;//本次增加积分的描述(带中文，请用utf-8进行url解码)
    private String sign;//MD5签名
    public void setApp_key(String app_key){
        this.app_key = app_key;
    }

    public void setUid(String uid){
        this.uid = uid;
    }

    public void setIntegrals(String integrals){
        this.integrals = integrals;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setEvent_num(String event_num){
        this.event_num = event_num;
    }

    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
    }

    public void setDesc(String desc){
        this.desc = desc;
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

    public String getIntegrals(){
        return integrals;
    }


    public String getPhone(){
        return phone;
    }

    public String getEvent_num(){
        return event_num;
    }

    public String getTimestamp(){
        return timestamp;
    }

    public String getDesc(){
        return desc;
    }

    public String getSign(){
        return sign;
    }
}
