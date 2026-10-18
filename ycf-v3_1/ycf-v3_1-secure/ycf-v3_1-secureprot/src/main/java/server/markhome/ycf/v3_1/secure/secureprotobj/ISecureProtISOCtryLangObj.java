// Description: Java 25 Object interface for SecureProt ISOCtryLang.

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

public interface ISecureProtISOCtryLangObj
	extends IYCFAnyObj
{
	/**
	 *	Initially, the class code for an object is ISecureProtISOCtryLang.CLASS_CODE, but the Obj layer relies on class code translation to map those
	 *	backing store entities to a runtime set of front-facing classcodes that the clients download and use when talking to the server implementing this code base.
	 *
	 *	@return The runtime class code used by this object. Only after the system is fully booted are these values stable and reliable.
	 */
	int getClassCode();
	/**
	 *	Get the user who created this instance.
	 *
	 *	@return	The ISecureProtSecUserObj instance who created this instance.
	 */
	ISecureProtSecUserObj getCreatedBy();

	/**
	 *	Get the LocalDateTime this instance was created.
	 *
	 *	@return	The LocalDateTime value for the creation time of the instance.
	 */
	LocalDateTime getCreatedAt();

	/**
	 *	Get the user who updated this instance.
	 *
	 *	@return	The ISecureProtSecUserObj instance who updated this instance.
	 */
	ISecureProtSecUserObj getUpdatedBy();

	/**
	 *	Get the LocalDateTime date-time this instance was updated.
	 *
	 *	@return	The LocalDateTime value for the create time of the instance.
	 */
	LocalDateTime getUpdatedAt();
	/**
	 *	Realise this instance of a ISOCtryLang.
	 *
	 *	@return	SecureProtISOCtryLangObj instance which should be subsequently referenced.
	 */
	ISecureProtISOCtryLangObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureProtISOCtryLangObj the reference to the cached or read (realised) instance.
	 */
	ISecureProtISOCtryLangObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureProtISOCtryLangObj the reference to the cached or read (realised) instance.
	 */
	ISecureProtISOCtryLangObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this ISOCtryLang instance.
	 *
	 *	@return	The newly locked ISecureProtISOCtryLangEditObj edition of this instance.
	 */
	ISecureProtISOCtryLangEditObj beginEdit();

	/**
	 *	End this edition of this ISOCtryLang instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this ISOCtryLang instance.
	 *
	 *	@return	The ISecureProtISOCtryLangEditObj edition of this instance.
	 */
	ISecureProtISOCtryLangEditObj getEdit();

	/**
	 *	Get the current edition of this ISOCtryLang instance as a ISecureProtISOCtryLangEditObj.
	 *
	 *	@return	The ISecureProtISOCtryLangEditObj edition of this instance.
	 */
	ISecureProtISOCtryLangEditObj getEditAsISOCtryLang();

	/**
	 *	Get the ISecureProtISOCtryLangTableObj table cache which manages this instance.
	 *
	 *	@return	ISecureProtISOCtryLangTableObj table cache which manages this instance.
	 */
	ISecureProtISOCtryLangTableObj getISOCtryLangTable();

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
	 *	Get the ISecureProtISOCtryLang instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureProtISOCtryLang instance which currently backs this object.
	 */
	ISecureProtISOCtryLang getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( ISecureProtISOCtryLang value );

	/**
	 *	Get the ISecureProtISOCtryLang instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureProtISOCtryLang instance which currently backs this object.
	 */
	ISecureProtISOCtryLang getISOCtryLangRec();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	ISecureProtISOCtryLangPKey primary key for this instance.
	 */
	ISecureProtISOCtryLangPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param ISecureProtISOCtryLangPKey primary key value for this instance.
	 */
	void setPKey( ISecureProtISOCtryLangPKey value );

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
	 *	Get the required ISecureProtISOCtryObj instance referenced by the Ctry key.
	 *
	 *	@return	The required ISecureProtISOCtryObj instance referenced by the Ctry key.
	 */
	ISecureProtISOCtryObj getRequiredContainerCtry();

	/**
	 *	Get the required ISecureProtISOCtryObj instance referenced by the Ctry key.
	 *
	 *	@return	The required ISecureProtISOCtryObj instance referenced by the Ctry key.
	 */
	ISecureProtISOCtryObj getRequiredContainerCtry( boolean forceRead );

	/**
	 *	Get the required ISecureProtISOLangObj instance referenced by the Lang key.
	 *
	 *	@return	The required ISecureProtISOLangObj instance referenced by the Lang key.
	 */
	ISecureProtISOLangObj getRequiredParentLang();

	/**
	 *	Get the required ISecureProtISOLangObj instance referenced by the Lang key.
	 *
	 *	@return	The required ISecureProtISOLangObj instance referenced by the Lang key.
	 */
	ISecureProtISOLangObj getRequiredParentLang( boolean forceRead );

	/**
	 *	Get the required short attribute ISOCtryId.
	 *
	 *	@return	The required short attribute ISOCtryId.
	 */
	short getRequiredISOCtryId();

	/**
	 *	Get the required short attribute ISOLangId.
	 *
	 *	@return	The required short attribute ISOLangId.
	 */
	short getRequiredISOLangId();

	/**
	 *	Internal use only.
	 */
	void copyPKeyToRec();

	/**
	 *	Internal use only.
	 */
	void copyRecToPKey();

}
