package testing;

import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestingQuery {
    public static void main(String[] args) {

        // Disponer el 'Logger' para evitar los avisos
        Logger logger = Logger.getLogger("org.hibernate");
        logger.setLevel(Level.SEVERE);

        // Abrir la session de hibernate
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Listado de queries
        Query<Product> query1 = session.createQuery("from model.Product p where p.category.id < :value");
        query1.setParameter("value", 5);
        List<Product> list = query1.list();

        for (Product element : list) {
            System.out.printf("Producto: %s%nCategoria: %s%n%n", element.getProductName(), element.getCategory().getId());
        }
    }
}
