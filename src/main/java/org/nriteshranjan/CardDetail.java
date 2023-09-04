package org.nriteshranjan;

public class CardDetail {

    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CardDetail(String cardNumber, String expiryDate, String cvv) {
        // Add validation logic here to ensure cardNumber, expiryDate, and cvv are valid
        if (!isValidCardNumber(cardNumber) || !isValidExpiryDate(expiryDate) || !isValidCvv(cvv)) {
            throw new IllegalArgumentException("Invalid card details");
        }
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    private boolean isValidCardNumber(String cardNumber) {
        // Add card number validation logic here
        // Example: Check if it's a valid credit card number format
        return true; // Replace with actual validation logic
    }

    private boolean isValidExpiryDate(String expiryDate) {
        // Add expiry date validation logic here
        // Example: Check if it's a valid date format and not expired
        return true; // Replace with actual validation logic
    }

    private boolean isValidCvv(String cvv) {
        // Add CVV validation logic here
        // Example: Check if it's a valid format (e.g., 3 or 4 digits)
        return true; // Replace with actual validation logic
    }
}