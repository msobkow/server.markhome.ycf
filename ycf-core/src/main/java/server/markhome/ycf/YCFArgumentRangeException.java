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
 * YCFArgumentRangeException indicates that a value did not fall with the range minValue to maxValue, inclusive.
 */
public class YCFArgumentRangeException extends YCFArgumentException {
	
	public YCFArgumentRangeException(
		String enMsg,
		String xMsg )
	{
		super(enMsg, xMsg);
	}

	public YCFArgumentRangeException(
		String enMsg,
		String xMsg,
		Throwable th)
	{
			super(enMsg, xMsg, th);
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg )
	{
		super(throwingClass, methName, enMsg, xMsg);
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg,
		Throwable th )
	{
		super(throwingClass, methName, enMsg, xMsg, th);
	}

	public YCFArgumentRangeException(
	 	Class<?> throwingClass,
	 	String methName,
	 	int argNo,
	 	String argName,
	 	String enMsg,
	 	String xMsg )
	{
	 	super(throwingClass, methName, argNo, argName, enMsg, xMsg);
	}

	public YCFArgumentRangeException(
	 	Class<?> throwingClass,
	 	String methName,
	 	int argNo,
	 	String argName,
	 	String enMsg,
	 	String xMsg,
	 	Throwable th )
	{
	 	super(throwingClass, methName, argNo, argName, enMsg, xMsg, th);
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String enMsg,
		String xMsg )
	{
		super(enFieldName, xFieldName, enMsg, xMsg);
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		String enMsg,
		String xMsg )
	{
		super(enFieldName, xFieldName, methName, enMsg, xMsg);
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		String enMsg,
		String xMsg,
		Throwable th )
	{
		super(enFieldName, xFieldName, methName, enMsg, xMsg, th);
	}

	public YCFArgumentRangeException(
	 	String enFieldName,
		String xFieldName,
	 	String methName,
	 	int argNo,
	 	String argName,
	 	String enMsg,
		String xMsg )
	{
	 	super(enFieldName, xFieldName, methName, argNo, argName, enMsg, xMsg);
	}

	public YCFArgumentRangeException(
	 	String enFieldName,
		String xFieldName,
	 	String methName,
	 	int argNo,
	 	String argName,
	 	String enMsg,
	 	String xMsg,
	 	Throwable th )
	{
	 	super(enFieldName, xFieldName, methName, argNo, argName, enMsg, xMsg, th);
	}



	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		short argValue,
		short minValue,
		short maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue));
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		short argValue,
		short minValue,
		short maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			th);
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		int argValue,
		int minValue,
		int maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue));
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		int argValue,
		int minValue,
		int maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			th);
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		long argValue,
		long minValue,
		long maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue));
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		long argValue,
		long minValue,
		long maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.decimal.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			th);
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		float argValue,
		float minValue,
		float maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue));
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		float argValue,
		float minValue,
		float maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			th);
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		double argValue,
		double minValue,
		double maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue));
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		double argValue,
		double minValue,
		double maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.float.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			th);
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		Calendar argValue,
		Calendar minValue,
		Calendar maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()));
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		Calendar argValue,
		Calendar minValue,
		Calendar maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()),
			th);
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		String argValue,
		String minValue,
		String maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue));
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		String argValue,
		String minValue,
		String maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			th);
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		BigDecimal argValue,
		BigDecimal minValue,
		BigDecimal maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()));
	}

	public YCFArgumentRangeException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		BigDecimal argValue,
		BigDecimal minValue,
		BigDecimal maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.string.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()),
			th);
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		short argValue,
		short minValue,
		short maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.decimal.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue));
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		short argValue,
		short minValue,
		short maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.decimal.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			th);
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		int argValue,
		int minValue,
		int maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.decimal.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue));
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		int argValue,
		int minValue,
		int maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.decimal.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			th);
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		long argValue,
		long minValue,
		long maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.decimal.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue));
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		long argValue,
		long minValue,
		long maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.decimal.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.decimal.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			th);
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		float argValue,
		float minValue,
		float maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.float.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.float.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue));
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		float argValue,
		float minValue,
		float maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.float.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.float.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			th);
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		double argValue,
		double minValue,
		double maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.float.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.float.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue));
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		double argValue,
		double minValue,
		double maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.float.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.float.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			th);
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		Calendar argValue,
		Calendar minValue,
		Calendar maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.string.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.string.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()));
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		Calendar argValue,
		Calendar minValue,
		Calendar maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.string.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.string.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()),
			th);
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		String argValue,
		String minValue,
		String maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.string.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.string.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue));
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		String argValue,
		String minValue,
		String maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.string.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.string.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue,
				minValue,
				maxValue),
			th);
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		BigDecimal argValue,
		BigDecimal minValue,
		BigDecimal maxValue )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.string.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.string.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()));
	}

	public YCFArgumentRangeException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		BigDecimal argValue,
		BigDecimal minValue,
		BigDecimal maxValue,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentRangeException.string.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()),
			String.format(Inz.x("ycflib.YCFArgumentRangeException.string.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? "." + methName + "()" : "" ),
				argNo,
				argName,
				argValue.toString(),
				minValue.toString(),
				maxValue.toString()),
			th);
	}
}
