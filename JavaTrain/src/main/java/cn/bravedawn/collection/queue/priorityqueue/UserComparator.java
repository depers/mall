package cn.bravedawn.collection.queue.priorityqueue;

import java.util.Comparator;

/**
 * @Description : 比较器
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-27 10:23
 */
public class UserComparator implements Comparator<User> {


    @Override
    public int compare(User u1, User u2) {
        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            // 如果两人的号都是A开头或者都是V开头,比较号的大小:
            return u1.number.compareTo(u2.number);
        }
        if (u1.number.charAt(0) == 'V') {
            // u1的号码是V开头,优先级高:
            return -1;
        } else {
            return 1;
        }
    }
}
