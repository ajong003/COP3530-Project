package MAIN;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CardList<T extends Card> extends ArrayList<Card> {


    //sorts the players/CPU cards
    public void sort(){
        Collections.sort(this);


    }

    public void suiteSort(){
        CardList<Card> clubsBucket = new CardList<Card>();
        CardList<Card> diamondBucket = new CardList<Card>();
        CardList<Card> heartsBucket = new CardList<Card>();
        CardList<Card> spadesBucket = new CardList<Card>();
        CardList[] bucketArray = {clubsBucket,diamondBucket,heartsBucket,spadesBucket };
        CardList<Card> temp=null;

        for(Iterator<Card> it = this.iterator();it.hasNext(); ){
            Card card = it.next();
            switch(card.getSuite()){
                case "Clubs":
                    clubsBucket.add(card);
                    it.remove();
                    break;
                case "Diamonds":
                    diamondBucket.add(card);
                    it.remove();
                    break;
                case "Hearts":
                    heartsBucket.add(card);
                    it.remove();
                    break;
                case "Spades":
                    spadesBucket.add(card);
                    it.remove();
                    break;

            }

        }

//        for(Card card:this){
//            switch(card.getSuite()){
//                case "Clubs":
//                    clubsBucket.add(card);
//                    this.remove(card);
//                case "Diamonds":
//                    diamondBucket.add(card);
//                    this.remove(card);
//                case "hearts":
//                    heartsBucket.add(card);
//                    this.remove(card);
//                case "Spades":
//                    spadesBucket.add(card);
//                    this.remove(card);
//
//            }
//
//        }
        for(CardList<Card> bucket:bucketArray){
            bucket.sort();
            for(Card card:bucket){
                this.add(card);
            }
        }


    }
}
