package Main;


import GUI.MainMenuUI;
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
    public MainMenuUI MainMenu;

    //empty playing lanes 1-3
    public Deck<Card> lane1= new Deck<Card>(), lane2= new Deck<Card>(), lane3 = new Deck<Card>();

    //initialize everything
    public  JackOfAllTrades(){
        //draw deck
        //generate deck
        drawDeck = generateDeck();
        drawDeck.shuffle();

        p1Cards.toString();


        //Initialize GUI//
        UI= new User_Interface();
        MainMenu = new MainMenuUI();
        MainMenu.InitializeMainMenu(UI);
        UI.InitializeUI(MainMenu);

        //register draw deck and initialize counter
        UI.DrawTable.setDeck(drawDeck);
        UI.initializeDrawDeckCounter();

        //create the button and register it to the draw Deck
        DrawButton drawButton = new DrawButton();

        UI.DrawTable.registerButton(drawButton);

        //Register lanes to GUI lane objects
        UI.Lane1.registerlane(lane1);
        UI.Lane2.registerlane(lane2);
        UI.Lane3.registerlane(lane3);
        //register buttons
        PlaceButton placeButton = new PlaceButton();
        UI.Lane1.registerButton(placeButton);
        UI.Lane2.registerButton(placeButton);
        UI.Lane3.registerButton(placeButton);

        //
        p1Cards.add(new Card("Hearts", 5,"sdfsdf"));
        UI.setP1CardList(p1Cards);
        UI.generateP1Cards();

        System.out.println(p1Cards);






    }

    //function for placing card,
    //remove Card linked to p1selectedcard from UI object from p1cardlist
    //add card to lane
    //remove card UI object from player cards
    public class PlaceButton implements ActionListener{
        public void actionPerformed(ActionEvent Click){
            
        	if (UI.isCardSelected == true) {
                //card linked to the selected card GUI object
                Card selectedCard = UI.P1SelectedCard.card;
                p1Cards.remove(selectedCard);
                UI.generateP1Cards();
                System.out.println("p1cards after placing");
                System.out.println(p1Cards);
        	}
        	else{
            	System.out.println("No Card selected");
        	}


        }
    }

    //call drawCard then refresh the P1cards GUI
    public class DrawButton implements ActionListener {

        public void actionPerformed(ActionEvent Click) {
           drawCard(p1Cards);
           UI.generateP1Cards();
           UI.refreshDrawDeckCounter();
           System.out.println(p1Cards);
           System.out.println(drawDeck);

        }
    }
    //player draws card from drawDeck (activated by actionPerformed)
    //does returns false if drawDeck is empty

    public boolean drawCard(CardList<Card> list) {
        if(!drawDeck.isEmpty()){
            list.add(drawDeck.pop());
            list.sort();
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
                fullDeck.push(new Card(suiteArray[i], k,"test"));

            }


        }
        return fullDeck;
    }

}
