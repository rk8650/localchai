package main.java.beans;

import org.springframework.stereotype.Component;

/**
 * Created by rahul on 4/2/2017.
 */
@Component
public class UserLogin {
    private String loginId;
    private StringBuilder loginPassword;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public StringBuilder getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(StringBuilder loginPassword) {
        this.loginPassword = loginPassword;
    }
}
