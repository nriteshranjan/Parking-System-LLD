package org.nriteshranjan;

public class PaymentService {

    private int retryCount;
    private PaymentSession paymentSession;

    public PaymentService(int retryCount) {
        this.retryCount = retryCount;
    }

    public boolean startSessionAndMakePayment(String paymentMode, ClientDetails clientDetails, float amountToPay) {
        if (retryCount <= 0) {
            return false; // Maximum retry attempts reached
        }

        // Create a new payment session
        PaymentSession session = new PaymentSession(clientDetails, amountToPay);

        // Select the payment mode and get its details
        PaymentMode paymentModeDetails = session.selectPaymentModeAndGetDetails(paymentMode);

        if (paymentModeDetails == null) {
            return false; // Handle the case where a payment mode wasn't selected
        }

        // Attempt to make the payment using the selected payment mode
        if (session.makePayment()) {
            return true; // Payment successful
        } else {
            retryCount--;
            return startSessionAndMakePayment(paymentMode, clientDetails, amountToPay); // Retry with the same payment mode
        }
    }
}