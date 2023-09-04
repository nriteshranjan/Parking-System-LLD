package org.nriteshranjan;

import java.util.ArrayList;
import java.util.List;

public class CardPayment implements PaymentMode {

    private CardType cardType;
    private CardDetail cardDetail;

    public CardPayment(CardType cardType, CardDetail cardDetail) {
        this.cardType = cardType;
        this.cardDetail = cardDetail;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardDetail getCardDetail() {
        return cardDetail;
    }

    public void setCardDetail(CardDetail cardDetail) {
        this.cardDetail = cardDetail;
    }

    @Override
    public List<Object> getDetails() {
        List<Object> details = new ArrayList<>();
        details.add(cardType);
        details.add(cardDetail);
        return details;
    }
}