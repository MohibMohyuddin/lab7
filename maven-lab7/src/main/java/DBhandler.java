import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DBhandler{
public static void insertRecord(Person person,Session session,Transaction tx) throws IOException {
		try {
			 tx = session.beginTransaction();	
	         session.save(person); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	}
	}
	
	public static void deleteRecord(Session session,Transaction tx,int id) throws IOException {
		try{
		tx = session.beginTransaction();	
		Object persistentInstance = session.load(Person.class, id);
		if (persistentInstance != null) {
		    session.delete(persistentInstance);
		}
		tx.commit();
		}
		catch(HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
	}
	public static void fetchRecord(Session session,Transaction tx,int id) throws IOException {
		try {
			tx = session.beginTransaction();	
			Criteria cr = session.createCriteria(Person.class);
			cr.add(Restrictions.eq("id", id));
			List result = cr.list();
			tx.commit();
			Iterator iterator = result.iterator();
			Person person = (Person) iterator.next();
			ObjectMapper objectMapper = new ObjectMapper();
			String parsed = objectMapper.writeValueAsString(person);
			System.out.println(parsed);
		}
		catch(HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
	}
	}