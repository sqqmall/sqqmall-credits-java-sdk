package cn.com.sqqmall.integrals.sdk;

import java.util.Map;

public class IntegralsQureyNotifyResult {
    private String frozen_integrals;//冻结积分
    private String integrals;//积分余额
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
        }else if(result.get("integrals")==null){
            throw  new Exception("积分余额是必须响应的数据项");
        }else if(result.get("frozen_integrals")==null){
            throw  new Exception("冻结积分是必须响应的数据项");
        }else{
            return result;
        }
    }

    public void setFrozen_integrals(String frozen_integrals){
        this.frozen_integrals = frozen_integrals;
    }

    public String getFrozen_integrals(){
        return frozen_integrals;
    }

    public void setIntegrals(String integrals){
        this.integrals = integrals;
    }
    public String getIntegrals(){
        return integrals;
    }
}
