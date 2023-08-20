package cn.bravedawn.basic.keyword.static_.interface_;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/8/2 21:24
 */
public class Athlete implements Running{


    @Override
    public void shortDistanceRun() {
        System.out.println("短跑运动");
    }
}
