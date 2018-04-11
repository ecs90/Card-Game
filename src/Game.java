import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Game implements Observer{
    private ArrayList<Player> players;
    private Deck deck;

    public Game(Player player1, Player player2, Player player3, Player player4, Deck deck) {
        this.players.add(player1);
        this.players.add(player2);
        this.players.add(player3);
        this.players.add(player4);
        this.deck = deck;
    }

    public void deal(){
        for(int i=0; i<4; i++){
            if(this.deck.anyCardLeft()) {
                this.players.get(i).setPlayable(this.deck.popCard());
            }else{
                System.out.println("No more cards to deal, hand cant be played");
                break;
            }
        }
    }

    public void play(){
        int winner = 0;
        for(int i = 1; i<4; i++){
            if(this.players.get(winner).getPlayable().getNumber()<this.players.get(i).getPlayable().getNumber()){
                winner = i;
            }
        }
        System.out.println("The winner of the row is " + players.get(winner).getName());
        int points = this.players.get(winner).getPoints();
        this.players.get(winner).setPoints(points+1);
    }

    public void row(){
        this.deal();
        this.play();
    }

    @Override
    public void update(Observable o, Object arg) {
        Player player = (Player) o;

        if(arg instenceof Card){
            Card card = (Card) arg;

            player.setPoints(player.getPoints() + card.getNumber());
            System.out.println(player.getName() + " has received " + card);
        }else{
            System.out.println(player.getName() + " has now " + player.getPoints() + " points");
        }
    }
}
