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
	String password = null;
	java.sql.Statement st = null;
	ResultSet rs = null;
	Connection con = null;

	public void conn() throws SQLException {
		System.out.println("conn - begin");
		con = DriverManager.getConnection(url, username, password);
		st = con.createStatement();
		System.out.println("conn - end");
	}

	public void discon() throws SQLException {
		con.close();
	}

	public List<film> ricercaString(String col, String s) throws SQLException {
		String query = "SELECT * FROM movies WHERE " + col + " LIKE" + "'" + s + "%'";
		rs = st.executeQuery(query);
		film f = null;
		List<film> films = new ArrayList<film>();
		while (rs.next()) {
			f = new film();
			f.setID(rs.getInt(1));
			f.setName(rs.getString(2));
			f.setRating(rs.getString(3));
			f.setGenre(rs.getString(4));
			f.setReleased(rs.getString(5));
			f.setScore(rs.getInt(6));
			f.setDirector(rs.getString(7));
			f.setWriter(rs.getString(8));
			f.setStar(rs.getString(9));
			f.setCountry(rs.getString(10));
			f.setBudget(rs.getInt(11));
			f.setGross(rs.getInt(12));
			f.setCompany(rs.getString(13));
			f.setRuntime(rs.getInt(14));
			films.add(f);
		}
		return films;

	}
	
	public List<film> ricercaInt(String col, int s) throws SQLException {
		String query = "SELECT * FROM movies WHERE " + col + " = " + s ;
		rs = st.executeQuery(query);
		film f = null;
		List<film> films = new ArrayList<film>();
		while (rs.next()) {
			f = new film();
			f.setID(rs.getInt(1));
			f.setName(rs.getString(2));
			f.setRating(rs.getString(3));
			f.setGenre(rs.getString(4));
			f.setReleased(rs.getString(5));
			f.setScore(rs.getInt(6));
			f.setDirector(rs.getString(7));
			f.setWriter(rs.getString(8));
			f.setStar(rs.getString(9));
			f.setCountry(rs.getString(10));
			f.setBudget(rs.getInt(11));
			f.setGross(rs.getInt(12));
			f.setCompany(rs.getString(13));
			f.setRuntime(rs.getInt(14));
			films.add(f);
		}
		return films;

	}

	public int insert(film f) throws SQLException {
		String query = "INSERT INTO movies VALUES ('" + f.getName() + "', '" + f.getRating() + "', '" + f.getGenre()
				+ "', '" + f.getReleased() + "', " + f.getScore() + ", '" + f.getDirector() + "', '" + f.getWriter()
				+ "', '" + f.getStar() + "', '" + f.getCountry() + "', " + f.getBudget() + ", " + f.getGross() + ", '"
				+ f.getCompany() + "', " + f.getRuntime() + ")";
		rs = st.executeQuery(query);
		
		rs.last();
		return rs.getInt("ID");
		
	}

}
