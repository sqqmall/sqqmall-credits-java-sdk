package cn.com.sqqmall.integrals.sdk;

import java.util.Map;

public class IntegralsConsumeResult {
    private String biz_id;//开发者的订单号(唯一且不重复，如果失败情况，该值可以不传)
    private String integrals;//用户积分余额
    private String frozen_integrals;//用户冻结积分
    private String total_price;//订单总金额
    private String goods_price;//商品总金额
    private String freight;//运费
    private String comsume_integrals;//消耗积分
    private String send_integrals;//赠送积分
    private static final String SUCCESS = "ok";
    private static final String FAIL = "fail";
    private String error_msg = "";//错误说明
    private Map<String,String> result;

    /**
     * 结果拼接上code和可能的msg
     * @param success
     * @param result
     */
    public void setResult(boolean success,Map<String,String> result){
        if(success){
            result.put("code",SUCCESS);
            result.put("msg",SUCCESS);
        }else{
            result.put("code",FAIL);
        }
        this.result = result;
    }

    public Map<String,String> getResult(){
        return result;
    }

    public void setBiz_id(String biz_id){
        this.biz_id = biz_id;
    }

    public void setIntegrals(String integrals){
        this.integrals = integrals;
    }

    public void setFrozen_integrals(String frozen_integrals){
        this.frozen_integrals = frozen_integrals;
    }


    public void setTotal_price(String total_price){
        this.total_price = total_price;
    }

    public void setGoods_price(String goods_price){
        this.goods_price = goods_price;
    }

    public void setFreight(String freight){
        this.freight = freight;
    }

    public void setComsume_integrals(String comsume_integrals){
        this.comsume_integrals = comsume_integrals;
    }

    public void setSend_integrals(String send_integrals){
        this.send_integrals = send_integrals;
    }

    public String getBiz_id(){
        return biz_id;
    }

    public String getIntegrals(){
        return integrals;
    }

    public String getFrozen_integrals(){
        return frozen_integrals;
    }

    public String getTotal_price(){
        return total_price;
    }

    public String getGoods_price(){
        return goods_price;
    }

    public String getFreight(){
        return freight;
    }

    public String getComsume_integrals(){
        return comsume_integrals;
    }

    public String getSend_integrals(){
        return send_integrals;
    }
}
