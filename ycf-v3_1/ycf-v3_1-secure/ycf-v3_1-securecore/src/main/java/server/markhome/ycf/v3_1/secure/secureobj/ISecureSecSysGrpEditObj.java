// Description: Java 25 Instance Edit Object interface for Secure SecSysGrp.

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

package server.markhome.ycf.v3_1.secure.secureobj;

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
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

public interface ISecureSecSysGrpEditObj
	extends ISecureSecSysGrpObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecureSecSysGrpObj.
	 */
	ISecureSecSysGrpObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecureSecSysGrpObj.
	 */
	ISecureSecSysGrpObj getOrigAsSecSysGrp();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecureSecSysGrpObj create();

	/*
	 *	Update the instance.
	 */
	SecureSecSysGrpEditObj update();

	/*
	 *	Delete the instance.
	 */
	SecureSecSysGrpEditObj deleteInstance();

	/**
	 *	Set the user who created this instance.
	 *
	 *	@param	value	The ISecureSecUserObj instance who created this instance.
	 */
	void setCreatedBy( ISecureSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was created.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setCreatedAt( LocalDateTime value );

	/**
	 *	Set the user who updated this instance.
	 *
	 *	@param	value	The ISecureSecUserObj instance who updated this instance.
	 */
	void setUpdatedBy( ISecureSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was updated.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setUpdatedAt( LocalDateTime value );

	/**
	 *	Get a list ISecureSecSysGrpIncObj instances referenced by the IncByGrp key.
	 *
	 *	@return	The (potentially empty) list of ISecureSecSysGrpIncObj instances referenced by the IncByGrp key.
	 */
	List<ISecureSecSysGrpIncObj> getOptionalComponentsIncByGrp();

	/**
	 *	Get a list ISecureSecSysGrpMembObj instances referenced by the MembByGrp key.
	 *
	 *	@return	The (potentially empty) list of ISecureSecSysGrpMembObj instances referenced by the MembByGrp key.
	 */
	List<ISecureSecSysGrpMembObj> getOptionalChildrenMembByGrp();

	/**
	 *	Get a list ISecureSecClusGrpObj instances referenced by the ImplClusGrp key.
	 *
	 *	@return	The (potentially empty) list of ISecureSecClusGrpObj instances referenced by the ImplClusGrp key.
	 */
	List<ISecureSecClusGrpObj> getOptionalComponentsImplClusGrp();

	/**
	 *	Get a list ISecureSecTentGrpObj instances referenced by the ImplTentGrp key.
	 *
	 *	@return	The (potentially empty) list of ISecureSecTentGrpObj instances referenced by the ImplTentGrp key.
	 */
	List<ISecureSecTentGrpObj> getOptionalComponentsImplTentGrp();

	/**
	 *	Get the ISecureSecSysRoleObj instance referenced by the ImplSysRole key.
	 *
	 *	@return	The ISecureSecSysRoleObj instance referenced by the ImplSysRole key.
	 */
	ISecureSecSysRoleObj getOptionalComponentsImplSysRole();

	/**
	 *	Get the optional ISecureSecSysRoleObj instance referenced by the ImplSysRole key.
	 *
	 *	@return	The optional ISecureSecSysRoleObj instance referenced by the ImplSysRole key.
	 */
	ISecureSecSysRoleObj getOptionalComponentsImplSysRole( boolean forceRead );

	/**
	 *	Get a list ISecureSecClusRoleObj instances referenced by the ImplClusRole key.
	 *
	 *	@return	The (potentially empty) list of ISecureSecClusRoleObj instances referenced by the ImplClusRole key.
	 */
	List<ISecureSecClusRoleObj> getOptionalComponentsImplClusRole();

	/**
	 *	Get a list ISecureSecTentRoleObj instances referenced by the ImplTentRole key.
	 *
	 *	@return	The (potentially empty) list of ISecureSecTentRoleObj instances referenced by the ImplTentRole key.
	 */
	List<ISecureSecTentRoleObj> getOptionalComponentsImplTentRole();

	/**
	 *	Get a list ISecureSecSysGrpIncObj instances referenced by the SysGrpByName key.
	 *
	 *	@return	The (potentially empty) list of ISecureSecSysGrpIncObj instances referenced by the SysGrpByName key.
	 */
	List<ISecureSecSysGrpIncObj> getOptionalChildrenSysGrpByName();

	/**
	 *	Get a list ISecureSecSysRoleEnablesObj instances referenced by the RoleByEnableName key.
	 *
	 *	@return	The (potentially empty) list of ISecureSecSysRoleEnablesObj instances referenced by the RoleByEnableName key.
	 */
	List<ISecureSecSysRoleEnablesObj> getOptionalChildrenRoleByEnableName();

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
