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
 * IYCFArgumentException provides the base implementation for a number of argument exceptions, including IYCFArgumentOverflowException,
 * IYCFArgumentRangeExxception, IYCFArgumentUnderflowException, IYCFEmptyArgumentExeption, IYCFInvalidArgumentException, and IYCFNullArgumentException.
 * 
 * There is a rich set of constructors for the class, with variations that accept the class object for the caller and a method name, and versions that accept nationalized field names and method names.
 */
public interface IYCFArgumentException extends JSObject {

	protected String localMessage = null;

	/**
	 *	YCFArgumentException(enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 */

	/**
	 *	YCFArgumentException(enMsg, xMsg, th)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *	@param th Root cause thrown by code
	 */

	/**
	 *	YCFArgumentException(throwingClass, methName, enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name which is throwing the exception; include a "-variant" distinguishing sub-tag if the method has overloaded implementations and signatures.
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 */

	/**
	 *	YCFArgumentException(throwingClass, methName, enMsg, xMsg, th)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name which is throwing the exception; include a "-variant" distinguishing sub-tag if the method has overloaded implementations and signatures.
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *	@param th Root cause thrown by code
	 */

	/**
	 *	YCFArgumentException(throwingClass, methName, argNo, argName, enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name which is throwing the exception; include a "-variant" distinguishing sub-tag if the method has overloaded implementations and signatures.
	 *	@param argNo Argument number or index
	 *	@param argName Name of the argument with/causing the exception to be thrown
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 */

	/**
	 *	YCFArgumentException(throwingClass, methName, argNo, argName, enMsg, xMsg, th)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name which is throwing the exception; include a "-variant" distinguishing sub-tag if the method has overloaded implementations and signatures.
	 *	@param argNo Argument number or index
	 *	@param argName Name of the argument with/causing the exception to be thrown
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *	@param th Root cause thrown by code
	 */

	/**
	 *	YCFArgumentException(enFieldName, xFieldName, enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies being thrown in regards to the specified English and translated field names.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 */

	/**
	 *	YCFArgumentException(enFieldName, xFieldName, methName, enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies being thrown in regards to the specified English and translated field names.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName The method name that detected the issue
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 */

	/**
	 *	YCFArgumentException(enFieldName, xFieldName, methName, enMsg, xMsg, th)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies being thrown in regards to the specified English and translated field names.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName The method name that detected the issue
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *	@param th Root cause thrown by code
	 */

	/**
	 *	YCFArgumentException(enFieldName, xFieldName, methName, argNo, argName, enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies being thrown in regards to the specified English and translated field names.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName The method name that detected the issue
	 *	@param argNo The offset or index of the argument
	 *	@param argName The name of the argument
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 */

	/**
	 *	YCFArgumentException(enFieldName, xFieldName, methName, argNo, argName, enMsg, xMsg, th)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies being thrown in regards to the specified English and translated field names.
	 *
	 *	@param enFieldName English field name
	 *	@param xFieldName Translated field name
	 *	@param methName The method name that detected the issue
	 *	@param argNo The offset or index of the argument
	 *	@param argName The name of the argument
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *	@param th Root cause thrown by code
	 */

	/**
	 *	Get the localized/translated version of the exception message
	 *
	 *	@return The localized/translated exception message body.
	 */
}
