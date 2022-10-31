package cn.bravedawn.basic.coreclass.compare.comparator;

import cn.bravedawn.basic.coreclass.compare.comparable.Player;

import java.util.Comparator;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/31 20:22
 */
public class PlayerRankingComparator implements Comparator<Player> {


    @Override
    public int compare(Player firstPlayer, Player secondPlayer) {
        return Integer.compare(firstPlayer.getRanking(), secondPlayer.getRanking());
    }
}
