package cn.bravedawn.generic.border;

import java.util.List;

public class TopBorderExample6 {

    /**
     * 观察下面的这个方法，定义的方法参数是 List<? extends Integer>，而不是List<Integer>
     * 从方法的内容实现来看，这个方法的形参定义成List<? extends Integer>，还是List<Integer>都是一样的
     * 之所以这样定义是因为：
     *  1. 只允许调用get()方法获取Integer的引用
     *  2. 不允许调用set(? extends Integer)方法并传入任何Integer的引用（null除外）
     */

    int sumOfList(List<? extends Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer n = list.get(i);
            sum = sum + n;
        }

        return sum;
    }
}
