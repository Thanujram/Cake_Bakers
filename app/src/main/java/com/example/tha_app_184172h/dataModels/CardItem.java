package com.example.tha_app_184172h.dataModels;

public class CardItem {
    private   String  Item_name;
    private String Item_des;
    private int Item_price;

    public String getItem_name() {
        return Item_name;
    }

    public void setItem_name(String item_name) {
        Item_name = item_name;
    }

    public String getItem_des() {
        return Item_des;
    }

    public void setItem_des(String item_des) {
        Item_des = item_des;
    }

    public int getItem_price() {
        return Item_price;
    }

    public void setItem_price(int item_price) {
        Item_price = item_price;
    }

    public  CardItem(String item_name, String item_des, int item_price)
    {
        Item_name=item_name;
        Item_des = item_des;
        Item_price=item_price;
    }
}

