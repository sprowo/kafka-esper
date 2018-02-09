package com.prowo.util;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间工具类
 *
 * @author prowo
 * @create 2016-08-29 16:50
 */
public class DateUtil {

    public enum DATE_FORMAT {
        yyyy_MM_dd_HHmmss("yyyy-MM-dd HH:mm:ss"), yy_M_dd_HHmmss(
                "yy-M-dd HH:mm:ss"), yyyyMMdd("yyyyMMdd"), yyyyMMddHHmmss(
                "yyyyMMddHHmmss"), yyyy_MM_dd("yyyy-MM-dd");

        private DATE_FORMAT(String format) {
            this.format = format;
        }

        String format;

        public String getFormat() {
            return this.format;
        }
    }

    public static Boolean getExpireDeadLine(String dateDeadLine, DATE_FORMAT format) {
        if (StringUtils.isBlank(dateDeadLine)) {
            return Boolean.FALSE;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format.getFormat());
            String d = simpleDateFormat.format(new Long(dateDeadLine));
            Date now = new Date();
            Date date = simpleDateFormat.parse(d);
            return now.after(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    public static String format(DATE_FORMAT format, Date date) {
        return new SimpleDateFormat(format.getFormat()).format(date);
    }

    public static Date parse(DATE_FORMAT format, String str)
            throws ParseException {
        return new SimpleDateFormat(format.getFormat()).parse(str);
    }

    public static DateFormat getDateFormat(DATE_FORMAT format) {
        return new SimpleDateFormat(format.getFormat());
    }

    public static Date after(int field, int amount) {
        Date today = new Date();// 取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(today);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    public static Date before(int field, int amount) {
        Date today = new Date();// 取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(today);
        calendar.add(field, -amount);
        return calendar.getTime();
    }

    public static Date before(int field, int amount, Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(field, -amount);
        return calendar.getTime();
    }

    public static Date after(int field, int amount, Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * 如果晚的时间大，返回真; 否则返回假
     *
     * @param late  晚的时间
     * @param early 早的时间
     * @return
     */
    public static boolean compareDate(String late, String early) {
        Date lateDate = stringToDate(late);
        Date earlyDate = stringToDate(early);

        if (lateDate.compareTo(earlyDate) > 0) {
            return true;
        }

        return false;
    }

    /**
     * 如果晚的时间大于或等于，返回真; 否则返回假
     *
     * @param late  晚的时间
     * @param early 早的时间
     * @return
     */
    public static boolean compareEqDate(String late, String early) {
        Date lateDate = stringToDate(late);
        Date earlyDate = stringToDate(early);

        if (lateDate.compareTo(earlyDate) >= 0) {
            return true;
        }

        return false;
    }

    /**
     * 将字符串转化为日期类型
     *
     * @param date
     */
    public static Date stringToDate(String date) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date time = formater.parse(date);
            return time;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Calendar.getInstance().getTime();
    }

    /**
     * 将字符串转化为日期类型
     *
     * @param date
     */
    public static Date stringToDate(String date, DATE_FORMAT format) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        SimpleDateFormat formater = new SimpleDateFormat(format.getFormat());
        try {
            Date time = formater.parse(date);
            return time;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date stringToDate_1(String date) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date time = formater.parse(date);
            return time;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Calendar.getInstance().getTime();
    }

    public static Date getNow() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 获取当前时间
     *
     * @param format
     * @return
     */
    public static String getStrNow(DATE_FORMAT format) {
        SimpleDateFormat formater = new SimpleDateFormat(format.getFormat());
        return formater.format(getNow());
    }

    /**
     * 获取前minute分钟时间
     *
     * @param minute
     * @return
     */
    public static String getCurrDateBeforeByMinute(int minute) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, 0 - minute);
        return dateToString_7(cal.getTime());
    }

