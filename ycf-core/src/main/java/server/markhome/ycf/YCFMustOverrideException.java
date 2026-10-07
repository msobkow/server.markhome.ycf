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
 * If a base class only implements a method to allow it to be instantiated but it is only valid when a subclass specializes it, YCFMustOverrideException is thrown by that base implementation.
 */
public class YCFMustOverrideException extends IllegalStateException {

	protected String localMessage = null;

	public YCFMustOverrideException(
		String enMsg,
		String xMsg )
	{
		super( enMsg );
		this.localMessage = xMsg;
	}

	public YCFMustOverrideException(
		String enMsg, String xMsg, Throwable cause) {
			super(enMsg, cause);
			this.localMessage = xMsg;
	}

	public YCFMustOverrideException(
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

	public YCFMustOverrideException(
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

	public YCFMustOverrideException(
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

	public YCFMustOverrideException(
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

	// public YCFMustOverrideException(
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

	public YCFMustOverrideException(
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

	public YCFMustOverrideException(
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

	public YCFMustOverrideException(
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

	public YCFMustOverrideException(
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

	
	public YCFMustOverrideException()
	{
		super( String.format(Inz.s("ycflib.YCFMustOverrideException.default"), "").trim());
		this.localMessage = String.format(Inz.x("ycflib.YCFMustOverrideException.default"), "").trim();
	}

	public YCFMustOverrideException(Throwable th)
	{
		super( String.format(Inz.s("ycflib.YCFMustOverrideException.default"), "").trim(), th);
		this.localMessage = String.format(Inz.x("ycflib.YCFMustOverrideException.default"), "").trim();
	}

	public YCFMustOverrideException(
		Class<?> throwingClass,
		String methName)
	{
		super( String.format(Inz.s("ycflib.YCFMustOverrideException.default"),
				throwingClass.getName()	+ ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()" : "" )));
		this.localMessage = String.format(Inz.x("ycflib.YCFMustOverrideException.default"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ));
	}

	public YCFMustOverrideException(
		Class<?> throwingClass,
		String methName,
		Throwable th )
	{
		super( String.format(Inz.s("ycflib.YCFMustOverrideException.default"),
				throwingClass.getName()	+ ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()" : "" )),
			th);
		this.localMessage = String.format(Inz.x("ycflib.YCFMustOverrideException.default"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ));
	}

	public YCFMustOverrideException(
		String enFieldName,
		String xFieldName,
		String methName )
	{
		super( String.format(Inz.s("ycflib.YCFMustOverrideException.default"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" )));
		this.localMessage = String.format(Inz.x("ycflib.YCFMustOverrideException.default"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ));
	}
	public YCFMustOverrideException(
		String enFieldName,
		String xFieldName,
		String methName,
		Throwable th )
	{
		super( String.format(Inz.s("ycflib.YCFMustOverrideException.default"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" )),
			th);
		this.localMessage = String.format(Inz.x("ycflib.YCFMustOverrideException.default"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ));
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
