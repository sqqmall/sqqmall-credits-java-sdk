package cn.com.sqqmall.integrals.sdk;

import java.util.Map;

public class IntegralsProductParams {
    private String pro_id;
    private String pro_code;
    private String pro_name;
    private String pic;
    private String price;
    private String send_integrals;
    private String quantity;
    private String minnum_order_quantity;
    private String maxnum_order_quantity_one_day;
    private IntegralsProductInfoTimeParams maxnum_order_quantity_duration;
    private Map<String, IntegralsProductInfoSKUParams[]> sku;

    public void setPro_id(String pro_id){
        this.pro_id = pro_id;
    }
    public void setPro_code(String pro_code){
        this.pro_code = pro_code;
    }
    public void setPro_name(String pro_name){
        this.pro_name = pro_name;
    }
    public void setPic(String pic){
        this.pic = pic;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public void setSend_integrals(String send_integrals){
        this.send_integrals = send_integrals;
    }
    public void setQuantity(String quantity){
        this.quantity = quantity;
    }
    public void setMinnum_order_quantity(String minnum_order_quantity){
        this.minnum_order_quantity = minnum_order_quantity;
    }
    public void setMaxnum_order_quantity_one_day(String maxnum_order_quantity_one_day){
        this.maxnum_order_quantity_one_day = maxnum_order_quantity_one_day;
    }
    public void setMaxnum_order_quantity_duration(IntegralsProductInfoTimeParams maxnum_order_quantity_duration){
        this.maxnum_order_quantity_duration = maxnum_order_quantity_duration;
    }
    public void setSku(IntegralsProductInfoSKUParams integralsProductInfoSKUParams){
        this.sku = (Map<String, IntegralsProductInfoSKUParams[]>) integralsProductInfoSKUParams;
    }

    public String getPro_id(){
        return pro_id;
    }
    public String getPro_code(){
        return pro_code;
    }
    public String getPro_name(){
        return pro_name;
    }
    public String getPic(){
        return pic;
    }
    public String getPrice(){
        return price;
    }
    public String getSend_integrals(){
        return send_integrals;
    }
    public String getQuantity(){
        return quantity;
    }
    public String getMinnum_order_quantity(){
        return minnum_order_quantity;
    }
    public String getMaxnum_order_quantity_one_day(){
        return maxnum_order_quantity_one_day;
    }
    public IntegralsProductInfoTimeParams getMaxnum_order_quantity_duration(){
        return maxnum_order_quantity_duration;
    }

    public Map<String, IntegralsProductInfoSKUParams[]> getSku() {
        return sku;
    }
}
