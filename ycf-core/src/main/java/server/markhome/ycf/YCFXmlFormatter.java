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
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.v3_1.ycflib.YCFArgumentUnderflowException;
import server.markhome.ycf.v3_1.ycflib.YCFNullArgumentException;

/**
 * YCFXmlUtil provides a wide variety of XML field parsers and formatters, which are also used for JSON data streaming. The XML String methods need to be redone to use a proper XML mapping library/package.
 */
public class YCFXmlUtil {

	public final static Calendar localCalendar = new GregorianCalendar();
	public final static int localTZOffsetMillis = localCalendar.get( Calendar.ZONE_OFFSET );
	
	protected final static String S_emptyString = "";
	
	/**
	 *	Formatting for XML attribute content strings.
	**/

	public static LocalDate parseDate( String value ) {
		if( ( value == null ) || ( value.length() == 0 ) ) {
			return( null );
		}
		else {
			return( LocalDate.parse(value, DateTimeFormatter.ISO_DATE) );
		}
	}

	public static LocalDate parseDate( String enFieldName, String xFieldName, String value ) {
		final String S_ProcName = "parseDate";
		if( ( enFieldName == null ) || ( enFieldName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
				S_ProcName,
				1,
				"enFieldName" );
		}
		if( ( value == null ) || ( value.length() == 0 ) ) {
			return( null );
		}
		else {
			return LocalDate.parse(value, DateTimeFormatter.ISO_DATE);
		}
	}

	public static LocalTime parseTime( String value ) {
		if( ( value == null ) || ( value.length() == 0 ) ) {
			return( null );
		}
		else {
			return( LocalTime.parse(value, DateTimeFormatter.ISO_TIME) );
		}
	}

	public static LocalTime parseTime( String enFieldName, String xFieldName, String value ) {
		final String S_ProcName = "parseTime";
		if( ( enFieldName == null ) || ( enFieldName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
				S_ProcName,
				1,
				"enFieldName" );
		}
		if( ( value == null ) || ( value.length() == 0 ) ) {
			return( null );
		}
		else {
			return( LocalTime.parse(value, DateTimeFormatter.ISO_DATE) );
		}
	}

	public static LocalDateTime parseTimestamp( String value ) {
		if( ( value == null ) || ( value.length() == 0 ) ) {
			return( null );
		}
		else {
			return( LocalDateTime.parse(value, DateTimeFormatter.ISO_DATE_TIME) );
		}

	}

	public static LocalDateTime parseTimestamp( String enFieldName, String xFieldName, String value ) {
		final String S_ProcName="parseTimestamp";
		if( ( enFieldName == null ) || ( enFieldName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
				S_ProcName,
				1,
				"enFieldName" );
		}
		if( ( value == null ) || ( value.length() == 0 ) ) {
			return( null );
		}
		else {
			return( LocalDateTime.parse(value, DateTimeFormatter.ISO_DATE_TIME) );
		}

	}

	public static LocalDate parseTZDate( String value ) {
		if( ( value == null ) || ( value.length() == 0 ) ) {
			return( null );
		}
		else {
			return( LocalDate.parse(value, DateTimeFormatter.ISO_OFFSET_DATE) );
		}

	}

	public static LocalDate parseTZDate( String enFieldName, String xFieldName, String value ) {
		final String S_ProcName = "parseTZDate";
		if( ( enFieldName == null ) || ( enFieldName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
				S_ProcName,
				1,
				"enFieldName" );
		}
		if( ( value == null ) || ( value.length() == 0 ) ) {
			return( null );
		}
		else {
			return( LocalDate.parse(value, DateTimeFormatter.ISO_OFFSET_DATE) );
		}

	}

	public static LocalTime parseTZTime( String value ) {
		if( ( value == null ) || ( value.length() == 0 ) ) {
			return( null );
		}
		else {
			return( LocalTime.parse(value, DateTimeFormatter.ISO_OFFSET_TIME) );
		}
	}

	public static LocalTime parseTZTime( String enFieldName, String xFieldName, String value ) {
		final String S_ProcName = "parseTZTime";
		if( ( enFieldName == null ) || ( enFieldName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
				S_ProcName,
				1,
				"enFieldName" );
		}
		if( ( value == null ) || ( value.length() == 0 ) ) {
			return( null );
		}
		else {
			return( LocalTime.parse(value, DateTimeFormatter.ISO_OFFSET_TIME) );
		}
	}

