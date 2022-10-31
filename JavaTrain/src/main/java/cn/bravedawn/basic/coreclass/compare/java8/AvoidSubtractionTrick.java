package cn.bravedawn.basic.coreclass.compare.java8;

import cn.bravedawn.basic.coreclass.compare.comparable.Player;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/31 20:33
 */
public class AvoidSubtractionTrick {

    /**
     * 避免使用减法实现比较器
     * 下面的comparator比较器是我们用减法来实现的，这样实现有什么问题吗？
     *     由于 -1 远小于 Integer.MAX_VALUE，因此“Roger”在排序后的集合中应该排在“John”之前。
     *     但是，由于整数溢出，“Integer.MAX_VALUE – (-1)”将小于零。所以基于Comparator/Comparable合约，
     *     Integer.MAX_VALUE小于-1，这显然是不正确的。
     *     因此，如我们所料，“John”在排序后的集合中排在“Roger”之前
     */

    public static void main(String[] args) {
        Comparator<Player> comparator = (p1, p2) -> p1.getRanking() - p2.getRanking();

        Player player1 = new Player(59, "John", Integer.MAX_VALUE);
        Player player2 = new Player(67, "Roger", -1);
        List<Player> players = Arrays.asList(player1, player2);


        System.out.println("Before Sorting : " + players);
        players.sort(comparator);
        System.out.println("Before Sorting : " + players);
    }
}
