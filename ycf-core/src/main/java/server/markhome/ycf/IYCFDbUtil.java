/**
 *	server.markhome.ycf-core - Mark's Code Fractal Core Services
 *
 *	Copyright 2026 Mark Stephen Sobkow (mark.sobkow@gmail.com)
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *		http://apache.org
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *
 *	SPDX-License-Identifier: Apache-2.0
**/

package server.markhome.ycf;

import org.teavm.jso.JSExport;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

import java.util.*;

/**
 *	IYCFDbUtil provides a set of methods that provide useful constants used for persisting information that has a time zone.
 *
 *	@since 2026
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public interface IYCFDbUtil extends JSObject {

	/**
	 *	IYCFDbUtil getSingleton()
	 *		Get the singleton instance that provides the getInstance() and service method implementations.
	 *
	 *	@return IYCFDbUtil The singleton for the implementation.
	 */
	@JSExport
	public IYCFDbUtil getSingleton();

	//protected final static IYCFMtReference<TimeZone> tzUTC = IYCFMtReference<TimeZone>.getSingleton().getInstance(TimeZone.getTimeZone("GMT+0000"));
	//protected final static IYCFMtReference<Calendar> localCalendar = IYCFMtReference<Calendar>.getSingleton().getInstance(new GregorianCalendar());
	//protected final static IYCFMtReference<int> localTZOffsetMillis = IYCFMtReference<int>.getSingleton().getInstance(localCalendar.get().get(Calendar.ZONE_OFFSET));
	//protected final static IYCFMtReference<int> dbServerTZOffsetMillis = IYCFMtReference<int>.getSingleton().getInstance(localTZOffsetMillis.get());
	//protected final static IYCFMtReference<TimeZone> dbServerTimeZone = IYCFMtReference<TimeZone>.getSingleton().getInstance((TimeZone)null);

	/**
	 *	Get the database server's timezone offset in milliseconds.
	 *
	 *	@return Timezone offset in milliseconds
	 */
	@JSExport
	public int getDbServerTZOffsetMillis() {
		return(YCFDbUtil_getDbServerTZOffsetMillis());
	}

	/**
	 *	Get the database server's timezone offset in milliseconds.
	 *
	 *	@return Timezone offset in milliseconds
	 */
	@JSExport
	public static int YCFDbUtil_getDbServerTZOffsetMillis() {
		return(dbServerTZOffsetMillis.get());
	}

	/**
	 *	Set the database server's timezone offset in milliseconds.
	 *
	 *	@param value Timezone offset in milliseconds
	 */
	@JSExport
	public void setDbServerTZOffsetMillis(int expected, int value) {
		YCFDbUtil_setDbServerTZOffsetMillis(expected, value);
	}

	/**
	 *	Set the database server's timezone offset in milliseconds.
	 *
	 *	@param value Timezone offset in milliseconds
	 */
	public static void YCFDbUtil_setDbServerTZOffsetMillis(int expected, int value) {
		dbServerTZOffsetMillis.set(expected, value);
		dbServerTimeZone.set(dbServerTimeZone.get(), null);
	}

	/**
	 *	Get the database server's timezone.
	 *
	 *	@return Database server timezone
	 */
	@JSExport
	public TimeZone getDbServerTimeZone() {
		return(YCFDbUtil_getDbServerTimeZone());
	}

	/**
	 *	Get the database server's timezone.
	 *
	 *	@return Database server timezone
	 */
	@JSExport
	public static TimeZone YCFDbUtil_getDbServerTimeZone() {
		if(dbServerTimeZone.get() == null) {
			int secondsOnly = dbServerTZOffsetMillis.get() / 1000;
			int minutesOnly = secondsOnly / 60;
			int absMinutes = (minutesOnly < 0) ? (0 - minutesOnly) : minutesOnly;
			int minutes = absMinutes % 60;
			int hours = absMinutes / 60;
			StringBuilder buff = new StringBuilder();
			Formatter fmt = new Formatter(buff);
			if(minutesOnly < 0) {
				buff.append("GMT-");
			}
			else {
				buff.append("GMT+");
			}
			fmt.format("%1$02d", hours);
			fmt.format("%1$02d", minutes);
			dbServerTimeZone.set(dbServerTimeZone.get(), TimeZone.getTimeZone(buff.toString()));
			fmt.close();
		}
		return(dbServerTimeZone.get());
	}

	/**
	 *	Set the database server's timezone.
	 *
	 *	@param tz Database server timezone
	 *
	 *	@return Database server timezone
	 */
	@JSExport
	public TimeZone setDbServerTimeZone(TimeZone expected, TimeZone tz) {
		return(YCFDbUtil_setDbServerTimeZone(expected, tz));
	}

	/**
	 *	Set the database server's timezone.
	 *
	 *	@param tz Database server timezone
	 *
	 *	@return Database server timezone
	 */
	@JSExport
	public static TimeZone YCFDbUtil_setDbServerTimeZone(TimeZone expected, TimeZone tz) {
		if(tz == null) {
			throw new IllegalArgumentException("TimeZone tz is null");
		}
		dbServerTimeZone.set(expected, tz);
		dbServerTZOffsetMillis.set(dbServerTZOffsetMillis.get(), tz.getRawOffset());
		return(dbServerTimeZone.get());
	}

	/**
	 *	Get a database server adjusted Calendar instance.
	 *
	 *	@param Calendar value to be adjusted
	 *
	 *	@return Database server adjusted Calendar instance.
	 */
	@JSExport
	public Calendar getDbServerCalendar(Calendar value) {
		return(YCFDbUtil_getDbServerCalendar(value));
	}

	/**
	 *	Get a database server adjusted Calendar instance.
	 *
	 *	@param Calendar value to be adjusted
	 *
	 *	@return Database server adjusted Calendar instance.
	 */
	@JSExport
	public static Calendar YCFDbUtil_getDbServerCalendar(Calendar value) {
		if(value == null) {
			return(null);
		}
		Calendar cal = Calendar.getInstance(getDbServerTimeZone());
		cal.setTimeInMillis(value.getTimeInMillis());
		return(cal);
	}

	/**
	 *	Get a UTC adjusted Calendar instance.
	 *
	 *	@param Calendar value to be adjusted
	 *
	 *	@return UTC adjusted Calendar instance.
	 */
	@JSExport
	public Calendar YCFDbUtil_getUTCCalendar(Calendar value) {
		return(YCFDbUtil_getUTCCalendar(value));
	}

	/**
	 *	Get a UTC adjusted Calendar instance.
	 *
	 *	@param Calendar value to be adjusted
	 *
	 *	@return UTC adjusted Calendar instance.
	 */
	@JSExport
	public static Calendar YCFDbUtil_getUTCCalendar(Calendar value);// {
