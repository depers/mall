package cn.bravedawn.basicexpression;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTransitionExprSample {

    /**
     * SpEL表达式基础-集合转换
     */


    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();

        List<Integer> credits = new ArrayList<>();
        credits.addAll(Arrays.asList(150, 100, 90, 50, 110, 130, 70));
        context.setVariable("credits", credits);

        List<Boolean> creditsGreater100 = (List<Boolean>) parser.parseExpression("#credits.![#this>100]").getValue(context);
        System.out.println(creditsGreater100);
    }
}
