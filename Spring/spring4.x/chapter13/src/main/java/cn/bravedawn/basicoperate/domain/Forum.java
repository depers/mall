package cn.bravedawn.basicoperate.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author : depers
 * @program : spring4.x
 * @description:
 * @date : Created in 2023/8/3 21:23
 */
public class Forum {

    private int forumId;
    private String forumName;
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
