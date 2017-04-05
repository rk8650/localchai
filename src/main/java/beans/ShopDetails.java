package main.java.beans;

import org.springframework.stereotype.Component;

/**
 * Created by rahul on 4/2/2017.
 */
@Component
public class ShopDetails {
    private String shopId;
    private String shopName;
    private String shopAddress;
//    private String itemName;
//    private double itemPrice;
    private Item item;
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

//    public String getItemName() {
//        return itemName;
//    }
//
//    public void setItemName(String itemName) {
//        this.itemName = itemName;
//    }
//
//    public double getItemPrice() {
//        return itemPrice;
//    }
//
//    public void setItemPrice(double itemPrice) {
//        this.itemPrice = itemPrice;
//    }
}
