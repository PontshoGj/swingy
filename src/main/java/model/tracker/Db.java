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

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //function to get player info from exiting players

    public static void getPlayers() {
        // PreparedStatement pstmt = null;
        try { 
            String sqlQuery = "SELECT * FROM player";

            Statement  stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            int i = 0;
            while(rs.next()){
                i = 1;
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + 
                                    rs.getString("classname") + "\t" + 
                                    rs.getInt("attack") + "\t" + 
                                    rs.getInt("defence") + "\t" +
                                    rs.getInt("hp") + "\t" +
                                    rs.getInt("level") + "\t" +
                                    rs.getInt("xp"));
            }
            if (i == 0){
                System.out.println("Please create player first");
                System.exit(0);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //function to update player info during game play


    public static String [] getPlayInfo(int id) {
        // PreparedStatement pstmt = null;
        try { 
            String sqlQuery = "SELECT * FROM player WHERE id = " + id;

            Statement  stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            if (rs.next())
                return (new String []{""+rs.getInt("id")+"", rs.getString("name"), rs.getString("classname"), "" + rs.getInt("attack") + "", "" + rs.getInt("defence") + "", "" + rs.getInt("hp") + "", "" + rs.getInt("level") + "", "" + rs.getInt("xp") + ""});
        } catch (SQLException e) {
            System.out.println("Please enter correct number");
        }
        System.out.println("Please enter correct number");
        return null;
    }

    public static String [][] getPlay() {
        // PreparedStatement pstmt = null;
        try { 
            String sqlQuery = "SELECT * FROM player";

            Statement  stmts = getConnection().createStatement();
            ResultSet rs = stmts.executeQuery(sqlQuery);
            Statement  stmt = getConnection().createStatement();
            ResultSet rss = stmt.executeQuery("SELECT count(*) FROM player");
            int count = 0;
            if (rss.next())
                count = rss.getInt("count(*)");
            String[][]      data= new String[count][1];
            int         i = 0;
            while(rs.next()){

                data[i++]  = new String []{""+rs.getInt("id")+"", rs.getString("name"), rs.getString("classname"), "" + rs.getInt("attack") + "", "" + rs.getInt("defence") + "", "" + rs.getInt("hp") + "", "" + rs.getInt("level") + "", "" + rs.getInt("xp") + ""};
            }
            if (data != null)
                return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void updateXp(int xp, int level, int id){

        if (xp >= 1 && xp < 2450)
            level = 1;
        else if (xp >= 2450 && xp < 4800)
            level = 2;
        else if (xp >= 4800 && xp < 8050)
            level = 3;
        else if (xp >= 8050 && xp < 12200)
            level = 4;
        else
            level = 5;

        int val = level * 1000 + (level - 1) * 450;
        int newxp = xp + val;

        try { 
            String sqlQuery = "UPDATE player SET xp = ? WHERE id = ?";
            PreparedStatement pstmt = getConnection().prepareStatement(sqlQuery); 
            pstmt.setInt(1, newxp);
            // pstmt.setInt(2, level);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void updateLevel(int level, int id){
        level++;
        try { 
            String sqlQuery = "UPDATE player SET level = ? WHERE id = ?";
            PreparedStatement pstmt = getConnection().prepareStatement(sqlQuery); 
            pstmt.setInt(1, level);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getlevel(int id) {
        // PreparedStatement pstmt = null;
        try { 
            String sqlQuery = "SELECT * FROM player WHERE id = " + id;

            Statement  stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            if (rs.next())
                return  rs.getInt("level");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}