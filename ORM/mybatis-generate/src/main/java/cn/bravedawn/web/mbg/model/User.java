package cn.bravedawn.web.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别，1-男，2-女
     */
    private Byte gender;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 家庭住址
     */
    private String familyAddress;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 婚姻状态，0-未婚，1-已婚
     */
    private Byte maritalStatus;

    /**
     * 出生日期
     */
    private String dateOfBirth;

    /**
     * 学历，0-大专，1-本科，3-硕士，4-博士
     */
    private Byte educationBackground;

    /**
     * 插入人员
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date insertTime;

    /**
     * 更新人员
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFamilyAddress() {
        return familyAddress;
    }

    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Byte maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Byte getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(Byte educationBackground) {
        this.educationBackground = educationBackground;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", gender=").append(gender);
        sb.append(", phone=").append(phone);
        sb.append(", familyAddress=").append(familyAddress);
        sb.append(", email=").append(email);
        sb.append(", maritalStatus=").append(maritalStatus);
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", educationBackground=").append(educationBackground);
        sb.append(", createUser=").append(createUser);
        sb.append(", insertTime=").append(insertTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}