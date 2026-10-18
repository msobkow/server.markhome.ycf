// Description: Java 25 Object interface for IntNet SecSysRoleMemb.

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public interface IIntNetSecSysRoleMembObj
	extends ISecureSecSysRoleMembObj
{
	/**
	 *	Initially, the class code for an object is ISecureSecSysRoleMemb.CLASS_CODE, but the Obj layer relies on class code translation to map those
	 *	backing store entities to a runtime set of front-facing classcodes that the clients download and use when talking to the server implementing this code base.
	 *
	 *	@return The runtime class code used by this object. Only after the system is fully booted are these values stable and reliable.
	 */
	int getClassCode();
	/**
	 *	Get the user who created this instance.
	 *
	 *	@return	The ISecureSecUserObj instance who created this instance.
	 */
	ISecureSecUserObj getCreatedBy();

	/**
	 *	Get the LocalDateTime this instance was created.
	 *
	 *	@return	The LocalDateTime value for the creation time of the instance.
	 */
	LocalDateTime getCreatedAt();

	/**
	 *	Get the user who updated this instance.
	 *
	 *	@return	The ISecureSecUserObj instance who updated this instance.
	 */
	ISecureSecUserObj getUpdatedBy();

	/**
	 *	Get the LocalDateTime date-time this instance was updated.
	 *
	 *	@return	The LocalDateTime value for the create time of the instance.
	 */
	LocalDateTime getUpdatedAt();
	/**
	 *	Realise this instance of a SecSysRoleMemb.
	 *
	 *	@return	SecureSecSysRoleMembObj instance which should be subsequently referenced.
	 */
	ISecureSecSysRoleMembObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureSecSysRoleMembObj the reference to the cached or read (realised) instance.
	 */
	ISecureSecSysRoleMembObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureSecSysRoleMembObj the reference to the cached or read (realised) instance.
	 */
	ISecureSecSysRoleMembObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SecSysRoleMemb instance.
	 *
	 *	@return	The newly locked ISecureSecSysRoleMembEditObj edition of this instance.
	 */
	ISecureSecSysRoleMembEditObj beginEdit();

	/**
	 *	End this edition of this SecSysRoleMemb instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SecSysRoleMemb instance.
	 *
	 *	@return	The ISecureSecSysRoleMembEditObj edition of this instance.
	 */
	ISecureSecSysRoleMembEditObj getEdit();

	/**
	 *	Get the current edition of this SecSysRoleMemb instance as a ISecureSecSysRoleMembEditObj.
	 *
	 *	@return	The ISecureSecSysRoleMembEditObj edition of this instance.
	 */
	ISecureSecSysRoleMembEditObj getEditAsSecSysRoleMemb();

	/**
	 *	Get the ISecureSecSysRoleMembTableObj table cache which manages this instance.
	 *
	 *	@return	ISecureSecSysRoleMembTableObj table cache which manages this instance.
	 */
	ISecureSecSysRoleMembTableObj getSecSysRoleMembTable();

	/**
	 *	Get the ISecureSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ISecureSchemaObj schema cache which manages this instance.
	 */
	ISecureSchemaObj getSchema();

	/**
	 *	Set the ISecureSchemaObj schema cache which manages this instance.
	 *	Should only be used to install overloads of the buff implementation wired specifically to a transport implementation
	 *	that eventually hits a server running a JPA backend.
	 *
	 *	@param schema	ISecureSchemaObj schema cache which manages this instance.
	 */
	void setSchema(ISecureSchemaObj schema);

	/**
	 *	Get the ISecureSecSysRoleMemb instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureSecSysRoleMemb instance which currently backs this object.
	 */
	ISecureSecSysRoleMemb getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( ISecureSecSysRoleMemb value );

	/**
	 *	Get the ISecureSecSysRoleMemb instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureSecSysRoleMemb instance which currently backs this object.
	 */
	ISecureSecSysRoleMemb getSecSysRoleMembRec();

	/**
	 *	Is this a new instance?
	 *
	 *	@return	True if this is a new instance, otherwise false if it has
	 *		been read, locked, or created.
	 */
	boolean getIsNew();

	/**
	 *	Indicate whether this is a new instance.
	 *	<p>
	 *	This method should only be used by implementation internals.
	 *
	 *	@param	True if this is a new instance, otherwise false.
	 */
	void setIsNew( boolean value );

	/**
	 *	Get the required IIntNetSecSysRoleObj instance referenced by the SysRole key.
	 *
	 *	@return	The required IIntNetSecSysRoleObj instance referenced by the SysRole key.
	 */
	ISecureSecSysRoleObj getRequiredContainerSysRole();

	/**
	 *	Get the required ISecureSecSysRoleObj instance referenced by the SysRole key.
	 *
	 *	@return	The required ISecureSecSysRoleObj instance referenced by the SysRole key.
	 */
	ISecureSecSysRoleObj getRequiredContainerSysRole( boolean forceRead );

	/**
	 *	Get the required IIntNetSecUserObj instance referenced by the User key.
	 *
	 *	@return	The required IIntNetSecUserObj instance referenced by the User key.
	 */
	ISecureSecUserObj getRequiredParentUser();

	/**
	 *	Get the required ISecureSecUserObj instance referenced by the User key.
	 *
	 *	@return	The required ISecureSecUserObj instance referenced by the User key.
	 */
	ISecureSecUserObj getRequiredParentUser( boolean forceRead );

	/**
	 *	Get the required IYCFKeyHash256 attribute SecSysRoleId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecSysRoleId.
	 */
	IYCFKeyHash256 getRequiredSecSysRoleId();

	/**
	 *	Get the required String attribute LoginId.
	 *
	 *	@return	The required String attribute LoginId.
	 */
	String getRequiredLoginId();

	/**
	 *	Internal use only.
	 */
	void copyPKeyToRec();

	/**
	 *	Internal use only.
	 */
	void copyRecToPKey();

}
