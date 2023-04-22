package GUI;

import MAIN.Card;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardUIObject {

	//card object the UI object represents
	public Card card;
	public User_Interface UI;
	public String CardName, basicValue;
	public String Suite;
	JButton SelectCard;
	Border blackline, selectedLine,highlightedLine;
	public String Description;
	public int cardValue, specialValue;

	CardUIObject self = this;
	
	JLabel cardSuiteLabel, basicValueLabel, HiddenLabel, cardDescriptionLabel;
	JButton ActivateCard;
	JPanel CardPanel;

    TitledBorder title;
    
    BorderLayout BorderLay = new BorderLayout();
    GridLayout GridLay = new GridLayout();
    
	
	//get values from actual card object
	public CardUIObject(Card card,User_Interface UI) {
		this.card=card;
		CardName = card.toString();
		this.Suite = card.getSuite();
		//actual rank in integer
		this.cardValue = card.getRank();
		this.specialValue = specialValue;
		this.UI=UI;

		this.Description = card.getDescription();

		//display Rank character (Q, K, 10, 9 etc)
		this.basicValue=String.valueOf(card.toString().charAt(0));
//		if(card.getRank()<1 && card.getRank()>10){
//			this.basicValue = String.valueOf(card.toString().charAt(0));
//		}else{
//			this.basicValue = card.toString().substring(0,2);
//		}

	}

//	public CardUIObject(String cardName, String basicValue, int cardValue, String suite, int specialValue, String Description) {
//		CardName = cardName;
//		this.Suite = suite;
//		this.cardValue = cardValue;
//		this.specialValue = specialValue;
//		this.Description = Description;
//		this.basicValue = basicValue;
//	}
	public JPanel InitializeCard(){


		SelectCardListener SelectCardListen = new SelectCardListener();
		cardSuiteLabel = new JLabel("" + Suite);
		basicValueLabel = new JLabel("" + basicValue);

		HiddenLabel = new JLabel("?");
		cardDescriptionLabel = new JLabel("" + Description);
		SelectCard = new JButton("");
		CardPanel = new JPanel();


		blackline = BorderFactory.createLineBorder(Color.black);
		selectedLine = BorderFactory.createLineBorder(Color.orange);
		highlightedLine = BorderFactory.createLineBorder(Color.green);
		CardPanel.setBackground(Color.white);
		SelectCard.setBackground(Color.white);



		title = BorderFactory.createTitledBorder(blackline, "" + CardName);
		title.setTitleJustification(TitledBorder.CENTER);

		CardPanel.setLayout(GridLay);
		CardPanel.add(SelectCard);

		SelectCard.setLayout(BorderLay);
		SelectCard.setBorder(title);

		SelectCard.add(cardSuiteLabel, BorderLayout.SOUTH);
		SelectCard.add(basicValueLabel, BorderLayout.NORTH);
		SelectCard.add(HiddenLabel, BorderLayout.CENTER);

		SelectCard.setBounds(0, 0, CardPanel.getWidth(), CardPanel.getHeight());
		SelectCard.add(cardDescriptionLabel, BorderLayout.CENTER);
		SelectCard.addActionListener(SelectCardListen);
		HiddenLabel.setVisible(false);

		return(CardPanel);
	}


	//Makes a card Hidden [With the ? Symbol]
	public JPanel HideCard() {

		SelectCard.setLayout(GridLay);

		HiddenLabel.setVisible(true);

		cardDescriptionLabel.setVisible(false);
		basicValueLabel.setVisible(false);
		cardSuiteLabel.setVisible(false);


		title = BorderFactory.createTitledBorder(blackline, "");
		SelectCard.setBorder(title);

		SelectCard.setEnabled(false);


		return(CardPanel);
	}

	//Reveals a Hidden Card
	public JPanel RevealCard() {


		SelectCard.setLayout(BorderLay);

		HiddenLabel.setVisible(false);

		cardDescriptionLabel.setVisible(true);
		basicValueLabel.setVisible(true);
		cardSuiteLabel.setVisible(true);

		title = BorderFactory.createTitledBorder(blackline, "" + CardName);
		SelectCard.setBorder(title);

		SelectCard.setEnabled(true);

		return(CardPanel);
	}

	//Clears a Card visually and Hides it Completely
	public JPanel ClearCard() {

		CardPanel.setVisible(false);


		return(CardPanel);
	}
	public void HighlightCard(){
		title = BorderFactory.createTitledBorder(highlightedLine, "" + CardName);
		title.setTitleJustification(TitledBorder.CENTER);
		SelectCard.setBorder(title);
	}

	public void SelectCard() {
		title = BorderFactory.createTitledBorder(selectedLine, "" + CardName);
		title.setTitleJustification(TitledBorder.CENTER);
		SelectCard.setBorder(title);
	}

	public void UnselectCard() {
		title = BorderFactory.createTitledBorder(blackline, "" + CardName);
		title.setTitleJustification(TitledBorder.CENTER);
		SelectCard.setBorder(title);
	}
	
	public class ActivateCardListener implements ActionListener{
		
		   public void actionPerformed(ActionEvent Click) {
			   
		   }
	}
	//Reinitializes a card with all new values [Used for Card Slots]
	public JPanel ReInitializeCard(String cardName, String basicValue, int cardValue, String suite, int specialValue, String Description) {

		CardName = cardName;
		this.Suite = suite;
		this.cardValue = cardValue;
		this.specialValue = specialValue;
		this.Description = Description;
		this.basicValue = basicValue;

		cardSuiteLabel.setText("" + Suite);
		basicValueLabel.setText("" + basicValue);
		cardDescriptionLabel.setText("" + Description);

		title.setTitle("" + CardName);

		CardPanel.setVisible(true);



		return(CardPanel);
	}
	public class SelectCardListener implements ActionListener{

		public void actionPerformed(ActionEvent Click) {

			if (UI.isCardSelected == true) {
				UI.P1SelectedCard.UnselectCard();
				UI.P1SelectedCard = self;
				UI.isCardSelected = true;
				SelectCard();
			}
			else {
				UI.P1SelectedCard = self;
				UI.isCardSelected = true;
				SelectCard();
			}

		}

	}
	
	
}
