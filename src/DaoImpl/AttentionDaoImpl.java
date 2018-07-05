package DaoImpl;

import Base.BaseDaoImpl;
import org.hibernate.query.Query;
import table.AttentionEntity;
import table.CollectionEntity;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 2018/7/4.
 */
public class AttentionDaoImpl extends BaseDaoImpl<AttentionEntity> {
    @Override
    public List<AttentionEntity> getAll(int userId) {
        se = HibernateUtils.openSession();
        ts = se.beginTransaction();

        List<AttentionEntity> attentionEntities = new ArrayList<AttentionEntity>();

        Query query = se.createQuery(" from AttentionEntity where userId=?");
        query.setParameter(0,userId);
        attentionEntities = query.getResultList();
        ts.commit();
        se.close();
        return attentionEntities;
    }

    @Override
    public void insert(AttentionEntity attentionEntity) {
        super.insert(attentionEntity);
    }

    @Override
    public void delete(int userId, String id) {
        AttentionEntity collection = draw(userId,id);
        if (collection==null){
            return;
        }
        se = HibernateUtils.openSession();
        ts = se.beginTransaction();
        se.delete(collection);
        ts.commit();
        se.close();
    }

    @Override
    public AttentionEntity selectT(int userId, String id) {
        AttentionEntity attention = draw(userId,id);
        return attention;
    }

    @Override
    public AttentionEntity queryByUserName(String username) {
        return null;
    }

    private AttentionEntity draw(int userId,String uid){

        se = HibernateUtils.openSession();
        ts = se.beginTransaction();

        AttentionEntity attention = null;
        Query query =  se.createQuery(" from AttentionEntity where userId=? and uid =?");
        query.setParameter(0,userId);
        query.setParameter(1,uid);
        query.setMaxResults(1);
        attention = (AttentionEntity) query.uniqueResult();

        ts.commit();
        se.close();
        return attention;
    }
}
