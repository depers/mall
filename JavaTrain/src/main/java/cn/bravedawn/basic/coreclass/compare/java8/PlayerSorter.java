package cn.bravedawn.basic.coreclass.compare.java8;

import cn.bravedawn.basic.coreclass.compare.comparable.Player;
import cn.bravedawn.basic.coreclass.compare.comparator.PlayerRankingComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/31 20:27
 */
public class PlayerSorter {

    /**
     * 使用Java8 lambda表达式编写comparator比较器
     */


    public static void main(String[] args) {
        Comparator<Player> byRanking = (firstPlayer, secondPlayer)
                -> Integer.compare(firstPlayer.getRanking(), secondPlayer.getRanking());

        Comparator<Player> byRanking2 = Comparator.comparing(Player::getRanking);

        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        System.out.println("Before Sorting : " + footballTeam);
        Collections.sort(footballTeam, byRanking);
        System.out.println("After Sorting : " + footballTeam);
    }
}
