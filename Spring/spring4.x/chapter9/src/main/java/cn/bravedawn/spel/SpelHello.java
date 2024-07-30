package cn.bravedawn.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author : depers
 * @program : chapter9
 * @description:
 * @date : Created in 2023/7/20 21:06
 */
public class SpelHello {

    /**
     * 1.SpEL的简单使用
     */

    public static void main(String[] args) {
        ExpressionParser parser =new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello'+' World'");
        String message = (String) exp.getValue();
        System.out.println(message);
    }
}
