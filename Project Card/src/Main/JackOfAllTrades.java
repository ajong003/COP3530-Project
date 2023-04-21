package MAIN;


import GUI.User_Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JackOfAllTrades {

    //draw deck
    public  Deck<Card> drawDeck;

    //P1 cards
    public  CardList<Card> p1Cards = new CardList<Card>();

    //P2 cards
    public CardList<Card> p2Cards = new CardList<Card>();

    public User_Interface UI;
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
        UI= new User_Interface();
        UI.InitializeUI();

        //create the button and register it to the draw Deck
        DrawButton drawButton = new DrawButton();
        UI.DrawTable.setDeck(drawDeck);
        UI.DrawTable.registerButton(drawButton);




    }
    public class DrawButton implements ActionListener {

        public void actionPerformed(ActionEvent Click) {
           drawCard();
        }
    }

    //player draws card from drawDeck (activated by actionPerformed)
    //does nothing returns false if drawDeck is empty
    public boolean drawCard() {
        if(!drawDeck.isEmpty()){
            p1Cards.add(drawDeck.pop());
            return true;
        }
        return false;
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
