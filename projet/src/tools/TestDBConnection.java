package tools;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Statement;

public class TestDBConnection {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdrgenerator?useSSL=false";
			
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();

			stmt.executeUpdate(("CREATE TABLE MONSTRE(NOM_MONSTRE VARCHAR(32),ID_MONSTRE INTEGER)"));
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}