package cn.bravedawn.util;

import cn.hutool.core.date.DateTime;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author : depers
 * @program : quartz-dynamic-job
 * @date : Created in 2024/9/21 13:49
 */
@Slf4j
public class DatetimeUtil {

    private static final String DEFAULT_DATETIME_MILLS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private static final String DEFAULT_TIME = "HH:mm:ss";

    public static String dateToStr(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATETIME_PATTERN);
        return sdf.format(date);
    }

    public static String dateToStrMills(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATETIME_MILLS_PATTERN);
        return sdf.format(date);
    }

    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static LocalDate date2LocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static String localDateToStr(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(date);
    }

    public static String getChineseDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(new Date());
    }

    public static String getChineseDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return sdf.format(new Date());
    }

    public Date str2Date(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            log.error("日志解析失败");
            return null;
        }
    }

    public static String localDateTime2Str(LocalDateTime date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    public static String localDateTime2Str(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATETIME_PATTERN);
        return date.format(formatter);
    }

    public static Date localDatetime2Date(LocalDateTime localDateTime) {
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }


    public static LocalDate str2LocalDate(String date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, formatter);
    }

    /**
     * 校验日期格式是否正确
     * @param date
     * @param pattern
     * @return
     */
    public static boolean validDate(String date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        TemporalAccessor temporalAccessor = formatter.parseUnresolved(date, new ParsePosition(0));
        return temporalAccessor != null;
    }

    public static LocalDateTime date2LocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalTime str2LocalTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_TIME);
        return LocalTime.parse(date, formatter);
    }
}
