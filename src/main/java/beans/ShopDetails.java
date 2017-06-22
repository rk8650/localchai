package main.java.beans;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 4/2/2017.
 */
@Component
public class ShopDetails {
    private String shopId;
    private String shopName;
    private String shopAddress;
    private String shopLocality;
    List<ItemDetails> itemDetailsList = new ArrayList<ItemDetails>();

    public List<ItemDetails> getItemDetailsList() {
        return itemDetailsList;
    }

    public void setItemDetailsList(List<ItemDetails> itemDetailsList) {
        this.itemDetailsList = itemDetailsList;
    }

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

    public String getShopLocality() {
        return shopLocality;
    }

    public void setShopLocality(String shopLocality) {
        this.shopLocality = shopLocality;
    }
}
