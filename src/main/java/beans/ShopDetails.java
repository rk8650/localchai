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
    ArrayList itemDetailsList = new ArrayList();
    ArrayList selectedItemlist = new ArrayList();
    private double totalAmount;

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ArrayList getSelectedItemlist() {
        return selectedItemlist;
    }

    public void setSelectedItemlist(ArrayList selectedItemlist) {
        this.selectedItemlist = selectedItemlist;
    }

    public ArrayList getItemDetailsList() {
        return itemDetailsList;
    }

    public void setItemDetailsList(ArrayList itemDetailsList) {
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
