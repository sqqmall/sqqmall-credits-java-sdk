package cn.com.sqqmall.integrals.sdk;

import java.util.List;

public class ConsumeParams {
        private String store_name;
        private String total_price;
        private String goods_price;
        private String total_send_integrals;
        private String freight;
        private List<StoreProducts> products;
        private String receiver_name;
        private String receiver_phone;
        private String receiver_province;
        private String receiver_city;
        private String receiver_area;
        private String receiver_address;
        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }
        public String getStore_name() {
            return store_name;
        }

        public void setTotal_price(String total_price) {
            this.total_price = total_price;
        }
        public String getTotal_price() {
            return total_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }
        public String getGoods_price() {
            return goods_price;
        }

        public void setTotal_send_integrals(String total_send_integrals) {
            this.total_send_integrals = total_send_integrals;
        }
        public String getTotal_send_integrals() {
            return total_send_integrals;
        }

        public void setFreight(String freight) {
            this.freight = freight;
        }
        public String getFreight() {
            return freight;
        }

        public void setProducts(List<StoreProducts> products) {
            this.products = products;
        }
        public List<StoreProducts> getProducts() {
            return products;
        }

        public void setReceiver_name(String receiver_name) {
            this.receiver_name = receiver_name;
        }
        public String getReceiver_name() {
            return receiver_name;
        }

        public void setReceiver_phone(String receiver_phone) {
            this.receiver_phone = receiver_phone;
        }
        public String getReceiver_phone() {
            return receiver_phone;
        }

        public void setReceiver_province(String receiver_province) {
            this.receiver_province = receiver_province;
        }
        public String getReceiver_province() {
            return receiver_province;
        }

        public void setReceiver_city(String receiver_city) {
            this.receiver_city = receiver_city;
        }
        public String getReceiver_city() {
            return receiver_city;
        }

        public void setReceiver_area(String receiver_area) {
            this.receiver_area = receiver_area;
        }
        public String getReceiver_area() {
            return receiver_area;
        }
        public void setReceiver_address(String receiver_address) {
            this.receiver_address = receiver_address;
        }
        public String getReceiver_address() {
            return receiver_address;
        }
}