    public static String getBeforeBySecond(Date date, int second) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, 0 - second);
        return dateToString_7(cal.getTime());
    }

    /**
     * 将字符串转化为日期类型
     *
     * @param date
     */
    public static Date stringToDate_2(String date) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        try {
            Date time = formater.parse(date);
            return time;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Calendar.getInstance().getTime();
    }

    /**
     * 格式化时间
     *
     * @param date
     * @return String
     */
    public static String dateToString_1(long date) {
        try {
            String dateString = String.valueOf(date);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
            Date formateDate = formatter.parse(dateString);
            formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            return formatter.format(formateDate);
        } catch (Exception e) {
            // e.printStackTrace();
            return String.valueOf(date);
        }
    }

    /**
     * 格式化日期
     *
     * @param date
     */
    public static String dateToString_2(Date date) {
        if (date == null) {
            return "";
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd hh:mm:ss");
            return formatter.format(date);
        } catch (Exception e) {
            // e.printStackTrace();
            return String.valueOf(date);
        }
    }

    /**
     * 格式化日期
     *
     * @param date
     */
    public static String dateToString_3(Date date) {
        if (date == null) {
            return "";
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy-MM-dd|HH:mm:ss");
            return formatter.format(date);
        } catch (Exception e) {
            // e.printStackTrace();
            return String.valueOf(date);
        }
    }

    /**
     * 格式化日期
     *
     * @param date
     */
    public static String dateToString_4(Date date) {
        if (date == null) {
            return "";
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(date);
        } catch (Exception e) {
            // e.printStackTrace();
            return String.valueOf(date);
        }
    }

    /**
     * 格式化日期
     *
     * @param date
     */
    public static String dateToString_5(Date date) {
        if (date == null) {
            return "";
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            return formatter.format(date);
        } catch (Exception e) {
            // e.printStackTrace();
            return String.valueOf(date);
        }
    }

    /**
     * 检查字符串是否为日期
     *
     * @param strDate
     * @return
     */
    public static boolean checkDate(String strDate) {
        boolean flag = false;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.parse(strDate);
            flag = true;
        } catch (Exception e) {
            System.out.println("字符串:" + strDate + " 不是有效日期");
        }

        return flag;
    }

    /**
     * 检查字符串是否为日期
     *
     * @param strDate
     * @return
     */
    public static boolean checkDate(String strDate, String format) {
        boolean flag = false;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            formatter.parse(strDate);
            flag = true;
        } catch (Exception e) {
            System.out.println("字符串:" + strDate + " 不是有效日期");
        }

        return flag;
    }

    /**
     * 格式化日期
     *
     * @param date
     */
    public static String dateToString_6(Date date) {
        if (date == null) {
            return "";
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy-MM-dd|HH:mm:ss.SSS");
            return formatter.format(date);
        } catch (Exception e) {
            // e.printStackTrace();
            return String.valueOf(date);
        }
    }

    /**
     * 格式化日期
     *
     * @param date
     */
    public static String dateToString_7(Date date) {
        if (date == null) {
            return "";
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            return formatter.format(date);
        } catch (Exception e) {
            // e.printStackTrace();
            return String.valueOf(date);
        }
    }

    /**
     * 格式化日期
     *
     * @param date
     */
    public static String dateToString_8(Date date) {
        if (date == null) {
            return "";
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            return formatter.format(date);
        } catch (Exception e) {
            // e.printStackTrace();
            return String.valueOf(date);
        }
    }

    /**
     * 返回有效期时间
     *
     * @param date
     * @return
     */
    public static Date getExpires(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DAY_OF_MONTH, 1); //

        Date expires = ca.getTime();

        return expires;
    }

    /**
     * 指定日期+相应年数
     *
     * @param date
     * @return
     */
    public static String getAfterYear(String date, int year) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(stringToDate_1(date));
        ca.add(Calendar.YEAR, year); //
        return dateToString_8(ca.getTime());
    }

    /**
     * 根据输入的日期字符串 和 提前天数 ， 获得 指定日期提前几天的日期对象
     *
     * @param dateString 日期对象 ，格式如 yyyy-MM-dd HH:mm:ss
     * @param beforeDays 倒推的天数
     * @return 指定日期倒推指定天数后的日期对象
     * @throws ParseException
     */
    public static String getBeforeDate(String dateString, int beforeDays) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date inputDate = null;
        try {
            inputDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(inputDate);
        int inputDayOfYear = cal.get(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, inputDayOfYear - beforeDays);
        return dateToString_5(cal.getTime());
    }

    /**
     * 是否在指定时间范围
     *
     * @param sourceTime
     * @param curTime
     * @return
     */
    public static boolean isInTime(String sourceTime, String curTime) {
        String[] args = sourceTime.split("-");
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        try {
            Date date = long2Date(curTime);
            long now = sdf.parse(dateToString_7(date).substring(8, 12)).getTime();
            long start = sdf.parse(args[0]).getTime();
            long end = sdf.parse(args[1]).getTime();
            if (args[1].equals("0000")) {
                args[1] = "2400";
            }
            if (end < start) {
                if (now >= end && now < start) {
                    return false;
                } else {
                    return true;
                }
            } else {
                if (now >= start && now < end) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
        }
    }

    public static Date long2Date(String longStr) {
        Long time = null;
        try {
            time = Long.parseLong(longStr);
        } catch (Exception e) {
            throw new IllegalArgumentException("Illegal Argument arg:" + longStr);
        }
        return new Date(time);
    }

    public static Date getFirstDayOfWeek() {

        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        return c.getTime();
    }


    public static int getDateSpace(Date before, Date after)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        before = sdf.parse(sdf.format(before));
        after = sdf.parse(sdf.format(after));
        Calendar cal = Calendar.getInstance();
        cal.setTime(before);
        long time1 = cal.getTimeInMillis();
        cal.setTime(after);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 时间戳转化为日期
     *
     * @param longStr
     * @param format
     * @return
     */
    public static String long2DateStr(String longStr, DATE_FORMAT format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format.getFormat());
        return sdf.format(long2Date(longStr));
    }


    public static boolean sameDate(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);
        return cal1.getTime().equals(cal2.getTime());
    }

    public static Date dateAddMonthOrDay(Date date, Integer m, String unit) {
        if (null == date || null == m || null == unit) {
            return date;
        }
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        if ("2".equals(unit)) {
            rightNow.add(Calendar.MONTH, m);
        } else if ("1".equals(unit)) {
            rightNow.add(Calendar.DATE, m);
        }
        return rightNow.getTime();
    }

    public static Date addDay(Date date, Integer days) {
        if (null == date || null == days) {
            return date;
        }
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DATE, days);

        return rightNow.getTime();
    }

    /**
     * 计算两个日期相差月份
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonthSpace(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(date1);
        c2.setTime(date2);

        int monthSpace = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        int yearSpace = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);

        return Math.abs(monthSpace) + Math.abs(yearSpace) * 12;
    }

    /**
     * @param date
     * @return
     */
    public static Date getNextHalfHour(Date date) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        int minute = c1.get(Calendar.MINUTE);
        int add = 0;
        if (minute > 30) {
            add = 60 - minute;
        } else {
            add = 30 - minute;
        }
        c1.add(Calendar.MINUTE, add);
        c1.set(Calendar.SECOND, 0);

        return c1.getTime();
    }

    /**
     * 获取时间格式小时
     *
     * @param date
     * @return
     */
    public static int getHour(Date date) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        return c1.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取前minute分钟时间
     *
     * @param minute
     * @return
     */
    public static Date getDateBeforeByMinute(Date date, int minute) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, 0 - minute);
        return cal.getTime();
    }

    /**
     * 获取前hour分钟时间
     *
     * @param hour
     * @return
     */
    public static Date getDateBeforeByHour(Date date, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, 0 - hour);
        return cal.getTime();
    }

    /**
     * 获取前day时间
     *
     * @param day
     * @return
     */
    public static Date getDateBeforeByDay(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, 0 - day);
        return cal.getTime();
    }

    /**
     * 获取前week时间
     *
     * @param week
     * @return
     */
    public static Date getDateBeforeByWeek(Date date, int week) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.WEEK_OF_YEAR, 0 - week);
        return cal.getTime();
    }

    /**
     * 获取前month时间
     *
     * @param month
     * @return
     */
    public static Date getDateBeforeByMonth(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 0 - month);
        return cal.getTime();
    }

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.err.println(dateToString_8(date));
        System.err.println(dateToString_8(getDateBeforeByMinute(date, 1)));
        System.err.println(dateToString_8(getDateBeforeByHour(date, 1)));
        System.err.println(dateToString_8(getDateBeforeByDay(date, 1)));
        System.err.println(dateToString_8(getDateBeforeByWeek(date, 1)));
        System.err.println(dateToString_8(getDateBeforeByMonth(date, 1)));
    }
}
