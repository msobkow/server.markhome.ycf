// Description: Java 25 Object interface for IntNet SecSysRoleEnables.

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

public interface IIntNetSecSysRoleEnablesObj
	extends ISecureSecSysRoleEnablesObj
{
	/**
	 *	Initially, the class code for an object is ISecureSecSysRoleEnables.CLASS_CODE, but the Obj layer relies on class code translation to map those
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
	 *	Realise this instance of a SecSysRoleEnables.
	 *
	 *	@return	SecureSecSysRoleEnablesObj instance which should be subsequently referenced.
	 */
	ISecureSecSysRoleEnablesObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureSecSysRoleEnablesObj the reference to the cached or read (realised) instance.
	 */
	ISecureSecSysRoleEnablesObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureSecSysRoleEnablesObj the reference to the cached or read (realised) instance.
	 */
	ISecureSecSysRoleEnablesObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SecSysRoleEnables instance.
	 *
	 *	@return	The newly locked ISecureSecSysRoleEnablesEditObj edition of this instance.
	 */
	ISecureSecSysRoleEnablesEditObj beginEdit();

	/**
	 *	End this edition of this SecSysRoleEnables instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SecSysRoleEnables instance.
	 *
	 *	@return	The ISecureSecSysRoleEnablesEditObj edition of this instance.
	 */
	ISecureSecSysRoleEnablesEditObj getEdit();

	/**
	 *	Get the current edition of this SecSysRoleEnables instance as a ISecureSecSysRoleEnablesEditObj.
	 *
	 *	@return	The ISecureSecSysRoleEnablesEditObj edition of this instance.
	 */
	ISecureSecSysRoleEnablesEditObj getEditAsSecSysRoleEnables();

	/**
	 *	Get the ISecureSecSysRoleEnablesTableObj table cache which manages this instance.
	 *
	 *	@return	ISecureSecSysRoleEnablesTableObj table cache which manages this instance.
	 */
	ISecureSecSysRoleEnablesTableObj getSecSysRoleEnablesTable();

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
	 *	Get the ISecureSecSysRoleEnables instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureSecSysRoleEnables instance which currently backs this object.
	 */
	ISecureSecSysRoleEnables getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( ISecureSecSysRoleEnables value );

	/**
	 *	Get the ISecureSecSysRoleEnables instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureSecSysRoleEnables instance which currently backs this object.
	 */
	ISecureSecSysRoleEnables getSecSysRoleEnablesRec();

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
	 *	Get the required IIntNetSecSysGrpObj instance referenced by the EnableGroup key.
	 *
	 *	@return	The required IIntNetSecSysGrpObj instance referenced by the EnableGroup key.
	 */
	ISecureSecSysGrpObj getRequiredParentEnableGroup();

	/**
	 *	Get the required ISecureSecSysGrpObj instance referenced by the EnableGroup key.
	 *
	 *	@return	The required ISecureSecSysGrpObj instance referenced by the EnableGroup key.
	 */
	ISecureSecSysGrpObj getRequiredParentEnableGroup( boolean forceRead );

	/**
	 *	Get the required IYCFKeyHash256 attribute SecSysRoleId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecSysRoleId.
	 */
	IYCFKeyHash256 getRequiredSecSysRoleId();

	/**
	 *	Get the required String attribute EnableName.
	 *
	 *	@return	The required String attribute EnableName.
	 */
	String getRequiredEnableName();

	/**
	 *	Internal use only.
	 */
	void copyPKeyToRec();

	/**
	 *	Internal use only.
	 */
	void copyRecToPKey();

}
