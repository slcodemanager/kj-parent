package com.saintlu.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author quan
 * @date 2020-11-25 10:49
 */

public class DateUtil {
    public static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat SDF = new SimpleDateFormat(TIME_PATTERN);
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern(TIME_PATTERN);

    public static String date2Str(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static String date2Str(Date date) {
        return SDF.format(date);
    }

    public static Date str2Date(String str) throws Exception {
        if (StringUtils.isBlank(str)) {
            throw new Exception("转换数据不能为空");
        }
        return SDF.parse(str);

    }

    public static String localDateTime2Str(LocalDateTime ldt) {
        return DTF.format(ldt);
    }

    public static String localDateTime2Str(LocalDateTime ldt, String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return dtf.format(ldt);
    }


    public static LocalDateTime str2LocalDateTime(String str) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(TIME_PATTERN);
        return LocalDateTime.parse(str, df);
    }

    public static LocalDateTime date2LocalDateTIme(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static Date localDateTime2Date(LocalDateTime ldt) {
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }


    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
    private static final SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final SimpleDateFormat dateTimeFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmss");
    private static final SimpleDateFormat timeFormat2 = new SimpleDateFormat("HH:mm:ss");
    private static final SimpleDateFormat timeFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat timeFormat4 = new SimpleDateFormat("yyyy/MM/dd");
    private static final SimpleDateFormat timeFormat5 = new SimpleDateFormat("yyMMdd");


    public static Date now() {
        return new Date();
    }

    public static Date today() {
        return org.apache.commons.lang3.time.DateUtils.truncate(now(), 5);
    }

    public static Date tomarrow() {
        Date now = now();
        long myTime = now.getTime() / 1000L + 86400L;
        now.setTime(myTime * 1000L);
        return org.apache.commons.lang3.time.DateUtils.truncate(now, 5);
    }

    public static String afterDays(int days, Date date, String pattern) {
        long myTime = date.getTime() / 1000L + (long)(86400 * days);
        date.setTime(myTime * 1000L);
        return format(org.apache.commons.lang3.time.DateUtils.truncate(date, 13), pattern);
    }

    public static Date afterDays(int days, Date date) {
        long myTime = date.getTime() / 1000L + (long)(86400 * days);
        date.setTime(myTime * 1000L);
        return date;
    }

    public static Date afterMinues(int minues, Date date) {
        long myTime = date.getTime() / 1000L + (long)(60 * minues);
        date.setTime(myTime * 1000L);
        return date;
    }

    public static int getDayInWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayInWeek = calendar.get(7) - 1;
        if (dayInWeek == 0) {
            dayInWeek = 7;
        }

        return dayInWeek;
    }

    public static Date parseDateNewFormat(String sDate) {
        Date d = null;
        if (sDate != null && sDate.length() == "yyyy-MM-dd".length()) {
            try {
                d = dateFormat3.parse(sDate);
            } catch (ParseException var3) {
                return null;
            }
        }

        return d;
    }

    public static Date getDate(int day) {
        Calendar now = Calendar.getInstance();
        now.add(5, day);
        return now.getTime();
    }

    public static Date getDateByWeek(int day) {
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        Calendar calendar;
        if (today.get(7) - 1 > day && today.get(7) - 1 != 0) {
            calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(7, day);
            if (day != 0) {
                calendar.add(4, 1);
            }

            calendar.add(5, 1);
            return calendar.getTime();
        } else {
            calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(7, day);
            calendar.add(5, 1);
            return calendar.getTime();
        }
    }

    public static Integer getDifference(Date start, Date end) throws Exception {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fromDate = simpleFormat.format(start);
        String toDate = simpleFormat.format(end);
        long from = simpleFormat.parse(fromDate).getTime();
        long to = simpleFormat.parse(toDate).getTime();
        return (int)((to - from) / 60000L);
    }

