package Base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public interface BaseDao<T> {


    //插入新数据
    void insert(T t);

    //查询全部数据
    List<T> getAll(int userId);

    //删除
    void delete(int userId,String name);

    //单个查询
    T selectT(int userId,String name);

    T queryByUserName(String username);

    T update(T t);
}
