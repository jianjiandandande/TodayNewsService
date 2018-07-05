package service;

import Base.BaseServiceImpl;
import DaoImpl.CollectionDaoImpl;
import net.sf.json.JSONArray;
import org.json.JSONObject;
import table.CollectionEntity;

import java.util.List;

public class CollectionService extends BaseServiceImpl<CollectionEntity> {

    private CollectionDaoImpl collectionDao = new CollectionDaoImpl();

    @Override
    public void add(CollectionEntity collectionEntity) {
        collectionDao.insert(collectionEntity);
    }

    @Override
    public List<CollectionEntity> getAll(int userId) {
        return collectionDao.getAll(userId);
    }

    @Override
    public void delete(int userId, String id) {
        collectionDao.delete(userId, id);
    }

    @Override
    public CollectionEntity selectT(int userId, String id) {
        return collectionDao.selectT(userId, id);
    }

    @Override
    public CollectionEntity queryByUserName(String username) {
        return null;
    }

    public JSONArray getAllCollection(int userId) {
        List<CollectionEntity> collectionEntities = getAll(userId);
        JSONArray jsonArray = JSONArray.fromObject(collectionEntities);
        return jsonArray;
    }

    public JSONObject addCollection(int userId, String id, String uid, String content,
                                 String model, String imageUrl, String videoUrl,
                                 String title,
                                 String author, String skimCount, String loveCount,
                                 String commentCount) {

        JSONObject json = new JSONObject();

        CollectionEntity collection = selectT(userId, id);

        if (collection != null) {

            delete(userId, id);
        }

        CollectionEntity collectionEntity = new CollectionEntity();

        collectionEntity.setUserId(userId);
        collectionEntity.setId(id);
        collectionEntity.setUid(uid);
        collectionEntity.setModel(model);
        collectionEntity.setContent(content);
        collectionEntity.setImageUrl(imageUrl);
        collectionEntity.setVideoUrl(videoUrl);
        collectionEntity.setTitle(title);
        collectionEntity.setAuthor(author);
        collectionEntity.setSkimCount(skimCount);
        collectionEntity.setLoveCount(loveCount);
        collectionEntity.setCommentCount(commentCount);

        add(collectionEntity);
        json.put("code", 504);
        json.put("msg", "添加收藏成功");

        return json;

    }

    public JSONArray queryCollection(int userId){

        JSONArray array = getAllCollection(userId);
        return array;
    }

    public JSONObject deleteCollection(int userId,String id){

        CollectionEntity collectionEntity = selectT(userId,id);
        JSONObject json = new JSONObject();
        if (collectionEntity!=null) {

            delete(userId,id);
            json.put("code", 505);
            json.put("msg", "删除收藏成功");

        }else {
            json.put("code", 404);
            json.put("msg", "删除收藏失败");
        }
        return json;
    }
}
