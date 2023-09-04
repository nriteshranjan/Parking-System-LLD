package org.nriteshranjan;

import java.util.Scanner;
import java.util.UUID;

public class PaymentSession {

    private String transactionId;
    private float amountToPay;
    private PaymentMode paymentModeDetails;
    private ClientDetails clientDetails;

    public PaymentSession(ClientDetails clientDetails, float amountToPay) {
        this.transactionId = UUID.randomUUID().toString(); // Generate a unique transaction ID
        this.clientDetails = clientDetails;
        this.amountToPay = amountToPay;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public float getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(float amountToPay) {
        this.amountToPay = amountToPay;
    }

    public PaymentMode getPaymentModeDetails() {
        return paymentModeDetails;
    }

    public void setPaymentModeDetails(PaymentMode paymentModeDetails) {
        this.paymentModeDetails = paymentModeDetails;
    }

    public ClientDetails getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
    }

    public PaymentMode selectPaymentModeAndGetDetails(String paymentMode) {
        Scanner scanner = new Scanner(System.in);

        if (paymentMode.equals("card")) {
            System.out.println("Select your card type: ");
            System.out.println("1. Credit Card");
            System.out.println("2. Debit Card");
            int cardTypeChoice = scanner.nextInt();

            CardType cardType;
            switch (cardTypeChoice) {
                case 1:
                    cardType = CardType.CREDIT_CARD;
                    break;
                case 2:
                    cardType = CardType.DEBIT_CARD;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid card type");
            }

            System.out.println("Enter your card number: ");
            String cardNumber = scanner.nextLine();
            System.out.println("Enter your expiry date (MM/YY): ");
            String expiryDate = scanner.nextLine();
            System.out.println("Enter your CVV: ");
            String cvv = scanner.nextLine();
            CardDetail cardDetail = new CardDetail(cardNumber, expiryDate, cvv);

            return new CardPayment(cardType, cardDetail);
        } else if (paymentMode.equals("upi")) {
            System.out.println("Enter your UPI ID: ");
            String upiId = scanner.nextLine();
            return new UPI(upiId);
        } else {
            throw new IllegalArgumentException("Invalid payment mode: " + paymentMode);
        }
    }

    public boolean makePayment() {
        if (paymentModeDetails == null) {
            // Handle the case where a payment mode hasn't been set
            return false;
        }
        //TODO: Implement payment logic
        return true;
    }
}