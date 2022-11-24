package cn.bravedawn.basic.dateandtime.javautil;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/24 10:21
 */
public class DateExample2 {

    /**
     * Date日期的比较
     */


    public static void main(String[] args) {
        Date dateOne = new Date(); // 2022
        Date dateTwo = new Date(130, 6, 1, 2, 12, 21); // 2030

        System.out.println(dateOne);
        System.out.println(dateTwo);

        System.out.println(dateOne.before(dateTwo));
        System.out.println(dateTwo.after(dateOne));
    }
}
