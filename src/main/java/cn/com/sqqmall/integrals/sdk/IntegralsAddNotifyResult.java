package cn.com.sqqmall.integrals.sdk;

import java.util.Map;

public class IntegralsAddNotifyResult {
    private String biz_id;//开发者的订单号(唯一且不重复，如果失败情况，该值可以不传)
    private String integrals;//用户积分余额
    private Map<String,String> result;
    private static final String SUCCESS = "ok";
    private static final String FAIL = "fail";
    public void setResult(boolean success,Map<String,String> result){
        if(success){
            result.put("code",SUCCESS);
            result.put("msg",SUCCESS);
        }else{
            result.put("code",FAIL);
        }
        this.result = result;
    }
    public Map<String,String> getResult() throws Exception {
        if(result.get("code")==null){
            throw  new Exception("结果状态是必须响应的数据项");
        }else if(result.get("biz_id")==null){
            throw  new Exception("开发者订单号是必须响应的数据项");
        }else if(result.get("integrals")==null){
            throw  new Exception("用户积分余额是必须响应的数据项");
        }else{
            return result;
        }
    }
    public void setBiz_id(String biz_id){
        this.biz_id = biz_id;
    }
    public void setIntegrals(String integrals){
        this.integrals = integrals;
    }
    public String getBiz_id(){
        return biz_id;
    }
    public String getIntegrals(){
        return integrals;
    }
}
