package DaoImpl;

import Base.BaseDaoImpl;
import org.hibernate.query.Query;
import table.UserEntity;
import utils.HibernateUtils;

import java.util.List;

/**
 * Created by Vincent on 2018/7/3.
 */
public class UserDaoImpl extends BaseDaoImpl<UserEntity> {

    @Override
    public void insert(UserEntity userEntity) {
        super.insert(userEntity);
    }

    @Override
    public List<UserEntity> getAll(int userId) {
        return null;
    }

    @Override
    public void delete(int userId, String name) {

    }

    @Override
    public UserEntity selectT(int userId, String name) {
        return null;
    }

    @Override
    public UserEntity queryByUserName(String value) {

        se = HibernateUtils.openSession();
        ts = se.beginTransaction();

        UserEntity user = null;
        Query query = se.createQuery("from UserEntity where username = ?");
        query.setParameter(0, value);
        query.setMaxResults(1);
        user = (UserEntity) query.uniqueResult();

        ts.commit();
        se.close();

        return user;
    }
}
