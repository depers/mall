package cn.bravedawn.basic.enum_;

import cn.bravedawn.basic.enum_.test2.Weekday;

public class EnumExample3 {

    /**
     * 枚举的Switch
     */

    public static void main(String[] args) {
        Weekday day = Weekday.SUN;

        switch (day) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("Today is " + day + ", Work at office!");
                break;
            case SAT:
            case SUN:
                System.out.println("Today is " + day + ", Work at home!");
                break;
            default:
                throw new RuntimeException("cannot process " + day);
        }
    }
}
