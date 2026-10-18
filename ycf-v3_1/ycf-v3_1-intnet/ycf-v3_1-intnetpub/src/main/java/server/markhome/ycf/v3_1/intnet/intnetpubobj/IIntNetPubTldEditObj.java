// Description: Java 25 Public Instance Edit Object interface for IntNet Tld.

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
import org.apache.commons.text.StringEscapeUtils;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public interface IIntNetPubTldEditObj
	extends IIntNetPubTldObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base IIntNetPubTldObj.
	 */
	IIntNetPubTldObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a IIntNetPubTldObj.
	 */
	IIntNetPubTldObj getOrigAsTld();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	IIntNetPubTldObj create();

	/*
	 *	Update the instance.
	 */
	IIntNetPubTldEditObj update();

	/*
	 *	Delete the instance.
	 */
	IIntNetPubTldEditObj deleteInstance();

	/**
	 *	Set the user who created this instance.
	 *
	 *	@param	value	The ISecurePubSecUserObj instance who created this instance.
	 */
	void setCreatedBy( ISecurePubSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was created.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setCreatedAt( LocalDateTime value );

	/**
	 *	Set the user who updated this instance.
	 *
	 *	@param	value	The ISecurePubSecUserObj instance who updated this instance.
	 */
	void setUpdatedBy( ISecurePubSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was updated.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setUpdatedAt( LocalDateTime value );

	/**
	 *	Get the ISecurePubTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The ISecurePubTenantObj instance referenced by the Tenant key.
	 */
	ISecurePubTenantObj getRequiredContainerTenant();

	/**
	 *	Get the required ISecurePubTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ISecurePubTenantObj instance referenced by the Tenant key.
	 */
	ISecurePubTenantObj getRequiredContainerTenant( boolean forceRead );

	/**
	 *	Set the ISecurePubTenantObj instance referenced by the Tenant key.
	 *
	 *	@param	value	the ISecurePubTenantObj instance to be referenced by the Tenant key.
	 */
	void setRequiredContainerTenant( ISecurePubTenantObj value );

	/**
	 *	Get a list IIntNetPubTopDomainObj instances referenced by the TopDomain key.
	 *
	 *	@return	The (potentially empty) list of IIntNetPubTopDomainObj instances referenced by the TopDomain key.
	 */
	List<IIntNetPubTopDomainObj> getOptionalComponentsTopDomain();

	/**
	 *	Get the required YCFDbKeyHash256 attribute Id.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute Id.
	 */
	YCFDbKeyHash256 getRequiredId();

	/**
	 *	Set the required YCFDbKeyHash256 attribute Id.
	 *
	 *	@param value The required YCFDbKeyHash256 attribute Id value to be applied.
	 */
	void setRequiredId(YCFDbKeyHash256 value);

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
	 *	Set the required String attribute Name.
	 *
	 *	@param value The required String attribute Name value to be applied.
	 */
	void setRequiredName(String value);

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The optional String attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Set the optional String attribute Description.
	 *
	 *	@param value The optional String attribute Description value to be applied.
	 */
	void setOptionalDescription(String value);

	public void copyRecToOrig();
	public void copyOrigToRec();

}
