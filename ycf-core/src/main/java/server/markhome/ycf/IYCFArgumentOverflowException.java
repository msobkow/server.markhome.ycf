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

import java.math.*;

/**
 * IYCFArgumentOverflowException indicates that an argument exceeds the permitted value range.
 */
public interface IYCFArgumentOverflowException extends IYCFArgumentException {

	/**
	 *	Get the interface implementation singleton providing the getInstance() implementations.
	 *
	 *	@return IYCFArgumentOverflowException The interface singleton
	 */
	@JSExport
	public IYCFArgumentOverflowException getSingleton();

	/**
	 *	Get an exception instance with the specified English and translated messages.
	 *
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enMsg, String xMsg );

	/**
	 *	Get an exception instance with the specified English and translated messages.
	 *
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enMsg, String xMsg, Throwable cause);

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass Class throwing the exception
	 *	@param methName Method name
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, String enMsg, String xMsg );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass Class throwing the exception
	 *	@param methName Method name
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, String enMsg, String xMsg, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String enMsg, String xMsg );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method Name
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, String enMsg, String xMsg );

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
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, String enMsg, String xMsg, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, short argValue, short maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, short argValue, short maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, int argValue, int maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, int argValue, int maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, long argValue, long maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, long argValue, long maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, float argValue, float maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, float argValue, float maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, double argValue, double maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, double argValue, double maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDate argValue, LocalDate maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDate argValue, LocalDate maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalTime argValue, LocalTime maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalTime argValue, LocalTime maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDateTime argValue, LocalDateTime maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDateTime argValue, LocalDateTime maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, String argValue, String maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, String argValue, String maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, BigDecimal argValue, BigDecimal maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, BigDecimal argValue, BigDecimal maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, short argValue, short maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, short argValue, short maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, int argValue, int maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, int argValue, int maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, long argValue, long maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, long argValue, long maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, float argValue, float maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, float argValue, float maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, double argValue, double maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, double argValue, double maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDate argValue, LocalDate maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDate argValue, LocalDate maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalTime argValue, LocalTime maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalTime argValue, LocalTime maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDateTime argValue, LocalDateTime maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDateTime argValue, LocalDateTime maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, String argValue, String maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, String argValue, String maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, BigDecimal argValue, BigDecimal maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param maxValue Limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentOverflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentOverflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, BigDecimal argValue, BigDecimal maxValue, Throwable cause );
}
