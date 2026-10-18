// Description: Java 25 Protected Instance Edit Object interface for Secure SecClusRoleMemb.

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

public interface ISecureProtSecClusRoleMembEditObj
	extends ISecureProtSecClusRoleMembObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecureProtSecClusRoleMembObj.
	 */
	ISecureProtSecClusRoleMembObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecureProtSecClusRoleMembObj.
	 */
	ISecureProtSecClusRoleMembObj getOrigAsSecClusRoleMemb();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecureProtSecClusRoleMembObj create();

	/*
	 *	Update the instance.
	 */
	ISecureProtSecClusRoleMembEditObj update();

	/*
	 *	Delete the instance.
	 */
	ISecureProtSecClusRoleMembEditObj deleteInstance();

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
	 *	Get the ISecureProtSecClusRoleObj instance referenced by the Role key.
	 *
	 *	@return	The ISecureProtSecClusRoleObj instance referenced by the Role key.
	 */
	ISecureProtSecClusRoleObj getRequiredContainerRole();

	/**
	 *	Get the required ISecureProtSecClusRoleObj instance referenced by the Role key.
	 *
	 *	@return	The required ISecureProtSecClusRoleObj instance referenced by the Role key.
	 */
	ISecureProtSecClusRoleObj getRequiredContainerRole( boolean forceRead );

	/**
	 *	Set the ISecureProtSecClusRoleObj instance referenced by the Role key.
	 *
	 *	@param	value	the ISecureProtSecClusRoleObj instance to be referenced by the Role key.
	 */
	void setRequiredContainerRole( ISecureProtSecClusRoleObj value );

	/**
	 *	Get the ISecureProtSecUserObj instance referenced by the User key.
	 *
	 *	@return	The ISecureProtSecUserObj instance referenced by the User key.
	 */
	ISecureProtSecUserObj getRequiredParentUser();

	/**
	 *	Get the required ISecureProtSecUserObj instance referenced by the User key.
	 *
	 *	@return	The required ISecureProtSecUserObj instance referenced by the User key.
	 */
	ISecureProtSecUserObj getRequiredParentUser( boolean forceRead );

	/**
	 *	Set the ISecureProtSecUserObj instance referenced by the User key.
	 *
	 *	@param	value	the ISecureProtSecUserObj instance to be referenced by the User key.
	 */
	void setRequiredParentUser( ISecureProtSecUserObj value );

	/**
	 *	Get the required IYCFKeyHash256 attribute SecClusRoleId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecClusRoleId.
	 */
	IYCFKeyHash256 getRequiredSecClusRoleId();

	/**
	 *	Get the required String attribute LoginId.
	 *
	 *	@return	The required String attribute LoginId.
	 */
	String getRequiredLoginId();

	public void copyRecToOrig();
	public void copyOrigToRec();

}
