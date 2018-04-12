public class Diamonds extends Card{

    public Diamonds(int number) {
        super(number);
    }

    public String toString() {
        String number = super.toString();
        return number + " of Diamonds";
    }
}
