package actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;
import service.AttentionService;
import service.CollectionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vincent on 2018/7/4.
 */
public class AddAttentionAction extends ActionSupport {


    private int userId;
    private String uid;
    private String iconUrl;
    private String uname;

    private HttpServletRequest request;

    private HttpServletResponse response;

    public String addAttention(){

        try {

            request = ServletActionContext.getRequest();
            response = ServletActionContext.getResponse();

            this.response.setContentType("text/json;charset=utf-8");
            this.response.setCharacterEncoding("UTF-8");

            AttentionService attentionService = new AttentionService();


            JSONObject json = attentionService.addAttention(userId,uid,uname,iconUrl);

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
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
