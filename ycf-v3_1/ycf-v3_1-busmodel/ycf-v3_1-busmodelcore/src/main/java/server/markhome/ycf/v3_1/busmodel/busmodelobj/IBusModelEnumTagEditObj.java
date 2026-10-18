// Description: Java 25 Instance Edit Object interface for BusModel EnumTag.

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

package server.markhome.ycf.v3_1.busmodel.busmodelobj;

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
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public interface IBusModelEnumTagEditObj
	extends IBusModelEnumTagObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base IBusModelEnumTagObj.
	 */
	IBusModelEnumTagObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a IBusModelEnumTagObj.
	 */
	IBusModelEnumTagObj getOrigAsEnumTag();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	IBusModelEnumTagObj create();

	/*
	 *	Update the instance.
	 */
	BusModelEnumTagEditObj update();

	/*
	 *	Delete the instance.
	 */
	BusModelEnumTagEditObj deleteInstance();

	/**
	 *	Set the user who created this instance.
	 *
	 *	@param	value	The ISecureSecUserObj instance who created this instance.
	 */
	void setCreatedBy( ISecureSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was created.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setCreatedAt( LocalDateTime value );

	/**
	 *	Set the user who updated this instance.
	 *
	 *	@param	value	The ISecureSecUserObj instance who updated this instance.
	 */
	void setUpdatedBy( ISecureSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was updated.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setUpdatedAt( LocalDateTime value );

	/**
	 *	Get the IBusModelEnumDefObj instance referenced by the EnumDef key.
	 *
	 *	@return	The IBusModelEnumDefObj instance referenced by the EnumDef key.
	 */
	IBusModelEnumDefObj getRequiredContainerEnumDef();

	/**
	 *	Get the required IBusModelEnumDefObj instance referenced by the EnumDef key.
	 *
	 *	@return	The required IBusModelEnumDefObj instance referenced by the EnumDef key.
	 */
	IBusModelEnumDefObj getRequiredContainerEnumDef( boolean forceRead );

	/**
	 *	Set the IBusModelEnumDefObj instance referenced by the EnumDef key.
	 *
	 *	@param	value	the IBusModelEnumDefObj instance to be referenced by the EnumDef key.
	 */
	void setRequiredContainerEnumDef( IBusModelEnumDefObj value );

	/**
	 *	Get the IBusModelSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The IBusModelSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional IBusModelSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional IBusModelSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Set the IBusModelSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@param	value	the IBusModelSchemaDefObj instance to be referenced by the DefSchema key.
	 */
	void setOptionalLookupDefSchema( IBusModelSchemaDefObj value );

	/**
	 *	Get the IBusModelEnumTagObj instance referenced by the Prev key.
	 *
	 *	@return	The IBusModelEnumTagObj instance referenced by the Prev key.
	 */
	IBusModelEnumTagObj getOptionalLookupPrev();

	/**
	 *	Get the optional IBusModelEnumTagObj instance referenced by the Prev key.
	 *
	 *	@return	The optional IBusModelEnumTagObj instance referenced by the Prev key.
	 */
	IBusModelEnumTagObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Set the IBusModelEnumTagObj instance referenced by the Prev key.
	 *
	 *	@param	value	the IBusModelEnumTagObj instance to be referenced by the Prev key.
	 */
	void setOptionalLookupPrev( IBusModelEnumTagObj value );

	/**
	 *	Get the IBusModelEnumTagObj instance referenced by the Next key.
	 *
	 *	@return	The IBusModelEnumTagObj instance referenced by the Next key.
	 */
	IBusModelEnumTagObj getOptionalLookupNext();

	/**
	 *	Get the optional IBusModelEnumTagObj instance referenced by the Next key.
	 *
	 *	@return	The optional IBusModelEnumTagObj instance referenced by the Next key.
	 */
	IBusModelEnumTagObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Set the IBusModelEnumTagObj instance referenced by the Next key.
	 *
	 *	@param	value	the IBusModelEnumTagObj instance to be referenced by the Next key.
	 */
	void setOptionalLookupNext( IBusModelEnumTagObj value );

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
	 *	Get the optional IYCFKeyHash256 attribute DefSchemaId.
	 *
	 *	@return	The optional IYCFKeyHash256 attribute DefSchemaId.
	 */
	IYCFKeyHash256 getOptionalDefSchemaId();

	/**
	 *	Get the required IYCFKeyHash256 attribute EnumId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute EnumId.
	 */
	IYCFKeyHash256 getRequiredEnumId();

	/**
	 *	Get the optional Short attribute EnumCode.
	 *
	 *	@return	The optional Short attribute EnumCode.
	 */
	Short getOptionalEnumCode();

	/**
	 *	Set the optional Short attribute EnumCode.
	 *
	 *	@param value The optional Short attribute EnumCode value to be applied.
	 */
	void setOptionalEnumCode(Short value);

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
	 *	Get the optional IYCFKeyHash256 attribute PrevId.
	 *
	 *	@return	The optional IYCFKeyHash256 attribute PrevId.
	 */
	IYCFKeyHash256 getOptionalPrevId();

	/**
	 *	Get the optional IYCFKeyHash256 attribute NextId.
	 *
	 *	@return	The optional IYCFKeyHash256 attribute NextId.
	 */
	IYCFKeyHash256 getOptionalNextId();

	public void copyRecToOrig();
	public void copyOrigToRec();

}
