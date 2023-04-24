package GUI;

import MAIN.Card;
import MAIN.Deck;
import MAIN.JackOfAllTrades;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class DrawUIObject {

	//associated deck object
	public Deck<Card> deck;
	JButton DrawCardButton;




	public JPanel InitializeCard(){
		



		
		DrawCardButton = new JButton("Draw");
	    JPanel CardPanel = new JPanel();
	    Border blackline;
	    blackline = BorderFactory.createLineBorder(Color.black);
	    CardPanel.setBackground(Color.white);
	    
	    TitledBorder title;
	    
	    
	    
	    title = BorderFactory.createTitledBorder(blackline, "");
	    title.setTitleJustification(TitledBorder.CENTER);
	    
	    
	    CardPanel.setLayout(new BorderLayout());
	    CardPanel.setBorder(title);

	    CardPanel.add(DrawCardButton, BorderLayout.CENTER);
	    
	    

	    
	    DrawCardButton.setBackground(Color.GRAY);
	    DrawCardButton.setForeground(Color.WHITE);
		
	    DrawCardButton.setFocusable(false);
	       

	       
	       return(CardPanel);
	}
	public void registerButton(JackOfAllTrades.DrawButton button){
		DrawCardButton.addActionListener(button);
	}

	//sets the deck to display
	public void setDeck(Deck<Card> deck){
		this.deck=deck;
	}

	public Deck<Card> getDeck(){
		return deck;
	}

	
	
	
	//transfer top card from associated deck to player card list


	
}
