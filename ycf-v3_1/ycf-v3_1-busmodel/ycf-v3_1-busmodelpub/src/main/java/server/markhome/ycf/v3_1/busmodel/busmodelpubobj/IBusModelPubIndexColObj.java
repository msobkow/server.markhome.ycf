// Description: Java 25 Object interface for BusModelPub IndexCol.

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

public interface IBusModelPubIndexColObj
	extends IYCFAnyObj
{
	/**
	 *	Initially, the class code for an object is IBusModelPubIndexCol.CLASS_CODE, but the Obj layer relies on class code translation to map those
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
	 *	Realise this instance of a IndexCol.
	 *
	 *	@return	BusModelPubIndexColObj instance which should be subsequently referenced.
	 */
	IBusModelPubIndexColObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	IBusModelPubIndexColObj the reference to the cached or read (realised) instance.
	 */
	IBusModelPubIndexColObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	IBusModelPubIndexColObj the reference to the cached or read (realised) instance.
	 */
	IBusModelPubIndexColObj read( boolean forceRead );

	/**
	 *	Move this object up in the chain and refresh the cache.
	 *
	 *	@return	IBusModelPubIndexColObj the reference to the moved and refreshed instance.
	 */
	IBusModelPubIndexColObj moveUp();

	/**
	 *	Move this object down in the chain and refresh the cache.
	 *
	 *	@return	IBusModelPubIndexColObj the reference to the moved and refreshed instance.
	 */
	IBusModelPubIndexColObj moveDown();

	/**
	 *	Initialize and return a locked edition of this IndexCol instance.
	 *
	 *	@return	The newly locked IBusModelPubIndexColEditObj edition of this instance.
	 */
	IBusModelPubIndexColEditObj beginEdit();

	/**
	 *	End this edition of this IndexCol instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this IndexCol instance.
	 *
	 *	@return	The IBusModelPubIndexColEditObj edition of this instance.
	 */
	IBusModelPubIndexColEditObj getEdit();

	/**
	 *	Get the current edition of this IndexCol instance as a IBusModelPubIndexColEditObj.
	 *
	 *	@return	The IBusModelPubIndexColEditObj edition of this instance.
	 */
	IBusModelPubIndexColEditObj getEditAsIndexCol();

	/**
	 *	Get the IBusModelPubIndexColTableObj table cache which manages this instance.
	 *
	 *	@return	IBusModelPubIndexColTableObj table cache which manages this instance.
	 */
	IBusModelPubIndexColTableObj getIndexColTable();

	/**
	 *	Get the IBusModelPubSchemaObj schema cache which manages this instance.
	 *
	 *	@return	IBusModelPubSchemaObj schema cache which manages this instance.
	 */
	IBusModelPubSchemaObj getSchema();

	/**
	 *	Set the IBusModelPubSchemaObj schema cache which manages this instance.
	 *	Should only be used to install overloads of the buff implementation wired specifically to a transport implementation
	 *	that eventually hits a server running a JPA backend.
	 *
	 *	@param schema	IBusModelPubSchemaObj schema cache which manages this instance.
	 */
	void setSchema(IBusModelPubSchemaObj schema);

	/**
	 *	Get the IBusModelPubIndexCol instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IBusModelPubIndexCol instance which currently backs this object.
	 */
	IBusModelPubIndexCol getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( IBusModelPubIndexCol value );

	/**
	 *	Get the IBusModelPubIndexCol instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IBusModelPubIndexCol instance which currently backs this object.
	 */
	IBusModelPubIndexCol getIndexColRec();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	IYCFKeyHash256 primary key for this instance.
	 */
	IYCFKeyHash256 getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param IYCFKeyHash256 primary key value for this instance.
	 */
	void setPKey( IYCFKeyHash256 value );

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
	 *	Get the required IBusModelPubIndexObj instance referenced by the Index key.
	 *
	 *	@return	The required IBusModelPubIndexObj instance referenced by the Index key.
	 */
	IBusModelPubIndexObj getRequiredContainerIndex();

	/**
	 *	Get the required IBusModelPubIndexObj instance referenced by the Index key.
	 *
	 *	@return	The required IBusModelPubIndexObj instance referenced by the Index key.
	 */
	IBusModelPubIndexObj getRequiredContainerIndex( boolean forceRead );

	/**
	 *	Get the optional IBusModelPubSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional IBusModelPubSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelPubSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional IBusModelPubSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional IBusModelPubSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelPubSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPubRelationColObj array of instances referenced by the RefRelFromCol key.
	 *
	 *	@return	The optional IBusModelPubRelationColObj[] array of instances referenced by the RefRelFromCol key.
	 */
	List<IBusModelPubRelationColObj> getOptionalChildrenRefRelFromCol();

	/**
	 *	Get the array of optional IBusModelPubRelationColObj array of instances referenced by the RefRelFromCol key.
	 *
	 *	@return	The optional IBusModelPubRelationColObj[] array of instances referenced by the RefRelFromCol key.
	 */
	List<IBusModelPubRelationColObj> getOptionalChildrenRefRelFromCol( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPubRelationColObj array of instances referenced by the RefRelToCol key.
	 *
	 *	@return	The optional IBusModelPubRelationColObj[] array of instances referenced by the RefRelToCol key.
	 */
	List<IBusModelPubRelationColObj> getOptionalChildrenRefRelToCol();

	/**
	 *	Get the array of optional IBusModelPubRelationColObj array of instances referenced by the RefRelToCol key.
	 *
	 *	@return	The optional IBusModelPubRelationColObj[] array of instances referenced by the RefRelToCol key.
	 */
	List<IBusModelPubRelationColObj> getOptionalChildrenRefRelToCol( boolean forceRead );

	/**
	 *	Get the optional IBusModelPubIndexColObj instance referenced by the Prev key.
	 *
	 *	@return	The optional IBusModelPubIndexColObj instance referenced by the Prev key.
	 */
	IBusModelPubIndexColObj getOptionalLookupPrev();

	/**
	 *	Get the optional IBusModelPubIndexColObj instance referenced by the Prev key.
	 *
	 *	@return	The optional IBusModelPubIndexColObj instance referenced by the Prev key.
	 */
	IBusModelPubIndexColObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Get the optional IBusModelPubIndexColObj instance referenced by the Next key.
	 *
	 *	@return	The optional IBusModelPubIndexColObj instance referenced by the Next key.
	 */
	IBusModelPubIndexColObj getOptionalLookupNext();

	/**
	 *	Get the optional IBusModelPubIndexColObj instance referenced by the Next key.
	 *
	 *	@return	The optional IBusModelPubIndexColObj instance referenced by the Next key.
	 */
	IBusModelPubIndexColObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Get the required IBusModelPubValueObj instance referenced by the Column key.
	 *
	 *	@return	The required IBusModelPubValueObj instance referenced by the Column key.
	 */
	IBusModelPubValueObj getRequiredLookupColumn();

	/**
	 *	Get the required IBusModelPubValueObj instance referenced by the Column key.
	 *
	 *	@return	The required IBusModelPubValueObj instance referenced by the Column key.
	 */
	IBusModelPubValueObj getRequiredLookupColumn( boolean forceRead );

	/**
	 *	Get the required YCFDbKeyHash256 attribute IndexId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute IndexId.
	 */
	YCFDbKeyHash256 getRequiredIndexId();

	/**
	 *	Get the required YCFDbKeyHash256 attribute Id.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute Id.
	 */
	YCFDbKeyHash256 getRequiredId();

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
	 *	Get the optional String attribute ShortName.
	 *
	 *	@return	The optional String attribute ShortName.
	 */
	String getOptionalShortName();

	/**
	 *	Get the optional String attribute Label.
	 *
	 *	@return	The optional String attribute Label.
	 */
	String getOptionalLabel();

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
	 *	Get the required YCFDbKeyHash256 attribute ColumnId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute ColumnId.
	 */
	YCFDbKeyHash256 getRequiredColumnId();

	/**
	 *	Get the required boolean attribute IsAscending.
	 *
	 *	@return	The required boolean attribute IsAscending.
	 */
	boolean getRequiredIsAscending();

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
