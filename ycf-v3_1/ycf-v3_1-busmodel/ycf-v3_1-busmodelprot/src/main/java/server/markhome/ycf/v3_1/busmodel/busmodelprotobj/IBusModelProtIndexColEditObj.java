// Description: Java 25 Protected Instance Edit Object interface for BusModel IndexCol.

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

package server.markhome.ycf.v3_1.busmodel.busmodelprotobj;

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
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;

public interface IBusModelProtIndexColEditObj
	extends IBusModelProtIndexColObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base IBusModelProtIndexColObj.
	 */
	IBusModelProtIndexColObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a IBusModelProtIndexColObj.
	 */
	IBusModelProtIndexColObj getOrigAsIndexCol();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	IBusModelProtIndexColObj create();

	/*
	 *	Update the instance.
	 */
	IBusModelProtIndexColEditObj update();

	/*
	 *	Delete the instance.
	 */
	IBusModelProtIndexColEditObj deleteInstance();

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
	 *	Get the IBusModelProtIndexObj instance referenced by the Index key.
	 *
	 *	@return	The IBusModelProtIndexObj instance referenced by the Index key.
	 */
	IBusModelProtIndexObj getRequiredContainerIndex();

	/**
	 *	Get the required IBusModelProtIndexObj instance referenced by the Index key.
	 *
	 *	@return	The required IBusModelProtIndexObj instance referenced by the Index key.
	 */
	IBusModelProtIndexObj getRequiredContainerIndex( boolean forceRead );

	/**
	 *	Set the IBusModelProtIndexObj instance referenced by the Index key.
	 *
	 *	@param	value	the IBusModelProtIndexObj instance to be referenced by the Index key.
	 */
	void setRequiredContainerIndex( IBusModelProtIndexObj value );

	/**
	 *	Get the IBusModelProtSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The IBusModelProtSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelProtSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional IBusModelProtSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional IBusModelProtSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelProtSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Set the IBusModelProtSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@param	value	the IBusModelProtSchemaDefObj instance to be referenced by the DefSchema key.
	 */
	void setOptionalLookupDefSchema( IBusModelProtSchemaDefObj value );

	/**
	 *	Get a list IBusModelProtRelationColObj instances referenced by the RefRelFromCol key.
	 *
	 *	@return	The (potentially empty) list of IBusModelProtRelationColObj instances referenced by the RefRelFromCol key.
	 */
	List<IBusModelProtRelationColObj> getOptionalChildrenRefRelFromCol();

	/**
	 *	Get a list IBusModelProtRelationColObj instances referenced by the RefRelToCol key.
	 *
	 *	@return	The (potentially empty) list of IBusModelProtRelationColObj instances referenced by the RefRelToCol key.
	 */
	List<IBusModelProtRelationColObj> getOptionalChildrenRefRelToCol();

	/**
	 *	Get the IBusModelProtIndexColObj instance referenced by the Prev key.
	 *
	 *	@return	The IBusModelProtIndexColObj instance referenced by the Prev key.
	 */
	IBusModelProtIndexColObj getOptionalLookupPrev();

	/**
	 *	Get the optional IBusModelProtIndexColObj instance referenced by the Prev key.
	 *
	 *	@return	The optional IBusModelProtIndexColObj instance referenced by the Prev key.
	 */
	IBusModelProtIndexColObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Set the IBusModelProtIndexColObj instance referenced by the Prev key.
	 *
	 *	@param	value	the IBusModelProtIndexColObj instance to be referenced by the Prev key.
	 */
	void setOptionalLookupPrev( IBusModelProtIndexColObj value );

	/**
	 *	Get the IBusModelProtIndexColObj instance referenced by the Next key.
	 *
	 *	@return	The IBusModelProtIndexColObj instance referenced by the Next key.
	 */
	IBusModelProtIndexColObj getOptionalLookupNext();

	/**
	 *	Get the optional IBusModelProtIndexColObj instance referenced by the Next key.
	 *
	 *	@return	The optional IBusModelProtIndexColObj instance referenced by the Next key.
	 */
	IBusModelProtIndexColObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Set the IBusModelProtIndexColObj instance referenced by the Next key.
	 *
	 *	@param	value	the IBusModelProtIndexColObj instance to be referenced by the Next key.
	 */
	void setOptionalLookupNext( IBusModelProtIndexColObj value );

	/**
	 *	Get the IBusModelProtValueObj instance referenced by the Column key.
	 *
	 *	@return	The IBusModelProtValueObj instance referenced by the Column key.
	 */
	IBusModelProtValueObj getRequiredLookupColumn();

	/**
	 *	Get the required IBusModelProtValueObj instance referenced by the Column key.
	 *
	 *	@return	The required IBusModelProtValueObj instance referenced by the Column key.
	 */
	IBusModelProtValueObj getRequiredLookupColumn( boolean forceRead );

	/**
	 *	Set the IBusModelProtValueObj instance referenced by the Column key.
	 *
	 *	@param	value	the IBusModelProtValueObj instance to be referenced by the Column key.
	 */
	void setRequiredLookupColumn( IBusModelProtValueObj value );

	/**
	 *	Get the required IYCFKeyHash256 attribute IndexId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute IndexId.
	 */
	IYCFKeyHash256 getRequiredIndexId();

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
	 *	Get the optional YCFDbKeyHash256 attribute DefSchemaId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute DefSchemaId.
	 */
	YCFDbKeyHash256 getOptionalDefSchemaId();

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
	 *	Get the optional String attribute ShortName.
	 *
	 *	@return	The optional String attribute ShortName.
	 */
	String getOptionalShortName();

	/**
	 *	Set the optional String attribute ShortName.
	 *
	 *	@param value The optional String attribute ShortName value to be applied.
	 */
	void setOptionalShortName(String value);

	/**
	 *	Get the optional String attribute Label.
	 *
	 *	@return	The optional String attribute Label.
	 */
	String getOptionalLabel();

	/**
	 *	Set the optional String attribute Label.
	 *
	 *	@param value The optional String attribute Label value to be applied.
	 */
	void setOptionalLabel(String value);

	/**
	 *	Get the optional String attribute ShortDescription.
	 *
	 *	@return	The optional String attribute ShortDescription.
	 */
	String getOptionalShortDescription();

	/**
	 *	Set the optional String attribute ShortDescription.
	 *
	 *	@param value The optional String attribute ShortDescription value to be applied.
	 */
	void setOptionalShortDescription(String value);

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
	 *	Get the required IYCFKeyHash256 attribute ColumnId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute ColumnId.
	 */
	IYCFKeyHash256 getRequiredColumnId();

	/**
	 *	Get the required boolean attribute IsAscending.
	 *
	 *	@return	The required boolean attribute IsAscending.
	 */
	boolean getRequiredIsAscending();

	/**
	 *	Set the required boolean attribute IsAscending.
	 *
	 *	@param value The required boolean attribute IsAscending value to be applied.
	 */
	void setRequiredIsAscending(boolean value);

	/**
	 *	Get the optional YCFDbKeyHash256 attribute PrevId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute PrevId.
	 */
	YCFDbKeyHash256 getOptionalPrevId();

	/**
	 *	Get the optional YCFDbKeyHash256 attribute NextId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute NextId.
	 */
	YCFDbKeyHash256 getOptionalNextId();

	public void copyRecToOrig();
	public void copyOrigToRec();

}
