import java.util.ArrayList;
import java.util.Observable;

public class Player extends Observable implements Runnable{
    private String name;
    private ArrayList<Card> playable;
    private int points;

    public Player(String name){
        this.name = name;
        this.playable = new ArrayList<>();
        this.points = 0;
    }

    public synchronized void setPlayable(Card playable) {
        this.playable.add(playable);
        setChanged();
        notifyObservers(this.playable.get(this.playable.size() - 1));
    }

    public void setPoints(int points) {
        this.points = points;
        setChanged();
        notifyObservers(this.points);
    }

    public Card getPlayable() {
        return playable.get(playable.size() - 1);
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {

    }

    public ArrayList<Card> getPlayables() {
        return this.playable;
    }
}