	public static LocalDateTime parseTZTimestamp( String value ) {
		if( ( value == null ) || ( value.length() == 0 ) ) {
			return( null );
		}
		else {
			return( LocalDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME) );
		}
	}

	public static LocalDateTime parseTZTimestamp( String enFieldName, String xFieldName, String value ) {
		final String S_ProcName = "parseTZTimestamp";
		if( ( enFieldName == null ) || ( enFieldName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
				S_ProcName,
				1,
				"enFieldName" );
		}
		if( ( value == null ) || ( value.length() == 0 ) ) {
			return( null );
		}
		else {
			return( LocalDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME) );
		}
	}

	public static String formatBoolean( boolean val ) {
		final String S_False = "false";
		final String S_True = "true";
		String retval;
		if( val ) {
			retval = S_True;
		}
		else {
			retval = S_False;
		}
		return( retval );
	}

	public static String formatBlob( byte[] val ) {
		final String S_ProcName = "formatBlob";
		if( val == null ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"val" );
		}
		byte[] encoded = Base64.encodeBase64( val );
		String retval = new String( encoded );
		return( retval );
	}
	
	public static String formatInt16( short val ) {
		String retval = Short.toString( val );
		return( retval );
	}

	public static String formatInt32( int val ) {
		String retval = Integer.toString( val );
		return( retval );
	}

	public static String formatInt64( long val ) {
		String retval = Long.toString( val );
		return( retval );
	}

	public static String formatUInt16( int val ) {
		final String S_ProcName = "formatUInt16";
		if( val < 0 ) {
			throw new YCFArgumentUnderflowException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"val",
					val,
					0 );
		}
		String retval = Integer.toString( val );
		return( retval );
	}

	public static String formatUInt32( long val ) {
		String retval = Long.toString( val );
		return( retval );
	}

	public static String formatUInt64( BigDecimal val ) {
		final String S_ProcName = "formatUInt64";
		if( val == null ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"val" );
		}
		String retval = val.toString();
		return( retval );
	}

	public static String formatFloat( float val ) {
		final DecimalFormat fmt = new DecimalFormat( "#################################################################################################################################0.##################################################################################################################################" );
		String retval = fmt.format( val );
		return( retval );
	}

	public static String formatDouble( double val ) {
		final DecimalFormat fmt = new DecimalFormat( "#########################################################################################################################################################################################################################################################################################################################################0.##########################################################################################################################################################################################################################################################################################################################################" );
		String retval = fmt.format( val );
		return( retval );
	}

	public static String formatNumber( BigDecimal val ) {
		final String S_ProcName = "formatNumber";
		final DecimalFormat fmt = new DecimalFormat( "#########################################################################################################################################################################################################################################################################################################################################0.#########################################################################################################################################################################################################################################################################################################################################" );
		if( val == null ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"val" );
		}
		String retval = fmt.format( val );
		return( retval );
	}

	public static String formatXmlString( String str ) {
		final String S_ProcName = "formatXmlString";
		if( str == null ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
				S_ProcName,
				1,
				"str" );
		}
		else {
			return( StringEscapeUtils.escapeXml11( str ) );
		}
	}

	public static String formatXmlStringWhitespacePreserve( String str ) {
		final String S_ProcName = "formatXmlStringWhitespacePreserve";
		if( str == null ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
				S_ProcName,
				1,
				"str" );
		}
		else {
			return( StringEscapeUtils.escapeXml11( str ) );
		}
	}

	public static String formatDate( LocalDate cal ) {
		final String S_ProcName = "formatDate";
		if( cal == null ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
				S_ProcName,
				1,
				"cal" );
		}
		else {
			return( cal.format(DateTimeFormatter.ISO_DATE) );
		}
	}

	public static String formatTime( LocalTime cal ) {
		final String S_ProcName = "formatTime";
		if( cal == null ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"cal" );
		}
		else {
			return( cal.format(DateTimeFormatter.ISO_TIME) );
		}
	}

	public static String formatTimestamp( LocalDateTime cal ) {
		final String S_ProcName = "formatTimestamp";
		if( cal == null ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName, 
					1,
					"cal" );
		}
		else {
			return( cal.format(DateTimeFormatter.ISO_DATE_TIME) );
		}
	}

	public static String formatTZDate( LocalDate cal ) {
		final String S_ProcName = "formatTZDate";
		if( cal == null ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"cal" );
		}
		else {
			return( cal.format(DateTimeFormatter.ISO_OFFSET_DATE) );
		}
	}

	public static String formatTZTime( LocalTime cal ) {
		final String S_ProcName = "formatTZTime";
		if( cal == null ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"cal" );
		}
		else {
			return( cal.format(DateTimeFormatter.ISO_OFFSET_TIME) );
		}
	}

	public static String formatTZTimestamp( LocalDateTime cal ) {
		final String S_ProcName = "formatTZTimestamp";
		if( cal == null ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"cal" );
		}
		else {
			return( cal.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME) );
		}
	}

	public static String formatUuid( UUID val ) {
		final String S_ProcName = "formatUuid";
		if( val == null ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"val" );
		}
		String retval = val.toString();
		return( retval );
	}

	/**
	 *	Formatting for Required XML attributes.
	**/
	
	public static String formatRequiredBoolean( String separator, String attrName, boolean val ) {
		final String S_ProcName = "formatRequiredBoolean";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatBoolean( val ) + "\"";
		return( retval );
	}

	public static String formatRequiredBlob( String separator, String attrName, byte[] val ) {
		final String S_ProcName = "formatRequiredBlob";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatBlob( val ) + "\"";
		return( retval );
	}
	
	public static String formatRequiredInt16( String separator, String attrName, short val ) {
		final String S_ProcName = "formatRequiredInt16";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatInt16( val ) + "\"";
		return( retval );
	}

	public static String formatRequiredInt32( String separator, String attrName, int val ) {
		final String S_ProcName = "formatRequiredInt32";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatInt32( val ) + "\"";
		return( retval );
	}

	public static String formatRequiredInt64( String separator, String attrName, long val ) {
		final String S_ProcName = "formatRequiredInt64";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatInt64( val ) + "\"";
		return( retval );
	}

	public static String formatRequiredUInt16( String separator, String attrName, int val ) {
		final String S_ProcName = "formatRequiredUInt16";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatUInt16( val ) + "\"";
		return( retval );
	}

	public static String formatRequiredUInt32( String separator, String attrName, long val ) {
		final String S_ProcName = "formatRequiredUInt32";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatUInt32( val ) + "\"";
		return( retval );
	}

	public static String formatRequiredUInt64( String separator, String attrName, BigDecimal val ) {
		final String S_ProcName = "formatRequiredUInt64";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatUInt64( val ) + "\"";
		return( retval );
	}

	public static String formatRequiredFloat( String separator, String attrName, float val ) {
		final String S_ProcName = "formatRequiredFloat";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatFloat( val ) + "\"";
		return( retval );
	}

	public static String formatRequiredDouble( String separator, String attrName, double val ) {
		final String S_ProcName = "formatRequiredDouble";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatDouble( val ) + "\"";
		return( retval );
	}

	public static String formatRequiredNumber( String separator, String attrName, BigDecimal val ) {
		final String S_ProcName = "formatRequiredNumber";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatNumber( val ) + "\"";
		return( retval );
	}

	public static String formatRequiredXmlString( String separator, String attrName, String str ) {
		final String S_ProcName = "formatRequiredXmlString";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatXmlString( str ) + "\"";
		return( retval );
	}

	public static String formatRequiredDate( String separator, String attrName, LocalDate cal ) {
		final String S_ProcName = "formatRequiredDate";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatDate( cal ) + "\"";
		return( retval );
	}

	public static String formatRequiredTime( String separator, String attrName, LocalTime cal ) {
		final String S_ProcName = "formatRequiredTime";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatTime( cal ) + "\"";
		return( retval );
	}

	public static String formatRequiredTimestamp( String separator, String attrName, LocalDateTime cal ) {
		final String S_ProcName = "formatRequiredTimestamp";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatTimestamp( cal ) + "\"";
		return( retval );
	}

	public static String formatRequiredTZDate( String separator, String attrName, LocalDate cal ) {
		final String S_ProcName = "formatRequiredTZDate";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatTZDate( cal ) + "\"";
		return( retval );
	}

	public static String formatRequiredTZTime( String separator, String attrName, LocalTime cal ) {
		final String S_ProcName = "formatRequiredTZTime";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatTZTime( cal ) + "\"";
		return( retval );
	}

	public static String formatRequiredTZTimestamp( String separator, String attrName, LocalDateTime cal ) {
		final String S_ProcName = "formatRequiredTZTimestamp";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatTZTimestamp( cal ) + "\"";
		return( retval );
	}

	public static String formatRequiredUuid( String separator, String attrName, UUID val ) {
		final String S_ProcName = "formatRequiredUuid";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatUuid( val ) + "\"";
		return( retval );
	}

	/**
	 *	Formatting for Optional XML attributes.
	**/
	
	public static String formatOptionalBoolean( String separator, String attrName, Boolean val ) {
		final String S_ProcName = "formatOptionalBoolean";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( val != null ) {
			retval = formatRequiredBoolean( separator, attrName, val.booleanValue() );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalBlob( String separator, String attrName, byte[] val ) {
		final String S_ProcName = "formatOptionalBlob";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( val != null ) {
			retval = formatRequiredBlob( separator, attrName, val );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}
	
	public static String formatOptionalInt16( String separator, String attrName, Short val ) {
		final String S_ProcName = "formatOptionalInt16";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( val != null ) {
			retval = formatRequiredInt16( separator, attrName, val.shortValue() );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalInt32( String separator, String attrName, Integer val ) {
		final String S_ProcName = "formatOptionalInt32";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( val != null ) {
			retval = formatRequiredInt32( separator, attrName, val.intValue() );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalInt64( String separator, String attrName, Long val ) {
		final String S_ProcName = "formatOptionalInt64";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( val != null ) {
			retval = formatRequiredInt64( separator, attrName, val.longValue() );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalUInt16( String separator, String attrName, Integer val ) {
		final String S_ProcName = "formatOptionalUInt16";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( val != null ) {
			retval = formatRequiredUInt16( separator, attrName, val.intValue() );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalUInt32( String separator, String attrName, Long val ) {
		final String S_ProcName = "formatOptionalUInt32";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( val != null ) {
			retval = formatRequiredUInt32( separator, attrName, val.longValue() );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalUInt64( String separator, String attrName, BigDecimal val ) {
		final String S_ProcName = "formatOptionalUInt64";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( val != null ) {
			retval = formatRequiredUInt64( separator, attrName, val );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalFloat( String separator, String attrName, Float val ) {
		final String S_ProcName = "formatOptionalFloat";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( val != null ) {
			retval = formatRequiredFloat( separator, attrName, val.floatValue() );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalDouble( String separator, String attrName, Double val ) {
		final String S_ProcName = "formatOptionalDouble";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( val != null ) {
			retval = formatRequiredDouble( separator, attrName, val.doubleValue() );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalNumber( String separator, String attrName, BigDecimal val ) {
		final String S_ProcName = "formatOptionalNumber";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( val != null ) {
			retval = formatRequiredNumber( separator, attrName, val );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalXmlString( String separator, String attrName, String str ) {
		final String S_ProcName = "formatOptionalXmlString";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( str != null ) {
			retval = formatRequiredXmlString( separator, attrName, str );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalDate( String separator, String attrName, LocalDate cal ) {
		final String S_ProcName = "formatOptionalDate";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( cal != null ) {
			retval = formatRequiredDate( separator, attrName, cal );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalTime( String separator, String attrName, LocalTime cal ) {
		final String S_ProcName = "formatOptionalTime";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( cal != null ) {
			retval = formatRequiredTime( separator, attrName, cal );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalTimestamp( String separator, String attrName, LocalDateTime cal ) {
		final String S_ProcName = "formatOptionalTimestamp";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( cal != null ) {
			retval = formatRequiredTimestamp( separator, attrName, cal );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalTZDate( String separator, String attrName, LocalDate cal ) {
		final String S_ProcName = "formatOptionalTZDate";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( cal != null ) {
			retval = formatRequiredTZDate( separator, attrName, cal );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalTZTime( String separator, String attrName, LocalTime cal ) {
		final String S_ProcName = "formatOptionalTZTime";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( cal != null ) {
			retval = formatRequiredTZTime( separator, attrName, cal );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalTZTimestamp( String separator, String attrName, LocalDateTime cal ) {
		final String S_ProcName = "formatOptionalTZTimestamp";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( cal != null ) {
			retval = formatRequiredTZTimestamp( separator, attrName, cal );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}

	public static String formatOptionalUuid( String separator, String attrName, UUID val ) {
		final String S_ProcName = "formatOptionalUuid";
		if( ( attrName == null ) || ( attrName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFXmlUtil.class,
					S_ProcName,
					1,
					"attrName" );
		}
		String retval;
		if( val != null ) {
			retval = formatRequiredUuid( separator, attrName, val );
		}
		else {
			retval = S_emptyString;
		}
		return( retval );
	}
	
}
