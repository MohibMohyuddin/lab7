import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DBmain {
	private static SessionFactory factory;
	
	public static void main(String[] args) throws IOException {
		factory = hibernateUtilities.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Person person = new Person(1,"Mohib","Siemens","Mohyuddin","03005057888");
		//DBhandler.insertRecord(person, session, tx);
		//DBhandler.deleteRecord(session, tx, 1);
		DBhandler.fetchRecord(session, tx, 2);

	}

}
