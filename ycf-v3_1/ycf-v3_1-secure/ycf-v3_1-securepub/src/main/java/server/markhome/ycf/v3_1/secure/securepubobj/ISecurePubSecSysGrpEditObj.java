// Description: Java 25 Public Instance Edit Object interface for Secure SecSysGrp.

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.secure.securepubobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import org.apache.commons.text.StringEscapeUtils;

import server.markhome.ycf.v3_1.secure.securepub.*;

public interface ISecurePubSecSysGrpEditObj
	extends ISecurePubSecSysGrpObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecurePubSecSysGrpObj.
	 */
	ISecurePubSecSysGrpObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecurePubSecSysGrpObj.
	 */
	ISecurePubSecSysGrpObj getOrigAsSecSysGrp();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecurePubSecSysGrpObj create();

	/*
	 *	Update the instance.
	 */
	ISecurePubSecSysGrpEditObj update();

	/*
	 *	Delete the instance.
	 */
	ISecurePubSecSysGrpEditObj deleteInstance();

	/**
	 *	Set the user who created this instance.
	 *
	 *	@param	value	The ISecurePubSecUserObj instance who created this instance.
	 */
	void setCreatedBy( ISecurePubSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was created.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setCreatedAt( LocalDateTime value );

	/**
	 *	Set the user who updated this instance.
	 *
	 *	@param	value	The ISecurePubSecUserObj instance who updated this instance.
	 */
	void setUpdatedBy( ISecurePubSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was updated.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setUpdatedAt( LocalDateTime value );

	/**
	 *	Get the ISecurePubSecSysRoleObj instance referenced by the ImplSysRole key.
	 *
	 *	@return	The ISecurePubSecSysRoleObj instance referenced by the ImplSysRole key.
	 */
	ISecurePubSecSysRoleObj getOptionalComponentsImplSysRole();

	/**
	 *	Get the optional ISecurePubSecSysRoleObj instance referenced by the ImplSysRole key.
	 *
	 *	@return	The optional ISecurePubSecSysRoleObj instance referenced by the ImplSysRole key.
	 */
	ISecurePubSecSysRoleObj getOptionalComponentsImplSysRole( boolean forceRead );

	/**
	 *	Get the required YCFDbKeyHash256 attribute SecSysGrpId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute SecSysGrpId.
	 */
	YCFDbKeyHash256 getRequiredSecSysGrpId();

	/**
	 *	Set the required YCFDbKeyHash256 attribute SecSysGrpId.
	 *
	 *	@param value The required YCFDbKeyHash256 attribute SecSysGrpId value to be applied.
	 */
	void setRequiredSecSysGrpId(YCFDbKeyHash256 value);

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Set the required String attribute Name.
	 *
	 *	@param value The required String attribute Name value to be applied.
	 */
	void setRequiredName(String value);

	/**
	 *	Get the required ISecurePubSchema.SecLevelEnum attribute SecLevel.
	 *
	 *	@return	The required ISecurePubSchema.SecLevelEnum attribute SecLevel.
	 */
	ISecurePubSchema.SecLevelEnum getRequiredSecLevel();

	/**
	 *	Set the required ISecurePubSchema.SecLevelEnum attribute SecLevel.
	 *
	 *	@param value The required ISecurePubSchema.SecLevelEnum attribute SecLevel value to be applied.
	 */
	void setRequiredSecLevel(ISecurePubSchema.SecLevelEnum value);

	public void copyRecToOrig();
	public void copyOrigToRec();

}
