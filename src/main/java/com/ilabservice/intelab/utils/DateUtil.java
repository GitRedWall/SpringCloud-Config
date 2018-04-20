package com.ilabservice.intelab.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @author huliang
 * @version $Id: DateUtil.java, v 0.1 2011-12-19 下午7:23:39 huliang Exp $
 */
public class DateUtil {

	public final static long ONE_DAY_SECONDS = 86400;
	public final static long ONE_DAY_MILL_SECONDS = 86400000;
	public final static String chineseDtFormat = "yyyy年MM月dd日";
	public final static String noSecondFormat = "yyyy-MM-dd HH:mm";
	public final static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 返回当前系统时间 返回的时间格式为 yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date();
	}
	/**
	 * 获取当前时间的yyyy-MM-dd HH:mm:ss
	 * @return
     */
	public static String getCurrentDateDefultFormat(){
		DateFormat df = new SimpleDateFormat(DEFAULT_FORMAT);
		return df.format(new Date());
	}

	/**
	 * @param pattern
	 * @return
	 */
	public static DateFormat getNewDateFormat(String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		df.setLenient(false);
		return df;
	}

	/**
	 * @param date
	 * @param format
	 * @return
	 */
	public static String format(Date date, String format) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * @param sDate
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDateNoTime(String sDate, String format)
			throws ParseException {
		if (StringUtils.isBlank(sDate)) {
			throw new ParseException("Null sDate. ", 0);
		}
		if (StringUtils.isBlank(format)) {
			throw new ParseException("Null format. ", 0);
		}
		return new SimpleDateFormat(format).parse(sDate);
	}

	/**
	 * @param sDate
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDateNewFormat(String sDate) throws ParseException {
		if (StringUtils.isBlank(sDate)) {
			throw new ParseException("Null sDate. ", 0);
		}
		return new SimpleDateFormat(DEFAULT_FORMAT).parse(sDate);
	}

	/**
	 * 
	 * @param sDate
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String sDate, String format) throws ParseException {
		if (StringUtils.isBlank(sDate)) {
			throw new ParseException("Null sDate. ", 0);
		}
		if (StringUtils.isBlank(sDate)) {
			throw new ParseException("Null format. ", 0);
		}
		return new SimpleDateFormat(format).parse(sDate);
	}

	/**
	 * 计算当前时间几小时之后的时间
	 *
	 * @param date
	 * @param hours
	 *
	 * @return
	 */
	public static Date addHours(Date date, long hours) {
		return addMinutes(date, hours * 60);
	}

	/**
	 * 计算当前时间几分钟之后的时间
	 *
	 * @param date
	 * @param minutes
	 *
	 * @return
	 */
	public static Date addMinutes(Date date, long minutes) {
		return addSeconds(date, minutes * 60);
	}

	/**
	 * @param date1
	 * @param secs
	 *
	 * @return
	 */

	public static Date addSeconds(Date date, long secs) {
		return new Date(date.getTime() + (secs * 1000));
	}

	/**
	 * 判断输入的字符串是否为合法的小时
	 *
	 * @param hourStr
	 *
	 * @return true/false
	 */
	public static boolean isValidHour(String hourStr) {
		if (!StringUtils.isEmpty(hourStr) && StringUtils.isNumeric(hourStr)) {
			int hour = new Integer(hourStr).intValue();

			if ((hour >= 0) && (hour <= 23)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 判断输入的字符串是否为合法的分或秒
	 *
	 * @param minuteStr
	 *
	 * @return true/false
	 */
	public static boolean isValidMinuteOrSecond(String str) {
		if (!StringUtils.isEmpty(str) && StringUtils.isNumeric(str)) {
			int hour = new Integer(str).intValue();

			if ((hour >= 0) && (hour <= 59)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 取得新的日期
	 *
	 * @param date1
	 *            日期
	 * @param days
	 *            天数
	 *
	 * @return 新的日期
	 */
	public static Date addDays(Date date1, long days) {
		return addSeconds(date1, days * ONE_DAY_SECONDS);
	}

	public static String getNewFormatDateString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
		return getDateString(date, dateFormat);
	}

	public static String getDateString(Date date, DateFormat dateFormat) {
		if (date == null || dateFormat == null) {
			return null;
		}

		return dateFormat.format(date);
	}

	/**
	 * 取得“X年X月X日”的日期格式
	 *
	 * @param date
	 *
	 * @return
	 */
	public static String getChineseDateString(Date date) {
		DateFormat dateFormat = getNewDateFormat(chineseDtFormat);

		return getDateString(date, dateFormat);
	}

	/**
	 * 取得两个日期间隔秒数（日期1-日期2）
	 *
	 * @param one
	 *            日期1
	 * @param two
	 *            日期2
	 *
	 * @return 间隔秒数
	 */
	public static long getDiffSeconds(Date one, Date two) {
		Calendar sysDate = new GregorianCalendar();

		sysDate.setTime(one);

		Calendar failDate = new GregorianCalendar();

		failDate.setTime(two);
		return (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / 1000;
	}

	public static long getDiffMinutes(Date one, Date two) {
		Calendar sysDate = new GregorianCalendar();

		sysDate.setTime(one);

		Calendar failDate = new GregorianCalendar();

		failDate.setTime(two);
		return (sysDate.getTimeInMillis() - failDate.getTimeInMillis())
				/ (60 * 1000);
	}

	/**
	 * 取得两个日期的间隔天数
	 *
	 * @param one
	 * @param two
	 *
	 * @return 间隔天数
	 */
	public static long getDiffDays(Date one, Date two) {
		Calendar sysDate = new GregorianCalendar();

		sysDate.setTime(one);

		Calendar failDate = new GregorianCalendar();

		failDate.setTime(two);
		return (sysDate.getTimeInMillis() - failDate.getTimeInMillis())
				/ (24 * 60 * 60 * 1000);
	}

	public static String convert(String dateString, DateFormat formatIn,
			DateFormat formatOut) {
		try {
			Date date = formatIn.parse(dateString);

			return formatOut.format(date);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * @param date1
	 * @param date2
	 * @param dateWebFormat2
	 *
	 * @return
	 */
	public static boolean dateNotLessThan(String date1, String date2,
			DateFormat format) {
		try {
			Date d1 = format.parse(date1);
			Date d2 = format.parse(date2);

			if (d1.before(d2)) {
				return false;
			} else {
				return true;
			}
		} catch (ParseException e) {
			return false;
		}
	}

	public static String formatTimeRange(Date startDate, Date endDate,
			String format) {
		if ((endDate == null) || (startDate == null)) {
			return null;
		}

		String rt = null;
		long range = endDate.getTime() - startDate.getTime();
		long day = range / DateUtils.MILLIS_PER_DAY;
		long hour = (range % DateUtils.MILLIS_PER_DAY)
				/ DateUtils.MILLIS_PER_HOUR;
		long minute = (range % DateUtils.MILLIS_PER_HOUR)
				/ DateUtils.MILLIS_PER_MINUTE;

		if (range < 0) {
			day = 0;
			hour = 0;
			minute = 0;
		}

		rt = format.replaceAll("dd", String.valueOf(day));
		rt = rt.replaceAll("hh", String.valueOf(hour));
		rt = rt.replaceAll("mm", String.valueOf(minute));

		return rt;
	}

	/**
	 * 获取系统日期的前一天日期，返回Date
	 *
	 * @return
	 */
	public static Date getBeforeDate() {
		Date date = new Date();

		return new Date(date.getTime() - (ONE_DAY_MILL_SECONDS));
	}

	/**
	 * 获得指定时间当天起点时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDayBegin(Date date) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		df.setLenient(false);

		String dateString = df.format(date);

		try {
			return df.parse(dateString);
		} catch (ParseException e) {
			return date;
		}
	}

	/**
	 * 判断参date上min分钟后，是否小于当前时间
	 * 
	 * @param date
	 * @param min
	 * @return
	 */
	public static boolean dateLessThanNowAddMin(Date date, long min) {
		return addMinutes(date, min).before(new Date());

	}

	public static boolean isBeforeNow(Date date) {
		if (date == null)
			return false;
		return date.compareTo(new Date()) < 0;
	}

	public static Date parseNoSecondFormat(String sDate) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(noSecondFormat);

		if ((sDate == null) || (sDate.length() < noSecondFormat.length())) {
			throw new ParseException("length too little", 0);
		}

		if (!StringUtils.isNumeric(sDate)) {
			throw new ParseException("not all digit", 0);
		}

		return dateFormat.parse(sDate);
	}
	
	/**
	 * 获取当前时间星期
	 * @return
	 */
	public static String todayWeekString() {
		String[] week = {"7", "1", "2", "3", "4", "5", "6",};
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		int i = c.get(Calendar.DAY_OF_WEEK);
		return week[i - 1];
	}

	/**
	 * 比较当前时间是否在有效期内，不在返回false
	 * @param endTime 生产日期
	 * @param days 保质期
     * @return
     */
	public static boolean checkDateInDays(String endTime,int days){
		boolean flag = true;
		String now = getCurrentDateDefultFormat();
		long daySub = getDaySub(endTime,now);
		if(daySub>days){
			flag = false;
		}
		return flag;
	}

	/**
	 * <li>功能描述：时间相减得到天数
	 * @param beginDateStr
	 * @param endDateStr
	 * @return
	 * long
	 * @author Administrator
	 */
	public static long getDaySub(String beginDateStr,String endDateStr){
		long day=0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = null;
		Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate= format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
		//System.out.println("相隔的天数="+day);

		return day;
	}
}
