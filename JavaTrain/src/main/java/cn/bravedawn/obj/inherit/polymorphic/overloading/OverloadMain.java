package cn.bravedawn.obj.inherit.polymorphic.overloading;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/3 13:12
 */
public class OverloadMain {

    // Normal main()
    public static void main(String[] args) {
        System.out.println("Hi Geek (from main)");
        OverloadMain.main("Geek");
    }

    // Overloaded main methods
    public static void main(String arg1) {
        System.out.println("Hi, " + arg1);
        OverloadMain.main("Dear Geek", "My Geek");
    }


    public static void main(String arg1, String arg2) {
        System.out.println("Hi, " + arg1 + ", " + arg2);
    }
}
