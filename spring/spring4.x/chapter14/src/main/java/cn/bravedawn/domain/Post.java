package cn.bravedawn.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : depers
 * @program : spring4.x
 * @description:
 * @date : Created in 2023/8/10 22:04
 */

@Entity
@Table(name="T_POST")
public class Post implements Serializable {
    @Id
    @Column(name = "POST_ID")
    private int postId;

    @Column(name = "USER_ID")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "TOPIC_ID")
    private Topic topic;

    @Lob
    @Column(name = "POST_TEXT")
    private String postText;

    @Lob
    @Column(name = "POST_ATTACH")
    private byte[] postAttach;

    @Column(name = "POST_TIME")
    private Date postTime;

    public int getPostId() {
        return postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }
    public String getPostText() {
        return postText;
    }
    public void setPostText(String postText) {
        this.postText = postText;
    }
    public Date getPostTime() {
        return postTime;
    }
    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public byte[] getPostAttach() {
        return postAttach;
    }
    public void setPostAttach(byte[] postAttach) {
        this.postAttach = postAttach;
    }
    public Topic getTopic() {
        return topic;
    }
    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
