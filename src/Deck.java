import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> gameCard = new Stack<Card>();
    private ArrayList<Card> usedCard = new ArrayList<Card>();

    public Deck(){
        for (int i = 1; i < 14; i++) {
            Spades spades = new Spades(i);
            this.usedCard.add(spades);
            Hearts hearts = new Hearts(i);
            this.usedCard.add(hearts);
            Diamonds diamonds = new Diamonds(i);
            this.usedCard.add(diamonds);
            Clubs clubs = new Clubs(i);
            this.usedCard.add(clubs);
        }

        Collections.shuffle(usedCard);

        while(!this.usedCard.isEmpty()) {
            this.gameCard.push(this.usedCard.get(0));
            this.usedCard.remove(0);
        }
    }

    public Card popCard(){
        return this.gameCard.pop();
    }

    public void disCard(Card card){
        this.usedCard.add(card);
    }

    public boolean anyCardLeft(){
        return !this.gameCard.empty();
    }

    public void disCardAll(ArrayList<Card> card){
        this.usedCard.addAll(card);
    }
}
