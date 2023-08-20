package cn.bravedawn.basicexpression;

import cn.bravedawn.User;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ObjectConstructExprSample {

    /**
     * SpEL表达式基础-使用new运算符调用构造器
     */


    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        User user  = parser.parseExpression("new cn.bravedawn.User('tom')").getValue(User.class);
        System.out.println(user.getUserName()); // tom
    }
}
