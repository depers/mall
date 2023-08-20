package cn.bravedawn.basic.coreclass.compare.comparator;

import cn.bravedawn.basic.coreclass.compare.comparable.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/31 20:25
 */
public class PlayerSorter {

    /**
     * Comparator比较器测试
     */


    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        System.out.println("Before Sorting : " + footballTeam);
        PlayerRankingComparator playerComparator = new PlayerRankingComparator();
        Collections.sort(footballTeam, playerComparator);
        System.out.println("After Sorting : " + footballTeam);
    }
}
