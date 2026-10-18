// Description: Java 25 Object interface for IntNet SubProject.

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
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.intnet.intnetprot.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;

public interface IIntNetSubProjectObj
	extends IYCFAnyObj
{
	/**
	 *	Initially, the class code for an object is IIntNetSubProject.CLASS_CODE, but the Obj layer relies on class code translation to map those
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
	 *	Realise this instance of a SubProject.
	 *
	 *	@return	IntNetSubProjectObj instance which should be subsequently referenced.
	 */
	IIntNetSubProjectObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	IIntNetSubProjectObj the reference to the cached or read (realised) instance.
	 */
	IIntNetSubProjectObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	IIntNetSubProjectObj the reference to the cached or read (realised) instance.
	 */
	IIntNetSubProjectObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SubProject instance.
	 *
	 *	@return	The newly locked IIntNetSubProjectEditObj edition of this instance.
	 */
	IIntNetSubProjectEditObj beginEdit();

	/**
	 *	End this edition of this SubProject instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SubProject instance.
	 *
	 *	@return	The IIntNetSubProjectEditObj edition of this instance.
	 */
	IIntNetSubProjectEditObj getEdit();

	/**
	 *	Get the current edition of this SubProject instance as a IIntNetSubProjectEditObj.
	 *
	 *	@return	The IIntNetSubProjectEditObj edition of this instance.
	 */
	IIntNetSubProjectEditObj getEditAsSubProject();

	/**
	 *	Get the IIntNetSubProjectTableObj table cache which manages this instance.
	 *
	 *	@return	IIntNetSubProjectTableObj table cache which manages this instance.
	 */
	IIntNetSubProjectTableObj getSubProjectTable();

	/**
	 *	Get the IIntNetSchemaObj schema cache which manages this instance.
	 *
	 *	@return	IIntNetSchemaObj schema cache which manages this instance.
	 */
	IIntNetSchemaObj getSchema();

	/**
	 *	Set the IIntNetSchemaObj schema cache which manages this instance.
	 *	Should only be used to install overloads of the buff implementation wired specifically to a transport implementation
	 *	that eventually hits a server running a JPA backend.
	 *
	 *	@param schema	IIntNetSchemaObj schema cache which manages this instance.
	 */
	void setSchema(IIntNetSchemaObj schema);

	/**
	 *	Get the IIntNetSubProject instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IIntNetSubProject instance which currently backs this object.
	 */
	IIntNetSubProject getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( IIntNetSubProject value );

	/**
	 *	Get the IIntNetSubProject instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IIntNetSubProject instance which currently backs this object.
	 */
	IIntNetSubProject getSubProjectRec();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	$implCommaIJavaOptAtomType$ primary key for this instance.
	 */
	$implCommaIJavaOptAtomType$ getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param $implCommaIJavaOptAtomType$ primary key value for this instance.
	 */
	void setPKey( $implCommaIJavaOptAtomType$ value );

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
	 *	Get the required IIntNetTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required IIntNetTenantObj instance referenced by the Tenant key.
	 */
	ISecureTenantObj getRequiredOwnerTenant();

	/**
	 *	Get the required ISecureTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ISecureTenantObj instance referenced by the Tenant key.
	 */
	ISecureTenantObj getRequiredOwnerTenant( boolean forceRead );

	/**
	 *	Get the required IIntNetTopProjectObj instance referenced by the ParentTPrj key.
	 *
	 *	@return	The required IIntNetTopProjectObj instance referenced by the ParentTPrj key.
	 */
	IIntNetTopProjectObj getRequiredContainerParentTPrj();

	/**
	 *	Get the required IIntNetTopProjectObj instance referenced by the ParentTPrj key.
	 *
	 *	@return	The required IIntNetTopProjectObj instance referenced by the ParentTPrj key.
	 */
	IIntNetTopProjectObj getRequiredContainerParentTPrj( boolean forceRead );

	/**
	 *	Get the array of optional IIntNetMajorVersionObj array of instances referenced by the MajorVer key.
	 *
	 *	@return	The optional IIntNetMajorVersionObj[] array of instances referenced by the MajorVer key.
	 */
	List<IIntNetMajorVersionObj> getOptionalComponentsMajorVer();

	/**
	 *	Get the array of optional IIntNetMajorVersionObj array of instances referenced by the MajorVer key.
	 *
	 *	@return	The optional IIntNetMajorVersionObj[] array of instances referenced by the MajorVer key.
	 */
	List<IIntNetMajorVersionObj> getOptionalComponentsMajorVer( boolean forceRead );

	/**
	 *	Get the required IYCFKeyHash256 attribute Id.
	 *
	 *	@return	The required IYCFKeyHash256 attribute Id.
	 */
	IYCFKeyHash256 getRequiredId();

	/**
	 *	Get the required IYCFKeyHash256 attribute TenantId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute TenantId.
	 */
	IYCFKeyHash256 getRequiredTenantId();

	/**
	 *	Get the required IYCFKeyHash256 attribute TopProjectId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute TopProjectId.
	 */
	IYCFKeyHash256 getRequiredTopProjectId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The optional String attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Internal use only.
	 */
	void copyPKeyToRec();

	/**
	 *	Internal use only.
	 */
	void copyRecToPKey();

}
