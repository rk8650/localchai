package main.java.beans;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 4/2/2017.
 */
@Component
public class AvailableShops {
    private String locality;
//    List<ItemDetails> itemDetailsList = new ArrayList<ItemDetails>();
    private String item;
    private int quantity;

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    //    public List<ItemDetails> getItemDetailsList() {
//        return itemDetailsList;
//    }

//    public void setItemDetailsList(List<ItemDetails> itemDetailsList) {
//        this.itemDetailsList = itemDetailsList;
//    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
