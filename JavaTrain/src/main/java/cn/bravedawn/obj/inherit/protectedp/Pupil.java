package cn.bravedawn.obj.inherit.protectedp;

public class Pupil extends Student{

    /**
     * 父类定义的字段访问控制权限是 protected，故其子类的子类也可以访问到
     * @return
     */

    public String helloPupil() {
        return "hello pupil" + name;
    }
}
