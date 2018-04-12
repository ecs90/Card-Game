public class Main{
    public static void main(String[] args) {
        Player player1 = new Player("p1");
        Player player2 = new Player("p2");
        Player player3 = new Player("p3");
        Player player4 = new Player("p4");
        Deck deck = new Deck();

        Game game = new Game(player1, player2, player3, player4, deck);

        game.startGame();
    }
}
