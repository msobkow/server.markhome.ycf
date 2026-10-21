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

import server.markhome.ycf.IInz;

/**
 * YCFInvalidArgumentException is thrown when an argument is invalid for some reason, usually specified by nationalized cause phrases.
 */
public class YCFInvalidArgumentException extends YCFArgumentException implements IYCFInvalidArgumentException {

	/**
	 *	The protected attributes need to be exported as properties, but not private attributes.
	 */
	@JSProperty
	protected static IYCFMtReference<IYCFInvalidArgumentException> mtSingleton = IYCFMtReference.getInstance<>(null);

	/**
	 *	IYCFInvalidArgumentException getSingleton()
	 *		Get the singleton instance that provides the getInstance() implementations.
	 *
	 *	@return IYCFInvalidArgumentException The singleton for the exception implementation.
	 */
	//@JSExport
	//public IYCFInvalidArgumentException getSingleton();

	/**
	 *	IYCFInvalidArgumentException(enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *
	 *	@return IYCFInvalidArgumentException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFInvalidArgumentException getInstance(String enMsg, String xMsg) {
		return new YCFInvalidArgumentException(enMsg, xMsg);
	}
}

	/**
	 *	IYCFInvalidArgumentException(enMsg, xMsg, cause)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *	@param cause Root cause thrown by code
	 *
	 *	@return IYCFInvalidArgumentException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFInvalidArgumentException getInstance(String enMsg, String xMsg, Throwable cause) {
		return new YCFInvalidArgumentException(enMsg, xMsg, cause);
	}
	/**
	 *	IYCFInvalidArgumentException(throwingClass, methName, enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name which is throwing the exception; include a "-variant" distinguishing sub-tag if the method has overloaded implementations and signatures.
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *
	 *	@return IYCFInvalidArgumentException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFInvalidArgumentException getInstance(Class<?> throwingClass, String methName, String enMsg, String xMsg) {
		return new YCFInvalidArgumentException(throwingClass, methName, enMsg, xMsg);
	}

	/**
	 *	IYCFInvalidArgumentException(throwingClass, methName, enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name which is throwing the exception; include a "-variant" distinguishing sub-tag if the method has overloaded implementations and signatures.
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *	@param cause Root cause thrown by code
	 *
	 *	@return IYCFInvalidArgumentException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFInvalidArgumentException getInstance(Class<?> throwingClass, String methName, String enMsg, String xMsg, Throwable cause) {
		return new YCFInvalidArgumentException(throwingClass, methName, enMsg, xMsg, cause);
	}

	/**
	 *	IYCFInvalidArgumentException(throwingClass, methName, argNo, argName, argObj, enMsg, xMsg)
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
	 *	@return IYCFInvalidArgumentException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFInvalidArgumentException getInstance(Class<?> throwingClass, String methName, int argNo, String argName, Object argObj, String enMsg, String xMsg) {
		return new YCFInvalidArgumentException(throwingClass, methName, argNo, argName, argObj, enMsg, xMsg);
	}

	/**
	 *	IYCFInvalidArgumentException(throwingClass, methName, enMsg, xMsg)
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
	 *	@return IYCFInvalidArgumentException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFInvalidArgumentException getInstance(Class<?> throwingClass, String methName, int argNo, String argName, Object argObj, String enMsg, String xMsg, Throwable cause) {
		return new YCFInvalidArgumentException(throwingClass, methName, argNo, argName, argObj, enMsg, xMsg, cause);
	}

	/**
	 *	IYCFInvalidArgumentException(throwingClass, methName, xFieldName, argNo, argName, argObj)
	 *		Construct an argument exception with the default formatted message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name which is throwing the exception; include a "-variant" distinguishing sub-tag if the method has overloaded implementations and signatures.
	 *	@param argNo Argument number or index
	 *	@param argName Name of the argument with/causing the exception to be thrown
	 *	@param argObj The object (typically a PKey, Key, or Buff instance) causing the issue
	 *
	 *	@return IYCFInvalidArgumentException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFInvalidArgumentException getInstance(Class<?> throwingClass, String methName, int argNo, String argName, Object argObj) {
		return new YCFInvalidArgumentException(throwingClass, methName, argNo, argName, argObj);
	}

	/**
	 *	IYCFInvalidArgumentException(throwingClass, methName, argNo, argName, argObj, cause)
	 *		Construct an argument exception with the default formatted message for the situation.
	 *
	 *	@param throwingClass The class throwing the exception
	 *	@param methName Method name which is throwing the exception; include a "-variant" distinguishing sub-tag if the method has overloaded implementations and signatures.
	 *	@param argNo Argument number or index
	 *	@param argName Name of the argument with/causing the exception to be thrown
	 *	@param argObj The object (typically a PKey, Key, or Buff instance) causing the issue
	 *	@param cause Root cause thrown by code
	 *
	 *	@return IYCFInvalidArgumentException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFInvalidArgumentException getInstance(Class<?> throwingClass, String methName, int argNo, String argName, Object argObj, Throwable cause) {
		return new YCFInvalidArgumentException(throwingClass, methName, argNo, argName, argObj, cause);
	}
	/**
	 *	IYCFInvalidArgumentException(enFieldName, xFieldName, enMsg, xMsg)
	 *		Construct an argument exception with the provided English and NLS-translated message bodies.
	 *
	 *	@param enFieldName Field name having the issue
	 *	@param xFieldName Translated field name having the issue
	 *	@param enMsg Text message body
	 *	@param xMsg Translated text message body
	 *
	 *	@return IYCFInvalidArgumentException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFInvalidArgumentException getInstance(String enFieldName, String xFieldName, String enMsg, String xMsg) {
		return new YCFInvalidArgumentException(enFieldName, xFieldName, enMsg, xMsg);
	}

	/**
	 *	IYCFInvalidArgumentException(enFieldName, xFieldName, argNo, argName, argObj, enMsg, xMsg, cause)
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
	 *	@return IYCFInvalidArgumentException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFInvalidArgumentException getInstance(String enFieldName, String xFieldName, int argNo, String argName, Object argObj, String enMsg, String xMsg) {
		return new YCFInvalidArgumentException(enFieldName, xFieldName, argNo, argName, argObj, enMsg, xMsg);
	}

	/**
	 *	IYCFInvalidArgumentException(enFieldName, xFieldName, argNo, argName, argObj, enMsg, xMsg, cause)
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
	 *	@return IYCFInvalidArgumentException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFInvalidArgumentException getInstance(String enFieldName, String xFieldName, int argNo, String argName, Object argObj, String enMsg, String xMsg, Throwable cause) {
		return new YCFInvalidArgumentException(enFieldName, xFieldName, argNo, argName, argObj, enMsg, xMsg, cause);
	}

	/**
	 *	IYCFInvalidArgumentException(enFieldName, xFieldName, argNo, argName, argObj)
	 *		Construct an argument exception with the default formatted message for the situation.
	 *
	 *	@param enFieldName Field name having the issue
	 *	@param xFieldName Translated field name having the issue
	 *	@param argNo Argument number or index
	 *	@param argName Name of the argument with/causing the exception to be thrown
	 *	@param argObj The object (typically a PKey, Key, or Buff instance) causing the issue
	 *
	 *	@return IYCFInvalidArgumentException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFInvalidArgumentException getInstance(String enFieldName, String xFieldName, int argNo, String argName, Object argObj) {
		return new YCFInvalidArgumentException(enFieldName, xFieldName, argNo, argName, argObj);
	}
	/**
	 *	IYCFInvalidArgumentException(enFieldName, xFieldName, argNo, argName, argObj, cause)
	 *		Construct an argument exception with the default formatted message for the situation.
	 *
	 *	@param enFieldName Field name having the issue
	 *	@param xFieldName Translated field name having the issue
	 *	@param argNo Argument number or index
	 *	@param argName Name of the argument with/causing the exception to be thrown
	 *	@param argObj The object (typically a PKey, Key, or Buff instance) causing the issue
	 *	@param cause Root cause thrown by code
	 *
	 *	@return IYCFInvalidArgumentException An exception instance with the specified messages.
	 */
	@JSExport
	public IYCFInvalidArgumentException getInstance(String enFieldName, String xFieldName, int argNo, String argName, Object argObj, Throwable cause) {
		return new YCFInvalidArgumentException(enFieldName, xFieldName, argNo, argName, argObj, cause);
	}

