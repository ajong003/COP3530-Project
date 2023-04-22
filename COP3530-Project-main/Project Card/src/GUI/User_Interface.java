package GUI;

import Main.Card;
import Main.CardList;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import GUI.MainMenuUI.StartBttnListener;


public class User_Interface {

	MainMenuUI MainMenu;
	
	ExitBttnListener ExitBttnListen = new ExitBttnListener();
	
	String PlayerName = "Player";
	int CurrentCardSlots = 0;
	JLabel PlayerNameLabel = new JLabel(PlayerName);
	JLabel Player2NameLabel = new JLabel("CPU");
	JLabel HPLabel1 = new JLabel("HP:");
	JLabel HPLabel2 = new JLabel("HP:");
	JLabel P1HPLabel = new JLabel("100 / 100");
	JLabel P2HPLabel = new JLabel("100 / 100");
	JButton ExitButton = new JButton("Exit");
	JFrame CardGameFrame = new JFrame();
	JPanel P1CardPanel = new JPanel();
	//Draw deck object
	public DrawUIObject DrawTable=new DrawUIObject();

	public CardList<Card> P1CardList;

	public CardUIObject P1SelectedCard;

	public boolean isCardSelected = false;

	public PlacementUIObject Lane1, Lane2, Lane3;

	JLabel  count;





	//Draw deck object



	public User_Interface(){
	}

	public void setP1CardList(CardList<Card> list){
		P1CardList=list;
	}
	
