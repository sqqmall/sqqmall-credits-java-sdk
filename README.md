# sqqmall-credits-java-sdk
积分开放平台开发包
import cn.com.sqqmall.credits.sdk.*;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "MyServlet", urlPatterns = { "/my" })
public class MyServlet implements Servlet{
    private String api_url = "https://test-open-integral-api.sqqmall.com";
    private transient ServletConfig servletConfig;
    private DoPost doPost = new DoPost();
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html; charset=utf-8");
        PrintWriter writer = servletResponse.getWriter();
        try {
            String result = storeExists(servletRequest);
            writer.println(result);
        } catch (Exception e) {
            writer.println(e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    /**
     * 免登录地址接口
     * @param request
     * @return
     * @throws Exception
     */
    private String autoLogin(ServletRequest request) throws Exception {
        String uri = "/api/v1/users/auto-login";
        String app_key = "fdsm_2020";
        String app_secret = "";//密钥参与加签，但是不在请求中传递
        CreditTool creditTool = new CreditTool(app_key,app_secret);
        AutoLoginParams params = creditTool.parseAutoLoginParams((HttpServletRequest) request);
        Map<String,String> map = new HashMap<String, String>();
        map.put("uid",params.getUid());
        map.put("timestamp",params.getTimestamp());
        map.put("sign",params.getSign());
        map.put("app_key",params.getApp_key());
        String param = JSON.toJSONString(map);
        String result = doPost.sendPost(api_url,param);
        return result;
    }

    /**
     * 扣减积分
     * @param request
     * @return
     * @throws Exception
     */
    private String creditDeduct(ServletRequest request) throws Exception {
        String uri = "/api/v1/integrals/sub";
        String app_key = "zzappkey2020";
        String app_secret = "";/密钥参与加签，但是不在请求中传递
        CreditTool creditTool = new CreditTool(app_key,app_secret);
        CreditDeductParams creditDeductParams = creditTool.parseCreditDeductParams((HttpServletRequest) request);
        Map<String,String> map = new HashMap<String, String>();
        map.put("uid",creditDeductParams.getUid());
        map.put("timestamp",creditDeductParams.getTimestamp());
        map.put("sign",creditDeductParams.getSign());
        map.put("integrals",creditDeductParams.getIntegrals());
        map.put("phone",creditDeductParams.getPhone());
        map.put("event_num",creditDeductParams.getEvent_num());
        map.put("app_key",creditDeductParams.getApp_key());
        if(request.getParameter("desc")!=null){
            map.put("desc",creditDeductParams.getDesc());
        }
        String param = JSON.toJSONString(map);
        System.out.println(param);
        String url_ = api_url+uri;
        String result = doPost.sendPost(url_,param);
        return result;
    }

    /**
     * 用户注册接口
     * @param request
     * @return
     * @throws Exception
     */
    private String userReg(ServletRequest request) throws Exception {
        String uri = "/api/v1/users/reg";
        String app_key = "zzappkey2020";
        String app_secret = "";/密钥参与加签，但是不在请求中传递
        CreditTool creditTool = new CreditTool(app_key,app_secret);
        UserRegParams userRegParams = creditTool.parseUserRegParams((HttpServletRequest) request);
        Map<String,String> map = new HashMap<String, String>();
        map.put("app_key",userRegParams.getApp_key());
        map.put("uid",userRegParams.getUid());
        map.put("phone",userRegParams.getPhone());
        map.put("timestamp",userRegParams.getTimestamp());
        map.put("sign",userRegParams.getSign());
        String param = JSON.toJSONString(map);
        System.out.println(param);
        String url_ = api_url+uri;
        String result = doPost.sendPost(url_,param);
        return result;
    }

    private String userWhiteList(ServletRequest request) throws Exception {
        String uri = "/api/v1/users/white-list";
        String app_key = "zzappkey2020";
        String app_secret = "";/密钥参与加签，但是不在请求中传递
        CreditTool creditTool = new CreditTool(app_key,app_secret);
        UserWhiteListParams userWhiteListParams = creditTool.parseUserWhiteListParams((HttpServletRequest) request);
        Map<String,String> map = new HashMap<String, String>();
        map.put("app_key",userWhiteListParams.getApp_key());
        map.put("uid",userWhiteListParams.getUid());
        map.put("phone",userWhiteListParams.getPhone());
        map.put("timestamp",userWhiteListParams.getTimestamp());
        map.put("sign",userWhiteListParams.getSign());
        map.put("type",String.valueOf(userWhiteListParams.getType()));
        String param = JSON.toJSONString(map);
        System.out.println(param);
        String url_ = api_url+uri;
        String result = doPost.sendPost(url_,param);
        return result;
    }

    /**
     * 增加积分
     * @param request
     * @return
     * @throws Exception
     */
    private String creditAdd(ServletRequest request) throws Exception {
        String uri = "/api/v1/integrals/add";
        String app_key = "zzappkey2020";
        String app_secret = "";/密钥参与加签，但是不在请求中传递
        CreditTool creditTool = new CreditTool(app_key,app_secret);
        CreditAddParams creditAddParams = creditTool.parseCreditAddParams((HttpServletRequest) request);
        Map<String,String> map = new HashMap<String, String>();
        map.put("uid",creditAddParams.getUid());
        map.put("timestamp",creditAddParams.getTimestamp());
        map.put("sign",creditAddParams.getSign());
        map.put("integrals",creditAddParams.getIntegrals());
        map.put("phone",creditAddParams.getPhone());
        map.put("event_num",creditAddParams.getEvent_num());
        map.put("app_key",creditAddParams.getApp_key());
        if(request.getParameter("desc")!=null){
            map.put("desc",creditAddParams.getDesc());
        }
        String param = JSON.toJSONString(map);
        System.out.println(param);
        String url_ = api_url+uri;
        String result = doPost.sendPost(url_,param);
        return result;
    }

    /**
     * 积分查询
     * @param request
     * @return
     * @throws Exception
     */
    private String creditQuery(ServletRequest request) throws Exception {
        String uri = "/api/v1/integrals/query";
        String app_key = "zzappkey2020";
        String app_secret = "";/密钥参与加签，但是不在请求中传递
        CreditTool creditTool = new CreditTool(app_key,app_secret);
        CreditQueryParams creditQueryParams = creditTool.parseCreditQueryParams((HttpServletRequest) request);
        Map<String,String> map = new HashMap<String, String>();
        map.put("app_key",creditQueryParams.getApp_key());
        map.put("uid",creditQueryParams.getUid());
        map.put("sign",creditQueryParams.getSign());
        String param = "?app_key="+creditQueryParams.getApp_key()+"&uid="+creditQueryParams.getUid()+"&sign="+creditQueryParams.getSign();
        String url_ = api_url+uri+param;
        String result = doPost.sendGet(url_);
        return result;
    }

    /**
     * 检查店铺是否存在
     * @param request
     * @return
     * @throws Exception
     */
    private String storeExists(ServletRequest request) throws Exception {
        String uri = "/api/v1/stores/exist";
        String app_key = "zzappkey2020";
        String app_secret = "";/密钥参与加签，但是不在请求中传递
        CreditTool creditTool = new CreditTool(app_key,app_secret);
        StoreExistsParams storeExistsParams = creditTool.parseStoreExistsParams((HttpServletRequest) request);
        Map<String,String> map = new HashMap<String, String>();
        map.put("app_key",storeExistsParams.getApp_key());
        map.put("store_id",storeExistsParams.getStore_id().toString());
        map.put("sign",storeExistsParams.getSign());
        String param = "?app_key="+storeExistsParams.getApp_key()+"&store_id="+storeExistsParams.getStore_id()+"&sign="+storeExistsParams.getSign();
        String url_ = api_url+uri+param;
        String result = doPost.sendGet(url_);
        return result;
    }
}
