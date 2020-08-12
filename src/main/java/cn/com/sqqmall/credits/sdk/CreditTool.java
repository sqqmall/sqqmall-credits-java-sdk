package cn.com.sqqmall.credits.sdk;

import javax.servlet.http.HttpServletRequest;

public class CreditTool {
    private String app_key;
    private String app_secret;

    public CreditTool(String app_key, String app_secret) {
        this.app_key = app_key;
        this.app_secret = app_secret;
    }

    /**
     * 通用检查项
     * @param request
     * @throws Exception
     */
    public void checkAppKey(HttpServletRequest request) throws Exception {
        if(!app_key.equals(request.getParameter("app_key"))){
            throw new Exception("app_key不匹配");
        }
    }

    /**
     * 免登录url获取接口参数校验
     * @param request
     * @return
     * @throws Exception
     */
    public AutoLoginParams parseAutoLoginParams(HttpServletRequest request) throws Exception {
        checkAppKey(request);

        if(request.getParameter("timestamp") == null){
            throw new Exception("timestamp为必填项");
        }
        if(request.getParameter("uid") == null){
            throw new Exception("uid为必填项");
        }
        boolean verify = SignTool.verifySignedString(app_secret,request);
        if(!verify){
            throw new Exception("签名验证失败");
        }
        AutoLoginParams params = new AutoLoginParams();
        params.setApp_key(request.getParameter("app_key"));
        params.setSign(request.getParameter("sign"));
        params.setUid(request.getParameter("uid"));
        params.setTimestamp(request.getParameter("timestamp"));
        //非必填项如果用户传了也需要
        if(request.getParameter("integrals")!=null){
            params.setIntegrals(Float.parseFloat(request.getParameter("integrals")));
        }
        if(request.getParameter("phone")!=null){
            params.setPhone(request.getParameter("phone"));
        }
        if(request.getParameter("redirect_url")!=null){
            params.setRedirect_url(request.getParameter("redirect_url"));
        }
        if(request.getParameter("allow_buy_product_ids")!=null){
            params.setAllow_buy_product_ids(request.getParameter("allow_buy_product_ids"));
        }
        if(request.getParameter("allow_buy_op_method")!=null){
            params.setAllow_buy_op_method(request.getParameter("allow_buy_op_method"));
        }
        if(request.getParameter("company_info")!=null){
            params.setCompany_info(request.getParameter("company_info"));
        }
        return params;
    }

    public CreditDeductParams parseCreditDeductParams(HttpServletRequest request) throws Exception {
        checkAppKey(request);
        if(request.getParameter("timestamp") == null){
            throw new Exception("timestamp为必填项");
        }
        if(request.getParameter("uid") == null){
            throw new Exception("uid为必填项");
        }
        if(request.getParameter("integrals") == null){
            throw new Exception("integrals为必填项");
        }
        if(request.getParameter("phone") == null){
            throw new Exception("phone为必填项");
        }
        if(request.getParameter("event_num") == null){
            throw new Exception("event_num为必填项");
        }

        boolean verify = SignTool.verifySignedString(app_secret,request);
        if(!verify){
            throw new Exception("签名验证失败");
        }

        CreditDeductParams creditDeductParams = new CreditDeductParams();
        creditDeductParams.setApp_key(request.getParameter("app_key"));
        creditDeductParams.setIntegrals(request.getParameter("integrals"));
        creditDeductParams.setPhone(request.getParameter("phone"));
        creditDeductParams.setUid(request.getParameter("uid"));
        creditDeductParams.setTimestamp(request.getParameter("timestamp"));
        creditDeductParams.setEvent_num(request.getParameter("event_num"));
        creditDeductParams.setSign(request.getParameter("sign"));
        if(request.getParameter("desc")!=null){
            creditDeductParams.setDesc(request.getParameter("desc"));
        }
        return creditDeductParams;
    }

    public UserRegParams parseUserRegParams(HttpServletRequest request) throws Exception {
        checkAppKey(request);
        if(request.getParameter("uid") == null){
            throw new Exception("uid为必填项");
        }
        if(request.getParameter("phone") == null){
            throw new Exception("phone为必填项");
        }
        if(request.getParameter("timestamp") == null){
            throw new Exception("timestamp为必填项");
        }
        boolean verify = SignTool.verifySignedString(app_secret,request);
        if(!verify){
            throw new Exception("签名验证失败");
        }
        UserRegParams userRegParams = new UserRegParams();
        userRegParams.setApp_key(request.getParameter("app_key"));
        userRegParams.setPhone(request.getParameter("phone"));
        userRegParams.setUid(request.getParameter("uid"));
        userRegParams.setSign(request.getParameter("sign"));
        userRegParams.setTimestamp(request.getParameter("timestamp"));
        return userRegParams;
    }

