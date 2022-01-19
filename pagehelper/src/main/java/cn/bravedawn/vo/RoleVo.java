package cn.bravedawn.vo;

/**
 * @author : depers
 * @program : pagehelper
 * @description:
 * @date : Created in 2022/1/5 11:21
 */
public class RoleVo {

    private long id;
    private String roleName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RoleVo{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
