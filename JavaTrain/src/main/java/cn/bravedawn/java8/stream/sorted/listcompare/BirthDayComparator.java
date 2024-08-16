package cn.bravedawn.java8.stream.sorted.listcompare;

import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Date;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/8/12 16:37
 */
public class BirthDayComparator implements Comparator<Student> {


    private final Date date;

    public BirthDayComparator(Date date) {
        this.date = date;
    }


    @Override
    public int compare(Student o1, Student o2) {

        Long between = ChronoUnit.DAYS.between(date.toInstant(), o1.getBirthDay().toInstant());
        between = Math.abs(between);

        Long between2 = ChronoUnit.DAYS.between(date.toInstant(), o2.getBirthDay().toInstant());
        between2 = Math.abs(between2);

        return between.compareTo(between2);
    }
}
