package airport_hibernate.connection_to_db;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
    private static final Configuration configuration = new Configuration().configure("META-INF/persistence.xml");
    
    private static final SessionFactory sessionFactory = configuration.buildSessionFactory();
    
    private Connection(){}
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}