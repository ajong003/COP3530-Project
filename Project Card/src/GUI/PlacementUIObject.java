package GUI;

import MAIN.Card;
import MAIN.Deck;
import MAIN.JackOfAllTrades;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PlacementUIObject {

	public JButton PlaceCardBttn;
	JPanel CardPanel;
	Border blackline;
	TitledBorder title;

	public User_Interface UI;
	PlacementUIObject self = this;


	public String CardName, basicValue;
	public String Suite;
	public String Description;
	public int cardValue, specialValue;

	JLabel cardSuiteLabel, basicValueLabel, HiddenLabel, cardDescriptionLabel;


	BorderLayout BorderLay = new BorderLayout();
	GridLayout GridLay = new GridLayout();

	public Deck<Card> lane;


	public PlacementUIObject(User_Interface UI) {

		this.UI = UI;
	}
	public JPanel InitializeCard(){

		ActivateCardListener DrawCardListen = new ActivateCardListener();

		cardSuiteLabel = new JLabel("" + Suite);
		basicValueLabel = new JLabel("" + basicValue);

		HiddenLabel = new JLabel("?");
		cardDescriptionLabel = new JLabel("" + Description);
		PlaceCardBttn = new JButton("Place");

		CardPanel = new JPanel();

		blackline = BorderFactory.createLineBorder(Color.black);
		CardPanel.setBackground(Color.white);




		title = BorderFactory.createTitledBorder(blackline, "");
		title.setTitleJustification(TitledBorder.CENTER);


		CardPanel.setLayout(GridLay);
		CardPanel.setBorder(title);

		CardPanel.add(PlaceCardBttn);

		PlaceCardBttn.setLayout(BorderLay);

		HiddenLabel.setVisible(false);

		cardDescriptionLabel.setVisible(false);
		basicValueLabel.setVisible(false);
		cardSuiteLabel.setVisible(false);



		PlaceCardBttn.addActionListener(DrawCardListen);

		PlaceCardBttn.setBackground(Color.GRAY);
		PlaceCardBttn.setForeground(Color.WHITE);

		PlaceCardBttn.setFocusable(false);

		PlaceCardBttn.add(cardSuiteLabel, BorderLayout.SOUTH);
		PlaceCardBttn.add(basicValueLabel, BorderLayout.NORTH);
		PlaceCardBttn.add(HiddenLabel, BorderLayout.CENTER);

		PlaceCardBttn.setBounds(0, 0, CardPanel.getWidth(), CardPanel.getHeight());
		PlaceCardBttn.add(cardDescriptionLabel, BorderLayout.CENTER);

		return(CardPanel);
	}

	public JPanel PlaceCard(CardUIObject Card) {

		PlaceCardBttn.setLayout(BorderLay);

		PlaceCardBttn.setText("");
		PlaceCardBttn.setBackground(Color.white);


		cardDescriptionLabel.setVisible(true);
		basicValueLabel.setVisible(true);
		cardSuiteLabel.setVisible(true);

		title = BorderFactory.createTitledBorder(blackline, "" + CardName);
		title.setTitleJustification(TitledBorder.CENTER);
		PlaceCardBttn.setBorder(title);

		CardName = Card.CardName;
		this.Suite = Card.Suite;
		this.cardValue = Card.cardValue;
		this.specialValue = Card.specialValue;
		this.Description = Card.Description;
		this.basicValue = Card.basicValue;

		cardSuiteLabel.setText("" + Suite);
		basicValueLabel.setText("" + basicValue);
		cardDescriptionLabel.setText("" + Description);

		title.setTitle("" + CardName);

		CardPanel.setVisible(true);



		return(CardPanel);
	}

	public void registerlane(Deck<Card> lane){
		this.lane=lane;
	}

	public void registerButton(JackOfAllTrades.PlaceButton button){
		PlaceCardBttn.addActionListener(button);
	}


	public class ActivateCardListener implements ActionListener{

		public void actionPerformed(ActionEvent Click) {

			if (UI.isCardSelected == true) {

				if(lane.isEmpty()|| UI.P1SelectedCard.card.getRank()==lane.peek().getRank() || UI.P1SelectedCard.card.getSuite().equals(lane.peek().getSuite())){
					PlaceCard(UI.P1SelectedCard);
					//UI.P1SelectedCard.ClearCard();
					UI.isCardSelected = false;

					//add card to logical linked lane
					lane.push(UI.P1SelectedCard.card);
					System.out.println("lane after adding");
					System.out.println(lane);
				}

			}
			else {
				//No Card Selected
			}


		}

	}

	
	
}
