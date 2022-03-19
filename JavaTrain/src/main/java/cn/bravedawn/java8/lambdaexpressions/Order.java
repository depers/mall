package cn.bravedawn.java8.lambdaexpressions;

import java.util.Date;

public class Order {

    private Date time;

    private int id;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order(int id, Date time) {
        this.time = time;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "time=" + time +
                ", id=" + id +
                '}';
    }
}