//		if(value == null) {
//			return(null);
//		}
//		Calendar cal = Calendar.getInstance(tzUTC);
//		cal.setTimeInMillis(value.getTimeInMillis());
//		return(cal);
//	}

	/**
	 *	Get a UTC adjusted LocalDate instance.
	 *
	 *	@param LocalDate value to be adjusted
	 *
	 *	@return UTC adjusted LocalDate instance.
	 */
	@JSExport
	public LocalDate getUTCLocalDate(LocalDate value);// {
//		return(YCFDbUtil_getUTCLocalDate(LocalDate value));
//	}

	/**
	 *	Get a UTC adjusted LocalDate instance.
	 *
	 *	@param LocalDate value to be adjusted
	 *
	 *	@return UTC adjusted LocalDate instance.
	 */
	@JSExport
	public static LocalDate YCFDbUtil_getUTCLocalDate(LocalDate value) {
		if(value == null) {
			return(null);
		}
		LocalDate cal = LocalDate.getInstance(getDbServerTimeZone());
		cal.setTimeInMillis(value.getTimeInMillis());
		return(cal);
	}

	public static LocalDate YCFDbUtil_setUTCLocalDate(LocalDate expected, LocalDate value);// {
//		if(value == null) {
//			return(null);
//		}
//		LocalDate cal = LocalDate.getInstance(tzUTC);
//		cal.setTimeInMillis(value.getTimeInMillis());
//		return(cal);
//	}

	public static LocalTime YCFDbUtil_getDbServerLocalTime(LocalTime value) {
		if(value == null) {
			return(null);
		}
		LocalTime cal = LocalTime.getInstance(getDbServerTimeZone());
		cal.setTimeInMillis(value.getTimeInMillis());
		return(cal);
	}

	public static LocalTime YCFDbUtil_getUTCLocalTime(LocalTime value);// {
//		if(value == null) {
//			return(null);
//		}
//		LocalTime cal = LocalTime.getInstance(tzUTC);
//		cal.setTimeInMillis(value.getTimeInMillis());
//		return(cal);
//	}

	public static LocalDateTime YCFDbUtil_getDbServerLocalDateTime(LocalDateTime value) {
		if(value == null) {
			return(null);
		}
		LocalDateTime cal = LocalDateTime.getInstance(getDbServerTimeZone());
		cal.setTimeInMillis(value.getTimeInMillis());
		return(cal);
	}

	public static LocalDateTime YCFDbUtil_getUTCLocalDateTime(LocalDateTime value);// {
//		if(value == null) {
//			return(null);
//		}
//		LocalDateTime cal = LocalDateTime.getInstance(tzUTC);
//		cal.setTimeInMillis(value.getTimeInMillis());
//		return(cal);
//	}
}
