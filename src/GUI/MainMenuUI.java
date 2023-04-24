package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenuUI {

	User_Interface GameUI;
	
	JPanel MainMenuPanel = new JPanel();
	JPanel OptionsMenuPanel = new JPanel();
	JPanel ScoreBoardMenuPanel = new JPanel();
	
    GridLayout GridLay = new GridLayout();
	
	StartBttnListener StartBttnListen = new StartBttnListener();
	OptionsBttnListener OptionsBttnListen = new OptionsBttnListener();
	ScoreBoardBttnListener ScoreBoardBttnListen = new ScoreBoardBttnListener();
	BackBttnListener BackBttnListenOp = new BackBttnListener();
	BackBttnListener BackBttnListenSB = new BackBttnListener();
	
	QuitBttnListener QuitBttnListen = new QuitBttnListener();
	
	
	JLabel Title = new JLabel("Jack Of All Trades");
	JLabel OptionsTitle = new JLabel("Options");
	JLabel ScoreBoardTitle = new JLabel("Score Board");
	
	
	JButton StartButton = new JButton("Start");
	
	JButton OptionsButton = new JButton("Options");
	JButton ScoreBoardButton = new JButton("Score Board");
	JButton QuitButton = new JButton("Quit");
	JButton BackButtonOp = new JButton("Back");
	JButton BackButtonSB = new JButton("Back");
	
	JFrame MainMenuFrame = new JFrame();
	
	
	public MainMenuUI(){

	}
	
	
	public void InitializeMainMenu(User_Interface GameUI){
		
		this.GameUI = GameUI;
		
		
		
		MainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainMenuFrame.setTitle("Jack of All Trades");
		
		MainMenuFrame.setSize(1280,720);
		
		MainMenuFrame.setLayout(GridLay);
		MainMenuPanel.setLayout(null);
		OptionsMenuPanel.setLayout(null);
		ScoreBoardMenuPanel.setLayout(null);
		
		
		
		Title.setFont(new Font("Serif",Font.BOLD,50));
		Title.setBounds(450, 100, 450, 200);
		
		OptionsTitle.setFont(new Font("Serif",Font.BOLD,40));
		OptionsTitle.setBounds(568, 0, 450, 200);
		
		ScoreBoardTitle.setFont(new Font("Serif",Font.BOLD,40));
		ScoreBoardTitle.setBounds(535, 0, 450, 200);
		
		
		//Button Properties
		StartButton.setBounds(540, 300, 200, 35);
		StartButton.setFocusable(false);
		StartButton.setBackground(Color.gray);
		StartButton.setForeground(Color.white);
		
		OptionsButton.setBounds(540, 350, 200, 35);
		OptionsButton.setFocusable(false);
		OptionsButton.setBackground(Color.gray);
		OptionsButton.setForeground(Color.white);
		
		ScoreBoardButton.setBounds(540, 400, 200, 35);
		ScoreBoardButton.setFocusable(false);
		ScoreBoardButton.setBackground(Color.gray);
		ScoreBoardButton.setForeground(Color.white);
		
		QuitButton.setBounds(540, 450, 200, 35);
		QuitButton.setFocusable(false);
		QuitButton.setBackground(Color.gray);
		QuitButton.setForeground(Color.white);
		
		BackButtonOp.setBounds(540, 450, 200, 35);
		BackButtonOp.setFocusable(false);
		BackButtonOp.setBackground(Color.gray);
		BackButtonOp.setForeground(Color.white);
		
		BackButtonSB.setBounds(540, 450, 200, 35);
		BackButtonSB.setFocusable(false);
		BackButtonSB.setBackground(Color.gray);
		BackButtonSB.setForeground(Color.white);
		

		StartButton.addActionListener(StartBttnListen);
		OptionsButton.addActionListener(OptionsBttnListen);
		ScoreBoardButton.addActionListener(ScoreBoardBttnListen);
		QuitButton.addActionListener(QuitBttnListen);
		
		BackButtonOp.addActionListener(BackBttnListenOp);
		BackButtonSB.addActionListener(BackBttnListenSB);
		
		
		
		//Add MainMenu Content
		MainMenuPanel.add(Title);
		MainMenuPanel.add(StartButton);
		MainMenuPanel.add(OptionsButton);
		MainMenuPanel.add(ScoreBoardButton);
		MainMenuPanel.add(QuitButton);
		
		//Add Options Menu Content
		OptionsMenuPanel.add(BackButtonOp);
		OptionsMenuPanel.add(OptionsTitle);
		
		//Add Score Board Content
		ScoreBoardMenuPanel.add(BackButtonSB);
		ScoreBoardMenuPanel.add(ScoreBoardTitle);
		
		
		MainMenuFrame.getContentPane().add(MainMenuPanel);
		
		ScoreBoardMenuPanel.setVisible(false);
		OptionsMenuPanel.setVisible(false);
		MainMenuFrame.setVisible(true);
		
	}
	
	public class StartBttnListener implements ActionListener{

		public void actionPerformed(ActionEvent Click) {
			System.out.println("Start Button Pressed");
			GameUI.CardGameFrame.setVisible(true);
			MainMenuFrame.setVisible(false);

		}

	}
	
	public class OptionsBttnListener implements ActionListener{

		public void actionPerformed(ActionEvent Click) {
			System.out.println("Options Button Pressed");
			MainMenuPanel.setVisible(false);
			MainMenuFrame.getContentPane().remove(MainMenuPanel);
			MainMenuFrame.getContentPane().add(OptionsMenuPanel);
			OptionsMenuPanel.setVisible(true);
		}

	}
	
	public class ScoreBoardBttnListener implements ActionListener{

		public void actionPerformed(ActionEvent Click) {
			System.out.println("Score Board Button Pressed");
			MainMenuPanel.setVisible(false);
			MainMenuFrame.getContentPane().remove(MainMenuPanel);
			MainMenuFrame.getContentPane().add(ScoreBoardMenuPanel);
			ScoreBoardMenuPanel.setVisible(true);
		}

	}
	
	public class QuitBttnListener implements ActionListener{

		public void actionPerformed(ActionEvent Click) {
			System.out.println("Quit Button Pressed");
			
		}

	}
	
	public class BackBttnListener implements ActionListener{

		public void actionPerformed(ActionEvent Click) {
			System.out.println("Back to Main Menu");
			
			if (ScoreBoardMenuPanel.isVisible()) {
				ScoreBoardMenuPanel.setVisible(false);
				MainMenuFrame.getContentPane().remove(ScoreBoardMenuPanel);
				MainMenuFrame.getContentPane().add(MainMenuPanel);
				MainMenuPanel.setVisible(true);
				
			}
			else if (OptionsMenuPanel.isVisible()) {
				OptionsMenuPanel.setVisible(false);
				MainMenuFrame.getContentPane().remove(OptionsMenuPanel);
				MainMenuFrame.getContentPane().add(MainMenuPanel);
				MainMenuPanel.setVisible(true);
				
			}
			
		}

	}
	
	
	
}
