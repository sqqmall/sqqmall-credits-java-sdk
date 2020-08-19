package cn.com.sqqmall.integrals.sdk;

import java.util.Map;

public class IntegralsNotifyResult {
    private String biz_id;//开发者的订单号(唯一且不重复，如果失败情况，该值可以不传)
    private String integrals;//用户积分余额
    private String frozen_integrals;//用户冻结积分
    private Map<String,String> result;
    private static final String SUCCESS = "ok";
    private static final String FAIL = "fail";
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
    public String getBiz_id(){
        return biz_id;
    }

    public String getIntegrals(){
        return integrals;
    }

    public String getFrozen_integrals(){
        return frozen_integrals;
    }
}
