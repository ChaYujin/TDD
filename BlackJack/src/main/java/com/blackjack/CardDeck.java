package com.blackjack;

import com.blackjack.define.CardNumber;
import com.blackjack.define.CardType;

import java.util.LinkedList;
import java.util.Random;

public class CardDeck {
    private static LinkedList<Card> cardDeck = new LinkedList<Card>();
    private static Random random = new Random();

    static {
        CardType[] types = CardType.values();
        CardNumber[] numbers = CardNumber.values();

        Card card;
        for( int i=0; i<types.length; i++ ){
            for( int j=0; j<numbers.length; j++ ){
                card = new Card(types[i], numbers[j]);
                cardDeck.add( card );
            }
        }
    }

    public static LinkedList getCardDeck(){
        return cardDeck;
    }

    public static LinkedList<Card> shuffle() {
        int shuffle_count = 20;
        int start_index=20;
        int card_count;

        int i, j;
        Card card;
        for( i=0; i<shuffle_count; i++ ){
            card_count = getShuffleCardCount( start_index );

            for( j=start_index; j<start_index+card_count ; j++ ){
                card = cardDeck.remove(j);
                cardDeck.add(0, card);
            }
        }
        return cardDeck;
    }

    private static int getShuffleCardCount( int start_index ){
        int min_card_count = 10;
        int max_card_count = cardDeck.size()-start_index;
        int random_num = (int) ( random.nextFloat() * (max_card_count-min_card_count) );

        return min_card_count + random_num;
    }
}
