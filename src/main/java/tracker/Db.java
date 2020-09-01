package tracker;

import java.sql.*;

public class Db{
    private static final String DATA_BASE_URL = "jdbc:sqlite::players.db";
    private static Connection connection;


    //function to create connection the database
    public static void connect(){

        String url = "jdbc:sqlite:/tracker/players.db";

        try (
            // Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DATA_BASE_URL);
			Statement statement = conn.createStatement();
		
        	statement.executeUpdate("CREATE TABLE IF NOT EXISTS player (ids INTEGER PRIMARY, name TEXT, classname TEXT, level INTEGER, xp INTEGER, attack INTEGER, defence INTEGER, hp INTEGER, artifacts TEXT)");
        } catch (SQLException | ClassNotFoundException e) {
            // System.out.println(e.printStackTrace());
            e.printStackTrace();
        }
        connection = conn;
    }

    private static Connection getConnection() {
        if (connection == null)
            connect();
        return connection;
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
    public static int newPlayer(String name, String className, int attack, int defense, int hp) {
        int id = 0;
        // PreparedStatement pstmt = null;
        try { 
            String sqlQuery = "INSERT INTO player(name, classname, level, xp, attack, defense, hp) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = getConnection().prepareStatement(sqlQuery); 
            // pstmt.setString(1, name);
            // pstmt.setString(2, className);
            // pstmt.setInt(3, 1);
            // pstmt.setInt(4, 1);
            // pstmt.setInt(5, attack);
            // pstmt.setInt(6, defense);
            // pstmt.setInt(7, hp);
            // pstmt.executeUpdate();

            // Statement  stmt = getConnection().createStatement();
            // ResultSet rs = stmt.executeQuery("SELECT seq FROM sqlite_sequence WHERE name=\"player\"");
            // if (rs.next())
            //     id = rs.getInt("seq");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    //function to get player info from exiting players


    //function to update player info during game play
}