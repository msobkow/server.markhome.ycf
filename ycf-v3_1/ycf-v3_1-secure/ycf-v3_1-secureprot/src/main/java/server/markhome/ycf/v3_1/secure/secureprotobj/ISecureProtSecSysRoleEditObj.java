// Description: Java 25 Protected Instance Edit Object interface for Secure SecSysRole.

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

public interface ISecureProtSecSysRoleEditObj
	extends ISecureProtSecSysRoleObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecureProtSecSysRoleObj.
	 */
	ISecureProtSecSysRoleObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecureProtSecSysRoleObj.
	 */
	ISecureProtSecSysRoleObj getOrigAsSecSysRole();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecureProtSecSysRoleObj create();

	/*
	 *	Update the instance.
	 */
	ISecureProtSecSysRoleEditObj update();

	/*
	 *	Delete the instance.
	 */
	ISecureProtSecSysRoleEditObj deleteInstance();

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
	 *	Get a list ISecureProtSecSysRoleEnablesObj instances referenced by the EnabledByRole key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecSysRoleEnablesObj instances referenced by the EnabledByRole key.
	 */
	List<ISecureProtSecSysRoleEnablesObj> getOptionalComponentsEnabledByRole();

	/**
	 *	Get a list ISecureProtSecSysRoleMembObj instances referenced by the MembByRole key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecSysRoleMembObj instances referenced by the MembByRole key.
	 */
	List<ISecureProtSecSysRoleMembObj> getOptionalChildrenMembByRole();

	/**
	 *	Get the required IYCFKeyHash256 attribute SecSysRoleId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecSysRoleId.
	 */
	IYCFKeyHash256 getRequiredSecSysRoleId();

	/**
	 *	Set the required IYCFKeyHash256 attribute SecSysRoleId.
	 *
	 *	@param value The required IYCFKeyHash256 attribute SecSysRoleId value to be applied.
	 */
	void setRequiredSecSysRoleId(IYCFKeyHash256 value);

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

	public void copyRecToOrig();
	public void copyOrigToRec();

}
