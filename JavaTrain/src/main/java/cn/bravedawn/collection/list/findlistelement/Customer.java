package cn.bravedawn.collection.list.findlistelement;

import java.util.Objects;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/16 13:14
 */
public class Customer {

    /**
     * 自定义POJO
     * 注意：这里必须重写该类的 hashCode()和equals()方法
     */

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
