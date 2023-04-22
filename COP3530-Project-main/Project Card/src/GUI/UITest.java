package GUI;

public class UITest {

	
	
	
	public static void main(String[] args){
		
		MainMenuUI MM = new MainMenuUI();
		User_Interface GameUI = new User_Interface();
		
		MM.InitializeMainMenu(GameUI);
		GameUI.InitializeUI(MM);
		
	}
}
