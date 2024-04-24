/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/8/14 21:39
 */
package cn.bravedawn.generic.variant;

/**
 * 类型系统中的重要概念：变型（variant），主要有三个规则
 * 1.协变（covariant），Java的数组采用了协变的规则
 * 2.逆变（contravariant）
 * 3.不变（invariant）,其中Java泛型采用了不变的规则
 *
 * 这些规则规定了类型构造器是如何界定父子类型之间关系的。
 * 我声明了两个类，一个是Animal类，一个是Dog类，其中Dog是Animal类的子类，f(type)就是指type类型经过f()类型构造器的处理转换为一个新的类型
 * 协变：就是指f(Dog)是f(Animal)的子类，也就是说Dog类经过类型构造器的处理后是Animal类经过类型构造器处理后的子类。
 * 逆变：就是指f(Animal)是f(Dog)的子类。
 * 不变：就是指f(Dog)和f(Animal)之前没有关系。既不是协变也不是逆变。
 *
 * 类型构造器f(type)可以是
 * 1.泛型：List<Animal>、List<Dog>
 * 2.数组：Animal[]、Dog[]
 * 3.函数/方法：method(Animal)、method(Dog)
 */