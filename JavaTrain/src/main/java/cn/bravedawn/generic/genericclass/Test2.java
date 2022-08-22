package cn.bravedawn.generic.genericclass;

public class Test2 {

    /**
     * 测试多元泛型类
     */


    public static void main(String[] args) {
        Notepad<String, Integer> t = new Notepad<>();
        t.setKey("fengxiao");
        t.setValue(20);
        System.out.println("姓名：" + t.getKey());
        System.out.println("年龄：" + t.getValue());
    }
}
