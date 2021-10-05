import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Cards> cards;

    public Deck(){
        this.cards = new ArrayList<Cards>();
    }

    //Lager kortstokk, for each loop
    public void fullDeck(){
        for(Suit cardSuit : Suit.values()){
            for(Values cardValue : Values.values()){
                this.cards.add(new Cards(cardSuit, cardValue));
            }
        }
    }

    //Metode for å stokke kortene
    public void shuffle(){
        ArrayList<Cards> shuffleDeck = new ArrayList<Cards>();
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for (int i=0; i < originalSize; i++){
            randomCardIndex = random.nextInt((this.cards.size()- 1 - 0) + 1) + 0;
            shuffleDeck.add(this.cards.get(randomCardIndex));
            //remove from original deck
            this.cards.remove(randomCardIndex);
        }
        this.cards = shuffleDeck;
    }


    public String toString(){
        String cardList = "";
        for(Cards aCard : this.cards){
            cardList += "\n " + aCard.toString();
        }
        return cardList;
    }

    /*
    //Brukes til å teste om vi har 52 kort, samme som metode over, bare med i
    public String toString(){
        String cardList = "";
        int i=0;
        for(Cards aCard : this.cards){
            cardList += "\n " + i + "-" + aCard.toString();
            i++;
        }
        return cardList;
    }
*/
    public void removeCard(int i){
        this.cards.remove(i);
    }

    public Cards getCard(int i){
         return this.cards.get(i);
    }

    public int deckSize(){
        return this.cards.size();
   }

    public void draw(Deck comingFrom){
        this.cards.add(comingFrom.getCard(0)); //Henter ut første kortet, index 0
        comingFrom.removeCard(0); //tar ut det kortet fra kortstokk
    }

    public int cardValue() {
        int totalValue = 0;
        for (Cards aCard : this.cards) {
           // System.out.println(totalValue); //tester om verdiene blir lagt sammen riktig
            switch (aCard.getValue()) {
                case TWO:
                    totalValue += 2;
                    break;
                case THREE:
                    totalValue += 3;
                    break;
                case FOUR:
                    totalValue += 4;
                    break;
                case FIVE:
                    totalValue += 5;
                    break;
                case SIX:
                    totalValue += 6;
                    break;
                case SEVEN:
                    totalValue += 7;
                    break;
                case EIGHT:
                    totalValue += 8;
                    break;
                case NINE:
                    totalValue += 9;
                    break;
                case TEN:
                    totalValue += 10;
                    break;
                case JACK:
                    totalValue += 10;
                    break;
                case QUEEN:
                    totalValue += 10;
                    break;
                case KING:
                    totalValue += 10;
                    break;
                case ACE:
                    totalValue += 11;
                    break;
            }

        }
        return totalValue;
    }
}
