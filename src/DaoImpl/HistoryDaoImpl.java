package DaoImpl;

import Base.BaseDaoImpl;

import org.hibernate.query.Query;
import table.HistoryEntity;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class HistoryDaoImpl extends BaseDaoImpl<HistoryEntity> {

    @Override
    public List<HistoryEntity> getAll(int userId) {

        se = HibernateUtils.openSession();
        ts = se.beginTransaction();

        List<HistoryEntity> history = new ArrayList<HistoryEntity>();

        Query query = se.createQuery(" from HistoryEntity where userId=?");
        query.setParameter(0,userId);
        history = query.getResultList();
        ts.commit();
        se.close();
        return history;
    }

    @Override
    public void insert(HistoryEntity historyEntity) {
        super.insert(historyEntity);
    }

    @Override
    public void delete(int userId, String id) {
        HistoryEntity history = draw(userId,id);
        se.delete(history);
    }

    @Override
    public HistoryEntity selectT(int userId, String id) {
        HistoryEntity history = draw(userId,id);

        return history;
    }

    @Override
    public HistoryEntity queryByUserName(String username) {
        return null;
    }

    private HistoryEntity draw(int userId,String id){

        se = HibernateUtils.openSession();
        ts = se.beginTransaction();

        HistoryEntity history = null;
        Query query =  se.createQuery(" from HistoryEntity where userId=? and id =?");
        query.setParameter(0,userId);
        query.setParameter(1,id);
        query.setMaxResults(1);
        history = (HistoryEntity) query.uniqueResult();

        ts.commit();
        se.close();
        return history;
    }
}