	public void InitializeUI(MainMenuUI MainMenu){

		this.MainMenu = MainMenu;
		
		
		
		CardGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CardGameFrame.setLayout(null);
		
		CardGameFrame.setTitle("Jack of All Trades");
		
		CardGameFrame.setSize(1280,720);
		
		ExitButton.setBounds(5, 655, 80, 20);
		ExitButton.setFocusable(false);
		
		ExitButton.addActionListener(ExitBttnListen);
		
		
		
		JPanel P1UIPanel = new JPanel();
			P1UIPanel.add(PlayerNameLabel);
			P1UIPanel.add(HPLabel1);
			P1UIPanel.add(P1HPLabel);
		P1UIPanel.setBounds(1000, 340, 200, 20);
			
			
		
		JPanel P2UIPanel = new JPanel();
			P2UIPanel.add(Player2NameLabel);
			P2UIPanel.add(HPLabel2);
			P2UIPanel.add(P2HPLabel);
		P2UIPanel.setBounds(1000, 140, 200, 50);


		//draw deck counter

		
		//P1CardSlots
		//card format
			//Card test = new Card("Hearts", 5);
			//CardUIObject P1Card1 = new CardUIObject(test);
			//JPanel PlayerCardSlot1 = new JPanel();
			//PlayerCardSlot1 = P1Card1.InitializeCard();

			

		//P1Card Slots
		
		
		
		//P2CardSlots
//		CardUIObject P1Card1 = new CardUIObject("King of Spades","K", 0, "Spades", 5, "Does Spades Stuff", this);
//		JPanel PlayerCardSlot1 = new JPanel();
//		PlayerCardSlot1 = P1Card1.InitializeCard();
//		PlayerCardSlot1 = P1Card1.ReInitializeCard("Queen of Spades","Q", 0, "Spades", 6, "Does Spades Stuff");
//
//		CardUIObject P1Card2 = new CardUIObject("Queen of Spades","Q", 0, "Spades", 6, "Does Spades Stuff", this);
//		JPanel PlayerCardSlot2 = new JPanel();
//		PlayerCardSlot2 = P1Card2.InitializeCard();
//		PlayerCardSlot2 = P1Card2.ClearCard();
//
//		CardUIObject P1Card3 = new CardUIObject("Ace of Spades","A", 0, "Spades", 7, "Does Spades Stuff", this);
//		JPanel PlayerCardSlot3 = new JPanel();
//		PlayerCardSlot3 = P1Card3.InitializeCard();
//
//		CardUIObject P1Card4 = new CardUIObject("Jack of Spades","J", 0, "Spades", 8, "Does Spades Stuff", this);
//		JPanel PlayerCardSlot4 = new JPanel();
//		PlayerCardSlot4 = P1Card4.InitializeCard();
//
//		CardUIObject P1Card5 = new CardUIObject("10 of Spades","10", 10, "Spades", 0, "Does Spades Stuff", this);
//		JPanel PlayerCardSlot5 = new JPanel();
//		PlayerCardSlot5 = P1Card5.InitializeCard();
//
//		CardUIObject P1Card6 = new CardUIObject("9 of Spades", "9", 9, "Spades", 0, "Does Spades Stuff", this);
//		JPanel PlayerCardSlot6 = new JPanel();
//		PlayerCardSlot6 = P1Card6.InitializeCard();
//
//		CardUIObject P1Card7 = new CardUIObject("8 of Spades", "8", 8, "Spades", 0, "Does Spades Stuff", this);
//		JPanel PlayerCardSlot7 = new JPanel();
//		PlayerCardSlot7 = P1Card7.InitializeCard();
//
//		CardUIObject P1Card8 = new CardUIObject("7 of Spades", "7", 7, "Spades", 0, "Does Spades Stuff", this);
//		JPanel PlayerCardSlot8 = new JPanel();
//		PlayerCardSlot8 = P1Card8.InitializeCard();
//
//		CardUIObject P1Card9 = new CardUIObject("6 of Spades", "6", 6, "Spades", 0, "Does Spades Stuff", this);
//		JPanel PlayerCardSlot9 = new JPanel();
//		PlayerCardSlot9 = P1Card9.InitializeCard();
//
//		CardUIObject P1Card10 = new CardUIObject("5 of Spades", "5", 5, "Spades", 0, "Does Spades Stuff", this);
//		JPanel PlayerCardSlot10 = new JPanel();
//		PlayerCardSlot10 = P1Card10.InitializeCard();
//		//P2CardSlots
			
		//DrawObject

		JPanel DrawTablePanel = new JPanel();
		DrawTablePanel = DrawTable.InitializeCard();

		DrawTablePanel.setBounds(80, 150, 150, 230);
		//DrawObject
		
		//Place Objects
		Lane1 = new PlacementUIObject(this);
		JPanel Place1Panel = new JPanel();
		Place1Panel = Lane1.InitializeCard();

		Place1Panel.setBounds(450, 150, 150, 230);
		
		Lane2 = new PlacementUIObject(this);
		JPanel Place2Panel = new JPanel();
		Place2Panel = Lane2.InitializeCard();

		Place2Panel.setBounds(610, 150, 150, 230);
		
		Lane3 = new PlacementUIObject(this);
		JPanel Place3Panel = new JPanel();
		Place3Panel = Lane3.InitializeCard();

		Place3Panel.setBounds(770, 150, 150, 230);
		//Place Objects
		
		
		

		P1CardPanel.setLayout(null);
		JScrollPane P1CardPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JPanel P2CardPanel = new JPanel();
		P2CardPanel.setLayout(null);
		JScrollPane P2CardPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			
		//P1 Card Slot Bounds
			P1CardPane.setBounds(30, 400, 1200, 250);
			
			//PlayerCardSlot1.setBounds(0, 0, 150, 230);
//			PlayerCardSlot2.setBounds(150, 0, 150, 230);
//			PlayerCardSlot3.setBounds(300, 0, 150, 230);
//			PlayerCardSlot4.setBounds(450, 0, 150, 230);
//			PlayerCardSlot5.setBounds(600, 0, 150, 230);
//			PlayerCardSlot6.setBounds(750, 0, 150, 230);
//			PlayerCardSlot7.setBounds(900, 0, 150, 230);
//			PlayerCardSlot8.setBounds(1050, 0, 150, 230);
//			PlayerCardSlot9.setBounds(1200, 0, 150, 230);
//			PlayerCardSlot10.setBounds(1350, 0, 150, 230);
		//P1 Card Slot Bounds
			
		//P2 Card Slot Bounds
			P2CardPane.setBounds(30, 10, 1200, 120);
			
//			Player2CardSlot1.setBounds(0, 0, 120, 100);
//			Player2CardSlot2.setBounds(120, 0, 120, 100);
//			Player2CardSlot3.setBounds(240, 0, 120, 100);
//			Player2CardSlot4.setBounds(360, 0, 120, 100);
//			Player2CardSlot5.setBounds(480, 0, 120, 100);
//			Player2CardSlot6.setBounds(600, 0, 120, 100);
//			Player2CardSlot7.setBounds(720, 0, 120, 100);
//			Player2CardSlot8.setBounds(840, 0, 120, 100);
//			Player2CardSlot9.setBounds(960, 0, 120, 100);
//			Player2CardSlot10.setBounds(1080, 0, 120, 100);
		//P2 Card Slot Bounds
		
		//P1 Add Cards
		//	P1CardPanel.add(PlayerCardSlot1);

//			P1CardPanel.add(PlayerCardSlot2);
//			P1CardPanel.add(PlayerCardSlot3);
//			P1CardPanel.add(PlayerCardSlot4);
//			P1CardPanel.add(PlayerCardSlot5);
//			P1CardPanel.add(PlayerCardSlot6);
//			P1CardPanel.add(PlayerCardSlot7);
//			P1CardPanel.add(PlayerCardSlot8);
//			P1CardPanel.add(PlayerCardSlot9);
//			P1CardPanel.add(PlayerCardSlot10);
		//P1 Add Cards
			
		//P2 Add Cards
//			P2CardPanel.add(Player2CardSlot1);
//			P2CardPanel.add(Player2CardSlot2);
//			P2CardPanel.add(Player2CardSlot3);
//			P2CardPanel.add(Player2CardSlot4);
//			P2CardPanel.add(Player2CardSlot5);
//			P2CardPanel.add(Player2CardSlot6);
//			P2CardPanel.add(Player2CardSlot7);
//			P2CardPanel.add(Player2CardSlot8);
//			P2CardPanel.add(Player2CardSlot9);
//			P2CardPanel.add(Player2CardSlot10);
		//P2 Add Cards
			
		P1CardPane.getViewport().add(P1CardPanel);
		P1CardPanel.setPreferredSize(new Dimension(150,250));

		
		P2CardPane.getViewport().add(P2CardPanel);
		P2CardPanel.setPreferredSize(new Dimension(1200, 250));
		


		CardGameFrame.getContentPane().add(ExitButton);
		
		CardGameFrame.getContentPane().add(P1UIPanel);
		CardGameFrame.getContentPane().add(P1CardPane);
		
		CardGameFrame.getContentPane().add(P2CardPane);
		CardGameFrame.getContentPane().add(P2UIPanel);
		
		CardGameFrame.getContentPane().add(DrawTablePanel);
		
		CardGameFrame.getContentPane().add(Place1Panel);
		CardGameFrame.getContentPane().add(Place2Panel);
		CardGameFrame.getContentPane().add(Place3Panel);
		
		
		// CardGameFrame.setVisible(true);

	}

