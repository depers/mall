package cn.bravedawn.basic.enum_;

public enum Weekday {

    MON(1, "星期一"),
    TUE(2, "星期二"),
    WED(3, "星期三"),
    THU(4, "星期四"),
    FRI(5, "星期五"),
    SAT(6, "星期六"),
    SUN(7, "星期天")
    ;

    private final int dayValue;
    private final String chinese;


    private Weekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }
}
