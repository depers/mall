package cn.bravedawn.springsecurity.constant;

public enum RoleType {

    ADMIN("admin"),
    USER("user");

    private String roleName;

    RoleType(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
