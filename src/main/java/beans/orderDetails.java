package main.java.beans;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 8/26/2017.
 */
@Component
public class OrderDetails {
    private String orderId;
    private UserLogin userLogin;
    private List<ItemDetails> orderedItems=new ArrayList<ItemDetails>();

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public List<ItemDetails> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<ItemDetails> orderedItems) {
        this.orderedItems = orderedItems;
    }
}
