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

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;

public class YCFBigDecimalUtil {

	public final static int MAX_DIGITS = 31;
	public final static int MAX_PRECISION = 30;
	
	final static String S_Hashes = "###############################";
	final static String S_Zeroes = "0000000000000000000000000000000";
	final static String S_Nines =  "9999999999999999999999999999999";

	public static Format getNumberFormat( String enFieldName, String xFieldName, int argDigits, int argPrecis ) {
		final String S_ProcName = "getNumberFormat";

		if( ( enFieldName == null ) || ( enFieldName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFBigDecimalUtil.class,
				S_ProcName,
				1,
				"enFieldName" );
		}

		if( argDigits < 1 ) {
			throw new YCFArgumentUnderflowException( enFieldName,
				xFieldName,
				S_ProcName,
				3,
				"argDigits",
				argDigits,
				1 );
		}
		else if( argDigits > MAX_DIGITS ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				3,
				"argDigits",
				argDigits,
				MAX_DIGITS );
		}

		if( argPrecis < 0 ) {
			throw new YCFArgumentUnderflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				0 );
		}
		else if( argPrecis > MAX_PRECISION ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				MAX_PRECISION );
		}

		if( argPrecis >= argDigits ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				argDigits - 1 );
		}

		int integerDigits = argDigits - argPrecis;
		
		String usePrefixHash = S_Hashes.substring( 0, integerDigits - 1 );
		
		String useSuffix;
		if( argPrecis > 0 ) {
			useSuffix = "." + S_Zeroes.substring( 0, argPrecis );
		}
		else {
			useSuffix = "";
		}
		
		Format numberFormat = new DecimalFormat(
			usePrefixHash + "0" + useSuffix + ";-" + usePrefixHash + "0" + useSuffix );
		
		return( numberFormat );
	}

	public static Format getNumberFormat( Class<?> clazz, int argDigits, int argPrecis ) {
		final String S_ProcName = "getNumberFormat";

		if( ( clazz == null ) ) {
			throw new YCFNullArgumentException( YCFBigDecimalUtil.class,
				S_ProcName,
				1,
				"clazz" );
		}

		if( argDigits < 1 ) {
			throw new YCFArgumentUnderflowException( clazz,
				S_ProcName,
				3,
				"argDigits",
				argDigits,
				1 );
		}
		else if( argDigits > MAX_DIGITS ) {
			throw new YCFArgumentOverflowException( clazz,
				S_ProcName,
				3,
				"argDigits",
				argDigits,
				MAX_DIGITS );
		}

		if( argPrecis < 0 ) {
			throw new YCFArgumentUnderflowException( clazz,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				0 );
		}
		else if( argPrecis > MAX_PRECISION ) {
			throw new YCFArgumentOverflowException( clazz,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				MAX_PRECISION );
		}

		if( argPrecis >= argDigits ) {
			throw new YCFArgumentOverflowException( clazz,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				argDigits - 1 );
		}

		int integerDigits = argDigits - argPrecis;
		
		String usePrefixHash = S_Hashes.substring( 0, integerDigits - 1 );
		
		String useSuffix;
		if( argPrecis > 0 ) {
			useSuffix = "." + S_Zeroes.substring( 0, argPrecis );
		}
		else {
			useSuffix = "";
		}
		
		Format numberFormat = new DecimalFormat(
			usePrefixHash + "0" + useSuffix + ";-" + usePrefixHash + "0" + useSuffix );
		
		return( numberFormat );
	}

	public static BigDecimal getAbsoluteMinValue( String enFieldName, String xFieldName, int argDigits, int argPrecis ) {
		final String S_ProcName = "getAbsoluteMinValue";

		if( ( enFieldName == null ) || ( enFieldName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFBigDecimalUtil.class,
				S_ProcName,
				1,
				"enFieldName" );
		}

		if( argDigits < 1 ) {
			throw new YCFArgumentUnderflowException( enFieldName,
				xFieldName,
				S_ProcName,
				3,
				"argDigits",
				argDigits,
				1 );
		}
		else if( argDigits > MAX_DIGITS ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				3,
				"argDigits",
				argDigits,
				MAX_DIGITS );
		}

		if( argPrecis < 0 ) {
			throw new YCFArgumentUnderflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				0 );
		}
		else if( argPrecis > MAX_PRECISION ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				MAX_PRECISION );
		}

		if( argPrecis >= argDigits ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				argDigits - 1 );
		}

		int integerDigits = argDigits - argPrecis;

		String strval;
		if( argPrecis == 0 ) {
			strval = "-" + S_Nines.substring( 0, integerDigits );
		}
		else {
			strval = "-" + S_Nines.substring( 0, integerDigits ) + "." + S_Nines.substring( 0, argPrecis );
		}
		
		BigDecimal absoluteMinValue = new BigDecimal( strval );
		
		return( absoluteMinValue );
	}

	public static BigDecimal getAbsoluteMaxValue( String enFieldName, String xFieldName, int argDigits, int argPrecis ) {
		final String S_ProcName = "getAbsoluteMaxValue";

		if( ( enFieldName == null ) || ( enFieldName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFBigDecimalUtil.class,
				S_ProcName,
				1,
				"enFieldName" );
		}

		if( argDigits < 1 ) {
			throw new YCFArgumentUnderflowException( enFieldName,
				xFieldName,
				S_ProcName,
				3,
				"argDigits",
				argDigits,
				1 );
		}
		else if( argDigits > MAX_DIGITS ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				3,
				"argDigits",
				argDigits,
				MAX_DIGITS );
		}

		if( argPrecis < 0 ) {
			throw new YCFArgumentUnderflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				0 );
		}
		else if( argPrecis > MAX_PRECISION ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				MAX_PRECISION );
		}

		if( argPrecis >= argDigits ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				argDigits - 1 );
		}

		int integerDigits = argDigits - argPrecis;

		String strval;
		if( argPrecis == 0 ) {
			strval = S_Nines.substring( 0, integerDigits );
		}
		else {
			strval = S_Nines.substring( 0, integerDigits ) + "." + S_Nines.substring( 0, argPrecis );
		}
		
		BigDecimal absoluteMaxValue = new BigDecimal( strval );
		
		return( absoluteMaxValue );
	}

	public static BigDecimal coerce( String enFieldName, String xFieldName, int argDigits, int argPrecis, BigDecimal value ) {
		final String S_ProcName = "coerce";

		if( ( enFieldName == null ) || ( enFieldName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFBigDecimalUtil.class,
				S_ProcName,
				1,
				"enFieldName" );
		}

		if( value == null ) {
			throw new YCFNullArgumentException( enFieldName,
				xFieldName,
				S_ProcName,
				5,
				"value" );
		}
		
		if( argDigits < 1 ) {
			throw new YCFArgumentUnderflowException( enFieldName,
				xFieldName,
				S_ProcName,
				3,
				"argDigits",
				argDigits,
				1 );
		}
		else if( argDigits > MAX_DIGITS ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				3,
				"argDigits",
				argDigits,
				MAX_DIGITS );
		}

		if( argPrecis < 0 ) {
			throw new YCFArgumentUnderflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				0 );
		}
		else if( argPrecis > MAX_PRECISION ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				MAX_PRECISION );
		}

		if( argPrecis >= argDigits ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				argDigits - 1 );
		}

		BigDecimal minValue = getAbsoluteMinValue( enFieldName, xFieldName, argDigits, argPrecis );
		if( value.compareTo( minValue ) < 0 ) {
			throw new YCFArgumentUnderflowException( enFieldName,
				xFieldName,
				S_ProcName,
				5,
				"value",
				value,
				minValue );
		}
		
		BigDecimal maxValue = getAbsoluteMaxValue( enFieldName, xFieldName, argDigits, argPrecis );
		if( value.compareTo( maxValue ) > 0 ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				5,
				"value",
				value,
				maxValue );
		}

		String coercedString = getNumberFormat( enFieldName, xFieldName, argDigits, argPrecis ).format( value );
		
		BigDecimal coercedValue = new BigDecimal( coercedString );
		
		return( coercedValue );
	}

	public static BigDecimal parse( String enFieldName, String xFieldName, int argDigits, int argPrecis, String value ) {
		final String S_ProcName = "parse";

		if( ( enFieldName == null ) || ( enFieldName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFBigDecimalUtil.class,
				S_ProcName,
				1,
				"enFieldName" );
		}

		if( ( value == null ) || ( value.length() <= 0 ) ) {
			return( null );
		}
		
		if( argDigits < 1 ) {
			throw new YCFArgumentUnderflowException( enFieldName,
				xFieldName,
				S_ProcName,
				3,
				"argDigits",
				argDigits,
				1 );
		}
		else if( argDigits > MAX_DIGITS ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				3,
				"argDigits",
				argDigits,
				MAX_DIGITS );
		}

		if( argPrecis < 0 ) {
			throw new YCFArgumentUnderflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				0 );
		}
		else if( argPrecis > MAX_PRECISION ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				MAX_PRECISION );
		}

		if( argPrecis >= argDigits ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				argDigits - 1 );
		}
		
		BigDecimal rawValue = new BigDecimal( value );
		BigDecimal minValue = getAbsoluteMinValue( enFieldName, xFieldName, argDigits, argPrecis );
		BigDecimal maxValue = getAbsoluteMaxValue( enFieldName, xFieldName, argDigits, argPrecis );

		if( rawValue.compareTo( minValue ) < 0 ) {
			throw new YCFArgumentUnderflowException( enFieldName,
				xFieldName,
				S_ProcName,
				5,
				"value",
				rawValue,
				minValue );
		}
		
		if( rawValue.compareTo( maxValue ) > 0 ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				5,
				"value",
				rawValue,
				maxValue );
		}

		String coercedString = getNumberFormat( enFieldName, xFieldName, argDigits, argPrecis ).format( rawValue );
		
		BigDecimal coercedValue = new BigDecimal( coercedString );
		
		return( coercedValue );
	}

	public static String format( String enFieldName, String xFieldName, int argDigits, int argPrecis, BigDecimal value ) {
		final String S_ProcName = "format";

		if( ( enFieldName == null ) || ( enFieldName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( YCFBigDecimalUtil.class,
				S_ProcName,
				1,
				"enFieldName" );
		}

		if( value == null ) {
			throw new YCFNullArgumentException( enFieldName,
				xFieldName,
				S_ProcName,
				5,
				"value" );
		}
		
		if( argDigits < 1 ) {
			throw new YCFArgumentUnderflowException( enFieldName,
				xFieldName,
				S_ProcName,
				3,
				"argDigits",
				argDigits,
				1 );
		}
		else if( argDigits > MAX_DIGITS ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				3,
				"argDigits",
				argDigits,
				MAX_DIGITS );
		}

		if( argPrecis < 0 ) {
			throw new YCFArgumentUnderflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				0 );
		}
		else if( argPrecis > MAX_PRECISION ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				MAX_PRECISION );
		}

		if( argPrecis >= argDigits ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				4,
				"argPrecis",
				argPrecis,
				argDigits - 1 );
		}

		BigDecimal minValue = getAbsoluteMinValue( enFieldName, xFieldName, argDigits, argPrecis );
		if( value.compareTo( minValue ) < 0 ) {
			throw new YCFArgumentUnderflowException( enFieldName,
				xFieldName,
				S_ProcName,
				5,
				"value",
				value,
				minValue );
		}
		
		BigDecimal maxValue = getAbsoluteMaxValue( enFieldName, xFieldName, argDigits, argPrecis );
		if( value.compareTo( maxValue ) > 0 ) {
			throw new YCFArgumentOverflowException( enFieldName,
				xFieldName,
				S_ProcName,
				5,
				"value",
				value,
				maxValue );
		}

		String coercedString = getNumberFormat( enFieldName, xFieldName, argDigits, argPrecis ).format( value );
		
		return( coercedString );
	}
}
