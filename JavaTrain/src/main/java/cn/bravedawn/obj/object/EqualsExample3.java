package cn.bravedawn.obj.object;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/24 7:29
 */
public class EqualsExample3 {

    /**
     * 对于整型包装类型，在-128到127之间的比较都用到了缓存池，这里的equals和==的作用是一样的。超过这个范围的值比较要使用equals方法，不能使用==
     * 对于浮点型包装类型，值的比较使用equals，不能使用==
     * 对于字符型包装类型，equals和==的作用是一样的
     * 对于布尔型包装类型，equals和==的作用是一样的
     *
     * 所以总结一句，对于基本数据类型的包装类型，值的比较建议使用equals，不要使用==
     */


    public static void main(String[] args) {
//        testInteger();
//        testLong();
//        testShort();
//        testByte();
//
//        testFloat();
//        testDouble();

//        testCharacter();

        testBoolean();
    }

    static void testInteger() {
        Integer i = -128;
        Integer i2 = -128;
        System.out.println(i.equals(i2));   // true
        System.out.println(i == i2);        // true

        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println(i3.equals(i4));  // true
        System.out.println(i3 == i4);       // true

        Integer i5 = -129;
        Integer i6 = -129;
        System.out.println(i5.equals(i6));  // true
        System.out.println(i5 == i6);       // false

        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7.equals(i8));  // true
        System.out.println(i7 == i8);       // false
    }

    static void testLong() {
        Long l = -128l;
        Long l2 = -128l;
        System.out.println(l.equals(l2));   // true
        System.out.println(l == l2);        // true

        Long l3 = 127l;
        Long l4 = 127l;
        System.out.println(l3.equals(l4));  // true
        System.out.println(l3 == l4);       // true

        Long l5 = -129l;
        Long l6 = -129l;
        System.out.println(l5.equals(l6));  // true
        System.out.println(l5 == l6);       // false

        Long l7 = 128l;
        Long l8 = 128l;
        System.out.println(l7.equals(l8));  // true
        System.out.println(l7 == l8);       // false
    }

    static void testByte() {
        Byte b = -128;
        Byte b2 = -128;
        System.out.println(b.equals(b2));   // true
        System.out.println(b == b2);        // true

        Byte b3 = 127;
        Byte b4 = 127;
        System.out.println(b3.equals(b4));  // true
        System.out.println(b3 == b4);       // true
    }

    static void testShort() {

        Short s = -128;
        Short s2 = -128;
        System.out.println(s.equals(s2));   // true
        System.out.println(s == s2);        // true

        Integer s3 = 127;
        Integer s4 = 127;
        System.out.println(s3.equals(s4));  // true
        System.out.println(s3 == s4);       // true

        Integer s5 = -129;
        Integer s6 = -129;
        System.out.println(s5.equals(s6));  // true
        System.out.println(s5 == s6);       // false

        Integer s7 = 128;
        Integer s8 = 128;
        System.out.println(s7.equals(s8));  // true
        System.out.println(s7 == s8);       // false
    }


    static void testFloat() {
        Float f = 3.14f;
        Float f2 = 3.14f;

        System.out.println(f == f2);        // false
        System.out.println(f.equals(f2));   // true
    }

    static void testDouble() {
        Double d = 3.14;
        Double d2 = 3.14;

        System.out.println(d == d2);        // false
        System.out.println(d.equals(d2));   // true
    }

    static void testCharacter() {
        Character c = '1';
        Character c2 = '1';

        System.out.println(c == c2);        // true
        System.out.println(c.equals(c2));   // true
    }

    static void testBoolean() {
        Boolean b = true;
        Boolean b2 = true;

        System.out.println(b == b2);        // true
        System.out.println(b.equals(b2));   // true
    }

}
