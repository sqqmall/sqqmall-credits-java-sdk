package cn.com.sqqmall.integrals.sdk;

public class IntegralsProductShelfParams {
    private String app_key;
    private String type;
    private IntegralsProductParams product;
    private String sign;

    public void setApp_key(String app_key){
        this.app_key = app_key;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setProduct(IntegralsProductParams integralsProductParams){
        this.product = integralsProductParams;
    }
    public void setSign(String sign){
        this.sign = sign;
    }
    public String getApp_key(){
        return app_key;
    }
    public String getType(){
        return type;
    }
    public IntegralsProductParams getProduct(){
        return product;
    }
    public String getSign(){
        return sign;
    }
}
