package cn.bravedawn.collection.list.commonuse;

import java.time.LocalDateTime;

public class Employee {

    private String name;
    private LocalDateTime date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Employee(String name, LocalDateTime date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
