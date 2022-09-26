package cn.bravedawn.obj.object.equalsandhashcode.hashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/26 17:25
 */
public class HashcodeExample {

    /**
     * 测试是否翻写（覆盖）对象的 hashcode方法
     */


    public static void main(String[] args) {
        Map<Team, String> leaders = new HashMap<>();
        leaders.put(new Team("New York", "development"), "Anne");
        leaders.put(new Team("Boston", "development"), "Brian");
        leaders.put(new Team("Boston", "marketing"), "Charlie");

        Team myTeam = new Team("New York", "development");
        String myTeamLeader = leaders.get(myTeam);
        // 这里我们期望得到一个 "Anne"，但是事实上返回的是 null
        System.out.println(myTeamLeader); // null

        System.out.println("---------------------------------------------------");
        Map<Team2, String> leaders2 = new HashMap<>();
        leaders2.put(new Team2("New York", "development"), "Anne");
        leaders2.put(new Team2("Boston", "development"), "Brian");
        leaders2.put(new Team2("Boston", "marketing"), "Charlie");
        Team2 myTeam2 = new Team2("New York", "development");
        String myTeamLeader2 = leaders2.get(myTeam2);
        System.out.println(myTeamLeader2); // Anne
    }
}
