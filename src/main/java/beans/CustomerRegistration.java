package main.java.beans;

import org.springframework.stereotype.Component;

/**
 * Created by rahul on 4/2/2017.
 */
@Component
public class CustomerRegistration {
    private String customerName;
    private String customerId;
    private StringBuilder customerPassword;
    private String customerPhoneNumber;
    private String customerEmailId;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public StringBuilder getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(StringBuilder customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }
}
