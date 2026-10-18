// Description: Java 25 Instance Edit Object interface for IntNet License.

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
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.intnet.intnetprot.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;

public interface IIntNetLicenseEditObj
	extends IIntNetLicenseObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base IIntNetLicenseObj.
	 */
	IIntNetLicenseObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a IIntNetLicenseObj.
	 */
	IIntNetLicenseObj getOrigAsLicense();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	IIntNetLicenseObj create();

	/*
	 *	Update the instance.
	 */
	IntNetLicenseEditObj update();

	/*
	 *	Delete the instance.
	 */
	IntNetLicenseEditObj deleteInstance();

	/**
	 *	Get the ISecureTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The ISecureTenantObj instance referenced by the Tenant key.
	 */
	ISecureTenantObj getRequiredOwnerTenant();

	/**
	 *	Get the required ISecureTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ISecureTenantObj instance referenced by the Tenant key.
	 */
	ISecureTenantObj getRequiredOwnerTenant( boolean forceRead );

	/**
	 *	Set the ISecureTenantObj instance referenced by the Tenant key.
	 *
	 *	@param	value	the ISecureTenantObj instance to be referenced by the Tenant key.
	 */
	void setRequiredOwnerTenant( ISecureTenantObj value );

	/**
	 *	Get the IIntNetTopDomainObj instance referenced by the TopDomain key.
	 *
	 *	@return	The IIntNetTopDomainObj instance referenced by the TopDomain key.
	 */
	IIntNetTopDomainObj getRequiredContainerTopDomain();

	/**
	 *	Get the required IIntNetTopDomainObj instance referenced by the TopDomain key.
	 *
	 *	@return	The required IIntNetTopDomainObj instance referenced by the TopDomain key.
	 */
	IIntNetTopDomainObj getRequiredContainerTopDomain( boolean forceRead );

	/**
	 *	Set the IIntNetTopDomainObj instance referenced by the TopDomain key.
	 *
	 *	@param	value	the IIntNetTopDomainObj instance to be referenced by the TopDomain key.
	 */
	void setRequiredContainerTopDomain( IIntNetTopDomainObj value );

	/**
	 *	Get the required IYCFKeyHash256 attribute Id.
	 *
	 *	@return	The required IYCFKeyHash256 attribute Id.
	 */
	IYCFKeyHash256 getRequiredId();

	/**
	 *	Set the required IYCFKeyHash256 attribute Id.
	 *
	 *	@param value The required IYCFKeyHash256 attribute Id value to be applied.
	 */
	void setRequiredId(IYCFKeyHash256 value);

	/**
	 *	Get the required IYCFKeyHash256 attribute TenantId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute TenantId.
	 */
	IYCFKeyHash256 getRequiredTenantId();

	/**
	 *	Get the required IYCFKeyHash256 attribute TopDomainId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute TopDomainId.
	 */
	IYCFKeyHash256 getRequiredTopDomainId();

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

	/**
	 *	Get the optional String attribute EmbeddedText.
	 *
	 *	@return	The optional String attribute EmbeddedText.
	 */
	String getOptionalEmbeddedText();

	/**
	 *	Set the optional String attribute EmbeddedText.
	 *
	 *	@param value The optional String attribute EmbeddedText value to be applied.
	 */
	void setOptionalEmbeddedText(String value);

	/**
	 *	Get the optional String attribute FullText.
	 *
	 *	@return	The optional String attribute FullText.
	 */
	String getOptionalFullText();

	/**
	 *	Set the optional String attribute FullText.
	 *
	 *	@param value The optional String attribute FullText value to be applied.
	 */
	void setOptionalFullText(String value);

	public void copyRecToOrig();
	public void copyOrigToRec();

}
