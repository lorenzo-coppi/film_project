package api;

import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("conn")
public class manager {
	DataBase db = new DataBase();

	@GET
	public void connessione() {
		try {
			db.conn();
			System.out.println("si");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GET
	@Path("{id}")
	public List<film> get(@PathParam("id") String id) throws SQLException {
		db.conn();
		System.out.println("si");

		List<film> F =db.ricerca(id);
		
		ListIterator<film> Fl = F.listIterator();
		
		while(Fl.hasNext()) {
			
			film f = (film) Fl.next();
			System.out.println("nome: " +f.getName() + " genere: "+f.getGenre());
		
		}
		
		return F;
		// return Response.status(Response.Status.NOT_FOUND).build();
	}
}
