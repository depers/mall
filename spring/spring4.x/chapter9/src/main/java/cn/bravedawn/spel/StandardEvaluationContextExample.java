package cn.bravedawn.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : depers
 * @program : chapter9
 * @description:
 * @date : Created in 2023/7/20 21:25
 */
public class StandardEvaluationContextExample {

    /**
     * 4.StandardEvaluationContext的简单使用
     * 下面主要演示了如果通过StandardEvaluationContext去修改对象实例的属性的。
     * 其中字符串"false"会自动由StandardEvaluationContext中的ConversionService将其从字符串变为布尔值。
     */


    static class Simple{

        public List<Boolean> booleanList = new ArrayList<Boolean>();

    }

    public static void main(String[] args) {
        Simple simple = new Simple();
        // 第0个索引处放true
        simple.booleanList.add(true);

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext simpleContext = new StandardEvaluationContext(simple);
        parser.parseExpression("booleanList[0]").setValue(simpleContext, "false");
        boolean b = simple.booleanList.get(0);
        System.out.println(b);
    }
}
