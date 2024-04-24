package cn.bravedawn.spel;

import cn.bravedawn.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author : depers
 * @program : chapter9
 * @description:
 * @date : Created in 2023/7/20 21:08
 */
public class SpelObjectProperties {

    /**
     * 2.通过SpEL获取User实例的属性
     */

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("peter");
        user.setCredits(100);

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);
        String username = (String) parser.parseExpression("userName").getValue(context);
        System.out.println(username);


    }
}
