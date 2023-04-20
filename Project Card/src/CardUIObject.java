
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

	public String CardName, basicValue;
	public String Suite;
	public String Description;
	public int cardValue, specialValue;
	
	JLabel cardSuiteLabel, basicValueLabel, HiddenLabel, cardDescriptionLabel;
	JButton ActivateCard;
	JPanel CardPanel;
    Border blackline;
    TitledBorder title;
    
    BorderLayout BorderLay = new BorderLayout();
    GridLayout GridLay = new GridLayout();
    
	
	
	public CardUIObject(String cardName, String basicValue, int cardValue, String suite, int specialValue, String Description) {
		CardName = cardName;
		this.Suite = suite;
		this.cardValue = cardValue;
		this.specialValue = specialValue;
		this.Description = Description;
		this.basicValue = basicValue;
	}
	

	public JPanel InitializeCard(){
		
		ActivateCardListener ActivateCardListen = new ActivateCardListener();
		
		cardSuiteLabel = new JLabel("" + Suite);
		basicValueLabel = new JLabel("" + basicValue);
		
		HiddenLabel = new JLabel("?");
		cardDescriptionLabel = new JLabel("" + Description);
		ActivateCard = new JButton("Use Card");
	    CardPanel = new JPanel();
	    blackline = BorderFactory.createLineBorder(Color.black);
	    CardPanel.setBackground(Color.white);
	    
	    
	    
	    title = BorderFactory.createTitledBorder(blackline, "" + CardName);
	    title.setTitleJustification(TitledBorder.CENTER);
	    
	    
	    CardPanel.setLayout(BorderLay);
	    CardPanel.setBorder(title);

	       CardPanel.add(cardSuiteLabel, BorderLayout.SOUTH);
	       CardPanel.add(basicValueLabel, BorderLayout.NORTH);
	       CardPanel.add(HiddenLabel, BorderLayout.CENTER);
	       CardPanel.add(cardDescriptionLabel, BorderLayout.CENTER);
	       ActivateCard.addActionListener(ActivateCardListen);
	       
		HiddenLabel.setVisible(false);
		
	       return(CardPanel);
	}
	
	
	
	public JPanel HideCard() {
		
		CardPanel.setLayout(GridLay);
		
		HiddenLabel.setVisible(true);
		
		cardDescriptionLabel.setVisible(false);
		basicValueLabel.setVisible(false);
		cardSuiteLabel.setVisible(false);
		
		
		title = BorderFactory.createTitledBorder(blackline, "");
		CardPanel.setBorder(title);
		
		
		return(CardPanel);
	}
	
	
	public JPanel RevealCard() {
		
		
		CardPanel.setLayout(BorderLay);
		
		HiddenLabel.setVisible(false);
		
		cardDescriptionLabel.setVisible(true);
		basicValueLabel.setVisible(true);
		cardSuiteLabel.setVisible(true);
		
		title = BorderFactory.createTitledBorder(blackline, "" + CardName);
		CardPanel.setBorder(title);
		
		return(CardPanel);
	}
	
	
	
	public class ActivateCardListener implements ActionListener{
		
		   public void actionPerformed(ActionEvent Click) {
			   
		   }
	}
	
	
}
