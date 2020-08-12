package cn.com.sqqmall.credits.sdk;

public class AutoLoginParams {
    private String uid;//用户唯一性标识，对应唯一一个用户且不可变 （用not_login作为uid标记游客用户（下期））
    private float integrals;//用户积分余额（无积分体系独立活动，积分可以传0）(下期)
    private String app_key;//接口appKey，应用的唯一标识
    private String timestamp;//1970-01-01开始的时间戳，毫秒为单位。
    private String phone;//用户手机号
    private String redirect_url;//登录成功后的重定向地址（需要进行urlencode编码），可以直达积分商城内的任意页面,如果不带redirect参数，默认跳转到积分商城首页
    private String sign;//MD5签名
    private String allow_buy_product_ids;//允许购买商品权限编号串，多个id以英文逗号隔开
    private String allow_buy_op_method;//允许购买商品操作类型， append 附加 add 删除上一次在加
    private String company_info;//公司信息，包含公司唯一代码，具体看传参示例

    //必填 uid app_key timestamp sign
    public void setUid(String uid){
        this.uid = uid;
    }

    public void setApp_key(String app_key){
        this.app_key = app_key;
    }

    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
    }

    public void setSign(String sign){
        this.sign = sign;
    }

    public String getUid(){
        return uid;
    }

    public String getApp_key(){
        return app_key;
    }

    public String getTimestamp(){
        return timestamp;
    }

    public String getSign(){
        return sign;
    }

    public float getIntegrals(){return integrals;}
    public void setIntegrals(float integrals){
        this.integrals = integrals;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
    }
    public void setRedirect_url(String redirect_url){
        this.redirect_url = redirect_url;
    }
    public String getRedirect_url(){
        return redirect_url;
    }
    public void setAllow_buy_product_ids(String allow_buy_product_ids){
        this.allow_buy_product_ids = allow_buy_product_ids;
    }
    public String getAllow_buy_product_ids(){
        return allow_buy_product_ids;
    }
    public void setAllow_buy_op_method(String allow_buy_op_method){
        this.allow_buy_op_method = allow_buy_op_method;
    }
    public String getAllow_buy_op_method(){
        return allow_buy_op_method;
    }
    public void setCompany_info(String company_info){
        this.company_info = company_info;
    }
    public String getCompany_info(){
        return company_info;
    }
}
