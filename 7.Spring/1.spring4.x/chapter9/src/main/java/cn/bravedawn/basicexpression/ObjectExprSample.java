package cn.bravedawn.basicexpression;

import cn.bravedawn.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ObjectExprSample {

    /**
     * SpEL表达式基础-对象属性赋值
     */


    public static void main(String[] args) {
        User user = new User("tom");
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        // 通过setValue()赋值
        parser.parseExpression("userName").setValue(context, "jony");
        System.out.println(user.getUserName());  // jony

        // 通过表达式赋值
        parser.parseExpression("userName='anyli'").getValue(context);
        System.out.println(user.getUserName());  // anyli

    }
}
