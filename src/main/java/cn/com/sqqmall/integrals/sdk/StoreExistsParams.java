package cn.com.sqqmall.integrals.sdk;

public class StoreExistsParams {
    private String app_key; //接口app_key，应用的唯一标识
    private Integer store_id;//店铺编号
    private String sign;//MD5签名
    public void setApp_key(String app_key){
        this.app_key = app_key;
    }
    public void setStore_id(Integer store_id){
        this.store_id = store_id;
    }
    public void setSign(String sign){
        this.sign = sign;
    }
    public String getApp_key(){
        return app_key;
    }
    public String getSign(){
        return sign;
    }
    public Integer getStore_id(){
        return store_id;
    }
}
