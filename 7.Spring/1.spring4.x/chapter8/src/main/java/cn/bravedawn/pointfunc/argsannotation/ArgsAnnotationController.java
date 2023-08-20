package cn.bravedawn.pointfunc.argsannotation;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/13 17:35
 */

public class ArgsAnnotationController {

    public String getStr(@Param(value = "id") int id) {
        System.out.println("方法的参数是id=" + id);
        return String.valueOf(id);
    }
}
