package controller;

import model.Product;
import org.hibernate.Session;
import java.util.List;

public class QueryProduct {
    Session session;
    public QueryProduct(){};
    public QueryProduct(Session session){
        this.session = session;
    }

    public List<Product> selectAllProducts(){
        return session.createNamedQuery("Product.SelectAllProducts", Product.class)
                .getResultList();
    }

    public List<Product> selectProductWithID(Integer id){
        return session.createNamedQuery("Product.SelectProductWithId", Product.class)
                .setParameter("id",id)
                .getResultList();
    }

    public List<Product> selectProductWithName(String productName){
        return session.createNamedQuery("Product.SelectProductWithName", Product.class)
                .setParameter("productName",productName)
                .getResultList();
    }
}
