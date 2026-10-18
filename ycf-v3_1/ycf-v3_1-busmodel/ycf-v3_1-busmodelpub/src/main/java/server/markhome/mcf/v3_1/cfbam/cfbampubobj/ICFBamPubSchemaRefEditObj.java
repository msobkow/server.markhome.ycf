// Description: Java 25 Public Instance Edit Object interface for CFBam SchemaRef.

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

public interface ICFBamPubSchemaRefEditObj
	extends ICFBamPubSchemaRefObj, ICFBamPubScopeEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamPubSchemaRefObj.
	 */
	ICFBamPubSchemaRefObj getOrigAsSchemaRef();

	/**
	 *	Get the ICFBamPubSchemaDefObj instance referenced by the Schema key.
	 *
	 *	@return	The ICFBamPubSchemaDefObj instance referenced by the Schema key.
	 */
	ICFBamPubSchemaDefObj getRequiredContainerSchema();

	/**
	 *	Get the required ICFBamPubSchemaDefObj instance referenced by the Schema key.
	 *
	 *	@return	The required ICFBamPubSchemaDefObj instance referenced by the Schema key.
	 */
	ICFBamPubSchemaDefObj getRequiredContainerSchema( boolean forceRead );

	/**
	 *	Set the ICFBamPubSchemaDefObj instance referenced by the Schema key.
	 *
	 *	@param	value	the ICFBamPubSchemaDefObj instance to be referenced by the Schema key.
	 */
	void setRequiredContainerSchema( ICFBamPubSchemaDefObj value );

	/**
	 *	Get the ICFBamPubSchemaDefObj instance referenced by the RefSchema key.
	 *
	 *	@return	The ICFBamPubSchemaDefObj instance referenced by the RefSchema key.
	 */
	ICFBamPubSchemaDefObj getOptionalLookupRefSchema();

	/**
	 *	Get the optional ICFBamPubSchemaDefObj instance referenced by the RefSchema key.
	 *
	 *	@return	The optional ICFBamPubSchemaDefObj instance referenced by the RefSchema key.
	 */
	ICFBamPubSchemaDefObj getOptionalLookupRefSchema( boolean forceRead );

	/**
	 *	Set the ICFBamPubSchemaDefObj instance referenced by the RefSchema key.
	 *
	 *	@param	value	the ICFBamPubSchemaDefObj instance to be referenced by the RefSchema key.
	 */
	void setOptionalLookupRefSchema( ICFBamPubSchemaDefObj value );

	/**
	 *	Get the ICFBamPubSchemaRefObj instance referenced by the Prev key.
	 *
	 *	@return	The ICFBamPubSchemaRefObj instance referenced by the Prev key.
	 */
	ICFBamPubSchemaRefObj getOptionalLookupPrev();

	/**
	 *	Get the optional ICFBamPubSchemaRefObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamPubSchemaRefObj instance referenced by the Prev key.
	 */
	ICFBamPubSchemaRefObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Set the ICFBamPubSchemaRefObj instance referenced by the Prev key.
	 *
	 *	@param	value	the ICFBamPubSchemaRefObj instance to be referenced by the Prev key.
	 */
	void setOptionalLookupPrev( ICFBamPubSchemaRefObj value );

	/**
	 *	Get the ICFBamPubSchemaRefObj instance referenced by the Next key.
	 *
	 *	@return	The ICFBamPubSchemaRefObj instance referenced by the Next key.
	 */
	ICFBamPubSchemaRefObj getOptionalLookupNext();

	/**
	 *	Get the optional ICFBamPubSchemaRefObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamPubSchemaRefObj instance referenced by the Next key.
	 */
	ICFBamPubSchemaRefObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Set the ICFBamPubSchemaRefObj instance referenced by the Next key.
	 *
	 *	@param	value	the ICFBamPubSchemaRefObj instance to be referenced by the Next key.
	 */
	void setOptionalLookupNext( ICFBamPubSchemaRefObj value );

	/**
	 *	Get the required MCFDbKeyHash256 attribute SchemaId.
	 *
	 *	@return	The required MCFDbKeyHash256 attribute SchemaId.
	 */
	MCFDbKeyHash256 getRequiredSchemaId();

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
	 *	Get the required String attribute RefModelName.
	 *
	 *	@return	The required String attribute RefModelName.
	 */
	String getRequiredRefModelName();

	/**
	 *	Set the required String attribute RefModelName.
	 *
	 *	@param value The required String attribute RefModelName value to be applied.
	 */
	void setRequiredRefModelName(String value);

	/**
	 *	Get the required String attribute IncludeRoot.
	 *
	 *	@return	The required String attribute IncludeRoot.
	 */
	String getRequiredIncludeRoot();

	/**
	 *	Set the required String attribute IncludeRoot.
	 *
	 *	@param value The required String attribute IncludeRoot value to be applied.
	 */
	void setRequiredIncludeRoot(String value);

	/**
	 *	Get the optional MCFDbKeyHash256 attribute RefSchemaId.
	 *
	 *	@return	The optional MCFDbKeyHash256 attribute RefSchemaId.
	 */
	MCFDbKeyHash256 getOptionalRefSchemaId();

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

}
