
package com.mycompany.mycart.Dao;

import com.mycompany.mycart.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductDao {
    private SessionFactory factory;

    public ProductDao(SessionFactory factory) {
        this.factory = factory;
    }
    public boolean saveProduct(Product product)
    {
        boolean f = false;
        try {
            
            Session session = this.factory.openSession();
            Transaction tx = session.beginTransaction();
            
            session.save(product);
            
            tx.commit();
            session.close();
            f = true;
            
        }catch (Exception e){
            e.getStackTrace();
            f = false;
        }
        return f;
        
    }
}
