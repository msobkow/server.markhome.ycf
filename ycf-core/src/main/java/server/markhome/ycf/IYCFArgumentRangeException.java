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

import server.markhome.ycf.Inz;

import java.math.*;

/**
 * IYCFArgumentRangeException indicates that an argument is outside the permitted value range.
 */
public interface IYCFArgumentRangeException extends IYCFArgumentException {

	/**
	 *	Get the interface implementation singleton providing the getInstance() implementations.
	 *
	 *	@return IYCFArgumentRangeException The interface singleton
	 */
	@JSExport
	public IYCFArgumentRangeException getSingleton();

	/**
	 *	Get an exception instance with the specified English and translated messages.
	 *
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enMsg, String xMsg );

	/**
	 *	Get an exception instance with the specified English and translated messages.
	 *
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enMsg, String xMsg, Throwable cause);

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass Class throwing the exception
	 *	@param methName Method name
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, String enMsg, String xMsg );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass Class throwing the exception
	 *	@param methName Method name
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, String enMsg, String xMsg, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String enMsg, String xMsg );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method Name
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, String enMsg, String xMsg );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method Name
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, String enMsg, String xMsg, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, short argValue, short minValue, short maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, short argValue, short minValue, short maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, int argValue, int minValue, int maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, int argValue, int minValue, int maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, long argValue, long minValue, long maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, long argValue, long minValue, long maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, float argValue, float minValue, float maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, float argValue, float minValue, float maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, double argValue, double minValue, double maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, double argValue, double minValue, double maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDate argValue, LocalDate minValue, LocalDate maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDate argValue, LocalDate minValue, LocalDate maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalTime argValue, LocalTime minValue, LocalTime maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalTime argValue, LocalTime minValue, LocalTime maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDateTime argValue, LocalDateTime minValue, LocalDateTime maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDateTime argValue, LocalDateTime minValue, LocalDateTime maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, String argValue, String minValue, String maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, String argValue, String minValue, String maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, BigDecimal argValue, BigDecimal minValue, BigDecimal maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, BigDecimal argValue, BigDecimal minValue, BigDecimal maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance(Class<?> throwingClass, String methName, int argNo, String argName, Object argValue, String enMsg, String xMsg);

	/**
	 *	Get an exception instance with the specified English and translated messages.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance(Class<?> throwingClass, String methName, int argNo, String argName, Object argValue, String enMsg, String xMsg, Throwable cause);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance(Class<?> throwingClass, String methName, int argNo, String argName, Object argValue, Object minValue, Object maxValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance(Class<?> throwingClass, String methName, int argNo, String argName, Object argValue, Object minValue, Object maxValue, Throwable cause);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, short argValue, short minValue, short maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, short argValue, short minValue, short maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, int argValue, int minValue, int maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, int argValue, int minValue, int maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, long argValue, long minValue, long maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, long argValue, long minValue, long maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, float argValue, float minValue, float maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, float argValue, float minValue, float maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, double argValue, double minValue, double maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, double argValue, double minValue, double maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDate argValue, LocalDate minValue, LocalDate maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDate argValue, LocalDate minValue, LocalDate maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalTime argValue, LocalTime minValue, LocalTime maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalTime argValue, LocalTime minValue, LocalTime maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDateTime argValue, LocalDateTime minValue, LocalDateTime maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDateTime argValue, LocalDateTime minValue, LocalDateTime maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, String argValue, String minValue, String maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, String argValue, String minValue, String maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, BigDecimal argValue, BigDecimal minValue, BigDecimal maxValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, BigDecimal argValue, BigDecimal minValue, BigDecimal maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance(String enFieldName, String xFieldName, String methName, int argNo, String argName, Object argValue, Object maxValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Maximum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance(String enFieldName, String xFieldName, String methName, int argNo, String argName, Object argValue, Object maxValue, Throwable cause);

	/**
	 *	Get an exception instance with the specified English and translated messages.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance(String enFieldName, String xFieldName, String methName, int argNo, String argName, Object argValue, String enMsg, String xMsg);

	/**
	 *	Get an exception instance with the specified English and translated messages.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentRangeException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentRangeException getInstance(Class<?> throwingClass, String methName, int argNo, String argName, Object argValue, String enMsg, String xMsg, Throwable cause);

	/**
	 *	Get the source of the exception (either the field name and possible argument number and name, or the class and method with possible argument number and name.)
	 *
	 *	@return The source of the exception.
	 */
	@JSExport
	public String getSource();

	/**
	 *	Get the English version of the exception message.
	 *
	 *	@return The English exception message body.
	 */
	@JSExport
	public String getEnMessage();

	/**
	 *	Get the localized/translated version of the exception message.
	 *
	 *	@return The localized/translated exception message body.
	 */
	@JSExport
	public String getXMessage();

	/**
	 *	Get the argument index provided at construction, if any.
	 *
	 *	@return The argument index provided at construction.
	 */
	@JSExport
	public int getArgNo();

	/**
	 *	Get the argument name provided at construction, if any.
	 *
	 *	@return The argument name provided at construction.
	 */
	@JSExport
	public String getArgName();

	/**
	 *	Get the argument Object value provided at construction, if any.
	 *
	 *	@return The argument object.
	 */
	@JSExport
	public Object getArgValue();

	/**
	 *	Get the argument maximum Object value provided at construction, if any.
	 *
	 *	@return The argument maximum value object.
	 */
	@JSExport
	public Object getMaxValue();

	/**
	 *	Get the argument minimum Object value provided at construction, if any.
	 *
	 *	@return The argument minimum value object.
	 */
	@JSExport
	public Object getMinValue();

	/**
	 *	Get the argument maximum Object value provided at construction, if any.
	 *
	 *	@return The argument maximum value object.
	 */
	@JSExport
	public Object getMaxValue();

	/**
	 *	Get the source of the exception (either the field name and possible argument number and name, or the class and method with possible argument number and name.)
	 *
	 *	@return The source of the exception.
	 */
	@JSExport
	public String getSource();

	/**
	 *	Get the English version of the exception message.
	 *
	 *	@return The English exception message body.
	 */
	@JSExport
	public String getEnMessage();

	/**
	 *	Get the localized/translated version of the exception message.
	 *
	 *	@return The localized/translated exception message body.
	 */
	@JSExport
	public String getXMessage();

	/**
	 *	Get the argument index provided at construction, if any.
	 *
	 *	@return The argument index provided at construction.
	 */
	@JSExport
	public int getArgNo();

	/**
	 *	Get the argument name provided at construction, if any.
	 *
	 *	@return The argument name provided at construction.
	 */
	@JSExport
	public String getArgName();

	/**
	 *	Get the argument Object value provided at construction, if any.
	 *
	 *	@return The argument object.
	 */
	@JSExport
	public Object getArgValue();

	/**
	 *	Get the argument maximum Object value provided at construction, if any.
	 *
	 *	@return The argument maximum value object.
	 */
	@JSExport
	public Object getMaxValue();

	/**
	 *	Get the argument minimum Object value provided at construction, if any.
	 *
	 *	@return The argument minimum value object.
	 */
	@JSExport
	public Object getMinValue();

	/**
	 *	Get the argument maximum Object value provided at construction, if any.
	 *
	 *	@return The argument maximum value object.
	 */
	@JSExport
	public Object getMaxValue();
}
