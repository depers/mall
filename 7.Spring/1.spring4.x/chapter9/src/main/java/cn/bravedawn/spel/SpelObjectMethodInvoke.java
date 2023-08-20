package cn.bravedawn.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author : depers
 * @program : chapter9
 * @description:
 * @date : Created in 2023/7/20 21:15
 */
public class SpelObjectMethodInvoke {

    /**
     * 3.通过Spel实现对方法的调用，下面例子中调用了String.concat()方法
     */

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'hello'.concat('!')");
        String msg = exp.getValue(String.class);
        System.out.println(msg);
    }
}
