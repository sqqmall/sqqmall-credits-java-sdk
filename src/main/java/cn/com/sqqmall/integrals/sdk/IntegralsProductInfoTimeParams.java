package cn.com.sqqmall.integrals.sdk;

public class IntegralsProductInfoTimeParams {
    private String start_time;
    private String end_time;
    private String maxnum_order_quantity;

    public void setStart_time(String start_time){
        this.start_time = start_time;
    }

    public void setEnd_time(String end_time){
        this.end_time = end_time;
    }

    public void setMaxnum_order_quantity(String maxnum_order_quantity){
        this.maxnum_order_quantity = maxnum_order_quantity;
    }

    public String getStart_time(){
        return start_time;
    }

    public String getEnd_time(){
        return end_time;
    }

    public String getMaxnum_order_quantity(){
        return maxnum_order_quantity;
    }
}
