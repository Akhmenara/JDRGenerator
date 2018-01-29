package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import models.Paths;

public class TestDBConnection {

	public static void main(String[] args) {

		HashMap<String, String> logins = new HashMap<String, String>();

		System.out.println(new File(".").getAbsoluteFile());
		
		BufferedReader brLogins = null;
		String lineLogins;
		String[] splitResultLogins = new String[2];
		try{
			brLogins = new BufferedReader(new FileReader(Paths.externalFiles + "logintodb.jdrg"));
			while ((lineLogins = brLogins.readLine()) != null) {
				splitResultLogins = lineLogins.split("=", 2);
				logins.put(splitResultLogins[0], splitResultLogins[1]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if (brLogins != null)
					brLogins.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		String url = logins.get("url");
		String login = logins.get("login");
		String password = logins.get("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Trying to connect...");

			Connection con = DriverManager.getConnection(url, login, password);
			
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