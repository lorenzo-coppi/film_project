package api;

import java.sql.Array;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		return query_get(query);

	}
	
	public List<film> ricercaInt(String col, int s) throws SQLException {
		String query = "SELECT * FROM movies WHERE " + col + " = " + s ;
		return query_get(query);

	}
	
	public List<film> ordinaRating() throws SQLException {
		String query = "SELECT * FROM movies ORDER BY score DESC";
		return query_get(query);

	}
	
	public boolean delete(int id) throws SQLException{
		
		String query = "DELETE FROM movies WHERE ID = ?";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		 pstmt.setInt(1, id);
		
		 boolean rowsAffected = pstmt.execute();
		 
		 return rowsAffected;
	}
	
	

	public void insert(film f) throws SQLException {
        String query = "INSERT INTO movies (name, rating, genre, released, score, director, writer, star, country, budget, gross, company, runtime) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            pstmt.setString(1, f.getName());
            pstmt.setString(2, f.getRating());
            pstmt.setString(3, f.getGenre());
            pstmt.setString(4, f.getReleased());
            pstmt.setInt(5, f.getScore());
            pstmt.setString(6, f.getDirector());
            pstmt.setString(7, f.getWriter());
            pstmt.setString(8, f.getStar());
            pstmt.setString(9, f.getCountry());
            pstmt.setDouble(10, f.getBudget());
            pstmt.setDouble(11, f.getGross());
            pstmt.setString(12, f.getCompany());
            pstmt.setInt(13, f.getRuntime());

            // Eseguiamo l'insert
            int affectedRows = pstmt.executeUpdate();
    }

	
	private List<film> query_get(String query) throws SQLException{
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

}
