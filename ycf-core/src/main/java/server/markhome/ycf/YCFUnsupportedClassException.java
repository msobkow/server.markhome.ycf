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

import server.markhome.ycf.Inz;

/**
 * YCFUnsupportedClassException is thrown when an argument is not a supported class instance or derivative.
 */
public class YCFUnsupportedClassException extends IllegalStateException {

	protected String localMessage = null;

	public YCFUnsupportedClassException(
		String enMsg,
		String xMsg )
	{
		super( enMsg );
		this.localMessage = xMsg;
	}

	// public YCFUnsupportedClassException(
	// 	String enMsg,
	// 	String xMsg,
	// 	Throwable th)
	// {
	// 		super(enMsg, th);
	// 		this.localMessage = xMsg;
	// }

	public YCFUnsupportedClassException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg )
	{
		super( String.format(Inz.s("ycflib.YCFArgumentException.TcmnMsg"),
				throwingClass.getName()	+ ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg : "" )));
		this.localMessage = String.format(Inz.x("ycflib.YCFArgumentException.TcmnMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				( ( ( xMsg != null ) && ( xMsg.length() > 0 ) ) ? xMsg : (enMsg != null && enMsg.length() > 0) ? enMsg : ""));
	}

	public YCFUnsupportedClassException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg,
		Throwable th )
	{
		super( String.format(Inz.s("ycflib.YCFArgumentException.TcmnMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg : "" )),
				th );
		this.localMessage = String.format(Inz.x("ycflib.YCFArgumentException.TcmnMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				( ( ( xMsg != null ) && ( xMsg.length() > 0 ) ) ? xMsg : (enMsg != null && enMsg.length() > 0) ? enMsg : ""));
	}

	public YCFUnsupportedClassException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		String enMsg,
		String xMsg )
	{
		super( String.format(Inz.s("ycflib.YCFArgumentException.TcmnArgMsg"),
				throwingClass.getName()	+ ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg	: "" ) ));
		this.localMessage = String.format(Inz.x("ycflib.YCFArgumentException.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName,
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg	: "" ) );
	}

	public YCFUnsupportedClassException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		String enMsg,
		String xMsg,
		Throwable th )
	{
		super( String.format(Inz.s("ycflib.YCFArgumentException.TcmnArgMsg"),
				throwingClass.getName()	+ ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg	: "" ) ),
				th );
		this.localMessage = String.format(Inz.x("ycflib.YCFArgumentException.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName,
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg	: "" ) );
	}

	// public YCFUnsupportedClassException(
	// 	String enFieldName,
	// 	String xFieldName,
	// 	String enMsg,
	// 	String xMsg )
	// {
	// 	super( String.format(Inz.s("ycflib.YCFArgumentException.FldMsg"),
	// 			enFieldName,
	// 			( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg	: "" ) ));
	// 	this.localMessage = String.format(Inz.x("ycflib.YCFArgumentException.FldMsg"),
	// 			(xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName,
	// 			( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg	: "" ) );
	// }

	public YCFUnsupportedClassException(
		String enFieldName,
		String xFieldName,
		String methName,
		String enMsg,
		String xMsg )
	{
		super( String.format(Inz.s("ycflib.YCFArgumentException.FldMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg : "" ) ));
		this.localMessage = String.format(Inz.x("ycflib.YCFArgumentException.FldMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				( ( ( xMsg != null ) && ( xMsg.length() > 0 ) ) ? xMsg : (enMsg != null && enMsg.length() > 0) ? enMsg : "") );
	}

	public YCFUnsupportedClassException(
		String enFieldName,
		String xFieldName,
		String methName,
		String enMsg,
		String xMsg,
		Throwable th )
	{
		super( String.format(Inz.s("ycflib.YCFArgumentException.FldMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg : "" ) ),
				th );
		this.localMessage = String.format(Inz.x("ycflib.YCFArgumentException.FldMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				( ( ( xMsg != null ) && ( xMsg.length() > 0 ) ) ? xMsg : (enMsg != null && enMsg.length() > 0) ? enMsg : "") );
	}

	public YCFUnsupportedClassException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		String enMsg,
		String xMsg )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentException.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg : "" ) ));
		this.localMessage = String.format(Inz.x("ycflib.YCFArgumentException.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName,
				( ( ( xMsg != null ) && ( xMsg.length() > 0 ) ) ? xMsg : (enMsg != null && enMsg.length() > 0) ? enMsg : "") );
	}

	public YCFUnsupportedClassException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		String enMsg,
		String xMsg,
		Throwable th )
	{
		super( String.format(Inz.s("ycflib.YCFArgumentException.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg : "" ) ),
				th );
		this.localMessage = String.format(Inz.x("ycflib.YCFArgumentException.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName,
				( ( ( xMsg != null ) && ( xMsg.length() > 0 ) ) ? xMsg : (enMsg != null && enMsg.length() > 0) ? enMsg : "") );
	}

	public YCFUnsupportedClassException()
	{
		super(String.format(Inz.s("ycflib.YCFUnsupportedClassException.default"), ""));//%1$sUnsupported class
		this.localMessage = String.format(Inz.x("ycflib.YCFUnsupportedClassException.default"), "");
	}

	public YCFUnsupportedClassException(
		Class<?> throwingClass,
		String methName )
	{
		super(String.format(Inz.s("ycflib.YCFUnsupportedClassException.default"),
				throwingClass.getName() + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "() " : " " )));
		this.localMessage = String.format(Inz.x("ycflib.YCFUnsupportedClassException.default"),
				throwingClass.getName() + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "() " : " " ));
	}

	public YCFUnsupportedClassException(
		Class<?> throwingClass,
		String methName,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFUnsupportedClassException.default"),
				throwingClass.getName() + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "() " : " " )),
				th );
		this.localMessage = String.format(Inz.x("ycflib.YCFUnsupportedClassException.default"),
				throwingClass.getName() + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "() " : " " ));
	}

	public YCFUnsupportedClassException(
		String fieldName,
		String methName,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFUnsupportedClassException.default"),
				fieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "() " : " " )),
				th );
		this.localMessage = String.format(Inz.x("ycflib.YCFUnsupportedClassException.default"),
				fieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "() " : " " ));
	}

	public YCFUnsupportedClassException(
		Class<?> throwingClass,
		String methName,
		String argObjName,
		Object argObj,
		String argExpectedClasses )
	{
		super( (argObj != null) ? String.format(Inz.s("ycflib.YCFUnsupportedClassException.objwithclasses"),
					throwingClass.getName() + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "() " : " " ),
					argObjName,
					argObj.getClass().getName(),
					argExpectedClasses )
				: String.format(Inz.s("ycflib.YCFUnsupportedClassException.nullwithclasses"),
					throwingClass.getName() + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "() " : " " ),
					argObjName,
					argExpectedClasses ) );
		this.localMessage = (argObj != null) ? String.format(Inz.x("ycflib.YCFUnsupportedClassException.objwithclasses"),
					throwingClass.getName() + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "() " : " " ),
					argObjName,
					argObj.getClass().getName(),
					argExpectedClasses )
				: String.format(Inz.x("ycflib.YCFUnsupportedClassException.nullwithclasses"),
					throwingClass.getName() + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "() " : " " ),
					argObjName,
					argExpectedClasses );
	}

	public YCFUnsupportedClassException(
		Class<?> throwingClass,
		String methName,
		String argObjName,
		Object argObj,
		String argExpectedClasses,
		Throwable th )
	{
		super( (argObj != null) ? String.format(Inz.s("ycflib.YCFUnsupportedClassException.objwithclasses"),
					throwingClass.getName() + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "() " : " " ),
					argObjName,
					argObj.getClass().getName(),
					argExpectedClasses )
				: String.format(Inz.s("ycflib.YCFUnsupportedClassException.nullwithclasses"),
					throwingClass.getName() + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "() " : " " ),
					argObjName,
					argExpectedClasses ),
			th );
		this.localMessage = (argObj != null) ? String.format(Inz.x("ycflib.YCFUnsupportedClassException.objwithclasses"),
					throwingClass.getName() + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "() " : " " ),
					argObjName,
					argObj.getClass().getName(),
					argExpectedClasses )
				: String.format(Inz.x("ycflib.YCFUnsupportedClassException.nullwithclasses"),
					throwingClass.getName() + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "() " : " " ),
					argObjName,
					argExpectedClasses );
	}

	@Override
	public String getLocalizedMessage() {
		if (localMessage != null) {
			return localMessage;
		}
		else {
			return getMessage();
		}
	}
}
