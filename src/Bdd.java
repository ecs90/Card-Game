import com.mysql.jdbc.Connection;

import java.sql.*;
import java.util.ArrayList;

public class Bdd {
    Connection connection;
    static Bdd instance;

    public static Bdd getInstance(){
        if(instance==null){
            instance = new Bdd();
        }

        return instance;
    }

    private Bdd(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tpJava", "root", "");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addPlayer(Player player){
        try{
            this.connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/tpJava", "root", "");
            String sql = ;//insertar query
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, player.getName());
            st.setInt(2, player.getPoints());
            st.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Player> getPlayers(){
        try{
            this.connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tpJava", "root", "");
            String sql = ; // TO DO query
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<Player> lista = new ArrayList<Player>();
            while(rs.next()){
                Player player = new Player(rs.getString("nombre"));
                player.setPoints(rs.getInt("puntos"));
                lista.add(player);
            }
            return lista;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void update(Player player){
        try{
            this.connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tpJava", "root", "");
            String sql = ; // TO DO query
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, player.getPoints());
            st.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateVictoria(Player player){
        try{
            this.connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tpJava", "root", "");
            String sql = ; // TO DO query
            PreparedStatement st = connection.prepareStatement(sql);
            //st.setInt(1,player.getVictorias());
            //st.setInt(2,player.getId());
            st.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Player getPlayer() {
        try{
            this.connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tpJava", "root", "");
            String sql = ; // TO DO query
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                Player player = new Player(rs.getString("nombre"));

                player.setPoints(rs.getInt("puntos"));
                return player;
            }
            return null;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
