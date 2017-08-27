package main.java.wrapper;

import main.java.beans.ShopDetails;

import java.util.List;

/**
 * Created by rahul on 8/21/2017.
 */
public class ShopListResponse {

    private List<ShopDetails> shopList;

    private String message;

    public ShopListResponse (List<ShopDetails> shopList, String message){
        this.shopList = shopList;
        this.message = message;
    }

// getters and setters

    public List<ShopDetails> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopDetails> shopList) {
        this.shopList = shopList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
