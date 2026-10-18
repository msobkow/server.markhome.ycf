// Description: Java 25 Instance Edit Object interface for IntNet SecSysRoleMemb.

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

public interface IIntNetSecSysRoleMembEditObj
	extends IIntNetSecSysRoleMembObj, ISecureSecSysRoleMembEditObj
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
	ISecureSecSysRoleMembObj create();

	/*
	 *	Update the instance.
	 */
	SecureSecSysRoleMembEditObj update();

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
	 *	Get the ISecureSecSysRoleObj instance referenced by the SysRole key.
	 *
	 *	@return	The ISecureSecSysRoleObj instance referenced by the SysRole key.
	 */
	ISecureSecSysRoleObj getRequiredContainerSysRole();

	/**
	 *	Get the required ISecureSecSysRoleObj instance referenced by the SysRole key.
	 *
	 *	@return	The required ISecureSecSysRoleObj instance referenced by the SysRole key.
	 */
	ISecureSecSysRoleObj getRequiredContainerSysRole( boolean forceRead );

	/**
	 *	Set the ISecureSecSysRoleObj instance referenced by the SysRole key.
	 *
	 *	@param	value	the ISecureSecSysRoleObj instance to be referenced by the SysRole key.
	 */
	void setRequiredContainerSysRole( ISecureSecSysRoleObj value );

	/**
	 *	Get the ISecureSecUserObj instance referenced by the User key.
	 *
	 *	@return	The ISecureSecUserObj instance referenced by the User key.
	 */
	ISecureSecUserObj getRequiredParentUser();

	/**
	 *	Get the required ISecureSecUserObj instance referenced by the User key.
	 *
	 *	@return	The required ISecureSecUserObj instance referenced by the User key.
	 */
	ISecureSecUserObj getRequiredParentUser( boolean forceRead );

	/**
	 *	Set the ISecureSecUserObj instance referenced by the User key.
	 *
	 *	@param	value	the ISecureSecUserObj instance to be referenced by the User key.
	 */
	void setRequiredParentUser( ISecureSecUserObj value );

	public void copyRecToOrig();
	public void copyOrigToRec();

}
