package cn.bravedawn.collection.map.treemap;

/**
 * @Description : TODO
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-25 16:27
 */
public class Student {

    public String name;
    public int score;


    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }


    public String toString() {
        return String.format("{%s: score=%d}", name, score);
    }
}
