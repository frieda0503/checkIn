package signAuto;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import constants.JobName;

public class MainCheckOut {
	private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;
//	private static final long PERIOD_DAY = 600 * 1000;

	public static void main(String args[]) {
		// 建立第一個Timer物件
		Timer timer = new Timer();

		// check in
		TimerTask checkIn = new CheckInOut(JobName.CHECKIN);

		// 每天早上八點四十執行
		timer.schedule(checkIn, getMorningCalendar(), PERIOD_DAY);
		System.out.println("Go into schedule CheckIn");

		// 建立第一個Timer物件
		Timer timer2 = new Timer();

		// check out
		TimerTask checkOut = new CheckInOut(JobName.CHECKOUT);

		// 每天晚上六點四十執行
		timer2.schedule(checkOut, getEveningCalendar(), PERIOD_DAY);
		System.out.println("Go into schedule CheckOut");
	}

	private static Date getMorningCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 35);
		calendar.set(Calendar.SECOND, 0);
		Date date = calendar.getTime();
		return date;
	}

	private static Date getEveningCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 18);
		calendar.set(Calendar.MINUTE, 10);
		calendar.set(Calendar.SECOND, 0);
		Date date = calendar.getTime();
		return date;
	}

}
