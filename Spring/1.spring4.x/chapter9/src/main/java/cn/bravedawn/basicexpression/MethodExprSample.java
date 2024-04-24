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
 * @date : Created in 2023/7/27 08:26
 */
public class MethodExprSample {

    /**
     * SpEL基础表达式，方法解析
     */

    public static void main(String[] args) {
        User user = new User();
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        // 调用String的方法
        String substring = parser.parseExpression("'Spring SpEL'.substring(7)").getValue(String.class);
        Integer index = parser.parseExpression("'Spring SpEL'.indexOf('SpEL')").getValue(Integer.class);

        // 调用实例的方法
        boolean isCorrect = parser.parseExpression("validatePassword('123456')").getValue(context, Boolean.class);
        // 调用私有方法，将会报错
        isCorrect = parser.parseExpression("validatePassword2('123456')").getValue(context, Boolean.class);
        // 调用静态方法
        isCorrect = parser.parseExpression("validatePassword3('123456')").getValue(context, Boolean.class);
        // 调用对象方法，可变参数列表
        parser.parseExpression("addInterests('Js','C')").getValue(context, Boolean.class);
    }
}
