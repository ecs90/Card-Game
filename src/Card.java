public class Card {
    private int number;

    public Card(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String changer(){
        if(this.number == 1){
            return "A";
        }else if(this.number == 11){
            return "J";
        }else if(this.number == 12){
            return "Q";
        }else if(this.number == 13){
            return "K";
        }
        return "" + this.number;
    }

    @Override
    public String toString() {
        return changer();

    }
}
