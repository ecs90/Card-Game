public class Hearts extends Card {

    public Hearts(int number) {
        super(number);
    }

    public String toString() {
        String number = super.toString();
        return number + " of Hearts";
    }
}
