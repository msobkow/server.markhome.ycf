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
 * YCFUnresolvedRelationException is thrown when there is no target object for a foreign key found.
 */
public class YCFUnresolvedRelationException extends IllegalStateException {

	protected String localMessage = null;

	protected String enRelnType = null;
	protected String xRelnType = null;

	protected String enRelnName = null;
	protected String xRelnName = null;

	protected String enRelnTarget = null;
	protected String xRelnTarget = null;

	protected Object indexKey = null;

	public YCFUnresolvedRelationException(
		String enMsg,
		String xMsg )
	{
		super( enMsg );
		this.localMessage = xMsg;
	}

	public YCFUnresolvedRelationException(
		String enMsg,
		String xMsg,
		Throwable th)
	{
			super(enMsg, th);
			this.localMessage = xMsg;
	}

	public YCFUnresolvedRelationException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg )
	{
		super( String.format(Inz.s("ycflib.YCFArgumentException.TcmnMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg : "" )));
		this.localMessage = String.format(Inz.x("ycflib.YCFArgumentException.TcmnMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				( ( ( xMsg != null ) && ( xMsg.length() > 0 ) ) ? xMsg : (enMsg != null && enMsg.length() > 0) ? enMsg : ""));
	}

	public YCFUnresolvedRelationException(
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

	public YCFUnresolvedRelationException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		String enMsg,
		String xMsg )
	{
		super( String.format(Inz.s("ycflib.YCFArgumentException.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName,
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg	: "" ) ));
		this.localMessage = String.format(Inz.x("ycflib.YCFArgumentException.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName,
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg	: "" ) );
	}

	public YCFUnresolvedRelationException(
		Class<?> throwingClass,
		String methName,
		int argNo,
		String argName,
		String enMsg,
		String xMsg,
		Throwable th )
	{
		super( String.format(Inz.s("ycflib.YCFArgumentException.TcmnArgMsg"),
				throwingClass.getName()	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
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

	public YCFUnresolvedRelationException(
		String enFieldName,
		String xFieldName,
		String enMsg,
		String xMsg )
	{
		super( String.format(Inz.s("ycflib.YCFArgumentException.FldMsg"),
				enFieldName,
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg	: "" ) ));
		this.localMessage = String.format(Inz.x("ycflib.YCFArgumentException.FldMsg"),
				(xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName,
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg	: "" ) );
	}

	public YCFUnresolvedRelationException(
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

	public YCFUnresolvedRelationException(
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

	public YCFUnresolvedRelationException(
		String enFieldName,
		String xFieldName,
		String methName,
		int argNo,
		String argName,
		String enMsg,
		String xMsg )
	{
		super(String.format(Inz.s("ycflib.YCFArgumentException.FldArgMsg"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName,
				( ( ( enMsg != null ) && ( enMsg.length() > 0 ) ) ? enMsg : "" ) ));
		this.localMessage = String.format(Inz.x("ycflib.YCFArgumentException.FldArgMsg"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName)	+ (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
				argNo,
				argName,
				( ( ( xMsg != null ) && ( xMsg.length() > 0 ) ) ? xMsg : (enMsg != null && enMsg.length() > 0) ? enMsg : "") );
	}

	public YCFUnresolvedRelationException(
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
				enFieldName + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
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

	public YCFUnresolvedRelationException()
	{
		super(String.format(Inz.s("ycflib.YCFUnresolvedRelationException.default"), ""));
		this.localMessage = String.format(Inz.x("ycflib.YCFUnresolvedRelationException.default"), "");
	}

	public YCFUnresolvedRelationException(
		Class<?> throwingClass,
		String methName )
	{
		super( String.format(Inz.s("ycflib.YCFUnresolvedRelationException.default"),
					throwingClass.getName() + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" )));
		this.localMessage = String.format(Inz.x("ycflib.YCFUnresolvedRelationException.default"),
					throwingClass.getName() + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ));
	}

	public YCFUnresolvedRelationException(
		Class<?> throwingClass,
		String methName,
		Throwable th )
	{
		super( String.format(Inz.s("ycflib.YCFUnresolvedRelationException.default"),
					throwingClass.getName() + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" )),
					th);
		this.localMessage = String.format(Inz.x("ycflib.YCFUnresolvedRelationException.default"),
					throwingClass.getName() + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ));
	}

	public YCFUnresolvedRelationException(
		String enFieldName,
		String xFieldName,
		String methName,
		Throwable th )
	{
		super( String.format(Inz.s("ycflib.YCFUnresolvedRelationException.default"),
				enFieldName + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" )),
			th);
		this.localMessage = String.format(Inz.x("ycflib.YCFUnresolvedRelationException.default"),
				((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ));
	}

	public YCFUnresolvedRelationException(
		Class<?> throwingClass,
		String methName,
		String enRelationType,
		String xRelationType,
		String enRelationName,
		String xRelationName,
		String enTargetName,
		String xTargetName,
		Object indexKey)
	{
		super( (indexKey != null) ? String.format(Inz.s("ycflib.YCFUnresolvedRelationException.fullkey"),//%1$s%2$s relation %3$s key %4%s referencing %5$s could not be resolved
					throwingClass.getName() + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					enRelationType,
					enRelationName,
					indexKey.toString(),
					enTargetName)
				: String.format(Inz.s("ycflib.YCFUnresolvedRelationException.fullnokey"),//%1$s%2$s relation %3$s referencing %4$s could not be resolved
					throwingClass.getName() + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					enRelationType,
					enRelationName,
					enTargetName ));
		this.localMessage = (indexKey != null) ? String.format(Inz.x("ycflib.YCFUnresolvedRelationException.fullkey"),//%1$s%2$s relation %3$s key %4%s referencing %5$s could not be resolved
					throwingClass.getName() + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					(xRelationType != null && !xRelationType.isEmpty()) ? xRelationType : enRelationType,
					(xRelationName != null && !xRelationName.isEmpty()) ? xRelationName : enRelationName,
					indexKey.toString(),
					(xTargetName != null && !xTargetName.isEmpty()) ? xTargetName : enTargetName)
				: String.format(Inz.x("ycflib.YCFUnresolvedRelationException.fullnokey"),//%1$s%2$s relation %3$s referencing %4$s could not be resolved
					throwingClass.getName() + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					(xRelationType != null && !xRelationType.isEmpty()) ? xRelationType : enRelationType,
					(xRelationName != null && !xRelationName.isEmpty()) ? xRelationName : enRelationName,
					(xTargetName != null && !xTargetName.isEmpty()) ? xTargetName : enTargetName);
		enRelnType = enRelationType;
		xRelnType = xRelationType;
		enRelnName = enRelationName;
		xRelnName = xRelationName;
		enRelnTarget = enTargetName;
		xRelnTarget = xTargetName;
		this.indexKey = indexKey;
	}

	public YCFUnresolvedRelationException(
		Class<?> throwingClass,
		String methName,
		String enRelationType,
		String xRelationType,
		String enRelationName,
		String xRelationName,
		String enTargetName,
		String xTargetName,
		Object indexKey,
		Throwable th )
	{
		super( (indexKey != null) ? String.format(Inz.s("ycflib.YCFUnresolvedRelationException.fullkey"),//%1$s%2$s relation %3$s key %4%s referencing %5$s could not be resolved
					throwingClass.getName() + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					enRelationType,
					enRelationName,
					indexKey.toString(),
					enTargetName)
				: String.format(Inz.s("ycflib.YCFUnresolvedRelationException.fullnokey"),//%1$s%2$s relation %3$s referencing %4$s could not be resolved
					throwingClass.getName() + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					enRelationType,
					enRelationName,
					enTargetName ),
			th);
		this.localMessage = (indexKey != null) ? String.format(Inz.x("ycflib.YCFUnresolvedRelationException.fullkey"),//%1$s%2$s relation %3$s key %4%s referencing %5$s could not be resolved
					throwingClass.getName() + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					(xRelationType != null && !xRelationType.isEmpty()) ? xRelationType : enRelationType,
					(xRelationName != null && !xRelationName.isEmpty()) ? xRelationName : enRelationName,
					indexKey.toString(),
					(xTargetName != null && !xTargetName.isEmpty()) ? xTargetName : enTargetName)
				: String.format(Inz.x("ycflib.YCFUnresolvedRelationException.fullnokey"),//%1$s%2$s relation %3$s referencing %4$s could not be resolved
					throwingClass.getName() + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					(xRelationType != null && !xRelationType.isEmpty()) ? xRelationType : enRelationType,
					(xRelationName != null && !xRelationName.isEmpty()) ? xRelationName : enRelationName,
					(xTargetName != null && !xTargetName.isEmpty()) ? xTargetName : enTargetName);
		enRelnType = enRelationType;
		xRelnType = xRelationType;
		enRelnName = enRelationName;
		xRelnName = xRelationName;
		enRelnTarget = enTargetName;
		xRelnTarget = xTargetName;
		this.indexKey = indexKey;
	}

	public YCFUnresolvedRelationException(
		String enFieldName,
		String xFieldName,
		String methName,
		String enRelationType,
		String xRelationType,
		String enRelationName,
		String xRelationName,
		String enTargetName,
		String xTargetName,
		Object indexKey)
	{
		super( (indexKey != null) ? String.format(Inz.s("ycflib.YCFUnresolvedRelationException.fullkey"),//%1$s%2$s relation %3$s key %4%s referencing %5$s could not be resolved
					enFieldName + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					enRelationType,
					enRelationName,
					indexKey.toString(),
					enTargetName)
				: String.format(Inz.s("ycflib.YCFUnresolvedRelationException.fullnokey"),//%1$s%2$s relation %3$s referencing %4$s could not be resolved
					enFieldName + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					enRelationType,
					enRelationName,
					enTargetName ));
		this.localMessage = (indexKey != null) ? String.format(Inz.x("ycflib.YCFUnresolvedRelationException.fullkey"),//%1$s%2$s relation %3$s key %4%s referencing %5$s could not be resolved
					((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					(xRelationType != null && !xRelationType.isEmpty()) ? xRelationType : enRelationType,
					(xRelationName != null && !xRelationName.isEmpty()) ? xRelationName : enRelationName,
					indexKey.toString(),
					(xTargetName != null && !xTargetName.isEmpty()) ? xTargetName : enTargetName)
				: String.format(Inz.x("ycflib.YCFUnresolvedRelationException.fullnokey"),//%1$s%2$s relation %3$s referencing %4$s could not be resolved
					((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					(xRelationType != null && !xRelationType.isEmpty()) ? xRelationType : enRelationType,
					(xRelationName != null && !xRelationName.isEmpty()) ? xRelationName : enRelationName,
					(xTargetName != null && !xTargetName.isEmpty()) ? xTargetName : enTargetName);
		enRelnType = enRelationType;
		xRelnType = xRelationType;
		enRelnName = enRelationName;
		xRelnName = xRelationName;
		enRelnTarget = enTargetName;
		xRelnTarget = xTargetName;
		this.indexKey = indexKey;
	}

	public YCFUnresolvedRelationException(
		String enFieldName,
		String xFieldName,
		String methName,
		String enRelationType,
		String xRelationType,
		String enRelationName,
		String xRelationName,
		String enTargetName,
		String xTargetName,
		Object indexKey,
		Throwable th)
	{
		super( (indexKey != null) ? String.format(Inz.s("ycflib.YCFUnresolvedRelationException.fullkey"),//%1$s%2$s relation %3$s key %4%s referencing %5$s could not be resolved
					enFieldName + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					enRelationType,
					enRelationName,
					indexKey.toString(),
					enTargetName)
				: String.format(Inz.s("ycflib.YCFUnresolvedRelationException.fullnokey"),//%1$s%2$s relation %3$s referencing %4$s could not be resolved
					enFieldName + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					enRelationType,
					enRelationName,
					enTargetName ),
			th);
		this.localMessage = (indexKey != null) ? String.format(Inz.x("ycflib.YCFUnresolvedRelationException.fullkey"),//%1$s%2$s relation %3$s key %4%s referencing %5$s could not be resolved
					((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					(xRelationType != null && !xRelationType.isEmpty()) ? xRelationType : enRelationType,
					(xRelationName != null && !xRelationName.isEmpty()) ? xRelationName : enRelationName,
					indexKey.toString(),
					(xTargetName != null && !xTargetName.isEmpty()) ? xTargetName : enTargetName)
				: String.format(Inz.x("ycflib.YCFUnresolvedRelationException.fullnokey"),//%1$s%2$s relation %3$s referencing %4$s could not be resolved
					((xFieldName != null && !xFieldName.isEmpty()) ? xFieldName : enFieldName) + (( methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" ),
					(xRelationType != null && !xRelationType.isEmpty()) ? xRelationType : enRelationType,
					(xRelationName != null && !xRelationName.isEmpty()) ? xRelationName : enRelationName,
					(xTargetName != null && !xTargetName.isEmpty()) ? xTargetName : enTargetName);
		enRelnType = enRelationType;
		xRelnType = xRelationType;
		enRelnName = enRelationName;
		xRelnName = xRelationName;
		enRelnTarget = enTargetName;
		xRelnTarget = xTargetName;
		this.indexKey = indexKey;
	}

	public String getRelationType() {
		return( enRelnType );
	}
	
	public String getRelationName() {
		return( enRelnName );
	}
	
	public String getRelationTarget() {
		return( enRelnTarget );
	}

	public String getLocalizedRelationType() {
		return( (xRelnType != null && !xRelnType.isEmpty()) ? xRelnType : enRelnType );
	}
	
	public String getLocalizedRelationName() {
		return( (xRelnName != null && !xRelnName.isEmpty()) ? xRelnName : enRelnName );
	}
	
	public String getLocalizedRelationTarget() {
		return( (xRelnTarget != null && !xRelnTarget.isEmpty()) ? xRelnTarget : enRelnTarget );
	}

	public Object getIndexKey() {
		return( indexKey );
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
