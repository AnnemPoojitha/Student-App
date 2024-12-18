package Student.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
public static Connection reqConnection() throws ClassNotFoundException, SQLException{
	Connection con=null;
	String url="jdbc:mysql://localhost:3306/student";
	String user="root";
	String pass="aruna@123";
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(url,user,pass);
	return con;
}
}