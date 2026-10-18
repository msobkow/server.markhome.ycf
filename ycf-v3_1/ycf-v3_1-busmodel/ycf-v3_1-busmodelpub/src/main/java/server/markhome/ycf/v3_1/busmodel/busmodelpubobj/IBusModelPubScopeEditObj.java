// Description: Java 25 Public Instance Edit Object interface for BusModel Scope.

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

package server.markhome.ycf.v3_1.busmodel.busmodelpubobj;

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
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

public interface IBusModelPubScopeEditObj
	extends IBusModelPubScopeObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base IBusModelPubScopeObj.
	 */
	IBusModelPubScopeObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a IBusModelPubScopeObj.
	 */
	IBusModelPubScopeObj getOrigAsScope();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	IBusModelPubScopeObj create();

	/*
	 *	Update the instance.
	 */
	IBusModelPubScopeEditObj update();

	/*
	 *	Delete the instance.
	 */
	IBusModelPubScopeEditObj deleteInstance();

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
	ISecurePubTenantObj getRequiredOwnerTenant();

	/**
	 *	Get the required ISecurePubTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ISecurePubTenantObj instance referenced by the Tenant key.
	 */
	ISecurePubTenantObj getRequiredOwnerTenant( boolean forceRead );

	/**
	 *	Set the ISecurePubTenantObj instance referenced by the Tenant key.
	 *
	 *	@param	value	the ISecurePubTenantObj instance to be referenced by the Tenant key.
	 */
	void setRequiredOwnerTenant( ISecurePubTenantObj value );

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

	public void copyRecToOrig();
	public void copyOrigToRec();

}
