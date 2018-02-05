package chl.hajo.library.rest;

import chl.hajo.library.core.Author;
import chl.hajo.library.dao.AuthorRegistry;
import chl.hajo.library.service.DataSupplier;
<<<<<<< HEAD

import chl.hajo.library.core.Book;
import chl.hajo.library.dao.BookCatalogue;
import chl.hajo.library.service.BookSupplier;

=======
>>>>>>> efff0fe1f65df167de227736289e49a8ba20b618
import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author hajo
 */
@Path("db")
public class DatabaseResource {

    @EJB
    private AuthorRegistry areg;
    private final Gson gson = new Gson();
<<<<<<< HEAD
    @EJB    //Added this
    private BookCatalogue breg; //Added this
=======
>>>>>>> efff0fe1f65df167de227736289e49a8ba20b618

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response recreateDatabase() {
        areg.clear();
        for (Author a : DataSupplier.getAuthors()) {
            areg.create(a);
        }
<<<<<<< HEAD
        
        //Added code here for book
        breg.clear();
        for(Book b : BookSupplier.getBooks()) {
            breg.create(b);
        }
        // The above part was added
        
=======
>>>>>>> efff0fe1f65df167de227736289e49a8ba20b618
        return Response.ok(gson.toJson("Database recreated")).build();
    }

}
