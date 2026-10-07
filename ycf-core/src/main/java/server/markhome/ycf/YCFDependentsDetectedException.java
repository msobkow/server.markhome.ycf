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
 * YCFDependentsDetectedException is thrown when an object cannot be deleted because it has dependent objects which are not flagged for cascading deletes.
 */
public class YCFDependentsDetectedException extends YCFRuntimeException {

	protected String enRelnType = null;
	protected String xRelnType = null;

	protected String enRelnName = null;
	protected String xRelnName = null;

	protected String enRelnTarget = null;
	protected String xRelnTarget = null;

	protected Object indexKey = null;

	public YCFDependentsDetectedException(
		String enMsg,
		String xMsg )
	{
		super( enMsg, xMsg );
	}

	public YCFDependentsDetectedException(
		String enMsg,
		String xMsg,
		Object indexKey )
	{
		super( enMsg, xMsg );
		this.indexKey = indexKey;
	}

	public YCFDependentsDetectedException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg )
	{
		super( throwingClass, methName, enMsg, xMsg );
	}

	public YCFDependentsDetectedException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg,
		Object indexKey )
	{
		super( throwingClass, methName, enMsg, xMsg );
		this.indexKey = indexKey;
	}

	public YCFDependentsDetectedException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg,
		Throwable th )
	{
		super( throwingClass, methName, enMsg, xMsg, th );
	}

	public YCFDependentsDetectedException(
		Class<?> throwingClass,
		String methName,
		String enMsg,
		String xMsg,
		Object indexKey,
		Throwable th )
	{
		super( throwingClass, methName, enMsg, xMsg, th );
		this.indexKey = indexKey;
	}

	public YCFDependentsDetectedException(
		Class<?> throwingClass,
		String methName,
		Throwable th )
	{
		super( 
				String.format(Inz.s("ycflib.YCFDependentsDetectedException.sqlexcept"),
					(throwingClass.getName() + (( methName != null && !methName.isEmpty())? ("." + methName + "()") : "")),
					th.getMessage()),
				String.format(Inz.x("ycflib.YCFDependentsDetectedException.sqlexcept"),
					(throwingClass.getName() + (( methName != null && !methName.isEmpty())? ("." + methName + "()") : "")),
					th.getMessage()),
				th);
	}

	public YCFDependentsDetectedException(
		Class<?> throwingClass,
		String methName,
		Object indexKey )
	{
		super( ((indexKey != null)
					? String.format(Inz.s("ycflib.YCFDependentsDetectedException.indexKey"),
						(throwingClass.getName() + ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" )),
						indexKey.toString())
					: String.format(Inz.s("ycflib.YCFDependentsDetectedException.default"),
						(throwingClass.getName() + ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" )))),
				((indexKey != null)
					? String.format(Inz.x("ycflib.YCFDependentsDetectedException.indexKey"),
						(throwingClass.getName() + (( methName != null && !methName.isEmpty())? ("." + methName + "()") : "")),
						indexKey.toString())
					: String.format(Inz.s("ycflib.YCFDependentsDetectedException.default"),
						(throwingClass.getName() + (( methName != null && !methName.isEmpty())? ("." + methName + "()") : "")))));
		this.indexKey = indexKey;
	}

	public YCFDependentsDetectedException(
		Class<?> throwingClass,
		String methName,
		Object indexKey,
		Throwable th)
	{
		super( ((indexKey != null)
					? String.format(Inz.s("ycflib.YCFDependentsDetectedException.indexKey"),
						(throwingClass.getName() + ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" )),
						indexKey.toString())
					: String.format(Inz.s("ycflib.YCFDependentsDetectedException.default"),
						(throwingClass.getName() + ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "" )))),
				((indexKey != null)
					? String.format(Inz.x("ycflib.YCFDependentsDetectedException.indexKey"),
						(throwingClass.getName() + (( methName != null && !methName.isEmpty())? ("." + methName + "()") : "")),
						indexKey.toString())
					: String.format(Inz.s("ycflib.YCFDependentsDetectedException.default"),
						(throwingClass.getName() + (( methName != null && !methName.isEmpty())? ("." + methName + "()") : "")))),
				th);
		this.indexKey = indexKey;
	}

	public YCFDependentsDetectedException(
		Class<?> throwingClass,
		String methName,
		String enRelationType,
		String xRelationType,
		String enRelationName,
		String xRelationName,
		String enTargetName,
		String xTargetName,
		Object indexKey )
	{
		super( ((indexKey != null) ?
				String.format(Inz.s("ycflib.YCFDependentsDetectedException.indexKey"),
					(throwingClass.getName() + ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "")),
					enRelationType, enRelationName, enTargetName, indexKey.toString())
				: String.format(Inz.s("ycflib.YCFDependentsDetectedException.default"),
					(throwingClass.getName() + ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "")),
					enRelationType, enRelationName, enTargetName)),
			((indexKey != null) ?
				String.format(Inz.x("ycflib.YCFDependentsDetectedException.indexKey"),
					(throwingClass.getName() + (( methName != null && !methName.isEmpty())? ("." + methName + "()") : "")),
					(xRelationType != null && !xRelationType.isEmpty()) ? xRelationType : enRelationType,
					(xRelationName != null && !xRelationName.isEmpty()) ? xRelationName : enRelationName,
					(xTargetName != null && !xTargetName.isEmpty()) ? xTargetName : enTargetName,
					indexKey.toString())
				: String.format(Inz.s("ycflib.YCFDependentsDetectedException.default"),
					(throwingClass.getName() + (( methName != null && !methName.isEmpty())? ("." + methName + "()") : "")),
					(xRelationType != null && !xRelationType.isEmpty()) ? xRelationType : enRelationType,
					(xRelationName != null && !xRelationName.isEmpty()) ? xRelationName : enRelationName,
					(xTargetName != null && !xTargetName.isEmpty()) ? xTargetName : enTargetName)));
		enRelnType = enRelationType;
		xRelnType = xRelationType;
		enRelnName = enRelationName;
		xRelnName = xRelationName;
		enRelnTarget = enTargetName;
		xRelnTarget = xTargetName;
		this.indexKey = indexKey;
	}

	public YCFDependentsDetectedException(
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
		super( ((indexKey != null) ?
				String.format(Inz.s("ycflib.YCFDependentsDetectedException.indexKey"),
					(throwingClass.getName() + ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "")),
					enRelationType, enRelationName, enTargetName, indexKey.toString())
				: String.format(Inz.s("ycflib.YCFDependentsDetectedException.default"),
					(throwingClass.getName() + ((methName != null && !methName.isEmpty()) ? ("." + methName + "()") : "")),
					enRelationType, enRelationName, enTargetName)),
			((indexKey != null) ?
				String.format(Inz.x("ycflib.YCFDependentsDetectedException.indexKey"),
					(throwingClass.getName() + (( methName != null && !methName.isEmpty())? ("." + methName + "()") : "")),
					(xRelationType != null && !xRelationType.isEmpty()) ? xRelationType : enRelationType,
					(xRelationName != null && !xRelationName.isEmpty()) ? xRelationName : enRelationName,
					(xTargetName != null && !xTargetName.isEmpty()) ? xTargetName : enTargetName,
					indexKey.toString())
				: String.format(Inz.s("ycflib.YCFDependentsDetectedException.default"),
					(throwingClass.getName() + (( methName != null && !methName.isEmpty())? ("." + methName + "()") : "")),
					(xRelationType != null && !xRelationType.isEmpty()) ? xRelationType : enRelationType,
					(xRelationName != null && !xRelationName.isEmpty()) ? xRelationName : enRelationName,
					(xTargetName != null && !xTargetName.isEmpty()) ? xTargetName : enTargetName)));
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
}
