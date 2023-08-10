package cn.bravedawn.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author : depers
 * @program : spring4.x
 * @description:
 * @date : Created in 2023/8/10 22:01
 */
@Entity
@Table(name="T_FORUM")
public class Forum implements Serializable {
    @Id
    @Column(name = "FORUM_ID")
    private int forumId;

    @Column(name = "FORUM_NAME")
    private String forumName;

    @Column(name = "FORUM_DESC")
    private String forumDesc;

    public String getForumDesc() {
        return forumDesc;
    }
    public void setForumDesc(String forumDesc) {
        this.forumDesc = forumDesc;
    }
    public int getForumId() {
        return forumId;
    }
    public void setForumId(int forumId) {
        this.forumId = forumId;
    }
    public String getForumName() {
        return forumName;
    }
    public void setForumName(String forumName) {
        this.forumName = forumName;
    }
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
