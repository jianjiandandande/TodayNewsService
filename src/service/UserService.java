package service;

import Base.BaseServiceImpl;
import DaoImpl.UserDaoImpl;
import org.json.JSONObject;
import table.UserEntity;

import java.util.List;

/**
 * Created by Vincent on 2018/7/3.
 */
public class UserService extends BaseServiceImpl<UserEntity> {

    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public void add(UserEntity userEntity) {
        userDao.insert(userEntity);
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
    public UserEntity queryByUserName(String username) {
        return userDao.queryByUserName(username);
    }

    public JSONObject checkLogin(String username,String password){

        JSONObject json = new JSONObject();

        UserEntity user = queryByUserName(username);

        if (user==null){
            json.put("code",400);
            json.put("msg","用户名不存在");
        }else if(!user.getPassword().equals(password)){
            json.put("code",401);
            json.put("msg","密码错误");
        }else if(user.getPassword().equals(password)){
            json.put("code",500);
            json.put("msg","登录成功");
        }

        return json;
    }

    public JSONObject checkRegister(String username,String passsword,
                                    String telephone,String user_icon){

        JSONObject json = new JSONObject();

        UserEntity user = queryByUserName(username);

        if (user!=null){
            json.put("code",402);
            json.put("msg","用户名已存在");
        }else {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(username);
            userEntity.setPassword(passsword);
            userEntity.setTelephone(telephone);
            userEntity.setUserIcon(user_icon);

            add(userEntity);

            json.put("code",501);
            json.put("msg","注册成功");
        }

        return json;
    }

    public  JSONObject getUserInfo(String username){

        JSONObject json = new JSONObject();

        UserEntity user = queryByUserName(username);

        if (user!=null) {
            json.put("userId",user.getUserId());
            json.put("username", user.getUsername());
            json.put("telephone", user.getTelephone());
            json.put("user_icon", user.getUserIcon());

            json.put("code", 502);
            json.put("msg", "获取用户信息成功");
        }else {
            json.put("code", 403);
            json.put("msg", "获取用户信息失败");
        }

        return json;

    }
}
