// Description: Java 25 Protected Instance Edit Object interface for Secure SecClusRole.

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

public interface ISecureProtSecClusRoleEditObj
	extends ISecureProtSecClusRoleObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecureProtSecClusRoleObj.
	 */
	ISecureProtSecClusRoleObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecureProtSecClusRoleObj.
	 */
	ISecureProtSecClusRoleObj getOrigAsSecClusRole();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecureProtSecClusRoleObj create();

	/*
	 *	Update the instance.
	 */
	ISecureProtSecClusRoleEditObj update();

	/*
	 *	Delete the instance.
	 */
	ISecureProtSecClusRoleEditObj deleteInstance();

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
	 *	Get the ISecureProtClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The ISecureProtClusterObj instance referenced by the Cluster key.
	 */
	ISecureProtClusterObj getRequiredOwnerCluster();

	/**
	 *	Get the required ISecureProtClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ISecureProtClusterObj instance referenced by the Cluster key.
	 */
	ISecureProtClusterObj getRequiredOwnerCluster( boolean forceRead );

	/**
	 *	Set the ISecureProtClusterObj instance referenced by the Cluster key.
	 *
	 *	@param	value	the ISecureProtClusterObj instance to be referenced by the Cluster key.
	 */
	void setRequiredOwnerCluster( ISecureProtClusterObj value );

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
	 *	Get a list ISecureProtSecClusRoleMembObj instances referenced by the MembByGrp key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecClusRoleMembObj instances referenced by the MembByGrp key.
	 */
	List<ISecureProtSecClusRoleMembObj> getOptionalChildrenMembByGrp();

	/**
	 *	Get the required IYCFKeyHash256 attribute SecClusRoleId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecClusRoleId.
	 */
	IYCFKeyHash256 getRequiredSecClusRoleId();

	/**
	 *	Set the required IYCFKeyHash256 attribute SecClusRoleId.
	 *
	 *	@param value The required IYCFKeyHash256 attribute SecClusRoleId value to be applied.
	 */
	void setRequiredSecClusRoleId(IYCFKeyHash256 value);

	/**
	 *	Get the required IYCFKeyHash256 attribute ClusterId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute ClusterId.
	 */
	IYCFKeyHash256 getRequiredClusterId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	public void copyRecToOrig();
	public void copyOrigToRec();

}
