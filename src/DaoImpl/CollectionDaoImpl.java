package DaoImpl;

import Base.BaseDaoImpl;
import org.hibernate.query.Query;
import table.CollectionEntity;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class CollectionDaoImpl extends BaseDaoImpl<CollectionEntity> {

    @Override
    public List<CollectionEntity> getAll(int userId) {

        se = HibernateUtils.openSession();
        ts = se.beginTransaction();

        List<CollectionEntity> collection = new ArrayList<CollectionEntity>();

        Query query = se.createQuery(" from CollectionEntity where userId=?");
        query.setParameter(0,userId);
        collection = query.getResultList();
        ts.commit();
        se.close();
        return collection;
    }

    @Override
    public void insert(CollectionEntity collectionEntity) {
        super.insert(collectionEntity);
    }

    @Override
    public void delete(int userId, String id) {
        CollectionEntity collection = draw(userId,id);
        se.delete(collection);
    }

    @Override
    public CollectionEntity selectT(int userId, String id) {
        CollectionEntity collection = draw(userId,id);

        return collection;
    }

    @Override
    public CollectionEntity queryByUserName(String username) {
        return null;
    }

    private CollectionEntity draw(int userId,String id){

        se = HibernateUtils.openSession();
        ts = se.beginTransaction();

        CollectionEntity collection = null;
        Query query =  se.createQuery(" from CollectionEntity where userId=? and id =?");
        query.setParameter(0,userId);
        query.setParameter(1,id);
        query.setMaxResults(1);
        collection = (CollectionEntity) query.uniqueResult();

        ts.commit();
        se.close();
        return collection;
    }
}
