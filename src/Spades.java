public class Spades extends Card {

    public Spades(int number) {
        super(number);
    }

    public String toString() {
        String number = super.toString();
        return number + " of Spades";
    }
}
