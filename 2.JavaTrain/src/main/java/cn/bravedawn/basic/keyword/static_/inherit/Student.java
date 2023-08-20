package cn.bravedawn.basic.keyword.static_.inherit;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/8/2 21:26
 */
public class Student extends People{


    @Override
    public void eat() {
        System.out.println("每个学生也要吃饭");
    }


}
