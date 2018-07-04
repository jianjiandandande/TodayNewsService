package Base;

import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface BaseServices<T> {


    void add(T t);

    List<T> getAll(int userId);

    void delete(int userId, String name);

    T selectT(int userId, String name);

    T queryByUserName(String username);

    T update(T t);


}
