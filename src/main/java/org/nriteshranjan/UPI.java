package org.nriteshranjan;

import java.util.ArrayList;
import java.util.List;

public class UPI implements PaymentMode {

    private String upiId;

    public UPI(String upiId) {
        this.upiId = upiId;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public List<Object> getDetails() {
        List<Object> details = new ArrayList<>();
        details.add(upiId);
        return details;
    }
}