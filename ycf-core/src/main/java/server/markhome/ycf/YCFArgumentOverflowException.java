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
 * YCFArgumentOverflowException indicates that an argument exceeds the permitted value range.
 */
public class YCFArgumentOverflowException extends YCFArgumentException {

	public YCFArgumentOverflowException(
		String enMsg,
		String xMsg )
	{
		super(enMsg, xMsg);
	}

	public YCFArgumentOverflowException(
		String enMsg, String xMsg, Throwable cause) {
			super(enMsg, xMsg, cause);
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg )
	{
		super(throwingClass, methName, enMsg, xMsg);
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg,
		Throwable th )
	{
		super(throwingClass, methName, enMsg, xMsg, th);
	}

	// public YCFArgumentOverflowException(
	//  	Class<?> throwingClass,
	//  	String methName,
	//  	int argNo,
	//  	String argName,
	//  	String enMsg,
	//  	String xMsg )
	// {
	//  	super(throwingClass, methName, argNo, argName, enMsg, xMsg);
	// }

	// public YCFArgumentOverflowException(
	// 	Class<?> throwingClass,
	// 	String methName,
	// 	int argNo,
	// 	String argName,
	// 	String enMsg,
	// 	String xMsg,
	// 	Throwable th )
	// {
	// 	super(throwingClass, methName, argNo, argName, enMsg, xMsg, th);
	// }

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String enMsg,
		String xMsg )
	{
		super(enFieldName, xFieldName, enMsg, xMsg);
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		String enMsg,
		String xMsg )
	{
		super(enFieldName, xFieldName, methName, enMsg, xMsg);
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		String enMsg,
		String xMsg,
		Throwable th )
	{
		super(enFieldName, xFieldName, methName, enMsg, xMsg, th);
	}

	// public YCFArgumentOverflowException(
	// 	String enFieldName,
	//  	String xFieldName,
	//  	String methName,
	//  	int argNo,
	//  	String argName,
	//  	String enMsg,
	//  	String xMsg )
	// {
	//  	super(enFieldName, xFieldName, methName, argNo, argName, enMsg, xMsg);
	// }

	// public YCFArgumentOverflowException(
	// 	String enFieldName,
	// 	String xFieldName,
	// 	String methName,
	// 	int argNo,
	// 	String argName,
	// 	String enMsg,
	// 	String xMsg,
	// 	Throwable th )
	// {
	// 	super(enFieldName, xFieldName, methName, argNo, argName, enMsg, xMsg, th);
	// }


	
	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		short argValue,
		short maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue));
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		short argValue,
		short maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			th );
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		int argValue,
		int maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue));
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		int argValue,
		int maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			th );
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		long argValue,
		long maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue));
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		long argValue,
		long maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			th );
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		float argValue,
		float maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue));
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		float argValue,
		float maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			th );
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		double argValue,
		double maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue));
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		double argValue,
		double maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			th );
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		Calendar argValue,
		Calendar maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()));
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		Calendar argValue,
		Calendar maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()),
			th );
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		String argValue,
		String maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue));
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		String argValue,
		String maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			th );
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		BigDecimal argValue,
		BigDecimal maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()));
	}

	public YCFArgumentOverflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		BigDecimal argValue,
		BigDecimal maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()),
			th );
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		short argValue,
		short maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				enFieldName + ((methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue));
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		short argValue,
		short maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			th);
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		int argValue,
		int maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue));
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		int argValue,
		int maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			th);
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		long argValue,
		long maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue));
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		long argValue,
		long maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			th);
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		float argValue,
		float maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue));
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		float argValue,
		float maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			th);
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		double argValue,
		double maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue));
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		double argValue,
		double maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			th);
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		Calendar argValue,
		Calendar maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.string.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.string.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()));
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		Calendar argValue,
		Calendar maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.string.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.string.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()),
			th);
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		String argValue,
		String maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.string.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.string.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue));
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		String argValue,
		String maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.string.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.string.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				maxValue),
			th);
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		BigDecimal argValue,
		BigDecimal maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.string.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.string.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()));
	}

	public YCFArgumentOverflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		BigDecimal argValue,
		BigDecimal maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentOverflowException.string.FldArgMsg"),
				enFieldName + ( ( ( methName != null ) && !methName.isEmpty()) ? "." + methName + "()"	: "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentOverflowException.string.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				maxValue.toString()),
			th);
	}
}
