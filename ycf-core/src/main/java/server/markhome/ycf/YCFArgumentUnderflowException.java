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
 * YCFArgumentUnderflowException is thrown when an argument is under the minimum value allowed.
 */
public class YCFArgumentUnderflowException extends YCFArgumentException {

	public YCFArgumentUnderflowException(
		String enMsg,
		String xMsg )
	{
		super( enMsg, xMsg );
	}

	public YCFArgumentUnderflowException(
		String enMsg,
		String xMsg,
		Throwable th )
	{
		super( enMsg, xMsg, th );
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg )
	{
		super( throwingClass, methName, enMsg, xMsg );
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg,
		Throwable th )
	{
		super( throwingClass, methName, enMsg, xMsg, th );
	}

	// public YCFArgumentUnderflowException(
	// 	Class<?> throwingClass,
	// 	String methName,
	// 	int argNo,
	// 	String argName,
	// 	String enMsg,
	// 	String xMsg )
	// {
	// 	super( throwingClass, methName, argNo, argName, enMsg, xMsg );
	// }

	// public YCFArgumentUnderflowException(
	// 	Class<?> throwingClass,
	// 	String methName,
	// 	int argNo,
	// 	String argName,
	// 	String enMsg,
	// 	String xMsg,
	// 	Throwable th )
	// {
	// 	super( throwingClass, methName, argNo, argName, enMsg, xMsg, th );
	// }

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		short argValue,
		short minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue));
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		short argValue,
		short minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			th);
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		int argValue,
		int minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue));
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		int argValue,
		int minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			th);
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		long argValue,
		long minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue));
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		long argValue,
		long minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			th);
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		float argValue,
		float minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue));
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		float argValue,
		float minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			th);
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		double argValue,
		double minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue));
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		double argValue,
		double minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			th);
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		Calendar argValue,
		Calendar minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString()));
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		Calendar argValue,
		Calendar minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString()),
			th);
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		String argValue,
		String minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue));
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		String argValue,
		String minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			th);
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		BigDecimal argValue,
		BigDecimal minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString()));
	}

	public YCFArgumentUnderflowException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		BigDecimal argValue,
		BigDecimal minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString()),
			th);
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String enMsg,
		String xMsg )
	{
		super( enFieldName, xFieldName, enMsg, xMsg );
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		String enMsg,
		String xMsg )
	{
		super( enFieldName, xFieldName, methName, enMsg, xMsg );
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		String enMsg,
		String xMsg,
		Throwable th )
	{
		super( enFieldName, xFieldName, methName, enMsg, xMsg, th );
	}

// 	public YCFArgumentUnderflowException(
// 		String enFieldName,
// 		String xFieldName,
// 		String methName,
// 		int argNo,
// 		String argName,
// 		String enMsg,
// 		String xMsg )
// 	{
// 		super( enFieldName, xFieldName, methName, argNo, argName, enMsg, xMsg );
// 	}

// 	public YCFArgumentUnderflowException(
// 		String enFieldName,
// 		String xFieldName,
// 		String methName,
// 		int argNo,
// 		String argName,
// 		String enMsg,
// 		String xMsg,
// 		Throwable th )
// 	{
// 		super( enFieldName, xFieldName, methName, argNo, argName, enMsg, xMsg, th );
// 	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		short argValue,
		short minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.decimal.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue,
				minValue));
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		short argValue,
		short minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.decimal.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue,
				minValue),
			th);
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		int argValue,
		int minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.decimal.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue,
				minValue));
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		int argValue,
		int minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.decimal.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue,
				minValue),
			th);
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		long argValue,
		long minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.decimal.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue,
				minValue));
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		long argValue,
		long minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.decimal.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue,
				minValue),
			th);
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		float argValue,
		float minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue,
				minValue));
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		float argValue,
		float minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue,
				minValue),
			th);
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		double argValue,
		double minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue,
				minValue));
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		double argValue,
		double minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue,
				minValue),
			th);
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		Calendar argValue,
		Calendar minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue.toString(),
				minValue.toString()));
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		Calendar argValue,
		Calendar minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue.toString(),
				minValue.toString()),
			th);
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		String argValue,
		String minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue,
				minValue));
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		String argValue,
		String minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue,
				minValue),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue,
				minValue),
			th);
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		BigDecimal argValue,
		BigDecimal minValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue.toString(),
				minValue.toString()));
	}

	public YCFArgumentUnderflowException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		BigDecimal argValue,
		BigDecimal minValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentUnderflowException.float.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : ""),
				argNo,
				(argName),
				argValue.toString(),
				minValue.toString()),
			th);
	}
}
