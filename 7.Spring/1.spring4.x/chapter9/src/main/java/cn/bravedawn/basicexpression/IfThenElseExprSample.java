package cn.bravedawn.basicexpression;

import cn.bravedawn.PlaceOfBirth;
import cn.bravedawn.User;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;

/**
 * @author : depers
 * @program : chapter9
 * @description:
 * @date : Created in 2023/7/27 08:47
 */
public class IfThenElseExprSample {

    /**
     * SpEL表达式基础-三元操作符
     */

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("tom");
        user.setLastVisit(new Date());
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国","厦门"));

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(user);

        String expression = "UserName == 'tom'? Credits+10:Credits";
        Integer credits = parser.parseExpression(expression).getValue(context, Integer.class);
        System.out.println(credits); // 110
    }
}
