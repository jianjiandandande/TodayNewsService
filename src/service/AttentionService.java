package service;

import Base.BaseServiceImpl;
import DaoImpl.AttentionDaoImpl;
import DaoImpl.CollectionDaoImpl;
import net.sf.json.JSONArray;
import org.json.JSONObject;
import table.AttentionEntity;
import table.CollectionEntity;

import java.util.List;

public class AttentionService extends BaseServiceImpl<AttentionEntity> {

    private AttentionDaoImpl attentionDao = new AttentionDaoImpl();

    @Override
    public void add(AttentionEntity attentionEntity) {
        attentionDao.insert(attentionEntity);
    }


    @Override
    public List<AttentionEntity> getAll(int userId) {
        return attentionDao.getAll(userId);
    }

    @Override
    public void delete(int userId, String id) {
        attentionDao.delete(userId, id);
    }

    @Override
    public AttentionEntity selectT(int userId, String id) {
        return attentionDao.selectT(userId, id);
    }

    @Override
    public AttentionEntity queryByUserName(String username) {
        return null;
    }

    public JSONArray getAllCollection(int userId) {
        List<AttentionEntity> attentionEntities = getAll(userId);
        JSONArray jsonArray = JSONArray.fromObject(attentionEntities);
        return jsonArray;
    }

    public JSONObject addAttention(int userId,String uid,String uname,String iconUrl) {

        JSONObject json = new JSONObject();

        AttentionEntity attention = selectT(userId, uid);

        if (attention != null) {

            delete(userId, uid);
        }

        AttentionEntity attentionEntity = new AttentionEntity();

        attentionEntity.setUserId(userId);
        attentionEntity.setUid(uid);
        attentionEntity.setUname(uname);
        attentionEntity.setIconUrl(iconUrl);

        add(attentionEntity);
        json.put("code", 507);
        json.put("msg", "关注成功");

        return json;

    }

    public JSONArray queryAttention(int userId){

        JSONArray array = getAllCollection(userId);
        return array;
    }

    public JSONObject deleteAttention(int userId,String uid){

        AttentionEntity attentionEntity = selectT(userId,uid);
        JSONObject json = new JSONObject();
        if (attentionEntity!=null) {

            delete(userId,uid);
            json.put("code", 508);
            json.put("msg", "已取消关注");

        }else {
            json.put("code", 407);
            json.put("msg", "取消关注失败");
        }
        return json;
    }
}
