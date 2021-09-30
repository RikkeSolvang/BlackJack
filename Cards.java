public class Cards {

    private Suit suit; //Henter fra suit enum
    private Values value; //Henter fra values enum

    public Cards (Suit suit, Values value) {
        this.value = value;
        this.suit = suit;
    }

    public String toString(){
        return this.suit.toString() +  this.value.toString();
    }

    public Values getValue() {
        return this.value;
    }
}
