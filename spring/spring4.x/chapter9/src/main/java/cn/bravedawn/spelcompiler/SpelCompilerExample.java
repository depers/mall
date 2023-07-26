package cn.bravedawn.spelcompiler;

import cn.bravedawn.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author : depers
 * @program : chapter9
 * @description:
 * @date : Created in 2023/7/26 13:07
 */
public class SpelCompilerExample {

    /**
     * SpelCompiler编译表达式示例代码
     */

    public static void main(String[] args) {
        User user = new User();
        // 创建解析配置
        SpelParserConfiguration configuration =
                new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, SpelCompilerExample.class.getClassLoader());
        // 创建解析器
        EvaluationContext context = new StandardEvaluationContext(user);
        // 创建取值上下文
        SpelExpressionParser parser = new SpelExpressionParser(configuration);
        // 表达式
        String expression = "isVipMember('tom') && isVipMember('jony')";
        // 解析表达式
        SpelExpression spelExpression = parser.parseRaw(expression);
        // 通过表达式求值
        System.out.println(spelExpression.getValue(context));
        System.out.println(spelExpression.getValue(context));
    }
}
