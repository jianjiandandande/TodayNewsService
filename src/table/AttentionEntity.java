package table;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Vincent on 2018/7/4.
 */
@Entity
@Table(name = "attention", schema = "today_news", catalog = "")
public class AttentionEntity implements Serializable{
    private int userId;
    private String uid;
    private String iconUrl;
    private String uname;

    @Id
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "icon_url")
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Basic
    @Column(name = "uname")
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttentionEntity that = (AttentionEntity) o;
        return userId == that.userId &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(iconUrl, that.iconUrl) &&
                Objects.equals(uname, that.uname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, uid, iconUrl, uname);
    }
}
