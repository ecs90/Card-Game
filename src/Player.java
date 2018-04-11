import java.util.Observable;

public class Player extends Observable implements Runnable{
    private String name;
    private Card playable;
    private int points;

    public Player(String name){
        this.name = name;
        this.points = 0;
    }

    public synchronized void setPlayable(Card playable) {
        this.playable = playable;
        setChanged();
        notifyObservers(this.playable);
    }

    public void setPoints(int points) {
        this.points = points;
        setChanged();
        notifyObservers(this.points);
    }

    public Card getPlayable() {
        return playable;
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
}
