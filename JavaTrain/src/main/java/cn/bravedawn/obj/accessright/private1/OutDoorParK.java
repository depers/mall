package cn.bravedawn.obj.accessright.private1;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/8/2 21:10
 */
public class OutDoorParK implements Exercise {

    /**
     * 接口定义的私有方法，子类是无法实现的
     */


    @Override
    public void swimming() {
        System.out.println("public method: swimming");
    }

}