    public static String formatDate2(Date date) {
        return dateFormat2.format(date);
    }

    public static String formatDate3(Date date) {
        return null == date ? "" : dateFormat3.format(date);
    }

    public static String formatDate(Date date) {
        return dateFormat.format(date);
    }

    public static String formatDateYMD(Date date) {
        return dateFormat3.format(date);
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


    public static String formatTime(Date time) {
        return timeFormat.format(time);
    }

    public static String formatTime2(Date time) {
        return timeFormat2.format(time);
    }

    public static String formatTime3(Date time) {
        return timeFormat3.format(time);
    }



    public static final Date convertStringToDate(String date, String dateFormat) throws ParseException {
        return (new SimpleDateFormat(dateFormat)).parse(date);
    }

    public static Timestamp getTimestamp() {
        return new Timestamp((new Date()).getTime());
    }

    public static Date getNow() {
        return new Date();
    }

    public static boolean isInRange(Date startDate, Date endDate) {
        Timestamp current = new Timestamp(System.currentTimeMillis());
        return (startDate == null || !startDate.after(current)) && (endDate == null || !endDate.before(current));
    }

    public static boolean isInRange(Date date, Date startDate, Date endDate) {
        Timestamp current = new Timestamp(date.getTime());
        return (startDate == null || !startDate.after(current)) && (endDate == null || !endDate.before(current));
    }

    public static boolean isDate(String dateStr, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);

        try {
            df.parse(dateStr);
            return true;
        } catch (ParseException var4) {
            return false;
        }
    }

    public static String getFormateDate(String formate) {
        Date currentTime = new Date();
        String dateString = DateFormatUtils.format(currentTime, formate);
        return dateString;
    }

    public static boolean isTimeDuring(Integer startTime, Integer endTime) {
        Calendar now = Calendar.getInstance();
        StringBuilder nowTimeStr = new StringBuilder();
        nowTimeStr.append(now.get(11));
        nowTimeStr.append(now.get(12));
        nowTimeStr.append(now.get(13));
        Integer nowTime = Integer.parseInt(nowTimeStr.toString());
        return nowTime >= startTime && nowTime <= endTime;
    }

    public static long differDaysBig(Date start, Date end) {
        if (start != null && end != null) {
            long differTime = end.getTime() - start.getTime();
            long hour = differTime / 1000L / 60L / 60L;
            if (hour > 24L) {
                return hour / 24L + 1L;
            } else {
                return hour > 0L && hour < 24L ? 1L : 0L;
            }
        } else {
            return 0L;
        }
    }



    public static long differDays(Date start, Date end) {
        if (start != null && end != null) {
            long differTime = end.getTime() - start.getTime();
            return differTime / 1000L / 60L / 60L / 24L;
        } else {
            return 0L;
        }
    }

    public static long differSeconds(Date start, Date end) {
        if (start != null && end != null) {
            long differTime = end.getTime() - start.getTime();
            return differTime / 1000L;
        } else {
            return 0L;
        }
    }

    public static long differHours(Date start, Date end) {
        if (start != null && end != null) {
            long differTime = end.getTime() - start.getTime();
            return differTime / 1000L / 60L / 60L;
        } else {
            return 0L;
        }
    }

    public static long differMonths(Date start, Date end) {
        return differDays(start, end) / 30L;
    }

    public static boolean afterNow(Date date) {
        if (date == null) {
            return false;
        } else {
            return getNow().compareTo(date) < 0;
        }
    }

    public static String getWeek(Date date) {
        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
        return dateFm.format(date);
    }

    public static Integer calBirthday(Date date) {
        try {
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMdd");
            String clidate = myFormatter.format(date);
            Calendar cToday = Calendar.getInstance();
            Calendar cBirth = Calendar.getInstance();
            cBirth.setTime(myFormatter.parse(clidate));
            cBirth.set(1, cToday.get(1));
            int days;
            if (cBirth.get(6) < cToday.get(6)) {
                days = cToday.getActualMaximum(6) - cToday.get(6);
                days += cBirth.get(6);
            } else {
                days = cBirth.get(6) - cToday.get(6);
            }

            return days;
        } catch (Exception var6) {
            return 100;
        }
    }

