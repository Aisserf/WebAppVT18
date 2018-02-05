package chl.hajo.library.rest;

import chl.hajo.library.core.Author;
import chl.hajo.library.dao.AuthorRegistry;
import chl.hajo.library.service.DataSupplier;

import chl.hajo.library.core.Book;
import chl.hajo.library.dao.BookCatalogue;
import chl.hajo.library.service.BookSupplier;

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
    @EJB    //Added this
    private BookCatalogue breg; //Added this

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response recreateDatabase() {
        areg.clear();
        for (Author a : DataSupplier.getAuthors()) {
            areg.create(a);
        }
        
        //Added code here for book
        breg.clear();
        for(Book b : BookSupplier.getBooks()) {
            breg.create(b);
        }
        // The above part was added
        
        return Response.ok(gson.toJson("Database recreated")).build();
    }

}
