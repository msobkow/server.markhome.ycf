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

/**
 * If a base class only implements a method to allow it to be instantiated but it is only valid when a subclass specializes it, IYCFMustOverrideException is thrown by that base implementation.
 */
public interface IYCFMustOverrideException extends IYCFRuntimeException {

	/**
	 *	IYCFMustOverrideException getSingleton()
	 *		Get the singleton instance that provides the getInstance() implementations.
	 *
	 *	@return IYCFMustOverrideException The singleton for the exception implementation.
	 */
	@JSExport
	public IYCFMustOverrideException getSingleton();

	/**
	 *	IYCFMustOverrideException(enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *
	 *	@return IYCFMustOverrideException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFMustOverrideException getInstance(String enMsg, String xMsg);

	/**
	 *	IYCFMustOverrideException(enMsg, xMsg, cause)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *	@param cause Root cause thrown by code
	 *
	 *	@return IYCFMustOverrideException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFMustOverrideException getInstance(String enMsg, String xMsg, Throwable cause);

	/**
	 *	IYCFMustOverrideException(throwingClass, methName, enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name which is throwing the exception; include a "-variant" distinguishing sub-tag if the method has overloaded implementations and signatures.
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *
	 *	@return IYCFMustOverrideException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFMustOverrideException getInstance(Class<?> throwingClass, String methName, String enMsg, String xMsg);

	/**
	 *	IYCFMustOverrideException(throwingClass, methName, enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name which is throwing the exception; include a "-variant" distinguishing sub-tag if the method has overloaded implementations and signatures.
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *	@param cause Root cause thrown by code
	 *
	 *	@return IYCFMustOverrideException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFMustOverrideException getInstance(Class<?> throwingClass, String methName, String enMsg, String xMsg, Throwable cause);

	/**
	 *	IYCFMustOverrideException(throwingClass, methName, argNo, argName, argObj, enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name which is throwing the exception; include a "-variant" distinguishing sub-tag if the method has overloaded implementations and signatures.
	 *	@param argNo Argument number or index
	 *	@param argName Name of the argument with/causing the exception to be thrown
	 *	@param argObj The object (typically a PKey, Key, or Buff instance) causing the issue
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *
	 *	@return IYCFMustOverrideException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFMustOverrideException getInstance(Class<?> throwingClass, String methName, int argNo, String argName, Object argObj, String enMsg, String xMsg);

	/**
	 *	IYCFMustOverrideException(throwingClass, methName, enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name which is throwing the exception; include a "-variant" distinguishing sub-tag if the method has overloaded implementations and signatures.
	 *	@param argNo Argument number or index
	 *	@param argName Name of the argument with/causing the exception to be thrown
	 *	@param argObj The object (typically a PKey, Key, or Buff instance) causing the issue
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *	@param cause Root cause thrown by code
	 *
	 *	@return IYCFMustOverrideException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFMustOverrideException getInstance(Class<?> throwingClass, String methName, int argNo, String argName, Object argObj, String enMsg, String xMsg, Throwable cause);

	/**
	 *	IYCFMustOverrideException(throwingClass, methName, xFieldName, argNo, argName, argObj)
	 *		Construct an argument exception with the default formatted message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name which is throwing the exception; include a "-variant" distinguishing sub-tag if the method has overloaded implementations and signatures.
	 *	@param argNo Argument number or index
	 *	@param argName Name of the argument with/causing the exception to be thrown
	 *	@param argObj The object (typically a PKey, Key, or Buff instance) causing the issue
	 *
	 *	@return IYCFMustOverrideException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFMustOverrideException getInstance(Class<?> throwingClass, String methName, int argNo, String argName, Object argObj);

	/**
	 *	IYCFMustOverrideException(throwingClass, methName, argNo, argName, argObj, cause)
	 *		Construct an argument exception with the default formatted message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name which is throwing the exception; include a "-variant" distinguishing sub-tag if the method has overloaded implementations and signatures.
	 *	@param argNo Argument number or index
	 *	@param argName Name of the argument with/causing the exception to be thrown
	 *	@param argObj The object (typically a PKey, Key, or Buff instance) causing the issue
	 *	@param cause Root cause thrown by code
	 *
	 *	@return IYCFMustOverrideException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFMustOverrideException getInstance(Class<?> throwingClass, String methName, int argNo, String argName, Object argObj, Throwable cause);

	/**
	 *	IYCFMustOverrideException(enFieldName, xFieldName, enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param enFieldName Field name having the issue
	 *	@param xFieldName Translated field name having the issue
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *
	 *	@return IYCFMustOverrideException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFMustOverrideException getInstance(String enFieldName, String xFieldName, String enMsg, String xMsg);

	/**
	 *	IYCFMustOverrideException(enFieldName, xFieldName, argNo, argName, argObj, enMsg, xMsg, cause)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param enFieldName Field name having the issue
	 *	@param xFieldName Translated field name having the issue
	 *	@param argNo Argument number or index
	 *	@param argName Name of the argument with/causing the exception to be thrown
	 *	@param argObj The object (typically a PKey, Key, or Buff instance) causing the issue
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *
	 *	@return IYCFMustOverrideException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFMustOverrideException getInstance(String enFieldName, String xFieldName, int argNo, String argName, Object argObj, String enMsg, String xMsg);

	/**
	 *	IYCFMustOverrideException(enFieldName, xFieldName, argNo, argName, argObj, enMsg, xMsg, cause)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param enFieldName Field name having the issue
	 *	@param xFieldName Translated field name having the issue
	 *	@param argNo Argument number or index
	 *	@param argName Name of the argument with/causing the exception to be thrown
	 *	@param argObj The object (typically a PKey, Key, or Buff instance) causing the issue
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *	@param cause Root cause thrown by code
	 *
	 *	@return IYCFMustOverrideException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFMustOverrideException getInstance(String enFieldName, String xFieldName, int argNo, String argName, Object argObj, String enMsg, String xMsg, Throwable cause);

	/**
	 *	IYCFMustOverrideException(enFieldName, xFieldName, argNo, argName, argObj)
	 *		Construct an argument exception with the default formatted message for the situation.
	 *
	 *	@param enFieldName Field name having the issue
	 *	@param xFieldName Translated field name having the issue
	 *	@param argNo Argument number or index
	 *	@param argName Name of the argument with/causing the exception to be thrown
	 *	@param argObj The object (typically a PKey, Key, or Buff instance) causing the issue
	 *
	 *	@return IYCFMustOverrideException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFMustOverrideException getInstance(String enFieldName, String xFieldName, int argNo, String argName, Object argObj);

	/**
	 *	IYCFMustOverrideException(enFieldName, xFieldName, argNo, argName, argObj, cause)
	 *		Construct an argument exception with the default formatted message for the situation.
	 *
	 *	@param enFieldName Field name having the issue
	 *	@param xFieldName Translated field name having the issue
	 *	@param argNo Argument number or index
	 *	@param argName Name of the argument with/causing the exception to be thrown
	 *	@param argObj The object (typically a PKey, Key, or Buff instance) causing the issue
	 *	@param cause Root cause thrown by code
	 *
	 *	@return IYCFMustOverrideException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFMustOverrideException getInstance(String enFieldName, String xFieldName, int argNo, String argName, Object argObj, Throwable cause);
}
