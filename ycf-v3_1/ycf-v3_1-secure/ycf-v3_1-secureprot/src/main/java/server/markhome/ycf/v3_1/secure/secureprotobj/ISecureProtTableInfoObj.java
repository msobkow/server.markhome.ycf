// Description: Java 25 Object interface for SecureProt TableInfo.

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.secure.secureprotobj;

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
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public interface ISecureProtTableInfoObj
	extends IYCFAnyObj
{
	/**
	 *	Initially, the class code for an object is ISecureProtTableInfo.CLASS_CODE, but the Obj layer relies on class code translation to map those
	 *	backing store entities to a runtime set of front-facing classcodes that the clients download and use when talking to the server implementing this code base.
	 *
	 *	@return The runtime class code used by this object. Only after the system is fully booted are these values stable and reliable.
	 */
	int getClassCode();
	/**
	 *	Realise this instance of a TableInfo.
	 *
	 *	@return	SecureProtTableInfoObj instance which should be subsequently referenced.
	 */
	ISecureProtTableInfoObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureProtTableInfoObj the reference to the cached or read (realised) instance.
	 */
	ISecureProtTableInfoObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureProtTableInfoObj the reference to the cached or read (realised) instance.
	 */
	ISecureProtTableInfoObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this TableInfo instance.
	 *
	 *	@return	The newly locked ISecureProtTableInfoEditObj edition of this instance.
	 */
	ISecureProtTableInfoEditObj beginEdit();

	/**
	 *	End this edition of this TableInfo instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this TableInfo instance.
	 *
	 *	@return	The ISecureProtTableInfoEditObj edition of this instance.
	 */
	ISecureProtTableInfoEditObj getEdit();

	/**
	 *	Get the current edition of this TableInfo instance as a ISecureProtTableInfoEditObj.
	 *
	 *	@return	The ISecureProtTableInfoEditObj edition of this instance.
	 */
	ISecureProtTableInfoEditObj getEditAsTableInfo();

	/**
	 *	Get the ISecureProtTableInfoTableObj table cache which manages this instance.
	 *
	 *	@return	ISecureProtTableInfoTableObj table cache which manages this instance.
	 */
	ISecureProtTableInfoTableObj getTableInfoTable();

	/**
	 *	Get the ISecureProtSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ISecureProtSchemaObj schema cache which manages this instance.
	 */
	ISecureProtSchemaObj getSchema();

	/**
	 *	Set the ISecureProtSchemaObj schema cache which manages this instance.
	 *	Should only be used to install overloads of the buff implementation wired specifically to a transport implementation
	 *	that eventually hits a server running a JPA backend.
	 *
	 *	@param schema	ISecureProtSchemaObj schema cache which manages this instance.
	 */
	void setSchema(ISecureProtSchemaObj schema);

	/**
	 *	Get the ISecureProtTableInfo instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureProtTableInfo instance which currently backs this object.
	 */
	ISecureProtTableInfo getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( ISecureProtTableInfo value );

	/**
	 *	Get the ISecureProtTableInfo instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureProtTableInfo instance which currently backs this object.
	 */
	ISecureProtTableInfo getTableInfoRec();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	Integer primary key for this instance.
	 */
	Integer getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param Integer primary key value for this instance.
	 */
	void setPKey( Integer value );

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
	 *	Get the optional ISecureProtTableInfoObj instance referenced by the SuperRef key.
	 *
	 *	@return	The optional ISecureProtTableInfoObj instance referenced by the SuperRef key.
	 */
	ISecureProtTableInfoObj getOptionalParentSuperRef();

	/**
	 *	Get the optional ISecureProtTableInfoObj instance referenced by the SuperRef key.
	 *
	 *	@return	The optional ISecureProtTableInfoObj instance referenced by the SuperRef key.
	 */
	ISecureProtTableInfoObj getOptionalParentSuperRef( boolean forceRead );

	/**
	 *	Get the array of optional ISecureProtTableInfoObj array of instances referenced by the SubRefs key.
	 *
	 *	@return	The optional ISecureProtTableInfoObj[] array of instances referenced by the SubRefs key.
	 */
	List<ISecureProtTableInfoObj> getOptionalChildrenSubRefs();

	/**
	 *	Get the array of optional ISecureProtTableInfoObj array of instances referenced by the SubRefs key.
	 *
	 *	@return	The optional ISecureProtTableInfoObj[] array of instances referenced by the SubRefs key.
	 */
	List<ISecureProtTableInfoObj> getOptionalChildrenSubRefs( boolean forceRead );

	/**
	 *	Get the required int attribute TableInfoId.
	 *
	 *	@return	The required int attribute TableInfoId.
	 */
	int getRequiredTableInfoId();

	/**
	 *	Get the required String attribute SchemaName.
	 *
	 *	@return	The required String attribute SchemaName.
	 */
	String getRequiredSchemaName();

	/**
	 *	Get the required String attribute TableName.
	 *
	 *	@return	The required String attribute TableName.
	 */
	String getRequiredTableName();

	/**
	 *	Get the optional String attribute SuperName.
	 *
	 *	@return	The optional String attribute SuperName.
	 */
	String getOptionalSuperName();

	/**
	 *	Get the required int attribute BackingClassCode.
	 *
	 *	@return	The required int attribute BackingClassCode.
	 */
	int getRequiredBackingClassCode();

	/**
	 *	Get the required int attribute RuntimeClassCode.
	 *
	 *	@return	The required int attribute RuntimeClassCode.
	 */
	int getRequiredRuntimeClassCode();

	/**
	 *	Get the required boolean attribute HasHistory.
	 *
	 *	@return	The required boolean attribute HasHistory.
	 */
	boolean getRequiredHasHistory();

	/**
	 *	Get the required boolean attribute IsMutable.
	 *
	 *	@return	The required boolean attribute IsMutable.
	 */
	boolean getRequiredIsMutable();

	/**
	 *	Get the required String attribute SecScopeName.
	 *
	 *	@return	The required String attribute SecScopeName.
	 */
	String getRequiredSecScopeName();

	/**
	 *	Get the required String attribute CodeVis.
	 *
	 *	@return	The required String attribute CodeVis.
	 */
	String getRequiredCodeVis();

	/**
	 *	Internal use only.
	 */
	void copyPKeyToRec();

	/**
	 *	Internal use only.
	 */
	void copyRecToPKey();

}
