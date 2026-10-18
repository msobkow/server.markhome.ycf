// Description: Java 25 Object interface for IntNetPub TopDomain.

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

package server.markhome.ycf.v3_1.intnet.intnetpubobj;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public interface IIntNetPubTopDomainObj
	extends IYCFAnyObj
{
	/**
	 *	Initially, the class code for an object is IIntNetPubTopDomain.CLASS_CODE, but the Obj layer relies on class code translation to map those
	 *	backing store entities to a runtime set of front-facing classcodes that the clients download and use when talking to the server implementing this code base.
	 *
	 *	@return The runtime class code used by this object. Only after the system is fully booted are these values stable and reliable.
	 */
	int getClassCode();
	/**
	 *	Get the user who created this instance.
	 *
	 *	@return	The ISecurePubSecUserObj instance who created this instance.
	 */
	ISecurePubSecUserObj getCreatedBy();

	/**
	 *	Get the LocalDateTime this instance was created.
	 *
	 *	@return	The LocalDateTime value for the creation time of the instance.
	 */
	LocalDateTime getCreatedAt();

	/**
	 *	Get the user who updated this instance.
	 *
	 *	@return	The ISecurePubSecUserObj instance who updated this instance.
	 */
	ISecurePubSecUserObj getUpdatedBy();

	/**
	 *	Get the LocalDateTime date-time this instance was updated.
	 *
	 *	@return	The LocalDateTime value for the create time of the instance.
	 */
	LocalDateTime getUpdatedAt();
	/**
	 *	Realise this instance of a TopDomain.
	 *
	 *	@return	IntNetPubTopDomainObj instance which should be subsequently referenced.
	 */
	IIntNetPubTopDomainObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	IIntNetPubTopDomainObj the reference to the cached or read (realised) instance.
	 */
	IIntNetPubTopDomainObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	IIntNetPubTopDomainObj the reference to the cached or read (realised) instance.
	 */
	IIntNetPubTopDomainObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this TopDomain instance.
	 *
	 *	@return	The newly locked IIntNetPubTopDomainEditObj edition of this instance.
	 */
	IIntNetPubTopDomainEditObj beginEdit();

	/**
	 *	End this edition of this TopDomain instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this TopDomain instance.
	 *
	 *	@return	The IIntNetPubTopDomainEditObj edition of this instance.
	 */
	IIntNetPubTopDomainEditObj getEdit();

	/**
	 *	Get the current edition of this TopDomain instance as a IIntNetPubTopDomainEditObj.
	 *
	 *	@return	The IIntNetPubTopDomainEditObj edition of this instance.
	 */
	IIntNetPubTopDomainEditObj getEditAsTopDomain();

	/**
	 *	Get the IIntNetPubTopDomainTableObj table cache which manages this instance.
	 *
	 *	@return	IIntNetPubTopDomainTableObj table cache which manages this instance.
	 */
	IIntNetPubTopDomainTableObj getTopDomainTable();

	/**
	 *	Get the IIntNetPubSchemaObj schema cache which manages this instance.
	 *
	 *	@return	IIntNetPubSchemaObj schema cache which manages this instance.
	 */
	IIntNetPubSchemaObj getSchema();

	/**
	 *	Set the IIntNetPubSchemaObj schema cache which manages this instance.
	 *	Should only be used to install overloads of the buff implementation wired specifically to a transport implementation
	 *	that eventually hits a server running a JPA backend.
	 *
	 *	@param schema	IIntNetPubSchemaObj schema cache which manages this instance.
	 */
	void setSchema(IIntNetPubSchemaObj schema);

	/**
	 *	Get the IIntNetPubTopDomain instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IIntNetPubTopDomain instance which currently backs this object.
	 */
	IIntNetPubTopDomain getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( IIntNetPubTopDomain value );

	/**
	 *	Get the IIntNetPubTopDomain instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IIntNetPubTopDomain instance which currently backs this object.
	 */
	IIntNetPubTopDomain getTopDomainRec();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	IYCFKeyHash256 primary key for this instance.
	 */
	IYCFKeyHash256 getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param IYCFKeyHash256 primary key value for this instance.
	 */
	void setPKey( IYCFKeyHash256 value );

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
	 *	Get the required IIntNetPubTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required IIntNetPubTenantObj instance referenced by the Tenant key.
	 */
	ISecurePubTenantObj getRequiredOwnerTenant();

	/**
	 *	Get the required ISecurePubTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ISecurePubTenantObj instance referenced by the Tenant key.
	 */
	ISecurePubTenantObj getRequiredOwnerTenant( boolean forceRead );

	/**
	 *	Get the required IIntNetPubTldObj instance referenced by the ParentTld key.
	 *
	 *	@return	The required IIntNetPubTldObj instance referenced by the ParentTld key.
	 */
	IIntNetPubTldObj getRequiredContainerParentTld();

	/**
	 *	Get the required IIntNetPubTldObj instance referenced by the ParentTld key.
	 *
	 *	@return	The required IIntNetPubTldObj instance referenced by the ParentTld key.
	 */
	IIntNetPubTldObj getRequiredContainerParentTld( boolean forceRead );

	/**
	 *	Get the array of optional IIntNetPubTopProjectObj array of instances referenced by the TopProject key.
	 *
	 *	@return	The optional IIntNetPubTopProjectObj[] array of instances referenced by the TopProject key.
	 */
	List<IIntNetPubTopProjectObj> getOptionalComponentsTopProject();

	/**
	 *	Get the array of optional IIntNetPubTopProjectObj array of instances referenced by the TopProject key.
	 *
	 *	@return	The optional IIntNetPubTopProjectObj[] array of instances referenced by the TopProject key.
	 */
	List<IIntNetPubTopProjectObj> getOptionalComponentsTopProject( boolean forceRead );

	/**
	 *	Get the array of optional IIntNetPubLicenseObj array of instances referenced by the License key.
	 *
	 *	@return	The optional IIntNetPubLicenseObj[] array of instances referenced by the License key.
	 */
	List<IIntNetPubLicenseObj> getOptionalComponentsLicense();

	/**
	 *	Get the array of optional IIntNetPubLicenseObj array of instances referenced by the License key.
	 *
	 *	@return	The optional IIntNetPubLicenseObj[] array of instances referenced by the License key.
	 */
	List<IIntNetPubLicenseObj> getOptionalComponentsLicense( boolean forceRead );

	/**
	 *	Get the required YCFDbKeyHash256 attribute Id.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute Id.
	 */
	YCFDbKeyHash256 getRequiredId();

	/**
	 *	Get the required YCFDbKeyHash256 attribute TenantId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute TenantId.
	 */
	YCFDbKeyHash256 getRequiredTenantId();

	/**
	 *	Get the required YCFDbKeyHash256 attribute TldId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute TldId.
	 */
	YCFDbKeyHash256 getRequiredTldId();

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
