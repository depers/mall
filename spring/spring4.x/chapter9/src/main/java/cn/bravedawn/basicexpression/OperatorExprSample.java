package cn.bravedawn.basicexpression;

import cn.bravedawn.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author : depers
 * @program : chapter9
 * @description:
 * @date : Created in 2023/7/27 08:33
 */
public class OperatorExprSample {

    /**
     * SpEL表达式基础-操作符解析
     */

    public static void main(String[] args) {
        User user = new User();
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        //关系操作符
        boolean trueValue = parser.parseExpression("2 == 2").getValue(Boolean.class);
        boolean falseValue = parser.parseExpression("2 < -5.0").getValue(Boolean.class);
        // 字符串关系比较
        trueValue = parser.parseExpression("\"black\" < \"block\"").getValue(Boolean.class);
        // instanceof运算符
        falseValue = parser.parseExpression("'xyz' instanceof T(int)").getValue(Boolean.class);
        //正则匹配运算
        trueValue = parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
        falseValue = parser.parseExpression("'5.0067' matches '\\^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);


        // 逻辑操作符
        //AND
        falseValue = parser.parseExpression("true and false").getValue(Boolean.class);
        String expression = "isVipMember('tom') && isVipMember('jony')";
        trueValue = parser.parseExpression(expression).getValue(context, Boolean.class);
        //OR
        trueValue = parser.parseExpression("true or false").getValue(Boolean.class);
        // NOT
        falseValue = parser.parseExpression("!true").getValue(Boolean.class);


        // 算术运算操作符
        //加法操作
        int two = parser.parseExpression("1 + 1").getValue(Integer.class); // 2
        String testString = parser.parseExpression(
                "\"test\" + ' ' + \"string\"").getValue(String.class); // test string
        //减法操作
        int four = parser.parseExpression("1 - -3").getValue(Integer.class); // 4
        double d = parser.parseExpression("1000.00 - 1e4").getValue(Double.class); // -9000
        // 乘法操作
        int six = parser.parseExpression("-2 * -3").getValue(Integer.class); // 6
        double twentyFour = parser.parseExpression("2.0 * 3e0 * 4").getValue(Double.class); //24.0
        // 除法操作
        int minusTwo = parser.parseExpression("6 / -3").getValue(Integer.class); // -2
        double one = parser.parseExpression("8.0 / 4e0 / 2").getValue(Double.class); // 1.0
        // 求余操作
        int three = parser.parseExpression("7 % 4").getValue(Integer.class); // 3
        one = parser.parseExpression("8 / 5 % 2").getValue(Integer.class); // 1
        //优先级算术运算
        int minusTwentyOne = parser.parseExpression("1+2-3*8").getValue(Integer.class); // -21
    }
}
