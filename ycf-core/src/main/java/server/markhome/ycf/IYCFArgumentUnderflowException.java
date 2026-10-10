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
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, short argObj, short minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, short argObj, short minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, int argObj, int minValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, int argObj, int minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, long argObj, long minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, long argObj, long minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, float argObj, float minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, float argObj, float minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
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
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, double argObj, double minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, double argObj, double minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDate argObj, LocalDate minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDate argObj, LocalDate minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalTime argObj, LocalTime minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalTime argObj, LocalTime minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDateTime argObj, LocalDateTime minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, LocalDateTime argObj, LocalDateTime minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, String argObj, String minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, String argObj, String minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, BigDecimal argObj, BigDecimal minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, BigDecimal argObj, BigDecimal minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, Object argObj, Object minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, Object argObj, Object minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( Class<?> throwingClass, String methName, int argNo, String argName, Object argObj, Object minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, short argObj, short minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, short argObj, short minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, int argObj, int minValue );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, int argObj, int minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, long argObj, long minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, long argObj, long minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, float argObj, float minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, float argObj, float minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, double argObj, double minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, double argObj, double minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDate argObj, LocalDate minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDate argObj, LocalDate minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalTime argObj, LocalTime minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalTime argObj, LocalTime minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDateTime argObj, LocalDateTime minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, LocalDateTime argObj, LocalDateTime minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, String argObj, String minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, String argObj, String minValue, Throwable cause );

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, BigDecimal argObj, BigDecimal minValue);

	/**
	 *	Get an exception instance with the default message for the situation.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, BigDecimal argObj, BigDecimal minValue, Throwable cause );

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, Object argObj, Object minValue);

	/**
	 *	Get an exception instance with the specified English and translated messages and source.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName Method name
	 *	@param argNo Argument number
	 *	@param argName Argument name
	 *	@param argObj The object (typically a PKey, Key, Buff, or Obj instance) causing the exception
	 *	@param minValue Minimum limit enforced by the exception
	 *	@param cause Throwable which caused the exception
	 *
	 *	@return IYCFArgumentUnderflowException A new instance with the specified messages and source.
	 */
	@JSExport
	public IYCFArgumentUnderflowException getInstance( String enFieldName, String xFieldName, String methName, int argNo, String argName, Object argObj, Object minValue, Throwable cause );

	/**
	 *	Get the argument minimum Object value provided at construction, if any.
	 *
	 *	@return The minium value object.
	 */
	@JSExport
	public Object getMinValue();
}
