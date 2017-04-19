package main.java.beans;

/**
 * Created by rahul on 4/5/2017.
 */
public class ItemDetails {
    private String itemId;
    private String itemName;
    private String itemPrice;
    private String itemQuantity;
    private String itemShopId;
    //private ShopDetails shopDetails;

    public String getItemShopId() {
        return itemShopId;
    }

    public void setItemShopId(String itemShopId) {
        this.itemShopId = itemShopId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
