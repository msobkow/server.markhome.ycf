// Description: Java 25 Protected Instance Edit Object interface for Secure SecSysGrp.

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

package server.markhome.ycf.v3_1.secure.secureprotobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public interface ISecureProtSecSysGrpEditObj
	extends ISecureProtSecSysGrpObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecureProtSecSysGrpObj.
	 */
	ISecureProtSecSysGrpObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecureProtSecSysGrpObj.
	 */
	ISecureProtSecSysGrpObj getOrigAsSecSysGrp();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecureProtSecSysGrpObj create();

	/*
	 *	Update the instance.
	 */
	ISecureProtSecSysGrpEditObj update();

	/*
	 *	Delete the instance.
	 */
	ISecureProtSecSysGrpEditObj deleteInstance();

	/**
	 *	Set the user who created this instance.
	 *
	 *	@param	value	The ISecureProtSecUserObj instance who created this instance.
	 */
	void setCreatedBy( ISecureProtSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was created.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setCreatedAt( LocalDateTime value );

	/**
	 *	Set the user who updated this instance.
	 *
	 *	@param	value	The ISecureProtSecUserObj instance who updated this instance.
	 */
	void setUpdatedBy( ISecureProtSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was updated.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setUpdatedAt( LocalDateTime value );

	/**
	 *	Get a list ISecureProtSecSysGrpIncObj instances referenced by the IncByGrp key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecSysGrpIncObj instances referenced by the IncByGrp key.
	 */
	List<ISecureProtSecSysGrpIncObj> getOptionalComponentsIncByGrp();

	/**
	 *	Get a list ISecureProtSecSysGrpMembObj instances referenced by the MembByGrp key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecSysGrpMembObj instances referenced by the MembByGrp key.
	 */
	List<ISecureProtSecSysGrpMembObj> getOptionalChildrenMembByGrp();

	/**
	 *	Get a list ISecureProtSecClusGrpObj instances referenced by the ImplClusGrp key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecClusGrpObj instances referenced by the ImplClusGrp key.
	 */
	List<ISecureProtSecClusGrpObj> getOptionalComponentsImplClusGrp();

	/**
	 *	Get a list ISecureProtSecTentGrpObj instances referenced by the ImplTentGrp key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecTentGrpObj instances referenced by the ImplTentGrp key.
	 */
	List<ISecureProtSecTentGrpObj> getOptionalComponentsImplTentGrp();

	/**
	 *	Get the ISecureProtSecSysRoleObj instance referenced by the ImplSysRole key.
	 *
	 *	@return	The ISecureProtSecSysRoleObj instance referenced by the ImplSysRole key.
	 */
	ISecureProtSecSysRoleObj getOptionalComponentsImplSysRole();

	/**
	 *	Get the optional ISecureProtSecSysRoleObj instance referenced by the ImplSysRole key.
	 *
	 *	@return	The optional ISecureProtSecSysRoleObj instance referenced by the ImplSysRole key.
	 */
	ISecureProtSecSysRoleObj getOptionalComponentsImplSysRole( boolean forceRead );

	/**
	 *	Get a list ISecureProtSecClusRoleObj instances referenced by the ImplClusRole key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecClusRoleObj instances referenced by the ImplClusRole key.
	 */
	List<ISecureProtSecClusRoleObj> getOptionalComponentsImplClusRole();

	/**
	 *	Get a list ISecureProtSecTentRoleObj instances referenced by the ImplTentRole key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecTentRoleObj instances referenced by the ImplTentRole key.
	 */
	List<ISecureProtSecTentRoleObj> getOptionalComponentsImplTentRole();

	/**
	 *	Get a list ISecureProtSecSysGrpIncObj instances referenced by the SysGrpByName key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecSysGrpIncObj instances referenced by the SysGrpByName key.
	 */
	List<ISecureProtSecSysGrpIncObj> getOptionalChildrenSysGrpByName();

	/**
	 *	Get a list ISecureProtSecSysRoleEnablesObj instances referenced by the RoleByEnableName key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecSysRoleEnablesObj instances referenced by the RoleByEnableName key.
	 */
	List<ISecureProtSecSysRoleEnablesObj> getOptionalChildrenRoleByEnableName();

	/**
	 *	Get the required IYCFKeyHash256 attribute SecSysGrpId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecSysGrpId.
	 */
	IYCFKeyHash256 getRequiredSecSysGrpId();

	/**
	 *	Set the required IYCFKeyHash256 attribute SecSysGrpId.
	 *
	 *	@param value The required IYCFKeyHash256 attribute SecSysGrpId value to be applied.
	 */
	void setRequiredSecSysGrpId(IYCFKeyHash256 value);

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
