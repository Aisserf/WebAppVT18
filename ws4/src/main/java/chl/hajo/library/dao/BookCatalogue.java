package chl.hajo.library.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * All orders Responsible for putting new PurchaseOrders objects into the model
 *
 * @author hajo
 */
@Stateless
public class BookCatalogue  {

    @PersistenceContext(unitName = "library_pu")
    private EntityManager em;

   
}