    public UserWhiteListParams parseUserWhiteListParams(HttpServletRequest request) throws Exception {
        checkAppKey(request);
        if(request.getParameter("type") == null){
            throw new Exception("type为必填项");
        }
        if(request.getParameter("uid") == null){
            throw new Exception("uid为必填项");
        }
        if(request.getParameter("phone") == null){
            throw new Exception("phone为必填项");
        }
        if(request.getParameter("timestamp") == null){
            throw new Exception("timestamp为必填项");
        }
        boolean verify = SignTool.verifySignedString(app_secret,request);
        if(!verify){
            throw new Exception("签名验证失败");
        }
        UserWhiteListParams userWhiteListParams = new UserWhiteListParams();
        userWhiteListParams.setApp_key(request.getParameter("app_key"));
        userWhiteListParams.setPhone(request.getParameter("phone"));
        userWhiteListParams.setUid(request.getParameter("uid"));
        userWhiteListParams.setSign(request.getParameter("sign"));
        userWhiteListParams.setTimestamp(request.getParameter("timestamp"));
        userWhiteListParams.setType(Integer.parseInt(request.getParameter("type")));
        return userWhiteListParams;
    }

    public CreditAddParams parseCreditAddParams(HttpServletRequest request) throws Exception {
        checkAppKey(request);
        if(request.getParameter("timestamp") == null){
            throw new Exception("timestamp为必填项");
        }
        if(request.getParameter("uid") == null){
            throw new Exception("uid为必填项");
        }
        if(request.getParameter("integrals") == null){
            throw new Exception("integrals为必填项");
        }
        if(request.getParameter("phone") == null){
            throw new Exception("phone为必填项");
        }
        if(request.getParameter("event_num") == null){
            throw new Exception("event_num为必填项");
        }
        boolean verify = SignTool.verifySignedString(app_secret,request);
        if(!verify){
            throw new Exception("签名验证失败");
        }
        CreditAddParams creditAddParams = new CreditAddParams();
        creditAddParams.setApp_key(request.getParameter("app_key"));
        creditAddParams.setIntegrals(request.getParameter("integrals"));
        creditAddParams.setPhone(request.getParameter("phone"));
        creditAddParams.setUid(request.getParameter("uid"));
        creditAddParams.setTimestamp(request.getParameter("timestamp"));
        creditAddParams.setEvent_num(request.getParameter("event_num"));
        creditAddParams.setSign(request.getParameter("sign"));
        if(request.getParameter("desc")!=null){
            creditAddParams.setDesc(request.getParameter("desc"));
        }
        return creditAddParams;
    }

    public CreditQueryParams parseCreditQueryParams(HttpServletRequest request) throws Exception {
        checkAppKey(request);
        if(request.getParameter("uid") == null){
            throw new Exception("uid为必填项");
        }
        boolean verify = SignTool.verifySignedString(app_secret,request);
        if(!verify){
            throw new Exception("签名验证失败");
        }
        CreditQueryParams creditQueryParams = new CreditQueryParams();
        creditQueryParams.setApp_key(request.getParameter("app_key"));
        creditQueryParams.setUid(request.getParameter("uid"));
        creditQueryParams.setSign(request.getParameter("sign"));
        return creditQueryParams;
    }

    public StoreExistsParams parseStoreExistsParams(HttpServletRequest request) throws Exception {
        checkAppKey(request);
        if(request.getParameter("store_id") == null){
            throw new Exception("store_id为必填项");
        }
        boolean verify = SignTool.verifySignedString(app_secret,request);
        if(!verify){
            throw new Exception("签名验证失败");
        }
        StoreExistsParams storeExistsParams = new StoreExistsParams();
        storeExistsParams.setApp_key(request.getParameter("app_key"));
        storeExistsParams.setStore_id(Integer.valueOf(request.getParameter("store_id")));
        storeExistsParams.setSign(request.getParameter("sign"));
        return storeExistsParams;
    }

}
