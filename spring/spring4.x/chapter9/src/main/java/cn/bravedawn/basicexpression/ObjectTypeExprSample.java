package cn.bravedawn.basicexpression;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ObjectTypeExprSample {


    /**
     * SpEL表达式基础-调用对象类型、调用类的静态方法
     */

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();


        // 加载java.lang.String
        Class stringClass = parser.parseExpression("T(java.lang.String)").getValue(Class.class);
        System.out.println(stringClass == java.lang.String.class); // true

        // 加载cn.bravedawn.User
        Class userClass = parser.parseExpression("T(cn.bravedawn.User)").getValue(Class.class);
        System.out.println(userClass == cn.bravedawn.User.class); // true

        // 调用类的静态方法
        Object randomValue = parser.parseExpression("T(java.lang.Math).random()").getValue();
        System.out.println(randomValue);

    }
}
