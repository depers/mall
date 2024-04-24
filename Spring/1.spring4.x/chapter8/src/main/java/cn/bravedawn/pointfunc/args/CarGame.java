package cn.bravedawn.pointfunc.args;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/11 17:36
 */
public class CarGame {

    public void run(Car car) {
        car.run();
    }

    public void run(Bus bus) {
        bus.run();
    }

    public void run(Train train) {
        train.run();
    }
}
