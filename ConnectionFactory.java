/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Justyna
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
        String host = "127.0.0.1";
        String port = "1433";
        String database = "ZakladMechaniczny";
        String user = "justyna";
        String password = "justyna";
	String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String driverClassName = "com.mysql.jdbc.Driver";
	//String connectionUrl = "jdbc:mysql://127.0.0.1:3306/serwis";
        String databaseURL = "jdbc:sqlserver://"+
                             host+"\\SQLEXPRESS:"+
                             port+";databaseName="+
                             database;
	//String dbUser = "root";
	//String dbPwd = "1234";

	private static ConnectionFactory connectionFactory = null;

	private ConnectionFactory() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(databaseURL, user, password);
		return conn;
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
}