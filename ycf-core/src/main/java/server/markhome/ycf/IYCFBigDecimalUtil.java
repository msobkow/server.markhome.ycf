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

/**
 *	IYCFBigDecimalUtil defines the service methods which are used to instantiate, parse, clone, and prepare a BigDecimal value for marshalling/unmarshalling as a byte array.
 *
 *	@since 2016
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public interface IYCFBigDecimalUtil extends JSObject {

	/**
	 *	IYCFBigDecimalUtil getSingleton()
	 *		Get the singleton instance that provides the getInstance() and service method implementations.
	 *
	 *	@return IYCFBigDecimalUtil The singleton for the implementation.
	 */
	@JSExport
	public IYCFBigDecimalUtil getSingleton();

	/**
	 *	The maximum number of digits supported is 31, in keeping with database NUMBER limitations from the majority of vendors.
	 */
	public final static int MAX_DIGITS = 31;

	/**
	 *	There must be at least a one's digit, so only 30 digits precision can be specified.
	 */
	public final static int MAX_PRECISION = 30;
	
	final static String S_Hashes = "###############################";
	final static String S_Zeroes = "0000000000000000000000000000000";
	final static String S_Nines =  "9999999999999999999999999999999";

	/**
	 *	Get a Format object for a number with the specified field name, translated field name, number of digits, and precision.
	 *
	 *	@param String enFieldName The English field name
	 *	@param String xFieldName The translated field name
	 *	@param int argDigits The maximum number of digits to display
	 *	@param int argPrecis The number of digits to show after the decimal point, or if negative, as zeroes before the decimal point.
	 */
	@JSExport
	public Format getNumberFormat( String enFieldName, String xFieldName, int argDigits, int argPrecis );

	/**
	 *	Get a Format object for a number with the specified field name, translated field name, number of digits, and precision.
	 *
	 *	@param Class<?> clazz The class formatting the number
	 *	@param int argDigits The maximum number of digits to display
	 *	@param int argPrecis The number of digits to show after the decimal point, or if negative, as zeroes before the decimal point.
	 */
	@JSExport
	public static Format getNumberFormat( Class<?> clazz, int argDigits, int argPrecis );

	/**
	 *	Get the absolute minimum value for a number with the specified field name, translated field name, number of digits, and precision.
	 *
	 *	@param String enFieldName The English field name
	 *	@param String xFieldName The translated field name
	 *	@param int argDigits The maximum number of digits to display
	 *	@param int argPrecis The number of digits to show after the decimal point, or if negative, as zeroes before the decimal point.
	 */
	@JSExport
	public BigDecimal getAbsoluteMinValue( String enFieldName, String xFieldName, int argDigits, int argPrecis );

	/**
	 *	Get the absolute maximum value for a number with the specified field name, translated field name, number of digits, and precision.
	 *
	 *	@param String enFieldName The English field name
	 *	@param String xFieldName The translated field name
	 *	@param int argDigits The maximum number of digits to display
	 *	@param int argPrecis The number of digits to show after the decimal point, or if negative, as zeroes before the decimal point.
	 */
	@JSExport
	public BigDecimal getAbsoluteMaxValue( String enFieldName, String xFieldName, int argDigits, int argPrecis );

	/**
	 *	Coerce a BigDecimal value to a number with the specified field name, translated field name, number of digits, and precision.
	 *
	 *	@param String enFieldName The English field name
	 *	@param String xFieldName The translated field name
	 *	@param int argDigits The maximum number of digits to display
	 *	@param int argPrecis The number of digits to show after the decimal point, or if negative, as zeroes before the decimal point.
	 */
	@JSExport
	public BigDecimal coerce( String enFieldName, String xFieldName, int argDigits, int argPrecis, BigDecimal value );

	/**
	 *	Parse a BigDecimal value string into a number with the specified field name, translated field name, number of digits, and precision.
	 *
	 *	@param String enFieldName The English field name
	 *	@param String xFieldName The translated field name
	 *	@param int argDigits The maximum number of digits to display
	 *	@param int argPrecis The number of digits to show after the decimal point, or if negative, as zeroes before the decimal point.
	 */
	@JSExport
	public BigDecimal parse( String enFieldName, String xFieldName, int argDigits, int argPrecis, String value );

	/**
	 *	Format BigDecimal value into a string with the specified field name, translated field name, number of digits, and precision.
	 *
	 *	@param String enFieldName The English field name
	 *	@param String xFieldName The translated field name
	 *	@param int argDigits The maximum number of digits to display
	 *	@param int argPrecis The number of digits to show after the decimal point, or if negative, as zeroes before the decimal point.
	 */
	@JSExport
	public String format( String enFieldName, String xFieldName, int argDigits, int argPrecis, BigDecimal value );
}
