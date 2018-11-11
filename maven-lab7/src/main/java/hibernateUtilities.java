import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class hibernateUtilities {

	public static SessionFactory buildSessionFactory() {
		try {
        	
        	Configuration cfg = new Configuration(); 
            cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file 
            //creating seession factory object 
            ServiceRegistry serviceRegistry = new  
                       StandardServiceRegistryBuilder().applySettings(cfg.getProperties()). build(); 
            return cfg.buildSessionFactory(serviceRegistry);        
        	   
        } 
        catch (HibernateException he) {
            System.out.println("Session Factory creation failure");
            throw he;
        }
	}

	}
  
