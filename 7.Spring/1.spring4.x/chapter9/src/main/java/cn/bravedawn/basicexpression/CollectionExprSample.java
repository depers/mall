package cn.bravedawn.basicexpression;

import cn.bravedawn.PlaceOfBirth;
import cn.bravedawn.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

/**
 * @author : depers
 * @program : chapter9
 * @description:
 * @date : Created in 2023/7/26 13:29
 */
public class CollectionExprSample {

    /**
     * SpEL表达式基础-数组、集合解析
     */

    public static void main(String[] args) {
        // 构造对象属性
        User user = new User();
        user.setUserName("tom");
        user.setLastVisit(new Date());
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国", "厦门"));
        user.setInterestsArray(new String[]{"Java", "C++"});

        Map interestsMap = new HashMap();
        interestsMap.put("interest1", "Java");
        interestsMap.put("interest2", "C++");
        user.setInterestsMap(interestsMap);

        List<String> interestsList = new ArrayList();
        interestsList.add("Java");
        interestsList.add("C++");
        user.setInterestsList(interestsList);

        // 构造spel解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        // 数组表达式解析
        int[] array1 = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(context);
        int[][] array2 = (int[][]) parser.parseExpression("new int[2][3]").getValue(context);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.deepToString(array2));

        // 目前不支持多维数组初始化，这段代码将会报错
        //int[][] array3= (int[][]) parser.parseExpression("new int[2][3]{{1,2,3},{4,5,6}}").getValue(context);

        // List表达式解析
        List list = (List) parser.parseExpression("{1,2,3,4}").getValue(context);
        List listOfLists = (List) parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(context);
        System.out.println(list);
        System.out.println(listOfLists);

        // 列表字符串解析
        Map userInfo = (Map) parser.parseExpression("{userName:'tom',credits:100 }").getValue(context);
        List userInfo2 = (List) parser.parseExpression("{{userName:'tom',credits:100 },{userName:'tom',credits:100 }}").getValue(context);
        System.out.println(userInfo);
        System.out.println(userInfo2.get(0) instanceof User);

        // 从User对象的属性 数组、列表和map取值
        String interest1 = (String)parser.parseExpression("interestsArray[0]").getValue(context);
        String interest2 = (String)parser.parseExpression("interestsList[0]").getValue(context);
        String interest3 = (String)parser.parseExpression("interestsMap['interest1']").getValue(context);
        System.out.println(interest1);
    }
}
