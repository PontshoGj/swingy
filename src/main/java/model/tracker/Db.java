package model.tracker;

import java.sql.*;

public class Db{
    // private static final String DATA_BASE_URL = "jdbc:sqlite:players.db";
    private static final String DATA_BASE_URL = "jdbc:sqlite::players.db";
    private static Connection connection;


    //function to create connection the database
    public static void connect(){
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DATA_BASE_URL);
			// Statement statement = conn.createStatement();
		
        	// statement.executeUpdate("CREATE TABLE IF NOT EXISTS player (ids INTEGER PRIMARY, name TEXT, classname TEXT, level INTEGER, xp INTEGER, attack INTEGER, defence INTEGER, hp INTEGER, artifacts TEXT)");
        } catch (SQLException | ClassNotFoundException e) {
            // System.out.println(e.printStackTrace());
            e.printStackTrace();
        }
        connection = conn;
    }

    private static Connection getConnection() {
        if (connection == null)
            connect();
        try{
            Statement state = connection.createStatement();
            ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='player'");
            if (!res.next()){
                // System.out.println(res.next());
                init();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    private static void init(){
        try{
			Statement statement = connection.createStatement();

        	statement.execute("CREATE TABLE  player(id integer primary key autoincrement, name varchar(60), classname varchar(60), level integer, xp integer, attack integer, defence integer, hp integer, artifacts varchar(60));");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //funtion to close connection to the database
    public static void close() {
        try {
            if (connection != null)
                connection.close();
            connection = null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //function to insert new player
    public static int newPlayer(String name) {
        int id = 0;
        // PreparedStatement pstmt = null;
        try { 
            String sqlQuery = "INSERT INTO player(name) VALUES(?)";
            PreparedStatement pstmt = getConnection().prepareStatement(sqlQuery); 
            pstmt.setString(1, name);
            pstmt.execute();

            Statement  stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT seq FROM sqlite_sequence WHERE name='player'");
            if (rs.next())
                id = rs.getInt("seq");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    //function to class new class
    public static void insertClass(int id, String classname, int attack, int defence, int hp) {
        // PreparedStatement pstmt = null;
        try { 
            String sqlQuery = "UPDATE player SET level = 1, xp = 1 ,classname = ?, attack = ?, defence = ?, hp = ? WHERE id = ?";
            PreparedStatement pstmt = getConnection().prepareStatement(sqlQuery); 
            pstmt.setString(1, classname);
            pstmt.setInt(2, attack);
            pstmt.setInt(3, defence);
            pstmt.setInt(4, hp);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();

            // Statement  stmt = getConnection().createStatement();
            // ResultSet rs = stmt.executeQuery("SELECT seq FROM sqlite_sequence WHERE name='player'");
            // if (rs.next())
                // id = rs.getInt("seq");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //function to get player info from exiting players


    //function to update player info during game play
}