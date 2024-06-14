package com.teamprooject.team.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("order")

public class Order {

    @Id
    private String orderId;
    private String pg;
    private String pay_method;
    private String merchant_uid;
    private String name;
    private String buyer_name;
    private String buyer_tel;
    private String buyer_email;
    private String buyer_addr;
    private String buyer_postcode;
    private boolean buyer_car;
    private String  buyer_userId;
    private OrderRoom buyer_reservation;


    public Order() {}

    public Order( String pg, String pay_method, String merchant_uid, String name, String buyer_name, String buyer_tel, String buyer_email,String buyer_addr,String buyer_postcode,boolean buyer_car,String  buyer_userId,OrderRoom buyer_reservation){
        this.pg = pg;
        this.pay_method = pay_method;
        this.merchant_uid = merchant_uid;
        this.name = name;
        this.buyer_name = buyer_name;
        this.buyer_tel = buyer_tel;
        this.buyer_email = buyer_email;
        this.buyer_addr = buyer_addr;
        this.buyer_postcode = buyer_postcode;
        this.buyer_car = buyer_car;
        this.buyer_userId = buyer_userId;
        this.buyer_reservation = buyer_reservation;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getPay_method() {
        return pay_method;
    }

    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }

    public String getMerchant_uid() {
        return merchant_uid;
    }

    public void setMerchant_uid(String merchant_uid) {
        this.merchant_uid = merchant_uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public String getBuyer_tel() {
        return buyer_tel;
    }

    public void setBuyer_tel(String buyer_tel) {
        this.buyer_tel = buyer_tel;
    }

    public String getBuyer_email() {
        return buyer_email;
    }

    public void setBuyer_email(String buyer_email) {
        this.buyer_email = buyer_email;
    }

    public String getBuyer_addr() {
        return buyer_addr;
    }

    public void setBuyer_addr(String buyer_addr) {
        this.buyer_addr = buyer_addr;
    }

    public String getBuyer_postcode() {
        return buyer_postcode;
    }

    public void setBuyer_postcode(String buyer_postcode) {
        this.buyer_postcode = buyer_postcode;
    }

    public boolean isBuyer_car() {
        return buyer_car;
    }

    public void setBuyer_car(boolean buyer_car) {
        this.buyer_car = buyer_car;
    }

    public String getBuyer_userId() {
        return buyer_userId;
    }

    public void setBuyer_userId(String buyer_userId) {
        this.buyer_userId = buyer_userId;
    }

    public OrderRoom getBuyer_reservation() {
        return buyer_reservation;
    }

    public void setBuyer_reservation(OrderRoom buyer_reservation) {
        this.buyer_reservation = buyer_reservation;
    }
}
