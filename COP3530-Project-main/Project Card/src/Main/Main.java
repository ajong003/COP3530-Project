package Main;


import GUI.User_Interface;

public class Main {

    public static void main(String[] args) {
        //starting deck
        //generate deck
        Deck<Card> startDeck = generateDeck();
        
        System.out.println(startDeck.toString());
        startDeck.shuffle();
        //testing shuffle
        System.out.println(startDeck.toString());



        //p1 and p2 list of cards
        CardList<Card> p1Cards = new CardList<Card>();
        CardList<Card> p2Cards = new CardList<Card>();
        //////

        //GUI test
        User_Interface UI = new User_Interface();

        UI.InitializeUI();
        UI.DrawTable.setDeck(startDeck);
        ////

    }
    //create card deck double loop generates  sorted deck
    public static Deck<Card> generateDeck(){
        Deck<Card> fullDeck = new Deck<Card>();
        String[] suiteArray = {"Hearts", "Clover", "Diamonds", "Spades"};
        for (int i = 0; i < suiteArray.length; i++) {
            for (int k = 0; k < 13; k++) {
                fullDeck.push(new Card(suiteArray[i], k));

            }


        }
        return fullDeck;
    }
}
