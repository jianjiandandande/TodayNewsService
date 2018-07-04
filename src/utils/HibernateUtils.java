package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/** 
 * Created by Vincent on 2018/7/3.
 */
public class HibernateUtils {

	private static SessionFactory sessionFactory;

	static {
		// 1.创建：调用空参构造
		Configuration conf = new Configuration();
		// 2.读取主配置文件：默认加载src下的hibernate.cfg.xml
		conf.configure();
		// 3.根据配置信息，建立SessionFactory对象
		sessionFactory = conf.buildSessionFactory();

	}

	// 获取全新session
	public static Session openSession() {
		Session session = sessionFactory.openSession();
		return session;
	}

	// 获取与线程绑定的session
	public static Session getCurrentSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
}
