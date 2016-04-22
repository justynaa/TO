//Do połączenia z bazą

/**
 *
 * @author Justyna
 */

import java.sql.*;


public class ConnectionManager {
    public static ResultSet sendQuery(Connection connection,String query) throws Exception {
    Statement statement =  connection.createStatement();
    return statement.executeQuery(query);
}    
    
   
    public static void main(String[] args){
        Connection connection = null;

        String host = "127.0.0.1";
        String port = "1433";
        String database = "ZakladMechaniczny";
        String user = "justyna";
        String password = "justyna";

        String databaseURL = "jdbc:sqlserver://"+
                             host+"\\SQLEXPRESS:"+
                             port+";databaseName="+
                             database;

        try {
            //Ładowanie sterownika
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //Nawiązanie połączenia
            connection = DriverManager.getConnection(databaseURL, user, password);
        } catch (Exception e) {
            //Gdyby coś poszło nie tak, wydrukuj komunikat...
            System.out.println(e.getMessage());
        }
    }
}
