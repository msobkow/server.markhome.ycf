// Description: Java 25 Public Instance Edit Object interface for Secure Tenant.

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
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

package server.markhome.ycf.v3_1.secure.securepubobj;

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

public interface ISecurePubTenantEditObj
	extends ISecurePubTenantObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecurePubTenantObj.
	 */
	ISecurePubTenantObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecurePubTenantObj.
	 */
	ISecurePubTenantObj getOrigAsTenant();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecurePubTenantObj create();

	/*
	 *	Update the instance.
	 */
	ISecurePubTenantEditObj update();

	/*
	 *	Delete the instance.
	 */
	ISecurePubTenantEditObj deleteInstance();

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
	 *	Get the ISecurePubClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The ISecurePubClusterObj instance referenced by the Cluster key.
	 */
	ISecurePubClusterObj getRequiredContainerCluster();

	/**
	 *	Get the required ISecurePubClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ISecurePubClusterObj instance referenced by the Cluster key.
	 */
	ISecurePubClusterObj getRequiredContainerCluster( boolean forceRead );

	/**
	 *	Set the ISecurePubClusterObj instance referenced by the Cluster key.
	 *
	 *	@param	value	the ISecurePubClusterObj instance to be referenced by the Cluster key.
	 */
	void setRequiredContainerCluster( ISecurePubClusterObj value );

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
	 *	Get the required YCFDbKeyHash256 attribute ClusterId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute ClusterId.
	 */
	YCFDbKeyHash256 getRequiredClusterId();

	/**
	 *	Get the required String attribute TenantName.
	 *
	 *	@return	The required String attribute TenantName.
	 */
	String getRequiredTenantName();

	/**
	 *	Set the required String attribute TenantName.
	 *
	 *	@param value The required String attribute TenantName value to be applied.
	 */
	void setRequiredTenantName(String value);

	public void copyRecToOrig();
	public void copyOrigToRec();

}
