// Description: Java 25 Object interface for IntNetPub Tld.

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

public interface IIntNetPubTldObj
	extends IYCFAnyObj
{
	/**
	 *	Initially, the class code for an object is IIntNetPubTld.CLASS_CODE, but the Obj layer relies on class code translation to map those
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
	 *	Realise this instance of a Tld.
	 *
	 *	@return	IntNetPubTldObj instance which should be subsequently referenced.
	 */
	IIntNetPubTldObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	IIntNetPubTldObj the reference to the cached or read (realised) instance.
	 */
	IIntNetPubTldObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	IIntNetPubTldObj the reference to the cached or read (realised) instance.
	 */
	IIntNetPubTldObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this Tld instance.
	 *
	 *	@return	The newly locked IIntNetPubTldEditObj edition of this instance.
	 */
	IIntNetPubTldEditObj beginEdit();

	/**
	 *	End this edition of this Tld instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this Tld instance.
	 *
	 *	@return	The IIntNetPubTldEditObj edition of this instance.
	 */
	IIntNetPubTldEditObj getEdit();

	/**
	 *	Get the current edition of this Tld instance as a IIntNetPubTldEditObj.
	 *
	 *	@return	The IIntNetPubTldEditObj edition of this instance.
	 */
	IIntNetPubTldEditObj getEditAsTld();

	/**
	 *	Get the IIntNetPubTldTableObj table cache which manages this instance.
	 *
	 *	@return	IIntNetPubTldTableObj table cache which manages this instance.
	 */
	IIntNetPubTldTableObj getTldTable();

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
	 *	Get the IIntNetPubTld instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IIntNetPubTld instance which currently backs this object.
	 */
	IIntNetPubTld getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( IIntNetPubTld value );

	/**
	 *	Get the IIntNetPubTld instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IIntNetPubTld instance which currently backs this object.
	 */
	IIntNetPubTld getTldRec();

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
	ISecurePubTenantObj getRequiredContainerTenant();

	/**
	 *	Get the required ISecurePubTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ISecurePubTenantObj instance referenced by the Tenant key.
	 */
	ISecurePubTenantObj getRequiredContainerTenant( boolean forceRead );

	/**
	 *	Get the array of optional IIntNetPubTopDomainObj array of instances referenced by the TopDomain key.
	 *
	 *	@return	The optional IIntNetPubTopDomainObj[] array of instances referenced by the TopDomain key.
	 */
	List<IIntNetPubTopDomainObj> getOptionalComponentsTopDomain();

	/**
	 *	Get the array of optional IIntNetPubTopDomainObj array of instances referenced by the TopDomain key.
	 *
	 *	@return	The optional IIntNetPubTopDomainObj[] array of instances referenced by the TopDomain key.
	 */
	List<IIntNetPubTopDomainObj> getOptionalComponentsTopDomain( boolean forceRead );

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
