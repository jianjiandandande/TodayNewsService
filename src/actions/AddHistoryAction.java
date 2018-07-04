package actions;


import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;
import service.HistoryService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddHistoryAction extends ActionSupport{

    private int userId;
    private String id;
    private String uid;
    private String content;
    private String imageUrl;
    private String model;
    private String videoUrl;
    private String author;
    private String skimCount;
    private String loveCount;
    private String title;
    private String commentCount;

    private HttpServletRequest request;

    private HttpServletResponse response;

    public String addHistory(){

        try {

            request = ServletActionContext.getRequest();
            response = ServletActionContext.getResponse();

            this.response.setContentType("text/json;charset=utf-8");
            this.response.setCharacterEncoding("UTF-8");

            HistoryService historyService = new HistoryService();

//            System.out.println("userId = "+userId);
//            System.out.println("id = "+id);
//            System.out.println("uid = "+uid);
//            System.out.println("content = "+content);
//            System.out.println("model = "+model);
//            System.out.println("imageUrl = "+imageUrl);
//            System.out.println("videoUrl = "+videoUrl);
//            System.out.println("author = "+author);
//            System.out.println("skim_count = "+skimCount);
//            System.out.println("loveCount = "+loveCount);
//            System.out.println("commentCount = "+commentCount);

            JSONObject json = historyService.addHistory(userId,id,uid,content,model,imageUrl,videoUrl,title,author,skimCount,loveCount,commentCount);

            byte[] jsonBytes = json.toString().getBytes("utf-8");
            response.setContentLength(jsonBytes.length);
            response.getOutputStream().write(jsonBytes);
            response.getOutputStream().flush();
            response.getOutputStream().close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSkimCount() {
        return skimCount;
    }

    public void setSkimCount(String skimCount) {
        this.skimCount = skimCount;
    }

    public String getLoveCount() {
        return loveCount;
    }

    public void setLoveCount(String loveCount) {
        this.loveCount = loveCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}
