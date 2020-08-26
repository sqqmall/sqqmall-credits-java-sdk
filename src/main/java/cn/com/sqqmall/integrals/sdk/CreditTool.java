package cn.com.sqqmall.integrals.sdk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
     * 通用检查项
     * @param request
     * @throws Exception
     */
    public void checkAppKeyObject(JSONObject request) throws Exception {
        if(!app_key.equals(request.getString("app_key"))){
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

    /**
     * 结果通知
     * @param request
     * @return
     * @throws Exception
     */
    public IntegralsNotifyParams parseIntegralsNotifyParams_bak(HttpServletRequest request) throws Exception {
        checkAppKey(request);
        if(request.getParameter("uid") == null){
            throw new Exception("uid为必填项");
        }
        if(request.getParameter("success") == null){
            throw new Exception("success为必填项");
        }
        if(request.getParameter("event_num") == null){
            throw new Exception("event_num为必填项");
        }
        if(request.getParameter("timestamp") == null){
            throw new Exception("timestamp为必填项");
        }
        boolean verify = SignTool.verifySignedString(app_secret,request);
        if(!verify){
            throw new Exception("签名验证失败");
        }
        IntegralsNotifyParams integralsNotifyParams = new IntegralsNotifyParams();
        integralsNotifyParams.setApp_key(request.getParameter("app_key"));
        integralsNotifyParams.setUid(request.getParameter("uid"));
        integralsNotifyParams.setUid(request.getParameter("success"));
        integralsNotifyParams.setUid(request.getParameter("event_num"));
        integralsNotifyParams.setUid(request.getParameter("timestamp"));
        integralsNotifyParams.setUid(request.getParameter("sign"));
        if(request.getParameter("integrals")!=null){
            integralsNotifyParams.setIntegrals(request.getParameter("integrals"));
        }
        if(request.getParameter("send_integrals")!=null){
            integralsNotifyParams.setSend_integrals(request.getParameter("send_integrals"));
        }
        if(request.getParameter("pay_money")!=null){
            integralsNotifyParams.setPay_money(request.getParameter("pay_money"));
        }
        if(request.getParameter("biz_id")!=null){
            integralsNotifyParams.setBiz_id(request.getParameter("biz_id"));
        }
        if(request.getParameter("error_msg")!=null){
            integralsNotifyParams.setError_msg(request.getParameter("error_msg"));
        }
        return  integralsNotifyParams;
    }




    /**
     * 结果通知
     * @param request
     * @return
     * @throws Exception
     */
    public IntegralsNotifyParams parseIntegralsNotifyParams(JSONObject request) throws Exception {
        checkAppKeyObject(request);
        if(request.getString("uid") == null){
            throw new Exception("uid为必填项");
        }
        if(request.getString("success") == null){
            throw new Exception("success为必填项");
        }
        if(request.getString("event_num") == null){
            throw new Exception("event_num为必填项");
        }
        if(request.getString("timestamp") == null){
            throw new Exception("timestamp为必填项");
        }
        boolean verify = SignToolJSONObject.verifySignedString(app_secret,request);
        if(!verify){
            throw new Exception("签名验证失败");
        }
        IntegralsNotifyParams integralsNotifyParams = new IntegralsNotifyParams();
        integralsNotifyParams.setApp_key(request.getString("app_key"));
        integralsNotifyParams.setUid(request.getString("uid"));
        integralsNotifyParams.setUid(request.getString("success"));
        integralsNotifyParams.setUid(request.getString("event_num"));
        integralsNotifyParams.setUid(request.getString("timestamp"));
        integralsNotifyParams.setUid(request.getString("sign"));
        if(request.getString("integrals")!=null){
            integralsNotifyParams.setIntegrals(request.getString("integrals"));
        }
        if(request.getString("send_integrals")!=null){
            integralsNotifyParams.setSend_integrals(request.getString("send_integrals"));
        }
        if(request.getString("pay_money")!=null){
            integralsNotifyParams.setPay_money(request.getString("pay_money"));
        }
        if(request.getString("biz_id")!=null){
            integralsNotifyParams.setBiz_id(request.getString("biz_id"));
        }
        if(request.getString("error_msg")!=null){
            integralsNotifyParams.setError_msg(request.getString("error_msg"));
        }
        return  integralsNotifyParams;
    }



    public IntegralsAddNotifyParams parseIntegralsAddNotifyParams(JSONObject request) throws Exception {
        checkAppKeyObject(request);
        if(request.getString("uid") == null){
            throw new Exception("uid为必填项");
        }
        if(request.getString("integrals") == null){
            throw new Exception("integrals为必填项");
        }
        if(request.getString("type") == null){
            throw new Exception("type为必填项");
        }

        if(request.getString("timestamp") == null){
            throw new Exception("timestamp为必填项");
        }

        if(request.getString("event_num") == null){
            throw new Exception("event_num为必填项");
        }
        //验签
        boolean verify = SignToolJSONObject.verifySignedString(app_secret,request);
        if(!verify){
            throw new Exception("签名验证失败");
        }
        IntegralsAddNotifyParams integralsAddNotifyParams = new IntegralsAddNotifyParams();
        if(request.getString("desc") != null){
            integralsAddNotifyParams.setDesc(request.getString("desc"));
        }
        if(request.getString("ip") != null){
            integralsAddNotifyParams.setIp(request.getString("ip"));
        }
        return integralsAddNotifyParams;
    }

    //商品信息变动数据验证
    public IntegralsProductShelfParams parseIntegralsProductShelfParams(JSONObject request) throws Exception {
        checkAppKeyObject(request);
        if(request.getString("type") == null){
            throw new Exception("type为必填项");
        }
        if(request.getString("product") == null){
            throw new Exception("product为必填项");
        }
        //验签
        boolean verify = SignToolJSONObject.verifySignedString(app_secret,request);
        if(!verify){
            throw new Exception("签名验证失败");
        }
        IntegralsProductShelfParams integralsProductShelfParams = new IntegralsProductShelfParams();
        integralsProductShelfParams.setApp_key(request.getString("app_key"));
        integralsProductShelfParams.setType(request.getString("type"));
        JSONObject product = JSON.parseObject(request.getString("product"));
        IntegralsProductParams productParams;
        productParams = parseIntegralsProductParams(product);
        integralsProductShelfParams.setProduct(productParams);

        integralsProductShelfParams.setSign(request.getString("sign"));
        return integralsProductShelfParams;
    }

    public IntegralsProductParams parseIntegralsProductParams(JSONObject request) throws Exception {
        if(request.getString("pro_id") == null){
            throw new Exception("pro_id为必填项");
        }
        if(request.getString("pro_code") == null){
            throw new Exception("pro_code为必填项");
        }
        if(request.getString("pro_name") == null){
            throw new Exception("pro_name为必填项");
        }
        if(request.getString("pic") == null){
            throw new Exception("pic为必填项");
        }
        if(request.getString("price") == null){
            throw new Exception("price为必填项");
        }
        if(request.getString("send_integrals") == null){
            throw new Exception("send_integrals为必填项");
        }
        if(request.getString("quantity") == null){
            throw new Exception("quantity为必填项");
        }
        if(request.getString("minnum_order_quantity") == null){
            throw new Exception("minnum_order_quantity为必填项");
        }
        if(request.getString("maxnum_order_quantity_one_day") == null){
            throw new Exception("maxnum_order_quantity_one_day为必填项");
        }
        if(request.getString("maxnum_order_quantity_duration") == null){
            throw new Exception("maxnum_order_quantity_duration为必填项");
        }
        if(request.getString("sku") == null){
            throw new Exception("sku为必填项");
        }
        IntegralsProductParams productParams = new IntegralsProductParams();
        productParams.setPro_id(request.getString("pro_id"));
        productParams.setPro_code(request.getString("pro_code"));
        productParams.setPro_name(request.getString("pro_name"));
        productParams.setPic(request.getString("pic"));
        productParams.setPrice(request.getString("price"));
        productParams.setSend_integrals(request.getString("send_integrals"));
        productParams.setQuantity(request.getString("quantity"));
        productParams.setMinnum_order_quantity(request.getString("minnum_order_quantity"));
        productParams.setMaxnum_order_quantity_one_day(request.getString("maxnum_order_quantity_one_day"));
        IntegralsProductInfoTimeParams timeParams;
        JSONObject time = JSON.parseObject(request.getString("maxnum_order_quantity_duration"));
        timeParams = parseIntegralsProductInfoTimeParams(time);
        productParams.setMaxnum_order_quantity_duration(timeParams);
        List<IntegralsProductInfoSKUParams> skuParams = new ArrayList<IntegralsProductInfoSKUParams>();
        JSONArray sku = JSON.parseArray(request.getString("sku"));
        for (int i=0;i<sku.size();i++){
            JSONObject skus = JSON.parseObject(sku.get(i).toString());
            IntegralsProductInfoSKUParams skuParam = parseIntegralsProductInfoSKUParams(skus);
            skuParams.add(skuParam);
        }
        productParams.setSku(skuParams);
        return productParams;
    }

    public IntegralsProductInfoTimeParams parseIntegralsProductInfoTimeParams(JSONObject request) throws Exception {
        if(request.getString("start_time") == null){
            throw new Exception("start_time为必填项");
        }
        if(request.getString("end_time") == null){
            throw new Exception("end_time为必填项");
        }
        if(request.getString("maxnum_order_quantity") == null){
            throw new Exception("maxnum_order_quantity为必填项");
        }
        IntegralsProductInfoTimeParams productInfoTimeParams = new IntegralsProductInfoTimeParams();
        productInfoTimeParams.setStart_time(request.getString("start_time"));
        productInfoTimeParams.setEnd_time(request.getString("end_time"));
        productInfoTimeParams.setMaxnum_order_quantity(request.getString("maxnum_order_quantity"));
        return productInfoTimeParams;
    }

    public IntegralsProductInfoSKUParams parseIntegralsProductInfoSKUParams(JSONObject request) throws Exception {
        if(request.getString("sku_id") == null){
            throw new Exception("sku_id为必填项");
        }
        if(request.getString("price") == null){
            throw new Exception("price为必填项");
        }
        if(request.getString("pic") == null){
            throw new Exception("pic为必填项");
        }
        IntegralsProductInfoSKUParams productInfoSKUParams = new IntegralsProductInfoSKUParams();
        productInfoSKUParams.setSku_id(request.getString("sku_id"));
        productInfoSKUParams.setPic(request.getString("pic"));
        productInfoSKUParams.setPrice(request.getString("price"));
        return productInfoSKUParams;
    }

    /**
     * 查询积分
     * @param request
     * @return
     * @throws Exception
     */
    public IntegralsQueryNotifyParams parseIntegralsQueryNotifyParams_bak(JSONObject request) throws Exception {
        checkAppKeyObject(request);

        if(request.getString("uid") == null){
            throw new Exception("uid为必填项");
        }

        boolean verify = SignToolJSONObject.verifySignedString(app_secret,request);

        if(!verify){
            throw new Exception("签名验证失败");
        }

        IntegralsQueryNotifyParams integralsQueryNotifyParams = new IntegralsQueryNotifyParams();
        integralsQueryNotifyParams.setApp_key(request.getString("app_key"));
        integralsQueryNotifyParams.setUid(request.getString("uid"));
        integralsQueryNotifyParams.setUid(request.getString("sign"));
        return integralsQueryNotifyParams;
    }

    /**
     * 查询积分
     * @param request
     * @return
     * @throws Exception
     */
    public IntegralsQueryNotifyParams parseIntegralsQueryNotifyParams(HttpServletRequest request) throws Exception {
        checkAppKey(request);
        if(request.getParameter("uid") == null){
            throw new Exception("uid为必填项");
        }
        boolean verify = SignTool.verifySignedString(app_secret,request);
        if(!verify){
            throw new Exception("签名验证失败");
        }
        IntegralsQueryNotifyParams integralsQueryNotifyParams = new IntegralsQueryNotifyParams();
        integralsQueryNotifyParams.setApp_key(request.getParameter("app_key"));
        integralsQueryNotifyParams.setUid(request.getParameter("uid"));
        integralsQueryNotifyParams.setUid(request.getParameter("sign"));
        return integralsQueryNotifyParams;
    }

    /**
     * 扣积分接口 通知
     * @param request
     * @return
     * @throws Exception
     */
    public IntegralsConsumeParams parseIntegralsConsumeParams(JSONObject request) throws Exception {
        checkAppKeyObject(request);
        if(request.getString("uid") == null){
            throw new Exception("uid为必填项");
        }
        if(request.getString("integrals") == null){
            throw new Exception("integrals为必填项");
        }
        if(request.getString("timestamp") == null){
            throw new Exception("timestamp为必填项");
        }
        if(request.getString("desc") == null){
            throw new Exception("desc为必填项");
        }
        if(request.getString("type") == null){
            throw new Exception("type为必填项");
        }
        if(request.getString("event_num") == null){
            throw new Exception("event_num为必填项");
        }

        boolean verify = SignToolJSONObject.verifySignedString(app_secret,request);

        if(!verify){
            throw new Exception("签名验证失败");
        }

        IntegralsConsumeParams integralsConsumeParams = new IntegralsConsumeParams();
        integralsConsumeParams.setApp_key(request.getString("app_key"));
        integralsConsumeParams.setUid(request.getString("uid"));
        integralsConsumeParams.setIntegrals(request.getString("integrals"));
        integralsConsumeParams.setTimestamp(request.getString("timestamp"));
        integralsConsumeParams.setDesc(request.getString("desc"));
        integralsConsumeParams.setEvent_num(request.getString("event_num"));
        integralsConsumeParams.setType(request.getString("type"));
        integralsConsumeParams.setSign(request.getString("sign"));
        if(request.getString("face_price")!=null){
            integralsConsumeParams.setFace_price(request.getString("face_price"));
        }
        if(request.getString("actual_price")!=null){
            integralsConsumeParams.setActual_price(request.getString("actual_price"));
        }
        if(request.getString("ip")!=null){
            integralsConsumeParams.setIp(request.getString("ip"));
        }
        if(request.getString("params")!=null){
            ConsumeParams params = new ConsumeParams();
            JSONObject products = JSON.parseObject(request.getString("params"));
            params = parseConsumeParams(products);
            integralsConsumeParams.setParams(params);
        }
        return integralsConsumeParams;
    }

    public ConsumeParams parseConsumeParams(JSONObject request) throws Exception {
        if(request.getString("store_name") == null){
            throw new Exception("store_name为必填项");
        }
        if(request.getString("total_price") == null){
            throw new Exception("total_price为必填项");
        }
        if(request.getString("goods_price") == null){
            throw new Exception("goods_price为必填项");
        }
        /*if(request.getString("total_send_integrals") == null){
            throw new Exception("total_send_integrals为必填项");
        }*/
        if(request.getString("freight") == null){
            throw new Exception("freight为必填项");
        }
        if(request.getString("receiver_name") == null){
            throw new Exception("receiver_name为必填项");
        }
        if(request.getString("receiver_phone") == null){
            throw new Exception("receiver_phone为必填项");
        }
        if(request.getString("receiver_province") == null){
            throw new Exception("receiver_province为必填项");
        }
        if(request.getString("receiver_city") == null){
            throw new Exception("receiver_city为必填项");
        }
        if(request.getString("receiver_area") == null){
            throw new Exception("receiver_area为必填项");
        }
        if(request.getString("receiver_address") == null){
            throw new Exception("receiver_address为必填项");
        }
        if(request.getString("products") == null){
            throw new Exception("products为必填项");
        }
        ConsumeParams params = new ConsumeParams();
        params.setStore_name(request.getString("store_name"));
        params.setTotal_price(request.getString("total_price"));
        params.setGoods_price(request.getString("goods_price"));
        params.setTotal_send_integrals(request.getString("total_send_integrals"));
        params.setFreight(request.getString("freight"));
        params.setReceiver_name(request.getString("receiver_name"));
        params.setReceiver_phone(request.getString("receiver_phone"));
        params.setReceiver_province(request.getString("receiver_province"));
        params.setReceiver_city(request.getString("receiver_city"));
        params.setReceiver_area(request.getString("receiver_area"));
        params.setReceiver_address(request.getString("receiver_address"));

        List<StoreProducts> storeProducts = new ArrayList<StoreProducts>();
        JSONArray products = JSON.parseArray(request.getString("products"));
        for (int i=0;i<products.size();i++){
            JSONObject pro = JSON.parseObject(products.get(i).toString());
            StoreProducts storeProduct = parseStoreProducts(pro);
            storeProducts.add(storeProduct);
        }
        params.setProducts(storeProducts);

        return params;
    }

    public StoreProducts parseStoreProducts(JSONObject request) throws Exception {
        if(request.getString("pro_id") == null){
            throw new Exception("pro_id为必填项");
        }
        if(request.getString("pro_name") == null){
            throw new Exception("pro_name为必填项");
        }
        if(request.getString("price") == null){
            throw new Exception("price为必填项");
        }
        if(request.getString("count") == null){
            throw new Exception("count为必填项");
        }
        if(request.getString("send_integrals") == null){
            throw new Exception("send_integrals为必填项");
        }
        StoreProducts storeProducts = new StoreProducts();
        storeProducts.setPro_id(request.getString("pro_id"));
        storeProducts.setPro_name(request.getString("pro_name"));
        storeProducts.setPrice(request.getString("price"));
        storeProducts.setCount(Integer.valueOf(request.getString("count")));
        storeProducts.setSend_integrals(request.getString("send_integrals"));
        return  storeProducts;
    }
}
