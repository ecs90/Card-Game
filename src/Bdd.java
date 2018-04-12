import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bdd {

    private static Connection openConnection() throws SQLException {
        com.mysql.jdbc.Driver.class.getName();
        return DriverManager.getConnection("jdbc:mysql://localhost/tpJava", "root", "");
    }

    public static void saveWinner(Player player) {
        String cardsText = "";
        for (Card card : player.getPlayables()) {
            cardsText += card + "; ";
        }

        try (Connection connection = openConnection()) {
            PreparedStatement st = connection.prepareStatement("INSERT INTO winners(player, points, cards) VALUES (?,?,?)");
            st.setString(1, player.getName());
            st.setInt(2, player.getPoints());
            st.setString(3, cardsText);
            st.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
