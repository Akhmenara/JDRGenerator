package tools;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Statement;

public class TestDBConnection {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/jdrgenerator?useSSL=false";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Trying to connect...");

			Connection con = DriverManager.getConnection(url, "root", "");
			
			System.out.println("Connection Established Successfull and the DATABASE NAME IS:"
                    + con.getMetaData().getDatabaseProductName());
			
			//Quick table creation test
			//Statement stmt = (Statement) con.createStatement();
			//stmt.executeUpdate(("CREATE TABLE TEST(NOM VARCHAR(32),ID INTEGER)"));
			
		} catch (Exception e) {
			System.out.println("Unable to connect to the DB");
			e.printStackTrace();
		}
	}
}