package cn.com.sqqmall.integrals.sdk;

public class IntegralsNotifyParams {
    private String app_key;//接口appKey，应用的唯一标识
    private String uid;//用户唯一性标识，对应唯一一个用户且不可变
    private String integrals;//本次兑换扣除的积分,比如”12.88”
    private String send_integrals;//赠送积分,比如”12.88”
    private String pay_money;//支付金额
    private String success;//兑换是否成功，true为成功，false为失败
    private String event_num;//神雀订单号(请记录到数据库中)
    private String biz_id;//开发者订单号(请记录到数据库中)
    private String timestamp;//1970-01-01开始的时间戳，毫秒为单位。
    private String error_msg;//出错原因(带中文，请用utf-8进行url解码)
    private String sign;

    public void setApp_key(String app_key){
        this.app_key = app_key;
    }
    public void setUid(String uid){
        this.uid = uid;
    }
    public void setIntegrals(String integrals){
        this.integrals = integrals;
    }
    public void setSend_integrals(String send_integrals){
        this.send_integrals = send_integrals;
    }
    public void setPay_money(String pay_money){
        this.pay_money = pay_money;
    }
    public void setSuccess(String success){
        this.success = success;
    }
    public void setEvent_num(String event_num){
        this.event_num = event_num;
    }
    public void setBiz_id(String biz_id){
        this.biz_id = biz_id;
    }
    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
    }
    public void setError_msg(String error_msg){
        this.error_msg = error_msg;
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
    public String getSend_integrals(){
        return send_integrals;
    }
    public String getPay_money(){
        return pay_money;
    }
    public String getSuccess(){
        return success;
    }
    public String getEvent_num(){
        return event_num;
    }
    public String getBiz_id(){
        return biz_id;
    }
    public String getTimestamp(){
        return timestamp;
    }
    public String getError_msg(){
        return error_msg;
    }
    public String getSign(){
        return sign;
    }
}
