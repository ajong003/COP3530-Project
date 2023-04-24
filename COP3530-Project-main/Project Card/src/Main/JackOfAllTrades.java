package Main;


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
    public CardList<Card> cpuCards = new CardList<Card>();

    public User_Interface GameUI;

    //empty playing lanes 1-3
    public Deck<Card> lane1 = new Deck<Card>(), lane2 = new Deck<Card>(), lane3 = new Deck<Card>();

    int p1HP=100, cpuHP=100;
    
    boolean P1NextCardNotLost,P2NextCardNotLost = false;
    
	boolean P1NextTurnAddAction = false;
	boolean P2NextTurnAddAction = false;
	
	boolean P1NextTurnRedAction = false;
	boolean P2NextTurnRedAction = false;
    
    int P1ActionsLeft = 1, P2ActionsLeft = 0;
    public boolean drawLock;
    public boolean placeLock;
    public int drawCounter;






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


        GameUI.setP1CardList(p1Cards);
        GameUI.generateP1Cards(-1);

        GameUI.setCPUCardList(cpuCards);
        GameUI.generateCPUCards();

        System.out.println(p1Cards);

        cpuDraw();
        cpuDraw();


    }

    public void playerTurn(){
        drawCounter=0;
        placeLock=false;
        drawLock=false;

    }
    public void cpuTurn(){

    }
    public void cpuDraw(){
        drawCard(cpuCards);
        GameUI.refreshDrawDeckCounter();
        GameUI.generateCPUCards();
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
            if (lane.isEmpty()||(lane.peek().getRank()==selectedCard.getRank() || lane.peek().getSuite().equals(selectedCard.getSuite()))||selectedCard.getRank()==11) {
                //card linked to the selected card GUI object
                
            	P1ActionsLeft--;
            	
            	if (!P1NextCardNotLost) {
            		p1Cards.remove(selectedCard);
                    GameUI.generateP1Cards(-1);
            	}
            	else {
                	P1NextCardNotLost = false;
            	}
                System.out.println("p1cards after placing");
                System.out.println(p1Cards);
                
                //Activate Effects
                if (selectedCard.suite == "Spades") {
                	if (selectedCard.rank == 1) { //FUNCTIONAL
                		System.out.println("Nullify All Active Effects in the lane and gain +1 Action");
                		lane.P1DmgModifier = 0;
                		lane.P2DmgModifier = 0;
                		
                		lane.P1NullifiedEffects = false;
                		lane.P2NullifiedEffects = false;
                		
                		lane.P1HealPerCard = 0;
                		lane.P2HealPerCard = 0;
                		lane.ReflectDmgP1 = false;
                		lane.ReflectDmgP2 = false;
                		lane.ZeroDamageALL = false;
                		lane.x2DamageALL = false;
                		
                		if (lane.P1NextTurnAddActionOrigin) {
                    		P1NextTurnAddAction = false;
                		}
                		if (lane.P2NextTurnAddActionOrigin) {
                    		P2NextTurnAddAction = false;
                		}
                		if (lane.P1NextTurnRedActionOrigin) {
                    		P1NextTurnRedAction = false;
                		}
                		if (lane.P2NextTurnRedActionOrigin) {
                    		P2NextTurnRedAction = false;
                		}
                		
                		
                		P1ActionsLeft++;
                	}
                	else if (selectedCard.rank == 11) {
                		if (!lane.P1NullifiedEffects) {
                    		System.out.println("Reveal 2 Random Cards of the Opponent");
                    		//ToDo
                		}
                	}
                	else if (selectedCard.rank == 12) {
                		if (!lane.P1NullifiedEffects) {//FUNCTIONAL
                    		System.out.println("Opponent Loses one action next turn");
                    		P2ActionsLeft--;
                		}

                	}
                	else if (selectedCard.rank == 13) {
                		if (!lane.P1NullifiedEffects) {
                    		System.out.println("All Future Cards Placed here, by the Opponent, will have their Effects Nullified.");
                    		lane.P2NullifiedEffects = true;
                		}

                	}
                }
                
                else if(selectedCard.suite == "Diamonds") {
                	if (!lane.P1NullifiedEffects) {
                    	if (selectedCard.rank == 1) {
                    		System.out.println("The next attack against the user, in this lane, is reflected");
                    		lane.ReflectDmgP1 = true;
                    	}
                    	else if (selectedCard.rank == 11) {//FUNCTIONAL
                    		System.out.println("Next card played on this lane deals Zero Damage");
                    		lane.ZeroDamageALL = true;
                    	}
                    	else if (selectedCard.rank == 12) {
                    		System.out.println("The User gains +2 actions next turn");
                    		lane.P1NextTurnAddActionOrigin = true;
                    	}
                    	else if (selectedCard.rank == 13) {
                    		System.out.println("All Future Cards Placed in this Lane, by the Opponent, will deal -3 Damage.");
                    		lane.P2DmgModifier = lane.P2DmgModifier - 3;
                    	}
                	}
                }
                
                else if(selectedCard.suite == "Hearts") {//FUNCTIONAL COMPLETE
                	if (!lane.P1NullifiedEffects) {
                    	if (selectedCard.rank == 1) {//FUNCTIONAL
                    		System.out.println("Dont Lose next Card, Gain +1 Action");
                    		P1NextCardNotLost = true;
                    		P1ActionsLeft++;
                    	}
                    	else if (selectedCard.rank == 11) {//FUNCTIONAL
                    		System.out.println("Regain HP equal to the last card on the Lane.");
                    		if (!lane.isEmpty()) {
                        		p1HP = p1HP + lane.peek().getRank();
                    		}
                    	}
                    	else if (selectedCard.rank == 12) {//FUNCTIONAL
                    		System.out.println("Heal the user by 12 HP");
                    		p1HP = p1HP + 12;
                    	}
                    	else if (selectedCard.rank == 13) {//FUNCTIONAL
                    		System.out.println("All Future Cards Placed here, by the User, will heal +2 HP.");
                    		lane.P1HealPerCard = lane.P1HealPerCard + 2;
                    	}
                	}
                }//FUNCTIONAL COMPLETE
                
                else if(selectedCard.suite == "Clubs") {
                	if (!lane.P1NullifiedEffects) {
                    	if (selectedCard.rank == 1) {
                    		System.out.println("Destroy 2 Random Cards in the Opponents Hand.");
                    		//ToDo
                    	}
                    	else if (selectedCard.rank == 11) {//FUNCTIONAL
                    		System.out.println("The Next card played on this lane will deal x2 Damage.");
                    		lane.x2DamageALL = true;
                    	}
                    	else if (selectedCard.rank == 12) {//FUNCTIONAL
                    		System.out.println("This card will deal x2 Damage");
                    		lane.P1x2Damage = true;
                    	}
                    	else if (selectedCard.rank == 13) {//FUNCTIONAL
                    		System.out.println("All Future Cards Placed in this Lane, by the User, will deal +3 Damage.");
                    		lane.P1DmgModifier = lane.P1DmgModifier + 3;
                    	}
                	}
                }
                
                
                p1HP = p1HP + lane.P1HealPerCard;
                
                adjustHP(lane);
                lane.push(GameUI.P1SelectedCard.card);
                System.out.println("lane after adding");
                System.out.println(lane);



                return true;

            }
            return false;
        }
        public void adjustHP(Deck<Card> lane){
        	int Damage = 0;
        	
        	//Calc Damage Difference
        	if(!lane.isEmpty()){
        		Damage = Math.abs((lane.peek().getRank() - GameUI.P1SelectedCard.card.getRank()));
            }
            else {
            	Damage = GameUI.P1SelectedCard.card.getRank();
            }
        	
        	Damage = Damage + lane.P1DmgModifier;
        	
        	if (lane.ZeroDamageALL) {
        		Damage = 0;
        		lane.ZeroDamageALL = false;
        	}
        	
            if (lane.P1x2Damage) {
            	Damage = Damage * 2;
            	lane.P1x2Damage = false;
            }
            if (lane.x2DamageALL) {
            	Damage = Damage * 2;
            	lane.x2DamageALL = false;
            }
            //Is the damage Reflected?
            if (lane.ReflectDmgP2) {
            	p1HP = p1HP - Damage;
            }
            else {
            	cpuHP = cpuHP - Damage;
            }
            
        	System.out.println("Dealt " + Damage + " Damage");
            System.out.println(cpuHP);
            GameUI.refreshHPPanels(p1HP,cpuHP);


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
                for (int k = 1; k <= 13; k++) {
                    fullDeck.push(new Card(suiteArray[i], k, "Normal card"));

                }


            }
            //Hardcode special card descriptions
            //Aces
            fullDeck.findCard(1,"Clubs").setDescription("<html><b>Power: 1</b><br>Destroy 2 Random Cards in the Opponents Hand.</html>");
            
            fullDeck.findCard(1,"Hearts").setDescription("<html><b>Power: 1</b><br>The next Card Placed by the User is not lost, User also also gains +1 Action.</html>");
            
            fullDeck.findCard(1,"Diamonds").setDescription("<html><b>Power: 1</b><br>The next attack against the user, in this lane, is reflected at the opponent.</html>");
            
            fullDeck.findCard(1,"Spades").setDescription("<html><b>Power: 1</b><br>Nullify all Active Effects on this Lane, the User also gains +1 Action.</html>");
            
            //Jacks
            fullDeck.findCard(11,"Hearts").setDescription("<html><b>Power: 11</b><br>Free Placement<br>Regain HP equal to the Power of the Previous card on the Lane.</html>");
            fullDeck.findCard(11,"Spades").setDescription("<html><b>Power: 11</b><br>Free Placement<br>Reveal 2 Random Cards of the Opponent.</html>");
            fullDeck.findCard(11,"Diamonds").setDescription("<html><b>Power: 11</b><br>Free Placement<br>Next card played on this lane deals Zero Damage.</html>");
            fullDeck.findCard(11,"Clubs").setDescription("<html><b>Power: 11</b><br>Free Placement<br>The Next card played on this lane will deal x2 Damage.</html>");

            //Queens
            fullDeck.findCard(12,"Hearts").setDescription("<html><b>Power: 12</b><br>This card will heal the user by 12 HP</html>");
            fullDeck.findCard(12,"Spades").setDescription("<html><b>Power: 12</b><br>The opponent loses 1 action next turn</html>");
            fullDeck.findCard(12,"Diamonds").setDescription("<html><b>Power: 12</b><br>The User gains +2 actions next turn</html>");
            fullDeck.findCard(12,"Clubs").setDescription("<html><b>Power: 12</b><br>This card will deal x2 Damage</html>");

            //Kings
            fullDeck.findCard(13,"Hearts").setDescription("<html><b>Power: 13</b><br>All Future Cards Placed here, by the User, will heal +2 HP.</html>");
            fullDeck.findCard(13,"Spades").setDescription("<html><b>Power: 13</b><br>All Future Cards Placed in this Lane, by the Opponent, will have their Effects Nullified.<br>[Except for One]</html>");
            fullDeck.findCard(13,"Diamonds").setDescription("<html><b>Power: 13</b><br>All Future Cards Placed in this Lane, by the Opponent, will deal -3 Damage.<br> [Max of 0]</html>");
            fullDeck.findCard(13,"Clubs").setDescription("<html><b>Power: 13</b><br>All Future Cards Placed in this Lane, by the User, will deal +3 Damage.</html>");


            return fullDeck;
        }

    }

