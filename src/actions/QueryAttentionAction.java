package actions;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import service.AttentionService;
import service.CollectionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vincent on 2018/7/4.
 */
public class QueryAttentionAction extends ActionSupport {

    private int userId;
    private HttpServletRequest request;

    private HttpServletResponse response;

    public String queryAttention(){


        try {

            request = ServletActionContext.getRequest();
            response = ServletActionContext.getResponse();

            this.response.setContentType("text/json;charset=utf-8");
            this.response.setCharacterEncoding("UTF-8");

            AttentionService attentionService = new AttentionService();


            JSONArray array = attentionService.queryAttention(userId);
            attentionService.requestAndResponse(array);

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
