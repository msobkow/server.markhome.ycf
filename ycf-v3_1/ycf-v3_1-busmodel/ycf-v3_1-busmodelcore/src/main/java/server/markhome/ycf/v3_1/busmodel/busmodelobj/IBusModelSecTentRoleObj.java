// Description: Java 25 Object interface for BusModel SecTentRole.

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodelobj;

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
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public interface IBusModelSecTentRoleObj
	extends ISecureSecTentRoleObj,
		IIntNetSecTentRoleObj
{
	/**
	 *	Initially, the class code for an object is ISecureSecTentRole.CLASS_CODE, but the Obj layer relies on class code translation to map those
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
	 *	Realise this instance of a SecTentRole.
	 *
	 *	@return	SecureSecTentRoleObj instance which should be subsequently referenced.
	 */
	ISecureSecTentRoleObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureSecTentRoleObj the reference to the cached or read (realised) instance.
	 */
	ISecureSecTentRoleObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureSecTentRoleObj the reference to the cached or read (realised) instance.
	 */
	ISecureSecTentRoleObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SecTentRole instance.
	 *
	 *	@return	The newly locked ISecureSecTentRoleEditObj edition of this instance.
	 */
	ISecureSecTentRoleEditObj beginEdit();

	/**
	 *	End this edition of this SecTentRole instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SecTentRole instance.
	 *
	 *	@return	The ISecureSecTentRoleEditObj edition of this instance.
	 */
	ISecureSecTentRoleEditObj getEdit();

	/**
	 *	Get the current edition of this SecTentRole instance as a ISecureSecTentRoleEditObj.
	 *
	 *	@return	The ISecureSecTentRoleEditObj edition of this instance.
	 */
	ISecureSecTentRoleEditObj getEditAsSecTentRole();

	/**
	 *	Get the ISecureSecTentRoleTableObj table cache which manages this instance.
	 *
	 *	@return	ISecureSecTentRoleTableObj table cache which manages this instance.
	 */
	ISecureSecTentRoleTableObj getSecTentRoleTable();

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
	 *	Get the ISecureSecTentRole instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureSecTentRole instance which currently backs this object.
	 */
	ISecureSecTentRole getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( ISecureSecTentRole value );

	/**
	 *	Get the ISecureSecTentRole instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureSecTentRole instance which currently backs this object.
	 */
	ISecureSecTentRole getSecTentRoleRec();

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
	 *	Get the required IBusModelTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required IBusModelTenantObj instance referenced by the Tenant key.
	 */
	ISecureTenantObj getRequiredOwnerTenant();

	/**
	 *	Get the required ISecureTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ISecureTenantObj instance referenced by the Tenant key.
	 */
	ISecureTenantObj getRequiredOwnerTenant( boolean forceRead );

	/**
	 *	Get the required IBusModelSecSysGrpObj instance referenced by the SysRole key.
	 *
	 *	@return	The required IBusModelSecSysGrpObj instance referenced by the SysRole key.
	 */
	ISecureSecSysGrpObj getRequiredContainerSysRole();

	/**
	 *	Get the required ISecureSecSysGrpObj instance referenced by the SysRole key.
	 *
	 *	@return	The required ISecureSecSysGrpObj instance referenced by the SysRole key.
	 */
	ISecureSecSysGrpObj getRequiredContainerSysRole( boolean forceRead );

	/**
	 *	Get the array of optional ISecureSecTentRoleMembObj array of instances referenced by the MembByRole key.
	 *
	 *	@return	The optional ISecureSecTentRoleMembObj[] array of instances referenced by the MembByRole key.
	 */
	List<ISecureSecTentRoleMembObj> getOptionalChildrenMembByRole();

	/**
	 *	Get the array of optional ISecureSecTentRoleMembObj array of instances referenced by the MembByRole key.
	 *
	 *	@return	The optional ISecureSecTentRoleMembObj[] array of instances referenced by the MembByRole key.
	 */
	List<ISecureSecTentRoleMembObj> getOptionalChildrenMembByRole( boolean forceRead );

	/**
	 *	Get the required IYCFKeyHash256 attribute SecTentRoleId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecTentRoleId.
	 */
	IYCFKeyHash256 getRequiredSecTentRoleId();

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

	/**
	 *	Internal use only.
	 */
	void copyPKeyToRec();

	/**
	 *	Internal use only.
	 */
	void copyRecToPKey();

}
