package com.teamprooject.team.order;

import java.time.LocalDate;

public class OrderRoom {

    public String room_role;
    public String room_adult;
    public String room_child;
    public String room_baby;
    public String room_price;
    public String room_day;
    public String room_resert_price;

    public LocalDate room_startDate;

    public LocalDate room_endDate;



    public OrderRoom() {
    }

    public OrderRoom(String room_role, String room_adult, String room_child, String room_baby, String room_price, String room_day, String room_resert_price, LocalDate  room_startDate, LocalDate room_endDate) {
        this.room_role = room_role;
        this.room_adult = room_adult;
        this.room_child = room_child;
        this.room_baby = room_baby;
        this.room_price = room_price;
        this.room_day = room_day;
        this.room_resert_price = room_resert_price;
        this.room_endDate = room_endDate;
        this.room_startDate = room_startDate;
    }


    public String getRoom_role() {
        return room_role;
    }

    public void setRoom_role(String room_role) {
        this.room_role = room_role;
    }

    public String getRoom_adult() {
        return room_adult;
    }

    public void setRoom_adult(String room_adult) {
        this.room_adult = room_adult;
    }

    public String getRoom_child() {
        return room_child;
    }

    public void setRoom_child(String room_child) {
        this.room_child = room_child;
    }

    public String getRoom_baby() {
        return room_baby;
    }

    public void setRoom_baby(String room_baby) {
        this.room_baby = room_baby;
    }

    public String getRoom_price() {
        return room_price;
    }

    public void setRoom_price(String room_price) {
        this.room_price = room_price;
    }

    public String getRoom_day() {
        return room_day;
    }

    public void setRoom_day(String room_day) {
        this.room_day = room_day;
    }

    public String getRoom_resert_price() {
        return room_resert_price;
    }

    public void setRoom_resert_price(String room_resert_price) {
        this.room_resert_price = room_resert_price;
    }

    public LocalDate getRoom_startDate() {
        return room_startDate;
    }

    public void setRoom_startDate(LocalDate room_startDate) {
        this.room_startDate = room_startDate;
    }

    public LocalDate getRoom_endDate() {
        return room_endDate;
    }

    public void setRoom_endDate(LocalDate room_endDate) {
        this.room_endDate = room_endDate;
    }


}
