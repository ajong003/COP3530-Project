package GUI;

import Main.Card;
import Main.Deck;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class DrawUIObject {

	//asociated deck object
	public Deck<Card> deck;

	public JPanel InitializeCard(){
		
		ActivateCardListener DrawCardListen = new ActivateCardListener();
		
		
		JButton DrawCardBttn = new JButton("Draw");
	    JPanel CardPanel = new JPanel();
	    Border blackline;
	    blackline = BorderFactory.createLineBorder(Color.black);
	    CardPanel.setBackground(Color.white);
	    
	    TitledBorder title;
	    
	    
	    
	    title = BorderFactory.createTitledBorder(blackline, "");
	    title.setTitleJustification(TitledBorder.CENTER);
	    
	    
	    CardPanel.setLayout(new BorderLayout());
	    CardPanel.setBorder(title);

	    CardPanel.add(DrawCardBttn, BorderLayout.CENTER);
	    
	    
	    DrawCardBttn.addActionListener(DrawCardListen);
	    
	    DrawCardBttn.setBackground(Color.GRAY);
	    DrawCardBttn.setForeground(Color.WHITE);
		
	    DrawCardBttn.setFocusable(false);
	       
	       
	       
	       return(CardPanel);
	}


	//sets the deck to display
	public void setDeck(Deck<Card> deck){
		this.deck=deck;
	}

	public Deck<Card> getDeck(){
		return deck;
	}

	
	
	
	//transfer top card from associated deck to player card list
	public class ActivateCardListener implements ActionListener{
		   public void actionPerformed(ActionEvent Click) {
			   System.out.println("test");
		   }
	}

	
}
