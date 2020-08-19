package cn.com.sqqmall.integrals.sdk;

public class IntegralsAddNotifyParams {
    private String app_key;//接口appKey，应用的唯一标识
    private String uid;//用户唯一性标识，对应唯一一个用户且不可变
    private String integrals;//本次兑换扣除的积分,比如”12.88”
    private String type;//checkin(签到), lucky(大转盘),scan_code(扫码奖励)所有类型不区分大小写
    private String event_num;//神雀订单号(请记录到数据库中)
    private String timestamp;//1970-01-01开始的时间戳，毫秒为单位。
    private String desc;//本次积分消耗的描述(带中文，请用utf-8进行url解码)
    private String ip;//用户ip，不保证获取到(下期)
    private String sign;//允许购买商品操作类型， append 附加 add 删除上一次在加

    public void setApp_key(String app_key){
        this.app_key = app_key;
    }
    public void setUid(String uid){
        this.uid = uid;
    }
    public void setIntegrals(String integrals){
        this.integrals = integrals;
    }

    public void setType(String type){
        this.type = type;
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
    public void setIp(String ip){
        this.ip = ip;
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
        return  integrals;
    }
    public String getType(){
        return type;
    }
    public String getEvent_num(){
        return event_num;
    }

    public String getTimestamp(){
        return  timestamp;
    }

    public String getDesc(){
        return desc;
    }

    public String getIp(){
        return ip;
    }

    public String getSign(){
        return sign;
    }
}
