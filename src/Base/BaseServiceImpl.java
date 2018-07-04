package Base;

import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Vincent on 2018/7/3.
 */
public abstract class BaseServiceImpl<T> implements BaseServices<T>{

    public HttpServletRequest mRequest;

    public HttpServletResponse mResponse;

    private void init(){
        mRequest = ServletActionContext.getRequest();
        mResponse = ServletActionContext.getResponse();

        mResponse.setContentType("text/json;charset=utf-8");
        mResponse.setCharacterEncoding("UTF-8");
    }

    public void requestAndResponse(JSONArray jsonArray){
        init();
        try {
            byte[] jsonBytes = jsonArray.toString().getBytes("utf-8");
            mResponse.setContentLength(jsonBytes.length);
            mResponse.getOutputStream().write(jsonBytes);
            mResponse.getOutputStream().flush();
            mResponse.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public T update(T t) {
        return null;
    }
}
