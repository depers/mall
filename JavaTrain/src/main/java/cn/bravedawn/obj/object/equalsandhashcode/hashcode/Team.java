package cn.bravedawn.obj.object.equalsandhashcode.hashcode;

import java.util.Objects;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/26 17:02
 */
public class Team {

    /**
     * 翻写equals方法，不翻写hashcode方法。导致的结果是：equals会返回true，但是两个实例返回hashcode方法的值确是不一样的。
     *
     * 这里违反了hashcode方法的等于一致性原则
     */

    String city;
    String department;

    public Team(String city, String department) {
        this.city = city;
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(getCity(), team.getCity()) && Objects.equals(getDepartment(), team.getDepartment());
    }


    public static void main(String[] args) {
        Team t1 = new Team("New York", "marketing");
        Team t2 = new Team("New York", "marketing");

        System.out.println(t1.equals(t2)); // true
        System.out.println(t1.hashCode()); // 1342443276
        System.out.println(t2.hashCode()); // 769287236
    }


}
