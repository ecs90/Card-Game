import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Game implements Observer{
    private ArrayList<Player> players;
    private Deck deck;

    public Game(Player player1, Player player2, Player player3, Player player4, Deck deck) {
        this.players = new ArrayList<>();
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
        int number = 0;
        for(Player player : players){
            if(number <= player.getPlayable().getNumber()){
                number = player.getPlayable().getNumber();
            }
        }
        for(int i = 0; i<4; i++){
            if(this.players.get(i).getPlayable().getNumber()==number){
                System.out.println("The winner of the row is " + players.get(i).getName());
                int points = this.players.get(i).getPoints();
                this.players.get(i).setPoints(points+1);
            }
        }
    }

    public void row(){
        this.deal();
        this.play();
    }

    public void winner(){
        int winner = 0;
        int points = 0;
        for(Player player : players){
            if(player.getPoints()>points){
                points = player.getPoints();
            }
        }
    }

    public void startGame(){
        for(Player player: players){
            player.addObserver(this);
            new Thread(player).start();
        }

        while(deck.anyCardLeft()){
            row();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Player player = (Player) o;

        if(arg instanceof Card){
            Card card = (Card) arg;

            System.out.println(player.getName() + " has received " + card.toString());
        }else{
            System.out.println(player.getName() + " has now " + player.getPoints() + " points");
        }
    }
}
