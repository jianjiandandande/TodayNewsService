package table;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Vincent on 2018/7/4.
 */
@Entity
@Table(name = "user", schema = "today_news", catalog = "")
public class UserEntity implements Serializable{
    private int userId;
    private String username;
    private String password;
    private String telephone;
    private String userIcon;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "user_icon")
    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(userIcon, that.userIcon);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, username, password, telephone, userIcon);
    }
}
