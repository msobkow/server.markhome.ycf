// Description: Java 25 Protected Instance Edit Object interface for Secure SecTentRole.

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

public interface ISecureProtSecTentRoleEditObj
	extends ISecureProtSecTentRoleObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecureProtSecTentRoleObj.
	 */
	ISecureProtSecTentRoleObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecureProtSecTentRoleObj.
	 */
	ISecureProtSecTentRoleObj getOrigAsSecTentRole();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecureProtSecTentRoleObj create();

	/*
	 *	Update the instance.
	 */
	ISecureProtSecTentRoleEditObj update();

	/*
	 *	Delete the instance.
	 */
	ISecureProtSecTentRoleEditObj deleteInstance();

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
	 *	Get the ISecureProtTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The ISecureProtTenantObj instance referenced by the Tenant key.
	 */
	ISecureProtTenantObj getRequiredOwnerTenant();

	/**
	 *	Get the required ISecureProtTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ISecureProtTenantObj instance referenced by the Tenant key.
	 */
	ISecureProtTenantObj getRequiredOwnerTenant( boolean forceRead );

	/**
	 *	Set the ISecureProtTenantObj instance referenced by the Tenant key.
	 *
	 *	@param	value	the ISecureProtTenantObj instance to be referenced by the Tenant key.
	 */
	void setRequiredOwnerTenant( ISecureProtTenantObj value );

	/**
	 *	Get the ISecureProtSecSysGrpObj instance referenced by the SysRole key.
	 *
	 *	@return	The ISecureProtSecSysGrpObj instance referenced by the SysRole key.
	 */
	ISecureProtSecSysGrpObj getRequiredContainerSysRole();

	/**
	 *	Get the required ISecureProtSecSysGrpObj instance referenced by the SysRole key.
	 *
	 *	@return	The required ISecureProtSecSysGrpObj instance referenced by the SysRole key.
	 */
	ISecureProtSecSysGrpObj getRequiredContainerSysRole( boolean forceRead );

	/**
	 *	Set the ISecureProtSecSysGrpObj instance referenced by the SysRole key.
	 *
	 *	@param	value	the ISecureProtSecSysGrpObj instance to be referenced by the SysRole key.
	 */
	void setRequiredContainerSysRole( ISecureProtSecSysGrpObj value );

	/**
	 *	Get a list ISecureProtSecTentRoleMembObj instances referenced by the MembByRole key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecTentRoleMembObj instances referenced by the MembByRole key.
	 */
	List<ISecureProtSecTentRoleMembObj> getOptionalChildrenMembByRole();

	/**
	 *	Get the required IYCFKeyHash256 attribute SecTentRoleId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecTentRoleId.
	 */
	IYCFKeyHash256 getRequiredSecTentRoleId();

	/**
	 *	Set the required IYCFKeyHash256 attribute SecTentRoleId.
	 *
	 *	@param value The required IYCFKeyHash256 attribute SecTentRoleId value to be applied.
	 */
	void setRequiredSecTentRoleId(IYCFKeyHash256 value);

	/**
	 *	Get the required IYCFKeyHash256 attribute TenantId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute TenantId.
	 */
	IYCFKeyHash256 getRequiredTenantId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	public void copyRecToOrig();
	public void copyOrigToRec();

}
