package cn.bravedawn.obj.inherit.nestedclass.anonymousclass;

public class Book {


    /**
     * 声明一个匿名类的方法一：扩展一个类
     */

    private String name;

    public Book(String name) {
        this.name = name;
    }

    public void readBook() {
        System.out.println("我在读书");
    }

    public void noteBook() {
        System.out.println("我在记笔记");
    }


    public static void main(String[] args) {
        Book book = new Book("深入理解Java虚拟机") {

            static String name = "hello";
            static int a = 0;

            @Override
            public void readBook() {
                System.out.println("匿名类：我在读书");
            }

            @Override
            public void noteBook() {
                System.out.println("匿名类：我在记笔记");
            }

            public static void bookMark() {
                System.out.println("匿名类：标记");
            }
        };

        System.out.println(book.getClass().isAnonymousClass());
        book.noteBook();
    }

}
