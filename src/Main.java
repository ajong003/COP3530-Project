import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        //create card deck double loop
        StackExtended fullDeck = new StackExtended();
        String[] suiteArray = {"Hearts", "Clover", "Diamonds", "Spades"};
        for (int i = 0; i < suiteArray.length; i++) {
            for (int k = 0; k < 13; k++) {
                fullDeck.push(new Card(suiteArray[i], k));

            }


        }
        System.out.println(fullDeck.toString());
        fullDeck.shuffle();
        //testing shuffle
        System.out.println(fullDeck.toString());

    }
}
