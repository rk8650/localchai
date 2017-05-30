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
    ArrayList itemDetailsList=new ArrayList();
//    private String item;
    private int quantity;

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public ArrayList getItemDetailsList() {
        return itemDetailsList;
    }

    public void setItemDetailsList(ArrayList itemDetailsList) {
        this.itemDetailsList = itemDetailsList;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
