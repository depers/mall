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
 * @date : Created in 2023/7/27 08:42
 */
public class SafeExprSample {

    /**
     * SpEL表达式，安全导航操作符
     */

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("tom");
        user.setLastVisit(new Date());
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国","厦门"));

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(user);
        String city = parser.parseExpression("PlaceOfBirth?.City").getValue(context, String.class);
        System.out.println(city); // 厦门

        user.setPlaceOfBirth(null);
        city = parser.parseExpression("PlaceOfBirth?.City").getValue(context, String.class);
        System.out.println(city); // null
    }
}
