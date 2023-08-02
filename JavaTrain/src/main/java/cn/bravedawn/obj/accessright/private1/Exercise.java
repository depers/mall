package cn.bravedawn.obj.accessright.private1;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/8/2 21:08
 */
public interface Exercise {

    private void running() {
        System.out.println("private method:running()");
    }


    public void swimming();

    public static void badminton() {
        System.out.println("public static method: badminton()");
    }

}