    public static int getLastDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-d");
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, 1);
        calendar.set(5, 1);
        calendar.add(5, -1);
        Date theDate = calendar.getTime();
        String s = df.format(theDate);
        return Integer.parseInt(s.substring(8));
    }

    public static int getFirstDayInWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        int dayInWeek = calendar.get(7) - 1;
        return dayInWeek;
    }

    public static Integer getLastMonthDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-d");
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.add(5, -1);
        Date theDate = calendar.getTime();
        String s = df.format(theDate);
        return Integer.parseInt(s.substring(8));
    }

    public static Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(5, 1);
        Date theNextDay = calendar.getTime();
        return theNextDay;
    }

    public static Date getAfterHour(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(11, hours + 1);
        Date theNextHour = calendar.getTime();
        return theNextHour;
    }

    public static Date getAfterMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(12, minute);
        Date theNextHour = calendar.getTime();
        return theNextHour;
    }

    public static Date getAfterDay(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(5, days);
        Date theNextDay = calendar.getTime();
        return theNextDay;
    }

    public static Date getAfterDayNotOnClock(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, days);
        return calendar.getTime();
    }

    public static Date getAfterMonth(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(2, months);
        Date theNextDay = calendar.getTime();
        return theNextDay;
    }

    public static String getAge(Date start, Date end) {
        long days = differDaysBig(start, end);
        long year = days / 365L;
        String age = year + "岁";
        return age;
    }

    public static Date getOneMonthBefore() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -30);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        Date oneMonthBefore = calendar.getTime();
        return oneMonthBefore;
    }

    public static Date getYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        Date yesterday = calendar.getTime();
        return yesterday;
    }

    public static Date getToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        Date today = calendar.getTime();
        return today;
    }

    public static Date getOneHourAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(11, -1);
        Date today = calendar.getTime();
        return today;
    }

    public static Date getEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }

        calendar.add(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date getThisMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        Date today = calendar.getTime();
        return today;
    }

    public static Date getThisYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2, 0);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        Date today = calendar.getTime();
        return today;
    }

    public static Date getLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(2, -1);
        Date today = calendar.getTime();
        return today;
    }

    public static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);
            if (start.getTime() >= end.getTime()) {
                return null;
            } else {
                long date = random(start.getTime(), end.getTime());
                return new Date(date);
            }
        } catch (Exception var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public static long random(long begin, long end) {
        long rtnn = begin + (long)(Math.random() * (double)(end - begin));
        return rtnn != begin && rtnn != end ? rtnn : random(begin, end);
    }

    public static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        int dayOfWeek = cd.get(7);
        return dayOfWeek == 1 ? -6 : 2 - dayOfWeek;
    }

    public static String getCurrentMonday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus);
        Date monday = currentDate.getTime();
        String preMonday = dateFormat3.format(monday);
        return preMonday;
    }

    public static String getPreviousSunday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus + 6);
        Date monday = currentDate.getTime();
        String preMonday = dateFormat3.format(monday);
        return preMonday;
    }

    public static String getMinMonthDate(String date) {
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.setTime(dateFormat3.parse(date));
            calendar.set(5, calendar.getActualMinimum(5));
            return dateFormat3.format(calendar.getTime());
        } catch (ParseException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static String getMaxMonthDate(String date) {
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.setTime(dateFormat3.parse(date));
            calendar.set(5, calendar.getActualMaximum(5));
            return dateFormat3.format(calendar.getTime());
        } catch (ParseException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static String getCurrentLastMonthDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(2, calendar.get(2) - 1);
        return dateFormat3.format(calendar.getTime());
    }

}
