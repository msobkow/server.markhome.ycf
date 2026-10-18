// Description: Java 25 Public Instance Edit Object interface for CFBam Param.

/*
 *	server.markhome.mcf.CFBam
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal CFBam 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Mark's Code Fractal CFBam.
 *	
 *	Mark's Code Fractal CFBam is available under dual commercial license from
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
 *	Mark's Code Fractal CFBam is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFBam is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Mark's Code Fractal CFBam.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.mcf.v3_1.cfbam.cfbampubobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import org.apache.commons.text.StringEscapeUtils;

import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
import server.markhome.mcf.v3_1.cfbam.cfbampub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;

public interface ICFBamPubParamEditObj
	extends ICFBamPubParamObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFBamPubParamObj.
	 */
	ICFBamPubParamObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamPubParamObj.
	 */
	ICFBamPubParamObj getOrigAsParam();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFBamPubParamObj create();

	/*
	 *	Update the instance.
	 */
	ICFBamPubParamEditObj update();

	/*
	 *	Delete the instance.
	 */
	ICFBamPubParamEditObj deleteInstance();

	/**
	 *	Set the user who created this instance.
	 *
	 *	@param	value	The ICFSecPubSecUserObj instance who created this instance.
	 */
	void setCreatedBy( ICFSecPubSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was created.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setCreatedAt( LocalDateTime value );

	/**
	 *	Set the user who updated this instance.
	 *
	 *	@param	value	The ICFSecPubSecUserObj instance who updated this instance.
	 */
	void setUpdatedBy( ICFSecPubSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was updated.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setUpdatedAt( LocalDateTime value );

	/**
	 *	Get the ICFBamPubServerMethodObj instance referenced by the ServerMeth key.
	 *
	 *	@return	The ICFBamPubServerMethodObj instance referenced by the ServerMeth key.
	 */
	ICFBamPubServerMethodObj getRequiredContainerServerMeth();

	/**
	 *	Get the required ICFBamPubServerMethodObj instance referenced by the ServerMeth key.
	 *
	 *	@return	The required ICFBamPubServerMethodObj instance referenced by the ServerMeth key.
	 */
	ICFBamPubServerMethodObj getRequiredContainerServerMeth( boolean forceRead );

	/**
	 *	Set the ICFBamPubServerMethodObj instance referenced by the ServerMeth key.
	 *
	 *	@param	value	the ICFBamPubServerMethodObj instance to be referenced by the ServerMeth key.
	 */
	void setRequiredContainerServerMeth( ICFBamPubServerMethodObj value );

	/**
	 *	Get the ICFBamPubSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The ICFBamPubSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamPubSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional ICFBamPubSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional ICFBamPubSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamPubSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Set the ICFBamPubSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@param	value	the ICFBamPubSchemaDefObj instance to be referenced by the DefSchema key.
	 */
	void setOptionalLookupDefSchema( ICFBamPubSchemaDefObj value );

	/**
	 *	Get the ICFBamPubParamObj instance referenced by the Prev key.
	 *
	 *	@return	The ICFBamPubParamObj instance referenced by the Prev key.
	 */
	ICFBamPubParamObj getOptionalLookupPrev();

	/**
	 *	Get the optional ICFBamPubParamObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamPubParamObj instance referenced by the Prev key.
	 */
	ICFBamPubParamObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Set the ICFBamPubParamObj instance referenced by the Prev key.
	 *
	 *	@param	value	the ICFBamPubParamObj instance to be referenced by the Prev key.
	 */
	void setOptionalLookupPrev( ICFBamPubParamObj value );

	/**
	 *	Get the ICFBamPubParamObj instance referenced by the Next key.
	 *
	 *	@return	The ICFBamPubParamObj instance referenced by the Next key.
	 */
	ICFBamPubParamObj getOptionalLookupNext();

	/**
	 *	Get the optional ICFBamPubParamObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamPubParamObj instance referenced by the Next key.
	 */
	ICFBamPubParamObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Set the ICFBamPubParamObj instance referenced by the Next key.
	 *
	 *	@param	value	the ICFBamPubParamObj instance to be referenced by the Next key.
	 */
	void setOptionalLookupNext( ICFBamPubParamObj value );

	/**
	 *	Get the ICFBamPubValueObj instance referenced by the Type key.
	 *
	 *	@return	The ICFBamPubValueObj instance referenced by the Type key.
	 */
	ICFBamPubValueObj getRequiredLookupType();

	/**
	 *	Get the required ICFBamPubValueObj instance referenced by the Type key.
	 *
	 *	@return	The required ICFBamPubValueObj instance referenced by the Type key.
	 */
	ICFBamPubValueObj getRequiredLookupType( boolean forceRead );

	/**
	 *	Set the ICFBamPubValueObj instance referenced by the Type key.
	 *
	 *	@param	value	the ICFBamPubValueObj instance to be referenced by the Type key.
	 */
	void setRequiredLookupType( ICFBamPubValueObj value );

	/**
	 *	Get the required MCFDbKeyHash256 attribute ServerMethodId.
	 *
	 *	@return	The required MCFDbKeyHash256 attribute ServerMethodId.
	 */
	MCFDbKeyHash256 getRequiredServerMethodId();

	/**
	 *	Get the required MCFDbKeyHash256 attribute Id.
	 *
	 *	@return	The required MCFDbKeyHash256 attribute Id.
	 */
	MCFDbKeyHash256 getRequiredId();

	/**
	 *	Set the required MCFDbKeyHash256 attribute Id.
	 *
	 *	@param value The required MCFDbKeyHash256 attribute Id value to be applied.
	 */
	void setRequiredId(MCFDbKeyHash256 value);

	/**
	 *	Get the optional MCFDbKeyHash256 attribute DefSchemaId.
	 *
	 *	@return	The optional MCFDbKeyHash256 attribute DefSchemaId.
	 */
	MCFDbKeyHash256 getOptionalDefSchemaId();

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
	 *	Get the optional MCFDbKeyHash256 attribute TypeId.
	 *
	 *	@return	The optional MCFDbKeyHash256 attribute TypeId.
	 */
	MCFDbKeyHash256 getOptionalTypeId();

	/**
	 *	Get the optional MCFDbKeyHash256 attribute PrevId.
	 *
	 *	@return	The optional MCFDbKeyHash256 attribute PrevId.
	 */
	MCFDbKeyHash256 getOptionalPrevId();

	/**
	 *	Get the optional MCFDbKeyHash256 attribute NextId.
	 *
	 *	@return	The optional MCFDbKeyHash256 attribute NextId.
	 */
	MCFDbKeyHash256 getOptionalNextId();

	public void copyRecToOrig();
	public void copyOrigToRec();

}
