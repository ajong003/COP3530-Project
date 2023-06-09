package GUI;

import Main.Card;
import Main.CardList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class User_Interface {

	MainMenuUI MainMenu;

	String PlayerName = "Player";
	int CurrentCardSlots = 0;
	JLabel PlayerNameLabel = new JLabel(PlayerName);
	JLabel Player2NameLabel = new JLabel("CPU");
	JLabel HPLabel1 = new JLabel("HP:");
	JLabel HPLabel2 = new JLabel("HP:");
	JLabel P1HPLabel = new JLabel("100 / 100");
	JLabel P2HPLabel = new JLabel("100 / 100");
	JLabel uLost = new JLabel("You Lost");
	JLabel uWin = new JLabel("You Win!");
	
	JButton ExitButton = new JButton("Exit");
	JFrame CardGameFrame = new JFrame();
	JPanel P1CardPanel = new JPanel();
	//Draw deck object
	public DrawUIObject DrawTable=new DrawUIObject();

	public CardList<Card> P1CardList;

	public CardList<Card> CPUCardList;

	public CardUIObject P1SelectedCard;

	public boolean isCardSelected;

	public PlacementUIObject Lane1, Lane2, Lane3;

	ExitBttnListener ExitBttnListen = new ExitBttnListener();

	JLabel  count;

	public boolean laneMatch = false;

	JPanel P2UIPanel;

	JPanel P1UIPanel;

	public int P1HP;
	public int P2HP;

	JPanel CPUCardPanel;





	//Draw deck object



	public User_Interface(){

	}

	public void setP1CardList(CardList<Card> list){
		P1CardList=list;
	}
	public void setCPUCardList(CardList<Card> list){
		CPUCardList=list;
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
		
		
		//Font Changes
		PlayerNameLabel.setFont(new Font("Serif",Font.BOLD,20));
		HPLabel1.setFont(new Font("Serif",Font.BOLD,20));
		P1HPLabel.setFont(new Font("Serif",Font.BOLD,20));
		//Color
		Color DarkRedP1 = new Color(180, 0, 50);
		Color DarkRedP2 = new Color(180, 0, 150);
		
		PlayerNameLabel.setForeground(DarkRedP1);
		HPLabel1.setForeground(DarkRedP1);
		P1HPLabel.setForeground(DarkRedP1);
		
		Player2NameLabel.setFont(new Font("Serif",Font.BOLD,20));
		HPLabel2.setFont(new Font("Serif",Font.BOLD,20));
		P2HPLabel.setFont(new Font("Serif",Font.BOLD,20));
		
		Player2NameLabel.setForeground(DarkRedP2);
		HPLabel2.setForeground(DarkRedP2);
		P2HPLabel.setForeground(DarkRedP2);
		
		
		
		P1UIPanel = new JPanel();
			P1UIPanel.add(PlayerNameLabel);
			P1UIPanel.add(HPLabel1);
			P1UIPanel.add(P1HPLabel);
		P1UIPanel.setBounds(1000, 340, 200, 50);
			
			
		
		P2UIPanel = new JPanel();
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

//		CardUIObject P2Card1 = new CardUIObject("King of Spades","K", 0, "Spades", 5, "Does Spades Stuff");
//		JPanel Player2CardSlot1 = new JPanel();
//		Player2CardSlot1 = P2Card1.InitializeCard();
//		Player2CardSlot1 = P2Card1.HideCard();

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
		Lane1.PlaceCardBttn.setName("Lane1");

		Place1Panel.setBounds(450, 150, 150, 230);
		
		Lane2 = new PlacementUIObject(this);
		JPanel Place2Panel = new JPanel();
		Place2Panel = Lane2.InitializeCard();
		Lane2.PlaceCardBttn.setName("Lane2");

		Place2Panel.setBounds(610, 150, 150, 230);
		
		Lane3 = new PlacementUIObject(this);
		JPanel Place3Panel = new JPanel();
		Place3Panel = Lane3.InitializeCard();
		Lane3.PlaceCardBttn.setName("Lane3");

		Place3Panel.setBounds(770, 150, 150, 230);
		//Place Objects
		
		
		

		P1CardPanel.setLayout(null);
		JScrollPane P1CardPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		CPUCardPanel = new JPanel();
		CPUCardPanel.setLayout(null);
		JScrollPane CPUCardPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			
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
			CPUCardPane.setBounds(30, 10, 1200, 120);
			
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

		
		CPUCardPane.getViewport().add(CPUCardPanel);
		CPUCardPanel.setPreferredSize(new Dimension(150, 250));
		


		CardGameFrame.getContentPane().add(ExitButton);
		
		CardGameFrame.getContentPane().add(P1UIPanel);
		CardGameFrame.getContentPane().add(P1CardPane);
		
		CardGameFrame.getContentPane().add(CPUCardPane);
		CardGameFrame.getContentPane().add(P2UIPanel);
		
		CardGameFrame.getContentPane().add(DrawTablePanel);
		
		CardGameFrame.getContentPane().add(Place1Panel);
		CardGameFrame.getContentPane().add(Place2Panel);
		CardGameFrame.getContentPane().add(Place3Panel);
		
		
		//CardGameFrame.setVisible(true);

	}

	//initialize draw deck counter
	public void initializeDrawDeckCounter(){
		JPanel DrawCounter = new JPanel();
		count = new JLabel(""+DrawTable.deck.size());
		JLabel counter = new JLabel("Cards Left");
		
		count.setFont(new Font("Serif",Font.BOLD,15));
		counter.setFont(new Font("Serif",Font.BOLD,15));
		
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
	public void generateP1Cards(int index) {
		int cardSlotBound = 0;
		CardUIObject highLightCard = null;
		P1CardPanel.removeAll();
		for (int i = 0; i < P1CardList.size(); i++) {
			Card e = P1CardList.get(i);
			CardUIObject newCard = new CardUIObject(e, this);
			//if index matches highlighted card store reference to highlighted card UI objected

			if (i == index) {
				highLightCard = newCard;
			}

			JPanel PlayerCardSlot = newCard.InitializeCard();
			PlayerCardSlot.setBounds(cardSlotBound, 0, 150, 230);
			P1CardPanel.add(PlayerCardSlot);
			cardSlotBound += 150;
			P1CardPanel.setPreferredSize(new Dimension(cardSlotBound, 250));
		}
//		for(Card e:P1CardList){
//			CardUIObject newCard = new CardUIObject(e,this);
//			JPanel PlayerCardSlot = newCard.InitializeCard();
//			PlayerCardSlot.setBounds(cardSlotBound, 0, 150, 230);
//			P1CardPanel.add(PlayerCardSlot);
//			cardSlotBound+=150;
//			P1CardPanel.setPreferredSize(new Dimension(cardSlotBound,250));
//		}
		if (highLightCard != null) {
			highLightCard.HighlightCard();

//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//
//			}

			//highLightCard.UnselectCard();
		}
		P1CardPanel.revalidate();
		P1CardPanel.repaint();


	}
	public void generateCPUCards(){
		int cardSlotBound = 0;
		CPUCardPanel.removeAll();
		for (int i = 0; i < CPUCardList.size(); i++) {
			Card e = CPUCardList.get(i);
			CardUIObject newCard = new CardUIObject(e, this);

			newCard.InitializeCard();
			e.registerCardUIObject(newCard);
			//JPanel PlayerCardSlot = newCard.InitializeCard();
			JPanel PlayerCardSlot=newCard.HideCard();

			PlayerCardSlot.setBounds(cardSlotBound, 0, 120, 117);
			CPUCardPanel.add(PlayerCardSlot);
			cardSlotBound += 120;
			CPUCardPanel.setPreferredSize(new Dimension(cardSlotBound, 100));
		}
	}
//		P1CardPanel.revalidate();
//		P1CardPanel.repaint();

	public void PlayerLost(){
		CardGameFrame.setVisible(false);
		JFrame PlayerLost = new JFrame();
		
		JPanel Lost = new JPanel();
		
		PlayerLost.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PlayerLost.setLayout(null);
		
		PlayerLost.setTitle("Jack of All Trades");
		
		PlayerLost.setSize(1280,720);
		
		Lost.setBounds(445, 200, 400, 400);
		uLost.setFont(new Font("Serif",Font.BOLD,80));
		Color DarkRed = new Color(180, 0, 50);
		
		uLost.setForeground(DarkRed);
		PlayerLost.setLayout(null);
		
		
		Lost.add(uLost);
		
		PlayerLost.getContentPane().add(Lost);
		
		PlayerLost.setVisible(true);
		
	}
	public void PlayerWon(){
		CardGameFrame.setVisible(false);
		JFrame PlayerWon = new JFrame();
		
		JPanel Won = new JPanel();
		
		PlayerWon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PlayerWon.setLayout(null);
		
		PlayerWon.setTitle("Jack of All Trades");
		
		PlayerWon.setSize(1280,720);
		
		Won.setBounds(445, 200, 400, 400);
		uWin.setFont(new Font("Serif",Font.BOLD,80));
		Color DarkGreen = new Color(0, 180, 50);
		
		uWin.setForeground(DarkGreen);
		
		PlayerWon.setLayout(null);
		
		
		Won.add(uWin);
		
		PlayerWon.getContentPane().add(Won);
		
		PlayerWon.setVisible(true);
		
	}


	public void refreshHPPanels(int p1hp, int p2hp){
		P1HP=p1hp;
		P2HP=p2hp;
		P1HPLabel.setText(p1hp+" / 100");
		P2HPLabel.setText(p2hp+" / 100");
		P1UIPanel.revalidate();
		P1UIPanel.repaint();
		P2UIPanel.revalidate();
		P2UIPanel.repaint();
	}
	public class ExitBttnListener implements ActionListener {

		public void actionPerformed(ActionEvent Click) {
			System.out.println("Exit Button Pressed");
			CardGameFrame.setVisible(false);
			MainMenu.MainMenuFrame.setVisible(true);

		}
	}



	
}
