package Main;

import java.util.Collections;
import java.util.Stack;

public class Deck<T extends Card> extends Stack<T>{

	public boolean ReflectDmgP1 = false;
	public boolean ReflectDmgP2 = false;
	
	public boolean P1NullifiedEffects = false;
	public boolean P2NullifiedEffects = false;
	
	public boolean ZeroDamageALL = false;
	
	public boolean P1NextTurnAddActionOrigin = false;
	public boolean P2NextTurnAddActionOrigin = false;
	
	public boolean P1NextTurnRedActionOrigin = false;
	public boolean P2NextTurnRedActionOrigin = false;
	
	
	public boolean x2DamageALL = false;
	
	public boolean P1x2Damage = false;
	public boolean P2x2Damage = false;
	
	public int PrevCardRank = 0;
	public int P1HealPerCard = 0;
	public int P2HealPerCard = 0;
	public int P1DmgModifier = 0;
	public int P2DmgModifier = 0;
	
	

    public Deck(){

    }


    //card can only be pushed to stack if suite and or rank matches
    public boolean pushCheckSuite(T card) {
        if (this.peek().getSuite().equals(card.getSuite())) {
            this.push(card);
            return true;
        } else if (this.peek().getRank() == card.getRank()) {
            this.push(card);
            return true;
        }
        return false;
    }
    public void shuffle(){
        Collections.shuffle(this);
    }
    public Card findCard(int rank, String suite){
        for(Card card:this){
            if (rank==card.getRank() && suite.equals(card.getSuite())){
                return card;
            }
        }return null;
    }


}

