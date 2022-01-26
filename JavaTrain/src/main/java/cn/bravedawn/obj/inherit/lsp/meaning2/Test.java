package cn.bravedawn.obj.inherit.lsp.meaning2;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/24 15:04
 */
public class Test {

    /**
     * 子类中可以增加自己特有的方法
     */

    public static void main(String[] args) {

        Course course = new Course(96, "Java企业级电商课程", 348d);
        System.out.println(course.getPrice()); // 348.0

        Course course2 = new DiscountCourse(97, "Java企业级电商课程", 348d);
        System.out.println(course2.getPrice()); // 278.40000000000003

        DiscountCourse course3 = new DiscountCourse(97, "Java企业级电商课程", 348d);
        System.out.println(course3.getPrice()); // 278.40000000000003
    }
}
