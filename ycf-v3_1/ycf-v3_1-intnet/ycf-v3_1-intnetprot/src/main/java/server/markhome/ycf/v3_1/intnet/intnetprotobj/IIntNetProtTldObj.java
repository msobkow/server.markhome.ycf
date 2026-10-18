// Description: Java 25 Object interface for IntNetProt Tld.

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

package server.markhome.ycf.v3_1.intnet.intnetprotobj;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

public interface IIntNetProtTldObj
	extends IYCFAnyObj
{
	/**
	 *	Initially, the class code for an object is IIntNetProtTld.CLASS_CODE, but the Obj layer relies on class code translation to map those
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
	 *	@return	IntNetProtTldObj instance which should be subsequently referenced.
	 */
	IIntNetProtTldObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	IIntNetProtTldObj the reference to the cached or read (realised) instance.
	 */
	IIntNetProtTldObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	IIntNetProtTldObj the reference to the cached or read (realised) instance.
	 */
	IIntNetProtTldObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this Tld instance.
	 *
	 *	@return	The newly locked IIntNetProtTldEditObj edition of this instance.
	 */
	IIntNetProtTldEditObj beginEdit();

	/**
	 *	End this edition of this Tld instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this Tld instance.
	 *
	 *	@return	The IIntNetProtTldEditObj edition of this instance.
	 */
	IIntNetProtTldEditObj getEdit();

	/**
	 *	Get the current edition of this Tld instance as a IIntNetProtTldEditObj.
	 *
	 *	@return	The IIntNetProtTldEditObj edition of this instance.
	 */
	IIntNetProtTldEditObj getEditAsTld();

	/**
	 *	Get the IIntNetProtTldTableObj table cache which manages this instance.
	 *
	 *	@return	IIntNetProtTldTableObj table cache which manages this instance.
	 */
	IIntNetProtTldTableObj getTldTable();

	/**
	 *	Get the IIntNetProtSchemaObj schema cache which manages this instance.
	 *
	 *	@return	IIntNetProtSchemaObj schema cache which manages this instance.
	 */
	IIntNetProtSchemaObj getSchema();

	/**
	 *	Set the IIntNetProtSchemaObj schema cache which manages this instance.
	 *	Should only be used to install overloads of the buff implementation wired specifically to a transport implementation
	 *	that eventually hits a server running a JPA backend.
	 *
	 *	@param schema	IIntNetProtSchemaObj schema cache which manages this instance.
	 */
	void setSchema(IIntNetProtSchemaObj schema);

	/**
	 *	Get the IIntNetProtTld instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IIntNetProtTld instance which currently backs this object.
	 */
	IIntNetProtTld getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( IIntNetProtTld value );

	/**
	 *	Get the IIntNetProtTld instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IIntNetProtTld instance which currently backs this object.
	 */
	IIntNetProtTld getTldRec();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	YCFDbKeyHash256 primary key for this instance.
	 */
	YCFDbKeyHash256 getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param YCFDbKeyHash256 primary key value for this instance.
	 */
	void setPKey( YCFDbKeyHash256 value );

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
	 *	Get the required IIntNetProtTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required IIntNetProtTenantObj instance referenced by the Tenant key.
	 */
	ISecurePubTenantObj getRequiredContainerTenant();

	/**
	 *	Get the required ISecureProtTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ISecureProtTenantObj instance referenced by the Tenant key.
	 */
	ISecurePubTenantObj getRequiredContainerTenant( boolean forceRead );

	/**
	 *	Get the array of optional IIntNetProtTopDomainObj array of instances referenced by the TopDomain key.
	 *
	 *	@return	The optional IIntNetProtTopDomainObj[] array of instances referenced by the TopDomain key.
	 */
	List<IIntNetProtTopDomainObj> getOptionalComponentsTopDomain();

	/**
	 *	Get the array of optional IIntNetProtTopDomainObj array of instances referenced by the TopDomain key.
	 *
	 *	@return	The optional IIntNetProtTopDomainObj[] array of instances referenced by the TopDomain key.
	 */
	List<IIntNetProtTopDomainObj> getOptionalComponentsTopDomain( boolean forceRead );

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
