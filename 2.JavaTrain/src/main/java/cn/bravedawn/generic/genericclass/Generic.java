package cn.bravedawn.generic.genericclass;

// 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
// 在实例化泛型类时，必须指定T的具体类型
public class Generic<T> {

    /**
     * 定义一个泛型类
     *
     * 定义语法格式：
     *              class 类名称 <泛型标识：可以随便写任意标识号，标识指定的泛型的类型>{
     *                  private 泛型标识 var;
     *                  .....
     *              }
     */

    // key这个成员变量的类型为T，T的类型由外部指定
    private T key;


    // 泛型构造方法形参key的类型也为T，T的类型由外部指定
    public Generic(T key) {
        this.key = key;
    }


    /**
     * 成员方法getKey的返回值类型为T，T的类型由外部指定
     * 虽然在这个方法中使用了泛型，但是这并不是一个泛型方法。这只是类中一个普通的成员方法，
     * 只不过他的返回值是在声明泛型类已经声明过的泛型，所以在这个方法中才可以继续使用 T 这个泛型。
     */
    public T getKey() {
        return key;
    }
}
