package cn.bravedawn.basicexpression;

import cn.bravedawn.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VariablesExprSample {

    /**
     * SpEL表达式基础-变量解析、集合过滤
     */


    public static void main(String[] args) {
        User user = new User("tom");
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        // 为newUserName变量设置新值
        context.setVariable("newUserName", "jony");

        // 取变量值，并赋值
        parser.parseExpression("userName=#newUserName").getValue(context);
        System.out.println(user.getUserName());

        // this变量的使用
        List<Integer> credits = new ArrayList<>();
        credits.addAll(Arrays.asList(150, 100, 90, 50, 110, 130, 70));
        // 为变量赋值
        context.setVariable("creditList", credits);
        System.out.println(parser.parseExpression("#creditList").getValue(context));

        List<Integer> creditsGreater100 = (List<Integer>) parser.parseExpression("#creditList.?[#this>100]").getValue(context);
        System.out.println(creditsGreater100);
    }
}
