package Main;

import java.util.ArrayList;
import java.util.Collections;

public class CardList<T extends Card> extends ArrayList<T> {


    //sorts the players/CPU cards
    public void sort(){
        Collections.sort(this);

    }
}
