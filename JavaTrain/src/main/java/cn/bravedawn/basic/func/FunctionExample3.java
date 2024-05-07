package cn.bravedawn.basic.func;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/5/6 15:43
 */
public class FunctionExample3 {

    /**
     * 值传递和引用传递
     *
     * 结论：如果在方法中重置了对象的引用，则修改信息的是不同的对象。
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
        user = new User(user.name, user.age);
        user.name = user.name + "1";
        user.age = user.age + 1;
    }


    public static void main(String[] args) {
        FunctionExample3 example2 = new FunctionExample3();
        User user = new User("fengxiao", 18);
        System.out.println("User: " + user);
        example2.func(user);
        System.out.println("User: " + user);
    }

}

