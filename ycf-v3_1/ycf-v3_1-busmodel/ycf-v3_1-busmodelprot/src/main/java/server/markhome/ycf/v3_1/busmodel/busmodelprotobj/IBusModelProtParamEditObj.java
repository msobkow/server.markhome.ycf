// Description: Java 25 Protected Instance Edit Object interface for BusModel Param.

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

public interface IBusModelProtParamEditObj
	extends IBusModelProtParamObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base IBusModelProtParamObj.
	 */
	IBusModelProtParamObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a IBusModelProtParamObj.
	 */
	IBusModelProtParamObj getOrigAsParam();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	IBusModelProtParamObj create();

	/*
	 *	Update the instance.
	 */
	IBusModelProtParamEditObj update();

	/*
	 *	Delete the instance.
	 */
	IBusModelProtParamEditObj deleteInstance();

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
	 *	Get the IBusModelProtServerMethodObj instance referenced by the ServerMeth key.
	 *
	 *	@return	The IBusModelProtServerMethodObj instance referenced by the ServerMeth key.
	 */
	IBusModelProtServerMethodObj getRequiredContainerServerMeth();

	/**
	 *	Get the required IBusModelProtServerMethodObj instance referenced by the ServerMeth key.
	 *
	 *	@return	The required IBusModelProtServerMethodObj instance referenced by the ServerMeth key.
	 */
	IBusModelProtServerMethodObj getRequiredContainerServerMeth( boolean forceRead );

	/**
	 *	Set the IBusModelProtServerMethodObj instance referenced by the ServerMeth key.
	 *
	 *	@param	value	the IBusModelProtServerMethodObj instance to be referenced by the ServerMeth key.
	 */
	void setRequiredContainerServerMeth( IBusModelProtServerMethodObj value );

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
	 *	Get the IBusModelProtParamObj instance referenced by the Prev key.
	 *
	 *	@return	The IBusModelProtParamObj instance referenced by the Prev key.
	 */
	IBusModelProtParamObj getOptionalLookupPrev();

	/**
	 *	Get the optional IBusModelProtParamObj instance referenced by the Prev key.
	 *
	 *	@return	The optional IBusModelProtParamObj instance referenced by the Prev key.
	 */
	IBusModelProtParamObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Set the IBusModelProtParamObj instance referenced by the Prev key.
	 *
	 *	@param	value	the IBusModelProtParamObj instance to be referenced by the Prev key.
	 */
	void setOptionalLookupPrev( IBusModelProtParamObj value );

	/**
	 *	Get the IBusModelProtParamObj instance referenced by the Next key.
	 *
	 *	@return	The IBusModelProtParamObj instance referenced by the Next key.
	 */
	IBusModelProtParamObj getOptionalLookupNext();

	/**
	 *	Get the optional IBusModelProtParamObj instance referenced by the Next key.
	 *
	 *	@return	The optional IBusModelProtParamObj instance referenced by the Next key.
	 */
	IBusModelProtParamObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Set the IBusModelProtParamObj instance referenced by the Next key.
	 *
	 *	@param	value	the IBusModelProtParamObj instance to be referenced by the Next key.
	 */
	void setOptionalLookupNext( IBusModelProtParamObj value );

	/**
	 *	Get the IBusModelProtValueObj instance referenced by the Type key.
	 *
	 *	@return	The IBusModelProtValueObj instance referenced by the Type key.
	 */
	IBusModelProtValueObj getRequiredLookupType();

	/**
	 *	Get the required IBusModelProtValueObj instance referenced by the Type key.
	 *
	 *	@return	The required IBusModelProtValueObj instance referenced by the Type key.
	 */
	IBusModelProtValueObj getRequiredLookupType( boolean forceRead );

	/**
	 *	Set the IBusModelProtValueObj instance referenced by the Type key.
	 *
	 *	@param	value	the IBusModelProtValueObj instance to be referenced by the Type key.
	 */
	void setRequiredLookupType( IBusModelProtValueObj value );

	/**
	 *	Get the required IYCFKeyHash256 attribute ServerMethodId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute ServerMethodId.
	 */
	IYCFKeyHash256 getRequiredServerMethodId();

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
	 *	Get the required boolean attribute IsNullable.
	 *
	 *	@return	The required boolean attribute IsNullable.
	 */
	boolean getRequiredIsNullable();

	/**
	 *	Set the required boolean attribute IsNullable.
	 *
	 *	@param value The required boolean attribute IsNullable value to be applied.
	 */
	void setRequiredIsNullable(boolean value);

	/**
	 *	Get the optional YCFDbKeyHash256 attribute TypeId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute TypeId.
	 */
	YCFDbKeyHash256 getOptionalTypeId();

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
