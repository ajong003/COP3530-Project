package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PlacementUIObject {

	public JPanel InitializeCard(){
		
		ActivateCardListener DrawCardListen = new ActivateCardListener();
		
		
		JButton DrawCardBttn = new JButton("Place");
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
	
	
	public class ActivateCardListener implements ActionListener{
		
		public void actionPerformed(ActionEvent Click) {
				   
		}
		
	}

	
	
}
