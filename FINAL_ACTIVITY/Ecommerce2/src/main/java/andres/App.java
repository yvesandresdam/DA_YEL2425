package andres;

import Utils.Util;
import controller.Controller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
        // This class manages the 'Hibernate' session and the controller creation.
        // Session and controller are the main Instances of the APP.

        Util utils = new Util();
        utils.setLoggerSevere();

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Controller controller = new Controller(session);
        controller.launchMainController();
    }
}
