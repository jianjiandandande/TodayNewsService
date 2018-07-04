package table;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Vincent on 2018/7/4.
 */
@Entity
@Table(name = "history", schema = "today_news", catalog = "")
public class HistoryEntity implements Serializable{
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

    @Id
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "videoUrl")
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "skim_count")
    public String getSkimCount() {
        return skimCount;
    }

    public void setSkimCount(String skimCount) {
        this.skimCount = skimCount;
    }

    @Basic
    @Column(name = "love_count")
    public String getLoveCount() {
        return loveCount;
    }

    public void setLoveCount(String loveCount) {
        this.loveCount = loveCount;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "commentCount")
    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryEntity that = (HistoryEntity) o;
        return userId == that.userId &&
                Objects.equals(id, that.id) &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(content, that.content) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(model, that.model) &&
                Objects.equals(videoUrl, that.videoUrl) &&
                Objects.equals(author, that.author) &&
                Objects.equals(skimCount, that.skimCount) &&
                Objects.equals(loveCount, that.loveCount) &&
                Objects.equals(title, that.title) &&
                Objects.equals(commentCount, that.commentCount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, id, uid, content, imageUrl, model, videoUrl, author, skimCount, loveCount, title, commentCount);
    }
}
