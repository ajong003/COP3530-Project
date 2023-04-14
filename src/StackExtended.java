import java.util.Collections;
import java.util.Stack;

public class StackExtended extends Stack<Card> {


    public StackExtended(){

    }


    //card can only be pushed to stack if suite and or rank matches
    public boolean pushCheckSuite(Card card) {
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


}

