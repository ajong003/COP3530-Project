package MAIN;


import GUI.MainMenuUI;
import GUI.User_Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JackOfAllTrades {

    //draw deck
    public Deck<Card> drawDeck;

    //P1 cards
    public CardList<Card> p1Cards = new CardList<Card>();

    //P2 cards
    public CardList<Card> p2Cards = new CardList<Card>();

    public User_Interface GameUI;

    //empty playing lanes 1-3
    public Deck<Card> lane1 = new Deck<Card>(), lane2 = new Deck<Card>(), lane3 = new Deck<Card>();

    int p1HP=100, cpuHP=100;


    //initialize everything
    public JackOfAllTrades() {

        //draw deck
        //generate deck
        drawDeck = generateDeck();
        drawDeck.shuffle();

        p1Cards.toString();


        //Initialize GUI//
        MainMenuUI MM = new MainMenuUI();
        GameUI = new User_Interface();
        MM.InitializeMainMenu(GameUI);
        GameUI.InitializeUI(MM);

        //register draw deck and initialize counter
        GameUI.DrawTable.setDeck(drawDeck);
        GameUI.initializeDrawDeckCounter();

        //create the button and register it to the draw Deck
        DrawButton drawButton = new DrawButton();

        GameUI.DrawTable.registerButton(drawButton);

        //Register lanes to GUI lane objects
        GameUI.Lane1.registerlane(lane1);
        GameUI.Lane2.registerlane(lane2);
        GameUI.Lane3.registerlane(lane3);
        //register buttons
        PlaceButton placeButton = new PlaceButton();
        GameUI.Lane1.registerButton(placeButton);
        GameUI.Lane2.registerButton(placeButton);
        GameUI.Lane3.registerButton(placeButton);

        //

        GameUI.setP1CardList(p1Cards);
        GameUI.generateP1Cards(-1);

        System.out.println(p1Cards);


    }

    //function for placing card,
    //remove Card linked to p1selectedcard from UI object from p1cardlist
    //add card to lane
    //remove card UI object from player cards
    public class PlaceButton implements ActionListener {
        public void actionPerformed(ActionEvent Click) {
            if(GameUI.isCardSelected){
                JButton sourceButton = (JButton) Click.getSource();
                Card selectedCard = GameUI.P1SelectedCard.card;
                switch(sourceButton.getName()){
                    case "Lane1":
                        checkMatch(lane1,selectedCard);

                        break;
                    case "Lane2":
                        checkMatch(lane2,selectedCard);
                        break;
                    case "Lane3":
                        checkMatch(lane3,selectedCard);
                        break;
                }
            }


        }
        //tests if lane matches card rank or suite, or is empty
        public boolean checkMatch(Deck<Card> lane,Card selectedCard){
            if (lane.isEmpty()||(lane.peek().getRank()==selectedCard.getRank() || lane.peek().getSuite().equals(selectedCard.getSuite()))) {
                //card linked to the selected card GUI object
                p1Cards.remove(selectedCard);
                GameUI.generateP1Cards(-1);
                System.out.println("p1cards after placing");
                System.out.println(p1Cards);
                adjustHP(lane);
                lane.push(GameUI.P1SelectedCard.card);
                System.out.println("lane after adding");
                System.out.println(lane);



                return true;

            }
            return false;
        }
        public void adjustHP(Deck<Card> lane){
            if(!lane.isEmpty()){
                cpuHP = cpuHP - Math.abs((lane.peek().getRank() - GameUI.P1SelectedCard.card.getRank()));
                System.out.println("minus" + Math.abs((lane.peek().getRank() - GameUI.P1SelectedCard.card.getRank())));
                System.out.println(cpuHP);
                GameUI.refreshHPPanels(p1HP,cpuHP);
            }



        }
    }



        //call drawCard then refresh the P1cards GUI
        public class DrawButton implements ActionListener {

            public void actionPerformed(ActionEvent Click) {
                int index=drawCard(p1Cards);
                GameUI.generateP1Cards(index);
                GameUI.refreshDrawDeckCounter();
                System.out.println(p1Cards);
                System.out.println(drawDeck);

            }
        }
        //player draws card from drawDeck (activated by actionPerformed)
        //does returns false if drawDeck is empty

        public int drawCard(CardList<Card> list) {
            int index=-1;
            if (!drawDeck.isEmpty()) {
                Card newCard=drawDeck.pop();
                list.add(newCard);
                list.suiteSort();
                //find the index of the new card in sorted deck
                index=list.indexOf(newCard);

            }
            return index;
        }

        //create card deck double loop generates  sorted deck
        public static Deck<Card> generateDeck() {
            Deck<Card> fullDeck = new Deck<Card>();
            String[] suiteArray = {"Hearts", "Clubs", "Diamonds", "Spades"};
            for (int i = 0; i < suiteArray.length; i++) {
                for (int k = 0; k < 13; k++) {
                    fullDeck.push(new Card(suiteArray[i], k, "Normal card"));

                }


            }
            //hardcode special card descriptions
            fullDeck.findCard(0,"Clubs").setDescription("<html>2 Random Cards in the opponent's hand are Destroyed</html>");
            fullDeck.findCard(0,"Hearts").setDescription("<html>The nextCard Placed by the User is not lost, User also gets to play an extra card this turn</html>");
            fullDeck.findCard(0,"Diamonds").setDescription("<html>The next attack against the user, in this lane, is reflected at the opponent</html>");
            fullDeck.findCard(0,"Spades").setDescription("<html>Nullify all active effects on this Lane, the User may also play an extra card this turn</html>");


            return fullDeck;
        }

    }

