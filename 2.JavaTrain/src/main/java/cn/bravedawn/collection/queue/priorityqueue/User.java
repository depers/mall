package cn.bravedawn.collection.queue.priorityqueue;

/**
 * @Description : TODO
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-27 10:23
 */
public class User {

    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}
