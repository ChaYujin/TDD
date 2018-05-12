import com.blackjack.Card;
import com.blackjack.CardDeck;
import com.blackjack.define.CardNumber;
import com.blackjack.define.CardType;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BlackJackTest {

    @Test
    public void 카드타입enum확인(){
        assertThat( CardType.values() ).contains(CardType.CLUB , CardType.DIAMOND , CardType.HEART , CardType.SPADE);
        assertThat( CardType.values().length ).isEqualTo( 4 );
    }

    @Test
    public void 카드숫자enum확인(){
        assertThat( CardNumber.values() ).contains( CardNumber.A, CardNumber.TWO, CardNumber.FIVE,CardNumber.TEN, CardNumber.J, CardNumber.Q, CardNumber.K);
        assertThat( CardNumber.values().length ).isEqualTo( 13 );
    }

    @Test
    public void 카드생성확인(){
        //Exception case!
        Card card = new Card(CardType.HEART, CardNumber.A);

        //field이름이 type, number인 값을 가져와 HEART, A값이 존재하는지 확인한다.
        //field의 접근제어자가 private이여도 가져올 수 있다.
        assertThat(card).extracting("type", "number") .contains(CardType.HEART, CardNumber.A);

        assertThat( card.getType() ).isEqualTo(CardType.HEART);
        assertThat( card.getNumber() ).isEqualTo(CardNumber.A);
    }

    @Test
    public void 카드숫자확인(){
        Card card_a = new Card(CardType.HEART, CardNumber.A);
        Card card_4 = new Card(CardType.SPADE, CardNumber.FOUR);
        Card card_j = new Card(CardType.CLUB, CardNumber.J);
        Card card_q = new Card(CardType.SPADE, CardNumber.Q);
        Card card_k = new Card(CardType.HEART, CardNumber.K);

        assertThat(card_a.getNumber().getValue()).isEqualTo(1);
        assertThat(card_4.getNumber().getValue()).isEqualTo(4);
        assertThat(card_j.getNumber().getValue()).isEqualTo(10);
        assertThat(card_q.getNumber().getValue()).isEqualTo(10);
        assertThat(card_k.getNumber().getValue()).isEqualTo(10);
    }

    @Test
    public void 카드덱이_정상적으로_생성되었는지_확인() {
        LinkedList<Card> deck = CardDeck.getCardDeck();
        assertThat( deck.size() ).isEqualTo(52);

        List<CardNumber> numbers = new ArrayList<>();
        numbers.add(CardNumber.A );
        numbers.add(CardNumber.TWO );
        numbers.add(CardNumber.THREE );
        numbers.add(CardNumber.FOUR );
        numbers.add(CardNumber.FIVE );
        numbers.add(CardNumber.SIX );
        numbers.add(CardNumber.SEVEN );
        numbers.add(CardNumber.EIGHT );
        numbers.add(CardNumber.NINE );
        numbers.add(CardNumber.TEN );
        numbers.add(CardNumber.J );
        numbers.add(CardNumber.Q );
        numbers.add(CardNumber.K );

        assertThat( deck ).filteredOn("type", CardType.CLUB ).extracting("number").containsAll(numbers);

        List<CardType> types = new ArrayList<>();
        types.add( CardType.CLUB );
        types.add( CardType.DIAMOND );
        types.add( CardType.HEART );
        types.add( CardType.SPADE );
        assertThat( deck ).filteredOn( "number" , CardNumber.A ).extracting("type").containsAll(types);
    }

    @Test
    public void 카드덱_카드를_섞어_섞이는지_확인(){
        int total_count = 10;
        int diff_count = 0;
        Card[] first_cards = new Card[total_count];

        Card prv_card = null;
        Card crr_card = null;
        for( int i=0; i<10;i++){
            prv_card = crr_card;

            crr_card = CardDeck.shuffle().get(0);

            if( prv_card != null ){
                if( prv_card.getNumber().getValue() != crr_card.getNumber().getValue() || prv_card.getType() != crr_card.getType() ){
                    diff_count ++;
                }
            }
        }

        int percent = (int) (((float)diff_count/total_count)*100);

        assertThat(percent ).isGreaterThan( 50 );
    }
}
