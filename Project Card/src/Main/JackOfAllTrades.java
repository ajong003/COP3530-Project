package Main;


import GUI.User_Interface;

public class JackOfAllTrades {

    //draw deck
    public  Deck<Card> drawDeck;

    //P1 cards
    public  CardList<Card> p1Cards = new CardList<Card>();

    //P2 cards
    public CardList<Card> p2Cards = new CardList<Card>();


    //initialize everything
    public  JackOfAllTrades(){
        //draw deck
        //generate deck
        drawDeck = generateDeck();
        System.out.println(drawDeck.toString());
        //Shuffle deck
        drawDeck.shuffle();
        System.out.println(drawDeck.toString());

        //Initialize GUI//
        User_Interface UI = new User_Interface();
        UI.InitializeUI();
        UI.DrawTable.setDeck(drawDeck);
    }
    public static void main(String[] args) {
        //create game instance
        JackOfAllTrades game = new JackOfAllTrades();









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
