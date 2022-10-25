package cn.bravedawn.pojo;

import java.time.LocalDateTime;

/**
 * @author : depers
 * @program : jdbc-demo
 * @date : Created in 2022/10/25 20:43
 */
public class Role {

    private Integer id;

    private String roleName;

    private Integer type;

    private String note;

    private LocalDateTime insertTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(LocalDateTime insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", type=" + type +
                ", note='" + note + '\'' +
                ", insertTime=" + insertTime +
                '}';
    }
}
