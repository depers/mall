package cn.bravedawn.obj.object.equalsandhashcode.hashcode;

import java.util.Objects;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/26 18:05
 */
public class Team2 {

    /**
     * 覆盖了 hashcode() 方法的类
     */

    String city;
    String department;

    public Team2(String city, String department) {
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
        Team2 team2 = (Team2) o;
        return Objects.equals(city, team2.city) && Objects.equals(department, team2.department);
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (city != null) {
            result = 31 * result + city.hashCode();
        }
        if (department != null) {
            result = 31 * result + department.hashCode();
        }
        return result;
    }

    public static void main(String[] args) {
        Team2 t1 = new Team2("New York", "marketing");
        Team2 t2 = new Team2("New York", "marketing");

        System.out.println(t1.equals(t2)); // true
        System.out.println(t1.hashCode()); // -1010610888
        System.out.println(t2.hashCode()); // -1010610888
    }
}
