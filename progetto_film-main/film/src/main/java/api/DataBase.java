package api;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

public class DataBase {
	String url = "jdbc:mysql://localhost:3306/tepsit_film";
	String username = "root";
	String password= null;
	java.sql.Statement st = null;
    ResultSet rs = null;
	
	public void conn() throws SQLException {
		System.out.println("conn - begin");
		Connection con = DriverManager.getConnection(url,username,password);
		st=con.createStatement();
		System.out.println("conn - end");
	}
	
	public List<film> ricerca(String s) throws SQLException{
		String query="SELECT * FROM movies WHERE name LIKE"+"'"+s+"%'";
		rs=st.executeQuery(query);
		film f=null;
		List<film> films=new ArrayList<film>();
		while(rs.next()) {
			f=new film();
			f.setName(rs.getString(1));
			f.setRating(rs.getString(2));
			f.setGenre(rs.getString(3));
			f.setReleased(rs.getString(4));
			f.setScore(rs.getInt(5));
			f.setDirector(rs.getString(6));
			f.setWriter(rs.getString(7));
			f.setStar(rs.getString(8));
			f.setCountry(rs.getString(9));
			f.setBudget(rs.getInt(10));
			f.setGross(rs.getInt(11));
			f.setCompany(rs.getString(12));
			f.setRuntime(rs.getInt(13));
			films.add(f);
		}
		return films;
		
	}

}
