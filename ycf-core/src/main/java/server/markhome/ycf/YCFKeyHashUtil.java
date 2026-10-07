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

public class YCFKeyHashUtil {

	public final static TimeZone tzUTC = TimeZone.getTimeZone( "GMT+0000" );
	public final static Calendar localCalendar = new GregorianCalendar();
	public final static int localTZOffsetMillis = localCalendar.get( Calendar.ZONE_OFFSET );
	public static int dbServerTZOffsetMillis = localTZOffsetMillis;
	public static TimeZone dbServerTimeZone = null;

	public static int getDbServerTZOffsetMillis() {
		return( dbServerTZOffsetMillis );
	}
	
	public static void setDbServerTZOffsetMillis( int value ) {
		dbServerTZOffsetMillis = value;
		dbServerTimeZone = null;
	}

	public static TimeZone getDbServerTimeZone() {
		if( dbServerTimeZone == null ) {
			int secondsOnly = dbServerTZOffsetMillis / 1000;
			int minutesOnly = secondsOnly / 60;
			int absMinutes = ( minutesOnly < 0 ) ? ( 0 - minutesOnly ) : minutesOnly;
			int minutes = absMinutes % 60;
			int hours = absMinutes / 60;
			StringBuilder buff = new StringBuilder();
			Formatter fmt = new Formatter( buff );
			if( minutesOnly < 0 ) {
				buff.append( "GMT-" );
			}
			else {
				buff.append( "GMT+" );
			}
			fmt.format( "%1$02d", hours );
			fmt.format( "%1$02d", minutes );
			dbServerTimeZone = TimeZone.getTimeZone( buff.toString() );
			fmt.close();
		}
		return( dbServerTimeZone );
	}
	
	public static void setDbServerTimeZone( TimeZone tz ) {
		if( tz == null ) {
			throw new IllegalArgumentException( "TimeZone tz is null" );
		}
		dbServerTimeZone = tz;
		dbServerTZOffsetMillis = tz.getRawOffset();
	}

	public static Calendar getDbServerCalendar( Calendar value ) {
		if( value == null ) {
			return( null );
		}
		Calendar cal = Calendar.getInstance( getDbServerTimeZone() );
		cal.setTimeInMillis( value.getTimeInMillis() );
		return( cal );
	}

	public static Calendar getUTCCalendar( Calendar value ) {
		if( value == null ) {
			return( null );
		}
		Calendar cal = Calendar.getInstance( tzUTC );
		cal.setTimeInMillis( value.getTimeInMillis() );
		return( cal );
	}
}
