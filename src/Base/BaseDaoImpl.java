package Base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import utils.HibernateUtils;

import java.util.List;

/**
 * Created by Vincent on 2018/7/3.
 */
public abstract class BaseDaoImpl<T>  implements BaseDao<T>{

    protected Configuration cfg = null;
    protected ServiceRegistry sr = null;

    protected SessionFactory sf = null;
    protected Session se = null;
    protected Transaction ts = null;

    public BaseDaoImpl() {
        cfg = new Configuration().configure();
        sr = new StandardServiceRegistryBuilder().
                applySettings(cfg.getProperties()).build();
    }


    @Override
    public void insert(T t) {
        se = HibernateUtils.openSession();
        ts = se.beginTransaction();
        se.save(t);
        ts.commit();
        se.close();
    }

    @Override
    public T update(T t) {
        return null;
    }
}
