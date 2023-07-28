package cn.bravedawn.basicexpression;

import cn.bravedawn.PlaceOfBirth;
import cn.bravedawn.User;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;

/**
 * @author : depers
 * @program : spring4.x
 * @description:
 * @date : Created in 2023/7/28 21:28
 */
public class ElvisExprSample {


    /**
     * Spel表达式基础-Elvis操作符
     *
     * 操作符格式：name?:'UnKnown'，如果name是null就返回UnKnown，否则返回name本身
     */

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("tom");
        user.setLastVisit(new Date());
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国", "厦门"));

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(user);

        String username = parser.parseExpression("userName?:'用户名为空'").getValue(context, String.class);
        System.out.println(username);

        user.setUserName(null);
        username = parser.parseExpression("userName?:'用户名为空'").getValue(context, String.class);
        System.out.println(username);

    }
}
