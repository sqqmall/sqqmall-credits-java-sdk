package cn.com.sqqmall.integrals.sdk;

public class IntegralsProductInfoSKUParams {
    private String sku_id;
    private String price;
    private String pic;
    public void setSku_id(String sku_id){
        this.sku_id = sku_id;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public void setPic(String pic){
        this.pic = pic;
    }
    public String getSku_id(){
        return sku_id;
    }
    public String getPrice(){
        return price;
    }
    public String getPic(){
        return pic;
    }
}
