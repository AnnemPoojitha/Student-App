package Student.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Student.DTO.Student;
import Student.Factory.Connector;

public class StudentDAO {
public static boolean insert(Student s) {
	Connection con=null;
	PreparedStatement ps=null;
	String insert="insert into signup values(?,?,?,?,?)";
	int res=0;
	
		try {
			con=Connector.reqConnection();
			ps=con.prepareStatement(insert);
			ps.setInt(1, s.getId());
			ps.setString(2, s.getName());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPhone());
			ps.setString(5, s.getPassword());
			res=ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
		}	
}
public static Student login(Student s) {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Student ss=null;
	String query="SELECT * FROM SIGNUP WHERE EMAIL=? AND PASSWORD=?";
	try {
		con=Connector.reqConnection();
		ps=con.prepareStatement(query);
		ps.setString(1, s.getEmail());
		ps.setString(2, s.getPassword());
		rs=ps.executeQuery();
		while(rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String mail=rs.getString(3);
			String phone=rs.getString(4);
	        ss=new Student(id,name,mail,phone,mail);
	} 
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ss;
	}	
}