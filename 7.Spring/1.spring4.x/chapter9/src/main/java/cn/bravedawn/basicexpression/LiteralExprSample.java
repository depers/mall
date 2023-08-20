package cn.bravedawn.basicexpression;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author : depers
 * @program : chapter9
 * @description:
 * @date : Created in 2023/7/26 13:18
 */
public class LiteralExprSample {

    /**
     * SpEL表达式基础-文本字符解析
     */

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        // String
        String helloWorld = (String) parser.parseExpression("\"Hello World\"").getValue();
        // double
        double doubleNumber = (Double) parser.parseExpression("6.0221415E+23").getValue();
        // int
        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
        // bool
        boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
        // null
        Object nullValue = parser.parseExpression("null").getValue();

        System.out.println("Hello World = "+ helloWorld);
        System.out.println("6.0221415E+23 = "+ doubleNumber);
        System.out.println("0x7FFFFFFF = "+ maxValue);
        System.out.println("true = "+ trueValue);
        System.out.println("null = "+ nullValue);
    }
}
