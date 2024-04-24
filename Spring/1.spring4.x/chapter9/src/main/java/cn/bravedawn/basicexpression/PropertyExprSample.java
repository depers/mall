package cn.bravedawn.basicexpression;

import cn.bravedawn.PlaceOfBirth;
import cn.bravedawn.User;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author : depers
 * @program : chapter9
 * @description:
 * @date : Created in 2023/7/26 13:22
 */
public class PropertyExprSample {

    /**
     * SpEL表达式基础-对象属性解析
     */

    public static void main(String[] args) {
        // 构造一个对象
        User user = new User();
        user.setUserName("tom");
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国","厦门"));

        // 构造spel解析上下文
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(user);

        // 基本属性值获取
        String username = parser.parseExpression("userName").getValue(context,String.class);
        int credits = (Integer) parser.parseExpression("credits + 10").getValue(context);

        // 嵌套属性值获取
        String city = (String)parser.parseExpression("placeOfBirth.city").getValue(context);
        System.out.println("username = "+username);
        System.out.println("city = "+city);
        System.out.println("credits = "+credits);

    }
}
