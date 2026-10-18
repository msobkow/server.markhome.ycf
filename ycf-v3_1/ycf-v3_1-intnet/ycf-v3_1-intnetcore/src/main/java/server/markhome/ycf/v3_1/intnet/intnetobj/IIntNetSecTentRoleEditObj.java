// Description: Java 25 Instance Edit Object interface for IntNet SecTentRole.

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
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

package server.markhome.ycf.v3_1.intnet.intnetobj;

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public interface IIntNetSecTentRoleEditObj
	extends IIntNetSecTentRoleObj, ISecureSecTentRoleEditObj
{
	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecureSecTentRoleObj create();

	/*
	 *	Update the instance.
	 */
	SecureSecTentRoleEditObj update();

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
	 *	Get the ISecureTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The ISecureTenantObj instance referenced by the Tenant key.
	 */
	ISecureTenantObj getRequiredOwnerTenant();

	/**
	 *	Get the required ISecureTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ISecureTenantObj instance referenced by the Tenant key.
	 */
	ISecureTenantObj getRequiredOwnerTenant( boolean forceRead );

	/**
	 *	Set the ISecureTenantObj instance referenced by the Tenant key.
	 *
	 *	@param	value	the ISecureTenantObj instance to be referenced by the Tenant key.
	 */
	void setRequiredOwnerTenant( ISecureTenantObj value );

	/**
	 *	Get the ISecureSecSysGrpObj instance referenced by the SysRole key.
	 *
	 *	@return	The ISecureSecSysGrpObj instance referenced by the SysRole key.
	 */
	ISecureSecSysGrpObj getRequiredContainerSysRole();

	/**
	 *	Get the required ISecureSecSysGrpObj instance referenced by the SysRole key.
	 *
	 *	@return	The required ISecureSecSysGrpObj instance referenced by the SysRole key.
	 */
	ISecureSecSysGrpObj getRequiredContainerSysRole( boolean forceRead );

	/**
	 *	Set the ISecureSecSysGrpObj instance referenced by the SysRole key.
	 *
	 *	@param	value	the ISecureSecSysGrpObj instance to be referenced by the SysRole key.
	 */
	void setRequiredContainerSysRole( ISecureSecSysGrpObj value );

	/**
	 *	Get a list ISecureSecTentRoleMembObj instances referenced by the MembByRole key.
	 *
	 *	@return	The (potentially empty) list of ISecureSecTentRoleMembObj instances referenced by the MembByRole key.
	 */
	List<ISecureSecTentRoleMembObj> getOptionalChildrenMembByRole();

	public void copyRecToOrig();
	public void copyOrigToRec();

}
