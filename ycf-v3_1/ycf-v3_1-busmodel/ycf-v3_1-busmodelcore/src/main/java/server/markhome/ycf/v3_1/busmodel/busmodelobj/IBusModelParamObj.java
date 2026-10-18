// Description: Java 25 Object interface for BusModel Param.

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public interface IBusModelParamObj
	extends IYCFAnyObj
{
	/**
	 *	Initially, the class code for an object is IBusModelParam.CLASS_CODE, but the Obj layer relies on class code translation to map those
	 *	backing store entities to a runtime set of front-facing classcodes that the clients download and use when talking to the server implementing this code base.
	 *
	 *	@return The runtime class code used by this object. Only after the system is fully booted are these values stable and reliable.
	 */
	int getClassCode();
	/**
	 *	Get the user who created this instance.
	 *
	 *	@return	The ISecureSecUserObj instance who created this instance.
	 */
	ISecureSecUserObj getCreatedBy();

	/**
	 *	Get the LocalDateTime this instance was created.
	 *
	 *	@return	The LocalDateTime value for the creation time of the instance.
	 */
	LocalDateTime getCreatedAt();

	/**
	 *	Get the user who updated this instance.
	 *
	 *	@return	The ISecureSecUserObj instance who updated this instance.
	 */
	ISecureSecUserObj getUpdatedBy();

	/**
	 *	Get the LocalDateTime date-time this instance was updated.
	 *
	 *	@return	The LocalDateTime value for the create time of the instance.
	 */
	LocalDateTime getUpdatedAt();
	/**
	 *	Realise this instance of a Param.
	 *
	 *	@return	BusModelParamObj instance which should be subsequently referenced.
	 */
	IBusModelParamObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	IBusModelParamObj the reference to the cached or read (realised) instance.
	 */
	IBusModelParamObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	IBusModelParamObj the reference to the cached or read (realised) instance.
	 */
	IBusModelParamObj read( boolean forceRead );

	/**
	 *	Move this object up in the chain and refresh the cache.
	 *
	 *	@return	IBusModelParamObj the reference to the moved and refreshed instance.
	 */
	IBusModelParamObj moveUp();

	/**
	 *	Move this object down in the chain and refresh the cache.
	 *
	 *	@return	IBusModelParamObj the reference to the moved and refreshed instance.
	 */
	IBusModelParamObj moveDown();

	/**
	 *	Initialize and return a locked edition of this Param instance.
	 *
	 *	@return	The newly locked IBusModelParamEditObj edition of this instance.
	 */
	IBusModelParamEditObj beginEdit();

	/**
	 *	End this edition of this Param instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this Param instance.
	 *
	 *	@return	The IBusModelParamEditObj edition of this instance.
	 */
	IBusModelParamEditObj getEdit();

	/**
	 *	Get the current edition of this Param instance as a IBusModelParamEditObj.
	 *
	 *	@return	The IBusModelParamEditObj edition of this instance.
	 */
	IBusModelParamEditObj getEditAsParam();

	/**
	 *	Get the IBusModelParamTableObj table cache which manages this instance.
	 *
	 *	@return	IBusModelParamTableObj table cache which manages this instance.
	 */
	IBusModelParamTableObj getParamTable();

	/**
	 *	Get the IBusModelSchemaObj schema cache which manages this instance.
	 *
	 *	@return	IBusModelSchemaObj schema cache which manages this instance.
	 */
	IBusModelSchemaObj getSchema();

	/**
	 *	Set the IBusModelSchemaObj schema cache which manages this instance.
	 *	Should only be used to install overloads of the buff implementation wired specifically to a transport implementation
	 *	that eventually hits a server running a JPA backend.
	 *
	 *	@param schema	IBusModelSchemaObj schema cache which manages this instance.
	 */
	void setSchema(IBusModelSchemaObj schema);

	/**
	 *	Get the IBusModelParam instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IBusModelParam instance which currently backs this object.
	 */
	IBusModelParam getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( IBusModelParam value );

	/**
	 *	Get the IBusModelParam instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IBusModelParam instance which currently backs this object.
	 */
	IBusModelParam getParamRec();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	$implCommaIJavaOptAtomType$ primary key for this instance.
	 */
	$implCommaIJavaOptAtomType$ getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param $implCommaIJavaOptAtomType$ primary key value for this instance.
	 */
	void setPKey( $implCommaIJavaOptAtomType$ value );

	/**
	 *	Is this a new instance?
	 *
	 *	@return	True if this is a new instance, otherwise false if it has
	 *		been read, locked, or created.
	 */
	boolean getIsNew();

	/**
	 *	Indicate whether this is a new instance.
	 *	<p>
	 *	This method should only be used by implementation internals.
	 *
	 *	@param	True if this is a new instance, otherwise false.
	 */
	void setIsNew( boolean value );

	/**
	 *	Get the required IBusModelServerMethodObj instance referenced by the ServerMeth key.
	 *
	 *	@return	The required IBusModelServerMethodObj instance referenced by the ServerMeth key.
	 */
	IBusModelServerMethodObj getRequiredContainerServerMeth();

	/**
	 *	Get the required IBusModelServerMethodObj instance referenced by the ServerMeth key.
	 *
	 *	@return	The required IBusModelServerMethodObj instance referenced by the ServerMeth key.
	 */
	IBusModelServerMethodObj getRequiredContainerServerMeth( boolean forceRead );

	/**
	 *	Get the optional IBusModelSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional IBusModelSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional IBusModelSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional IBusModelSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Get the optional IBusModelParamObj instance referenced by the Prev key.
	 *
	 *	@return	The optional IBusModelParamObj instance referenced by the Prev key.
	 */
	IBusModelParamObj getOptionalLookupPrev();

	/**
	 *	Get the optional IBusModelParamObj instance referenced by the Prev key.
	 *
	 *	@return	The optional IBusModelParamObj instance referenced by the Prev key.
	 */
	IBusModelParamObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Get the optional IBusModelParamObj instance referenced by the Next key.
	 *
	 *	@return	The optional IBusModelParamObj instance referenced by the Next key.
	 */
	IBusModelParamObj getOptionalLookupNext();

	/**
	 *	Get the optional IBusModelParamObj instance referenced by the Next key.
	 *
	 *	@return	The optional IBusModelParamObj instance referenced by the Next key.
	 */
	IBusModelParamObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Get the required IBusModelValueObj instance referenced by the Type key.
	 *
	 *	@return	The required IBusModelValueObj instance referenced by the Type key.
	 */
	IBusModelValueObj getRequiredLookupType();

	/**
	 *	Get the required IBusModelValueObj instance referenced by the Type key.
	 *
	 *	@return	The required IBusModelValueObj instance referenced by the Type key.
	 */
	IBusModelValueObj getRequiredLookupType( boolean forceRead );

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
	 *	Get the optional IYCFKeyHash256 attribute DefSchemaId.
	 *
	 *	@return	The optional IYCFKeyHash256 attribute DefSchemaId.
	 */
	IYCFKeyHash256 getOptionalDefSchemaId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the optional String attribute ShortDescription.
	 *
	 *	@return	The optional String attribute ShortDescription.
	 */
	String getOptionalShortDescription();

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The optional String attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Get the required boolean attribute IsNullable.
	 *
	 *	@return	The required boolean attribute IsNullable.
	 */
	boolean getRequiredIsNullable();

	/**
	 *	Get the optional IYCFKeyHash256 attribute TypeId.
	 *
	 *	@return	The optional IYCFKeyHash256 attribute TypeId.
	 */
	IYCFKeyHash256 getOptionalTypeId();

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

	/**
	 *	Internal use only.
	 */
	void copyPKeyToRec();

	/**
	 *	Internal use only.
	 */
	void copyRecToPKey();

}
