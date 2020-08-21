package cn.com.sqqmall.integrals.sdk;

public class StoreProducts {
        private String pro_id;
        private String pro_name;
        private String price;
        private int count;
        private String send_integrals;
        public void setPro_id(String pro_id) {
            this.pro_id = pro_id;
        }
        public String getPro_id() {
            return pro_id;
        }

        public void setPro_name(String pro_name) {
            this.pro_name = pro_name;
        }
        public String getPro_name() {
            return pro_name;
        }

        public void setPrice(String price) {
            this.price = price;
        }
        public String getPrice() {
            return price;
        }

        public void setCount(int count) {
            this.count = count;
        }
        public int getCount() {
            return count;
        }

        public void setSend_integrals(String send_integrals) {
            this.send_integrals = send_integrals;
        }
        public String getSend_integrals() {
            return send_integrals;
        }
}
