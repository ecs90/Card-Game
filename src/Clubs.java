public class Clubs extends Card{

    public Clubs(int number) {
        super(number);
    }

    @Override
    public String toString() {
        String number = super.toString();
        return number + " of Clubs";
    }
}
