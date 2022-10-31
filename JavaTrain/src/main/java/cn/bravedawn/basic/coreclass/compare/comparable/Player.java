package cn.bravedawn.basic.coreclass.compare.comparable;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/31 20:15
 */
public class Player implements Comparable<Player>{

    /**
     * 示例实体类：运动员
     */

    private int ranking;
    private String name;
    private int age;

    public Player(int ranking, String name, int age) {
        this.ranking = ranking;
        this.name = name;
        this.age = age;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Player{" +
                "ranking=" + ranking +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Player o) {
        // 如果 x 小于 y，则 Integer.compare(x, y) 返回 -1，如果它们相等则返回 0，否则返回 1
        return Integer.compare(getRanking(), o.getRanking());
    }
}
