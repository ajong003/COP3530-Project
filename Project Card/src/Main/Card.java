package Main;

//class for representing playing card objects
public class Card implements Comparable<Card>{
    //
    String suite;
    //0=ace, 11 jack, 12, queen, 13 king
    int rank;

    //card object constructor
    public Card(String suite, int rank){
        this.suite=suite;
        this.rank=rank;
    }

    //returns the difference in card rank
    public int compareTo(Card o) {
        return rank-o.rank;
    }
    public String getSuite(){
        return suite;
    }
    public int getRank(){
        return rank;
    }

    //TODO
    public int getEffect(){
        return 0;
    }

    @Override
    public String toString() {
        if(rank>0&&rank<11){
            return rank + " of " + suite;
        }else{
            switch (rank){
                case 0:
                    return "Ace of " + suite;

                case 11:
                    return "Jack of "+suite;

                case 12:
                    return "Queen of " + suite;

                case 13:
                    return "King of " + suite;

                default:
                    return null;
            }
        }

    }
}