	// Inherited constructor patterns

	public YCFInvalidArgumentException(
		String enMsg,
		String xMsg)
	{
		super(enMsg, xMsg);
	}

	public YCFInvalidArgumentException(
		String enMsg,
		String xMsg,
		Throwable th)
	{
		super(enMsg, xMsg, th);
	}

	public YCFInvalidArgumentException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg)
	{
		super(throwingClass, methName, enMsg, xMsg);
	}

	public YCFInvalidArgumentException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg,
		Throwable th)
	{
		super(throwingClass, methName, enMsg, xMsg, th);
	}

	public YCFInvalidArgumentException(
	 	Class<?> throwingClass,
	 	String methName,
	 	int argNo,
	 	String argName,
	 	String enMsg,
	 	String xMsg)
	{
	 	super(throwingClass, methName, argNo, argName, enMsg, xMsg);
	}

	public YCFInvalidArgumentException(
	 	Class<?> throwingClass,
	 	String methName,
	 	int argNo,
	 	String argName,
	 	String enMsg,
	 	String xMsg,
	 	Throwable th)
	{
	 	super(throwingClass, methName, argNo, argName, enMsg, xMsg, th);
	}

	// public YCFInvalidArgumentException(
	// 	String enFieldName,
	// 	String xFieldName,
	// 	String enMsg,
	// 	String xMsg)
	// {
	// 	super(enFieldName, xFieldName, enMsg, xMsg);
	// }

	public YCFInvalidArgumentException(
		String enFieldName,
		String xFieldName,
		String methName,
		String enMsg,
		String xMsg)
	{
		super(enFieldName, xFieldName, methName, enMsg, xMsg);
	}

	public YCFInvalidArgumentException(
		String enFieldName,
		String xFieldName,
		String methName,
		String enMsg,
		String xMsg,
		Throwable th)
	{
		super(enFieldName, xFieldName, methName, enMsg, xMsg, th);
	}

	public YCFInvalidArgumentException(
	 	String enFieldName,
		String xFieldName,
	 	String methName,
	 	int argNo,
	 	String argName,
	 	String enMsg,
		String xMsg)
	{
	 	super(enFieldName, xFieldName, methName, argNo, argName, enMsg, xMsg);
	}

	public YCFInvalidArgumentException(
	 	String enFieldName,
		String xFieldName,
	 	String methName,
	 	int argNo,
	 	String argName,
	 	String enMsg,
	 	String xMsg,
	 	Throwable th)
	{
	 	super(enFieldName, xFieldName, methName, argNo, argName, enMsg, xMsg, th);
	}

	// Custom/most-often-used constructors

	public YCFInvalidArgumentException(
		Class<?> throwingClass,
		String methName)
	{
		super(String.format(Inz.s("ycflib.YCFInvalidArgumentException.TcmnMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "")),
			String.format(Inz.x("ycflib.YCFInvalidArgumentException.TcmnMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "")));
	}

	public YCFInvalidArgumentException(
		Class<?> throwingClass,
		String methName,
		Throwable th)
	{
		super(String.format(Inz.s("ycflib.YCFInvalidArgumentException.TcmnMsg"),
				throwingClass.getName()	+ (((methName != null) && !methName.isEmpty()) ? "." + methName + "()" : "")),
			String.format(Inz.x("ycflib.YCFInvalidArgumentException.TcmnMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "")),
			th);
	}

	public YCFInvalidArgumentException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName)
	{
		super(String.format(Inz.s("ycflib.YCFInvalidArgumentException.TcmnArgMsg"),
				throwingClass.getName()	+ (((methName != null) && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName),
			String.format(Inz.x("ycflib.YCFInvalidArgumentException.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : ""),
				argNo,
				argName));
	}

	public YCFInvalidArgumentException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		Throwable th)
	{
		super(String.format(Inz.s("ycflib.YCFInvalidArgumentException.TcmnArgMsg"),
				throwingClass.getName()	+ (((methName != null) && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName),
			String.format(Inz.x("ycflib.YCFInvalidArgumentException.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : ""),
				argNo,
				argName),
			th);
	}

	public YCFInvalidArgumentException(
		String enFieldName,
		String xFieldName,
		String methName)
	{
		super(String.format(Inz.s("ycflib.YCFInvalidArgumentException.FldMsg"),
				enFieldName + (((methName != null) && !methName.isEmpty()) ? "." + methName + "()" : "")),
			String.format(Inz.x("ycflib.YCFInvalidArgumentException.FldMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "")));
	}

	public YCFInvalidArgumentException(
		String enFieldName,
		String xFieldName,
		String methName,
		Throwable th)
	{
		super(String.format(Inz.s("ycflib.YCFInvalidArgumentException.FldMsg"),
				enFieldName + (((methName != null) && !methName.isEmpty()) ? "." + methName + "()" : "")),
			String.format(Inz.x("ycflib.YCFInvalidArgumentException.FldMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "")),
			th);
	}

	public YCFInvalidArgumentException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName)
	{
		super(String.format(Inz.s("ycflib.YCFInvalidArgumentException.FldArgMsg"),
				enFieldName + (((methName != null) && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName),
			String.format(Inz.x("ycflib.YCFInvalidArgumentException.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : ""),
				argNo,
				argName));
	}

	public YCFInvalidArgumentException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		Throwable th)
	{
		super(String.format(Inz.s("ycflib.YCFInvalidArgumentException.FldArgMsg"),
				enFieldName + (((methName != null) && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName),
			String.format(Inz.x("ycflib.YCFInvalidArgumentException.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : ""),
				argNo,
				argName),
			th);
	}
}
