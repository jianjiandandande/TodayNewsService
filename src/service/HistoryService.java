package service;

import Base.BaseServiceImpl;
import DaoImpl.HistoryDaoImpl;
import net.sf.json.JSONArray;
import org.json.JSONObject;
import table.HistoryEntity;
import table.UserEntity;

import java.util.List;

public class HistoryService extends BaseServiceImpl<HistoryEntity> {

    private HistoryDaoImpl historyDao = new HistoryDaoImpl();

    @Override
    public void add(HistoryEntity historyEntity) {
        historyDao.insert(historyEntity);
    }

    @Override
    public List<HistoryEntity> getAll(int userId) {
        return historyDao.getAll(userId);
    }

    @Override
    public void delete(int userId, String id) {
        historyDao.delete(userId, id);
    }

    @Override
    public HistoryEntity selectT(int userId, String id) {
        return historyDao.selectT(userId, id);
    }

    @Override
    public HistoryEntity queryByUserName(String username) {
        return null;
    }

    public JSONArray getAllHistory(int userId) {
        List<HistoryEntity> historyEntities = getAll(userId);
        JSONArray jsonArray = JSONArray.fromObject(historyEntities);
        return jsonArray;
    }

    public JSONObject addHistory(int userId, String id, String uid, String content,
                                 String model, String imageUrl, String videoUrl,
                                 String title,
                                 String author, String skimCount, String loveCount,
                                 String commentCount) {

        JSONObject json = new JSONObject();

        HistoryEntity history = selectT(userId, id);

        if (history != null) {

            delete(userId, id);
        }

        System.out.println("userId = "+userId);
        System.out.println("id = "+id);
        System.out.println("uid = "+uid);
        System.out.println("content = "+content);
        System.out.println("model = "+model);
        System.out.println("imageUrl = "+imageUrl);
        System.out.println("videoUrl = "+videoUrl);
        System.out.println("author = "+author);
        System.out.println("skim_count = "+skimCount);
        System.out.println("loveCount = "+loveCount);
        System.out.println("commentCount = "+commentCount);

        HistoryEntity historyEntity = new HistoryEntity();

        historyEntity.setUserId(userId);
        historyEntity.setId(id);
        historyEntity.setUid(uid);
        historyEntity.setModel(model);
        historyEntity.setContent(content);
        historyEntity.setImageUrl(imageUrl);
        historyEntity.setVideoUrl(videoUrl);
        historyEntity.setTitle(title);
        historyEntity.setAuthor(author);
        historyEntity.setSkimCount(skimCount);
        historyEntity.setLoveCount(loveCount);
        historyEntity.setCommentCount(commentCount);

        add(historyEntity);
        json.put("code", 503);
        json.put("msg", "添加历史成功");

        return json;

    }

    public JSONArray queryHistory(int userId){

        JSONArray array = getAllHistory(userId);
        return array;
    }
}
