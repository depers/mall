package cn.bravedawn.basicexpression;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

public class CollectionFilterExprSample {


    /**
     * SpEL表达式基础-集合过滤
     * 集合过滤的语法为：?[selectExpression]
     */

    public static void main(String[] args) {

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();

        // 列表的过滤
        List<Integer> credits = new ArrayList<>();
        credits.addAll(Arrays.asList(150, 100, 90, 50, 110, 130, 70));
        // 为变量赋值
        context.setVariable("creditList", credits);
        List<Integer> creditsGreater100 = (List<Integer>) parser.parseExpression("#creditList.?[#this>100]").getValue(context);
        System.out.println(creditsGreater100);

        // 键值对的过滤
        Map<String, Integer> creditsMap = new HashMap<>();
        creditsMap.put("Tom", 95);
        creditsMap.put("Jony", 110);
        creditsMap.put("Morin", 85);
        creditsMap.put("Mose", 120);
        creditsMap.put("Morrow", 60);
        context.setVariable("creditsMap", creditsMap);

        Map<String, Integer> creditsMapGreater100 = (Map<String, Integer>)parser.parseExpression("#creditsMap.?[value>90]").getValue(context);
        System.out.println(creditsMapGreater100);
    }
}
