package cn.bravedawn.pointfunc.annotationannotation;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/11 16:45
 */
public class Controller {

    @Security("要加密")
    public String handle(int a, int b) {
        System.out.println("a=" + a + " b=" + b);
        return "hello world";
    }
}
