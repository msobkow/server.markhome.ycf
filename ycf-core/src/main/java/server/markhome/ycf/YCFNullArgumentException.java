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
 * YCFNullArgumentException is thrown when a required argument is null.
 */
public class YCFNullArgumentException extends YCFArgumentException {

	// Inherited constructor patterns

	public YCFNullArgumentException(
		String enMsg,
		String xMsg )
	{
		super(enMsg, xMsg);
	}

	public YCFNullArgumentException(
		String enMsg,
		String xMsg,
		Throwable th)
	{
		super(enMsg, xMsg, th);
	}

	public YCFNullArgumentException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg )
	{
		super(throwingClass, methName, enMsg, xMsg);
	}

	public YCFNullArgumentException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg,
		Throwable th )
	{
		super(throwingClass, methName, enMsg, xMsg, th);
	}

	public YCFNullArgumentException(
	 	Class<?> throwingClass,
	 	String methName,
	 	int argNo,
	 	String argName,
	 	String enMsg,
	 	String xMsg )
	{
	 	super(throwingClass, methName, argNo, argName, enMsg, xMsg);
	}

	public YCFNullArgumentException(
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

	// public YCFNullArgumentException(
	// 	String enFieldName,
	// 	String xFieldName,
	// 	String enMsg,
	// 	String xMsg )
	// {
	// 	super(enFieldName, xFieldName, enMsg, xMsg);
	// }

	public YCFNullArgumentException(
		String enFieldName,
		String xFieldName,
		String methName,
		String enMsg,
		String xMsg )
	{
		super(enFieldName, xFieldName, methName, enMsg, xMsg);
	}

	public YCFNullArgumentException(
		String enFieldName,
		String xFieldName,
		String methName,
		String enMsg,
		String xMsg,
		Throwable th )
	{
		super(enFieldName, xFieldName, methName, enMsg, xMsg, th);
	}

	public YCFNullArgumentException(
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

	public YCFNullArgumentException(
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

	// Custom/most-often-used constructors

	public YCFNullArgumentException(
		Class<?> throwingClass,
		String methName )
	{
		super(String.format(Inz.s("ycflib.YCFNullArgumentException.TcmnMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" )),
			String.format(Inz.x("ycflib.YCFNullArgumentException.TcmnMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" )));
	}

	public YCFNullArgumentException(
		Class<?> throwingClass,
		String methName,
		Throwable th)
	{
		super(String.format(Inz.s("ycflib.YCFNullArgumentException.TcmnMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" )),
			String.format(Inz.x("ycflib.YCFNullArgumentException.TcmnMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" )),
			th);
	}

	public YCFNullArgumentException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName )
	{
		super(String.format(Inz.s("ycflib.YCFNullArgumentException.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName),
			String.format(Inz.x("ycflib.YCFNullArgumentException.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName));
	}

	public YCFNullArgumentException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFNullArgumentException.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName),
			String.format(Inz.x("ycflib.YCFNullArgumentException.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName),
			th);
	}

	public YCFNullArgumentException(
		String enFieldName,
		String xFieldName,
		String methName )
	{
		super(String.format(Inz.s("ycflib.YCFNullArgumentException.FldMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" )),
			String.format(Inz.x("ycflib.YCFNullArgumentException.FldMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" )));
	}

	public YCFNullArgumentException(
		String enFieldName,
		String xFieldName,
		String methName,
		Throwable th)
	{
		super(String.format(Inz.s("ycflib.YCFNullArgumentException.FldMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" )),
			String.format(Inz.x("ycflib.YCFNullArgumentException.FldMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" )),
			th);
	}

	public YCFNullArgumentException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName )
	{
		super(String.format(Inz.s("ycflib.YCFNullArgumentException.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName),
			String.format(Inz.x("ycflib.YCFNullArgumentException.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName));
	}

	public YCFNullArgumentException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		Throwable th )
	{
		super(String.format(Inz.s("ycflib.YCFNullArgumentException.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName),
			String.format(Inz.x("ycflib.YCFNullArgumentException.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName),
			th);
	}
}
