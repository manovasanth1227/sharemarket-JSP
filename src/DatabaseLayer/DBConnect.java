package DatabaseLayer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Model.OrderModel;
import Model.Stock;
import Model.User;
import Model.UserStock;

public class DBConnect {
	private static SessionFactory factory;
	private static Session session;
	private static ServiceRegistry serviceRegistry;
	
	public static Session getSession() {
		
		Configuration configuration = new Configuration();
		configuration.configure().addAnnotatedClass(OrderModel.class).addAnnotatedClass(Stock.class).addAnnotatedClass(User.class).addAnnotatedClass(UserStock.class);
		serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		factory = configuration.buildSessionFactory(serviceRegistry);
		session = factory.openSession();
		System.out.println("session is created....");
		return session;
	}
}
