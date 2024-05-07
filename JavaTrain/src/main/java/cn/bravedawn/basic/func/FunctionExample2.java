package cn.bravedawn.basic.func;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/5/6 15:43
 */
public class FunctionExample2 {

    /**
     * 值传递和引用传递
     *
     * 结论：对于引用类型，本质上是将对象的地址以值的方式传递到形参中，修改信息的是同一个对象。
     */


    static class User {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public void func(User user) {
        user.name = user.name + "1";
        user.age = user.age + 1;
    }


    public static void main(String[] args) {
        FunctionExample2 example2 = new FunctionExample2();
        User user = new User("fengxiao", 18);
        System.out.println("User: " + user);
        example2.func(user);
        System.out.println("User: " + user);
    }

}

