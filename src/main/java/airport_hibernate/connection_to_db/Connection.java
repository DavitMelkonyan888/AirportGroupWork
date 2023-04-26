package airport_hibernate.connection_to_db;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
    private static final Configuration configuration = new Configuration().configure("META-INF/persistence.xml");
    
    private static final SessionFactory sessionFactory;
    
    static {
        try {
            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println("Failed to Build Session Factory " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
