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
 * IYCFArgumentUnderflowException indicates that an argument is outside the permitted value range.
 */
public interface IYCFArgumentUnderflowException extends IYCFArgumentException {

	/**
	 *	Get the interface implementation singleton providing the getInstance() implementations.
	 *
	 *	@return IYCFArgumentUnderflowException The interface singleton
	 */
	@JSExport
	public IYCFArgumentUnderflowException getSingleton();

	/**
	 *	Get an exception instance with the specified English and translated messages.
	 *
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enMsg, String xMsg );

	/**
	 *	Get an exception instance with the specified English and translated messages.
	 *
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enMsg, String xMsg, Throwable cause);

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass Class throwing the exception
	 *	@param methName Method name
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, String enMsg, String xMsg );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass Class throwing the exception
	 *	@param methName Method name
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, String enMsg, String xMsg, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String enMsg, String xMsg );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method Name
	 *	@param enMsg English message text
	 *	@param xMsg Translated message text
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, String enMsg, String xMsg );

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
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, String enMsg, String xMsg, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, short argValue, short minValue, short maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, short argValue, short minValue, short maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, int argValue, int minValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, int argValue, int minValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, long argValue, long minValue, long maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, long argValue, long minValue, long maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, float argValue, float minValue, float maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, float argValue, float minValue, float maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, double argValue, double minValue, double maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, double argValue, double minValue, double maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDate argValue, LocalDate minValue, LocalDate maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDate argValue, LocalDate minValue, LocalDate maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalTime argValue, LocalTime minValue, LocalTime maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalTime argValue, LocalTime minValue, LocalTime maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDateTime argValue, LocalDateTime minValue, LocalDateTime maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDateTime argValue, LocalDateTime minValue, LocalDateTime maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, String argValue, String minValue, String maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, String argValue, String minValue, String maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, BigDecimal argValue, BigDecimal minValue, BigDecimal maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, BigDecimal argValue, BigDecimal minValue, BigDecimal maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, short argValue, short minValue, short maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, short argValue, short minValue, short maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, int argValue, int minValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, int argValue, int minValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, long argValue, long minValue, long maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, long argValue, long minValue, long maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, float argValue, float minValue, float maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, float argValue, float minValue, float maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, double argValue, double minValue, double maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, double argValue, double minValue, double maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDate argValue, LocalDate minValue, LocalDate maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDate argValue, LocalDate minValue, LocalDate maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalTime argValue, LocalTime minValue, LocalTime maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalTime argValue, LocalTime minValue, LocalTime maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDateTime argValue, LocalDateTime minValue, LocalDateTime maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDateTime argValue, LocalDateTime minValue, LocalDateTime maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, String argValue, String minValue, String maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, String argValue, String minValue, String maxValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, BigDecimal argValue, BigDecimal minValue, BigDecimal maxValue );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argValue Value which caused the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, BigDecimal argValue, BigDecimal minValue, BigDecimal maxValue, Throwable cause );
}
