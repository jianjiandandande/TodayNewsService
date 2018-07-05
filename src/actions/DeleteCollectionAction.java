package actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;
import service.CollectionService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vincent on 2018/7/4.
 */
public class DeleteCollectionAction extends ActionSupport {

    private int userId;

    private String id;

    private HttpServletRequest request;

    private HttpServletResponse response;

    public String deleteCollection(){


        try {

            request = ServletActionContext.getRequest();
            response = ServletActionContext.getResponse();

            this.response.setContentType("text/json;charset=utf-8");
            this.response.setCharacterEncoding("UTF-8");

            CollectionService collectionService = new CollectionService();

            JSONObject json = collectionService.deleteCollection(userId,id);

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
