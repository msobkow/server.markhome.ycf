// Description: Java 25 Public Instance Edit Object interface for CFBam EnumTag.

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

public interface ICFBamPubEnumTagEditObj
	extends ICFBamPubEnumTagObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFBamPubEnumTagObj.
	 */
	ICFBamPubEnumTagObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamPubEnumTagObj.
	 */
	ICFBamPubEnumTagObj getOrigAsEnumTag();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFBamPubEnumTagObj create();

	/*
	 *	Update the instance.
	 */
	ICFBamPubEnumTagEditObj update();

	/*
	 *	Delete the instance.
	 */
	ICFBamPubEnumTagEditObj deleteInstance();

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
	 *	Get the ICFBamPubEnumDefObj instance referenced by the EnumDef key.
	 *
	 *	@return	The ICFBamPubEnumDefObj instance referenced by the EnumDef key.
	 */
	ICFBamPubEnumDefObj getRequiredContainerEnumDef();

	/**
	 *	Get the required ICFBamPubEnumDefObj instance referenced by the EnumDef key.
	 *
	 *	@return	The required ICFBamPubEnumDefObj instance referenced by the EnumDef key.
	 */
	ICFBamPubEnumDefObj getRequiredContainerEnumDef( boolean forceRead );

	/**
	 *	Set the ICFBamPubEnumDefObj instance referenced by the EnumDef key.
	 *
	 *	@param	value	the ICFBamPubEnumDefObj instance to be referenced by the EnumDef key.
	 */
	void setRequiredContainerEnumDef( ICFBamPubEnumDefObj value );

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
	 *	Get the ICFBamPubEnumTagObj instance referenced by the Prev key.
	 *
	 *	@return	The ICFBamPubEnumTagObj instance referenced by the Prev key.
	 */
	ICFBamPubEnumTagObj getOptionalLookupPrev();

	/**
	 *	Get the optional ICFBamPubEnumTagObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamPubEnumTagObj instance referenced by the Prev key.
	 */
	ICFBamPubEnumTagObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Set the ICFBamPubEnumTagObj instance referenced by the Prev key.
	 *
	 *	@param	value	the ICFBamPubEnumTagObj instance to be referenced by the Prev key.
	 */
	void setOptionalLookupPrev( ICFBamPubEnumTagObj value );

	/**
	 *	Get the ICFBamPubEnumTagObj instance referenced by the Next key.
	 *
	 *	@return	The ICFBamPubEnumTagObj instance referenced by the Next key.
	 */
	ICFBamPubEnumTagObj getOptionalLookupNext();

	/**
	 *	Get the optional ICFBamPubEnumTagObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamPubEnumTagObj instance referenced by the Next key.
	 */
	ICFBamPubEnumTagObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Set the ICFBamPubEnumTagObj instance referenced by the Next key.
	 *
	 *	@param	value	the ICFBamPubEnumTagObj instance to be referenced by the Next key.
	 */
	void setOptionalLookupNext( ICFBamPubEnumTagObj value );

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
	 *	Get the required MCFDbKeyHash256 attribute EnumId.
	 *
	 *	@return	The required MCFDbKeyHash256 attribute EnumId.
	 */
	MCFDbKeyHash256 getRequiredEnumId();

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