	//initialize draw deck counter
	public void initializeDrawDeckCounter(){
		JPanel DrawCounter = new JPanel();
		count = new JLabel(""+DrawTable.deck.size());
		JLabel counter = new JLabel("Cards Left");
		DrawCounter.add(count);
		DrawCounter.add(counter);
		DrawCounter.setBounds(240, 300, 100, 40);
		CardGameFrame.getContentPane().add(DrawCounter);
		CardGameFrame.repaint();


	}
	public void refreshDrawDeckCounter(){
		System.out.println("refreshdrawdeckcounter");
		count.setText(""+DrawTable.deck.size());
		CardGameFrame.revalidate();
		CardGameFrame.repaint();
	}
	//Creates a new CardIU object and ads it to P1CardPanel for every card in P1CardList
	public void generateP1Cards(){
		int cardSlotBound=0;
		P1CardPanel.removeAll();
		for(Card e:P1CardList){
			CardUIObject newCard = new CardUIObject(e,this);
			JPanel PlayerCardSlot = newCard.InitializeCard();
			PlayerCardSlot.setBounds(cardSlotBound, 0, 150, 230);
			P1CardPanel.add(PlayerCardSlot);
			cardSlotBound+=150;
			P1CardPanel.setPreferredSize(new Dimension(cardSlotBound,250));
		}
		P1CardPanel.revalidate();
		P1CardPanel.repaint();


	}
	
	public class ExitBttnListener implements ActionListener{

		public void actionPerformed(ActionEvent Click) {
			System.out.println("Exiting to Main Menu");
			
			CardGameFrame.setVisible(false);
			MainMenu.MainMenuFrame.setVisible(true);

		}

	}
	


	
}
