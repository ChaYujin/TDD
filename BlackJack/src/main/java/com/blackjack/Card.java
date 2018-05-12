package com.blackjack;

import com.blackjack.define.CardNumber;
import com.blackjack.define.CardType;

public class Card {
    private CardType type;
    private CardNumber number;

    public Card( CardType card_type , CardNumber card_number ){
        this.type = card_type;
        this.number = card_number;
    }

    public CardType getType(){
        return this.type;
    }

    public CardNumber getNumber(){
        return this.number;
    }
}
