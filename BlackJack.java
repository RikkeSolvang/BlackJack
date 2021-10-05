import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {

        Deck playingDeck = new Deck();
        playingDeck.fullDeck();
        playingDeck.shuffle();

        //kort for å dele ut til sam og dealer
        Deck samDeck = new Deck();
        Deck dealerDeck = new Deck();

        //Tester om playingDeck har 52 kort, forventer 0-51 indeks (må fjerne kommentar fra deck klassen)
        System.out.println(playingDeck);

        Scanner samInput = new Scanner(System.in); //Scanner for å hente input fra terminalen

        //loop for å kjøre spiller
        System.out.println("Velkommen til BlackJack!");

        //boolean gaveOver = false;

        //while (gaveOver = false) { (ønsket egentlig å bruke en while loop, har ikke fått til enda)

        //kort er gitt i rekkefølge sam, dealer, sam, dealer.
        samDeck.draw(playingDeck);
        dealerDeck.draw(playingDeck);
        samDeck.draw(playingDeck);
        dealerDeck.draw(playingDeck);


        //Printer ut verdiene
        System.out.println("Her er dine kort:");
        System.out.println(samDeck.toString());
        System.out.println("Kortene dine har verdi: " + samDeck.cardValue());

        System.out.println("Dealer sine kort:");
        System.out.println(dealerDeck.toString());
        System.out.println("Kortene til dealeren har verdi: " + dealerDeck.cardValue());

        //Sjekker om noen fikk 21 på første forsøk
        if (samDeck.cardValue() == 21) {
            //gaveOver = true;
            System.out.println("Gratulerer Sam! Du har vunnet mot dealeren.");
            //break;
        } else if (dealerDeck.cardValue() == 21) {
            //gaveOver = true;
            System.out.println("Gratulerer dealer! Du har vunnet mot Sam.");
            //break;
        } else if (dealerDeck.cardValue() == 22 && samDeck.cardValue() == 22) {
            //gaveOver = true;
            System.out.println("Gratulerer Sam! Begge fikk BlackJack på første forsøk, du har vunnet mot Dealer.");
            //break;

            //Tar neste input fra sam
        } else {
            System.out.println("Ønsker du å [1] Ta et nytt kort, eller [2] stå over?");
            int response = samInput.nextInt();

            if (response == 1) {
                samDeck.draw(playingDeck);
                System.out.println("Du fikk kortet: " + samDeck.getCard(samDeck.deckSize() - 1).toString()
                        + "\n" + "Kortene dine har verdi: " + samDeck.cardValue());

                //Sjekker om hun fikk 21 eller mer
                if (samDeck.cardValue() > 21) {
                    //gaveOver = true;

                    System.out.println("Kortene dine er over 21 med verdi: " + samDeck.cardValue() + ". Game over!");
                    //break;
                }
                if (samDeck.cardValue() == 21) {
                    System.out.println("Gratulerer Sam! Du har vunnet mot dealeren.");
                    //break;
                }
                // tar neste input fra Sam
                if (samDeck.cardValue() < 21) {
                    System.out.println("Ønsker du å [1] Ta et nytt kort, eller [2] stå over?");
                    //break;

                    if (response == 1) {
                        samDeck.draw(playingDeck);
                        System.out.println("Du fikk kortet: " + samDeck.getCard(samDeck.deckSize() - 1).toString() + "\n" + "Kortene dine har verdi: " + samDeck.cardValue());

                        if (samDeck.cardValue() > 21) {
                            //gaveOver = true;

                            System.out.println("Kortene dine er over 21 med verdi: " + samDeck.cardValue() + ". Game over!");
                            //break;
                        }
                        if (samDeck.cardValue() == 21) {
                            System.out.println("Gratulerer Sam! Du har vunnet mot dealeren.");
                            //break;
                        }
                        // tar neste input fra Sam
                        if (samDeck.cardValue() < 21) {
                            System.out.println("Ønsker du å [1] Ta et nytt kort, eller [2] stå over?");
                        }
                    }
                }

                if (response == 2) {
                    System.out.println("Du står."); //break

                    if (samDeck.cardValue() > dealerDeck.cardValue()) {
                        System.out.println("Gratulerer, du har vunnet!");
                        if (samDeck.cardValue() < dealerDeck.cardValue()) {
                            System.out.println("Gratulerer, du har vunnet!");
                        }
                    }

                }
            }
        }
    }
}




