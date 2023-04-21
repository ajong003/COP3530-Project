package GUI;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class User_Interface {

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

	//Draw deck object
	public DrawUIObject DrawTable=new DrawUIObject();
	
	
	public void InitializeUI(){

		
		CardGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CardGameFrame.setLayout(null);
		
		CardGameFrame.setTitle("Jack of All Trades");
		
		CardGameFrame.setSize(1280,720);
		
		ExitButton.setBounds(5, 655, 80, 20);
		ExitButton.setFocusable(false);
		
		
		
		JPanel P1UIPanel = new JPanel();
			P1UIPanel.add(PlayerNameLabel);
			P1UIPanel.add(HPLabel1);
			P1UIPanel.add(P1HPLabel);
		P1UIPanel.setBounds(1000, 360, 200, 20);
			
			
		
		JPanel P2UIPanel = new JPanel();
			P2UIPanel.add(Player2NameLabel);
			P2UIPanel.add(HPLabel2);
			P2UIPanel.add(P2HPLabel);
		P2UIPanel.setBounds(1000, 140, 200, 50);
				
		
		//P1CardSlots
			CardUIObject P1Card1 = new CardUIObject("King of Spades","K", 0, "Spades", 5, "Does Spades Stuff");
			JPanel PlayerCardSlot1 = new JPanel();
			PlayerCardSlot1 = P1Card1.InitializeCard();
			
			
			CardUIObject P1Card2 = new CardUIObject("Queen of Spades","Q", 0, "Spades", 6, "Does Spades Stuff");
			JPanel PlayerCardSlot2 = new JPanel();
			PlayerCardSlot2 = P1Card2.InitializeCard();
			
			CardUIObject P1Card3 = new CardUIObject("Ace of Spades","A", 0, "Spades", 7, "Does Spades Stuff");
			JPanel PlayerCardSlot3 = new JPanel();
			PlayerCardSlot3 = P1Card3.InitializeCard();
			
			CardUIObject P1Card4 = new CardUIObject("Jack of Spades","J", 0, "Spades", 8, "Does Spades Stuff");
			JPanel PlayerCardSlot4 = new JPanel();
			PlayerCardSlot4 = P1Card4.InitializeCard();
			
			CardUIObject P1Card5 = new CardUIObject("10 of Spades","10", 10, "Spades", 0, "Does Spades Stuff");
			JPanel PlayerCardSlot5 = new JPanel();
			PlayerCardSlot5 = P1Card5.InitializeCard();
			
			CardUIObject P1Card6 = new CardUIObject("9 of Spades", "9", 9, "Spades", 0, "Does Spades Stuff");
			JPanel PlayerCardSlot6 = new JPanel();
			PlayerCardSlot6 = P1Card6.InitializeCard();
			
			CardUIObject P1Card7 = new CardUIObject("8 of Spades", "8", 8, "Spades", 0, "Does Spades Stuff");
			JPanel PlayerCardSlot7 = new JPanel();
			PlayerCardSlot7 = P1Card7.InitializeCard();
			
			CardUIObject P1Card8 = new CardUIObject("7 of Spades", "7", 7, "Spades", 0, "Does Spades Stuff");
			JPanel PlayerCardSlot8 = new JPanel();
			PlayerCardSlot8 = P1Card8.InitializeCard();
			
			CardUIObject P1Card9 = new CardUIObject("6 of Spades", "6", 6, "Spades", 0, "Does Spades Stuff");
			JPanel PlayerCardSlot9 = new JPanel();
			PlayerCardSlot9 = P1Card9.InitializeCard();
			
			CardUIObject P1Card10 = new CardUIObject("5 of Spades", "5", 5, "Spades", 0, "Does Spades Stuff");
			JPanel PlayerCardSlot10 = new JPanel();
			PlayerCardSlot10 = P1Card10.InitializeCard();
		//P1Card Slots
		
		
		
		//P2CardSlots
			CardUIObject P2Card1 = new CardUIObject("King of Spades","K", 0, "Spades", 5, "Does Spades Stuff");
			JPanel Player2CardSlot1 = new JPanel();
			Player2CardSlot1 = P2Card1.InitializeCard();
			Player2CardSlot1 = P2Card1.HideCard();
			
			CardUIObject P2Card2 = new CardUIObject("Queen of Spades","Q", 0, "Spades", 6, "Does Spades Stuff");
			JPanel Player2CardSlot2 = new JPanel();
			Player2CardSlot2 = P2Card2.InitializeCard();
			Player2CardSlot2 = P2Card2.HideCard();
			
			CardUIObject P2Card3 = new CardUIObject("Ace of Spades","A", 0, "Spades", 7, "Does Spades Stuff");
			JPanel Player2CardSlot3 = new JPanel();
			Player2CardSlot3 = P2Card3.InitializeCard();
			Player2CardSlot3 = P2Card3.HideCard();
			
			CardUIObject P2Card4 = new CardUIObject("Jack of Spades","J", 0, "Spades", 8, "Does Spades Stuff");
			JPanel Player2CardSlot4 = new JPanel();
			Player2CardSlot4 = P2Card4.InitializeCard();
			Player2CardSlot4 = P2Card4.HideCard();
			
			CardUIObject P2Card5 = new CardUIObject("10 of Spades","10", 10, "Spades", 0, "Does Spades Stuff");
			JPanel Player2CardSlot5 = new JPanel();
			Player2CardSlot5 = P2Card5.InitializeCard();
			Player2CardSlot5 = P2Card5.HideCard();
			
			CardUIObject P2Card6 = new CardUIObject("9 of Spades", "9", 9, "Spades", 0, "Does Spades Stuff");
			JPanel Player2CardSlot6 = new JPanel();
			Player2CardSlot6 = P2Card6.InitializeCard();
			Player2CardSlot6 = P2Card6.HideCard();
			
			CardUIObject P2Card7 = new CardUIObject("8 of Spades", "8", 8, "Spades", 0, "Does Spades Stuff");
			JPanel Player2CardSlot7 = new JPanel();
			Player2CardSlot7 = P2Card7.InitializeCard();
			Player2CardSlot7 = P2Card7.HideCard();
			
			CardUIObject P2Card8 = new CardUIObject("7 of Spades", "7", 7, "Spades", 0, "Does Spades Stuff");
			JPanel Player2CardSlot8 = new JPanel();
			Player2CardSlot8 = P2Card8.InitializeCard();
			Player2CardSlot8 = P2Card8.HideCard();
			
			CardUIObject P2Card9 = new CardUIObject("6 of Spades", "6", 6, "Spades", 0, "Does Spades Stuff");
			JPanel Player2CardSlot9 = new JPanel();
			Player2CardSlot9 = P2Card9.InitializeCard();
			Player2CardSlot9 = P2Card9.HideCard();
			
			CardUIObject P2Card10 = new CardUIObject("5 of Spades", "5", 5, "Spades", 0, "Does Spades Stuff");
			JPanel Player2CardSlot10 = new JPanel();
			Player2CardSlot10 = P2Card10.InitializeCard();
			Player2CardSlot10 = P2Card10.HideCard();
		//P2CardSlots
			
		//DrawObject

		JPanel DrawTablePanel = new JPanel();
		DrawTablePanel = DrawTable.InitializeCard();

		DrawTablePanel.setBounds(80, 150, 150, 230);
		//DrawObject
		
		//Place Objects
		PlacementUIObject Place1 = new PlacementUIObject();
		JPanel Place1Panel = new JPanel();
		Place1Panel = Place1.InitializeCard();

		Place1Panel.setBounds(450, 150, 150, 230);
		
		PlacementUIObject Place2 = new PlacementUIObject();
		JPanel Place2Panel = new JPanel();
		Place2Panel = Place2.InitializeCard();

		Place2Panel.setBounds(610, 150, 150, 230);
		
		PlacementUIObject Place3 = new PlacementUIObject();
		JPanel Place3Panel = new JPanel();
		Place3Panel = Place3.InitializeCard();

		Place3Panel.setBounds(770, 150, 150, 230);
		//Place Objects
		
		
		
		JPanel P1CardPanel = new JPanel();
		P1CardPanel.setLayout(null);
		JScrollPane P1CardPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JPanel P2CardPanel = new JPanel();
		P2CardPanel.setLayout(null);
		JScrollPane P2CardPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			
		//P1 Card Slot Bounds
			P1CardPane.setBounds(30, 400, 1200, 250);
			
			PlayerCardSlot1.setBounds(0, 0, 150, 230);
			PlayerCardSlot2.setBounds(150, 0, 150, 230);
			PlayerCardSlot3.setBounds(300, 0, 150, 230);
			PlayerCardSlot4.setBounds(450, 0, 150, 230);
			PlayerCardSlot5.setBounds(600, 0, 150, 230);
			PlayerCardSlot6.setBounds(750, 0, 150, 230);
			PlayerCardSlot7.setBounds(900, 0, 150, 230);
			PlayerCardSlot8.setBounds(1050, 0, 150, 230);
			PlayerCardSlot9.setBounds(1200, 0, 150, 230);
			PlayerCardSlot10.setBounds(1350, 0, 150, 230);
		//P1 Card Slot Bounds
			
		//P2 Card Slot Bounds
			P2CardPane.setBounds(30, 10, 1200, 120);
			
			Player2CardSlot1.setBounds(0, 0, 120, 100);
			Player2CardSlot2.setBounds(120, 0, 120, 100);
			Player2CardSlot3.setBounds(240, 0, 120, 100);
			Player2CardSlot4.setBounds(360, 0, 120, 100);
			Player2CardSlot5.setBounds(480, 0, 120, 100);
			Player2CardSlot6.setBounds(600, 0, 120, 100);
			Player2CardSlot7.setBounds(720, 0, 120, 100);
			Player2CardSlot8.setBounds(840, 0, 120, 100);
			Player2CardSlot9.setBounds(960, 0, 120, 100);
			Player2CardSlot10.setBounds(1080, 0, 120, 100);
		//P2 Card Slot Bounds
		
		//P1 Add Cards
			P1CardPanel.add(PlayerCardSlot1);
			P1CardPanel.add(PlayerCardSlot2);
			P1CardPanel.add(PlayerCardSlot3);
			P1CardPanel.add(PlayerCardSlot4);
			P1CardPanel.add(PlayerCardSlot5);
			P1CardPanel.add(PlayerCardSlot6);
			P1CardPanel.add(PlayerCardSlot7);
			P1CardPanel.add(PlayerCardSlot8);
			P1CardPanel.add(PlayerCardSlot9);
			P1CardPanel.add(PlayerCardSlot10);
		//P1 Add Cards
			
		//P2 Add Cards
			P2CardPanel.add(Player2CardSlot1);
			P2CardPanel.add(Player2CardSlot2);
			P2CardPanel.add(Player2CardSlot3);
			P2CardPanel.add(Player2CardSlot4);
			P2CardPanel.add(Player2CardSlot5);
			P2CardPanel.add(Player2CardSlot6);
			P2CardPanel.add(Player2CardSlot7);
			P2CardPanel.add(Player2CardSlot8);
			P2CardPanel.add(Player2CardSlot9);
			P2CardPanel.add(Player2CardSlot10);
		//P2 Add Cards
			
		P1CardPane.getViewport().add(P1CardPanel);
		P1CardPanel.setPreferredSize(new Dimension(1500, 250));
		
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
		
		
		CardGameFrame.setVisible(true);

	}


	
}
