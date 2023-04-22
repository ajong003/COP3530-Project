package MAIN;

import java.util.Collections;
import java.util.Stack;

public class Deck<T extends Card> extends Stack<T>{


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

