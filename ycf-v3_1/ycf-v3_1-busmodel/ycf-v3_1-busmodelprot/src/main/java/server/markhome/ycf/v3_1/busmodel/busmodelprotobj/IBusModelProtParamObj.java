// Description: Java 25 Object interface for BusModelProt Param.

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

public interface IBusModelProtParamObj
	extends IYCFAnyObj
{
	/**
	 *	Initially, the class code for an object is IBusModelProtParam.CLASS_CODE, but the Obj layer relies on class code translation to map those
	 *	backing store entities to a runtime set of front-facing classcodes that the clients download and use when talking to the server implementing this code base.
	 *
	 *	@return The runtime class code used by this object. Only after the system is fully booted are these values stable and reliable.
	 */
	int getClassCode();
	/**
	 *	Get the user who created this instance.
	 *
	 *	@return	The ISecurePubSecUserObj instance who created this instance.
	 */
	ISecurePubSecUserObj getCreatedBy();

	/**
	 *	Get the LocalDateTime this instance was created.
	 *
	 *	@return	The LocalDateTime value for the creation time of the instance.
	 */
	LocalDateTime getCreatedAt();

	/**
	 *	Get the user who updated this instance.
	 *
	 *	@return	The ISecurePubSecUserObj instance who updated this instance.
	 */
	ISecurePubSecUserObj getUpdatedBy();

	/**
	 *	Get the LocalDateTime date-time this instance was updated.
	 *
	 *	@return	The LocalDateTime value for the create time of the instance.
	 */
	LocalDateTime getUpdatedAt();
	/**
	 *	Realise this instance of a Param.
	 *
	 *	@return	BusModelProtParamObj instance which should be subsequently referenced.
	 */
	IBusModelProtParamObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	IBusModelProtParamObj the reference to the cached or read (realised) instance.
	 */
	IBusModelProtParamObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	IBusModelProtParamObj the reference to the cached or read (realised) instance.
	 */
	IBusModelProtParamObj read( boolean forceRead );

	/**
	 *	Move this object up in the chain and refresh the cache.
	 *
	 *	@return	IBusModelProtParamObj the reference to the moved and refreshed instance.
	 */
	IBusModelProtParamObj moveUp();

	/**
	 *	Move this object down in the chain and refresh the cache.
	 *
	 *	@return	IBusModelProtParamObj the reference to the moved and refreshed instance.
	 */
	IBusModelProtParamObj moveDown();

	/**
	 *	Initialize and return a locked edition of this Param instance.
	 *
	 *	@return	The newly locked IBusModelProtParamEditObj edition of this instance.
	 */
	IBusModelProtParamEditObj beginEdit();

	/**
	 *	End this edition of this Param instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this Param instance.
	 *
	 *	@return	The IBusModelProtParamEditObj edition of this instance.
	 */
	IBusModelProtParamEditObj getEdit();

	/**
	 *	Get the current edition of this Param instance as a IBusModelProtParamEditObj.
	 *
	 *	@return	The IBusModelProtParamEditObj edition of this instance.
	 */
	IBusModelProtParamEditObj getEditAsParam();

	/**
	 *	Get the IBusModelProtParamTableObj table cache which manages this instance.
	 *
	 *	@return	IBusModelProtParamTableObj table cache which manages this instance.
	 */
	IBusModelProtParamTableObj getParamTable();

	/**
	 *	Get the IBusModelProtSchemaObj schema cache which manages this instance.
	 *
	 *	@return	IBusModelProtSchemaObj schema cache which manages this instance.
	 */
	IBusModelProtSchemaObj getSchema();

	/**
	 *	Set the IBusModelProtSchemaObj schema cache which manages this instance.
	 *	Should only be used to install overloads of the buff implementation wired specifically to a transport implementation
	 *	that eventually hits a server running a JPA backend.
	 *
	 *	@param schema	IBusModelProtSchemaObj schema cache which manages this instance.
	 */
	void setSchema(IBusModelProtSchemaObj schema);

	/**
	 *	Get the IBusModelProtParam instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IBusModelProtParam instance which currently backs this object.
	 */
	IBusModelProtParam getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( IBusModelProtParam value );

	/**
	 *	Get the IBusModelProtParam instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IBusModelProtParam instance which currently backs this object.
	 */
	IBusModelProtParam getParamRec();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	YCFDbKeyHash256 primary key for this instance.
	 */
	YCFDbKeyHash256 getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param YCFDbKeyHash256 primary key value for this instance.
	 */
	void setPKey( YCFDbKeyHash256 value );

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
	 *	Get the required IBusModelProtServerMethodObj instance referenced by the ServerMeth key.
	 *
	 *	@return	The required IBusModelProtServerMethodObj instance referenced by the ServerMeth key.
	 */
	IBusModelProtServerMethodObj getRequiredContainerServerMeth();

	/**
	 *	Get the required IBusModelProtServerMethodObj instance referenced by the ServerMeth key.
	 *
	 *	@return	The required IBusModelProtServerMethodObj instance referenced by the ServerMeth key.
	 */
	IBusModelProtServerMethodObj getRequiredContainerServerMeth( boolean forceRead );

	/**
	 *	Get the optional IBusModelProtSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional IBusModelProtSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelProtSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional IBusModelProtSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional IBusModelProtSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelProtSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Get the optional IBusModelProtParamObj instance referenced by the Prev key.
	 *
	 *	@return	The optional IBusModelProtParamObj instance referenced by the Prev key.
	 */
	IBusModelProtParamObj getOptionalLookupPrev();

	/**
	 *	Get the optional IBusModelProtParamObj instance referenced by the Prev key.
	 *
	 *	@return	The optional IBusModelProtParamObj instance referenced by the Prev key.
	 */
	IBusModelProtParamObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Get the optional IBusModelProtParamObj instance referenced by the Next key.
	 *
	 *	@return	The optional IBusModelProtParamObj instance referenced by the Next key.
	 */
	IBusModelProtParamObj getOptionalLookupNext();

	/**
	 *	Get the optional IBusModelProtParamObj instance referenced by the Next key.
	 *
	 *	@return	The optional IBusModelProtParamObj instance referenced by the Next key.
	 */
	IBusModelProtParamObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Get the required IBusModelProtValueObj instance referenced by the Type key.
	 *
	 *	@return	The required IBusModelProtValueObj instance referenced by the Type key.
	 */
	IBusModelProtValueObj getRequiredLookupType();

	/**
	 *	Get the required IBusModelProtValueObj instance referenced by the Type key.
	 *
	 *	@return	The required IBusModelProtValueObj instance referenced by the Type key.
	 */
	IBusModelProtValueObj getRequiredLookupType( boolean forceRead );

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

	/**
	 *	Internal use only.
	 */
	void copyPKeyToRec();

	/**
	 *	Internal use only.
	 */
	void copyRecToPKey();

}
