package Main;

//class for representing playing card objects
public class Card implements Comparable<Card>{
  //
  String suite;
  //0=ace, 11 jack, 12, queen, 13 king
  int rank;
  String description;


  //card object constructor
  public Card(String suite, int rank,String description){
      this.suite=suite;
      this.rank=rank;
      this.description = description;
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
  public String getDescription(){
      return description;
  }
  public void setDescription(String description){
      this.description=description;
  }

  //TODO
  public int getEffect(){
      return 0;
  }

  @Override
  public String toString() {
      if(rank>1&&rank<11){
          return rank + " of " + suite;
      }else{
          switch (rank){
              case 1:
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
