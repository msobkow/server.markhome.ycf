// Description: Java 25 Object interface for SecurePub SecUser.

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

package server.markhome.ycf.v3_1.secure.securepubobj;

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

public interface ISecurePubSecUserObj
	extends IYCFAnyObj
{
	/**
	 *	Initially, the class code for an object is ISecurePubSecUser.CLASS_CODE, but the Obj layer relies on class code translation to map those
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
	 *	Realise this instance of a SecUser.
	 *
	 *	@return	SecurePubSecUserObj instance which should be subsequently referenced.
	 */
	ISecurePubSecUserObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecurePubSecUserObj the reference to the cached or read (realised) instance.
	 */
	ISecurePubSecUserObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecurePubSecUserObj the reference to the cached or read (realised) instance.
	 */
	ISecurePubSecUserObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SecUser instance.
	 *
	 *	@return	The newly locked ISecurePubSecUserEditObj edition of this instance.
	 */
	ISecurePubSecUserEditObj beginEdit();

	/**
	 *	End this edition of this SecUser instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SecUser instance.
	 *
	 *	@return	The ISecurePubSecUserEditObj edition of this instance.
	 */
	ISecurePubSecUserEditObj getEdit();

	/**
	 *	Get the current edition of this SecUser instance as a ISecurePubSecUserEditObj.
	 *
	 *	@return	The ISecurePubSecUserEditObj edition of this instance.
	 */
	ISecurePubSecUserEditObj getEditAsSecUser();

	/**
	 *	Get the ISecurePubSecUserTableObj table cache which manages this instance.
	 *
	 *	@return	ISecurePubSecUserTableObj table cache which manages this instance.
	 */
	ISecurePubSecUserTableObj getSecUserTable();

	/**
	 *	Get the ISecurePubSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ISecurePubSchemaObj schema cache which manages this instance.
	 */
	ISecurePubSchemaObj getSchema();

	/**
	 *	Set the ISecurePubSchemaObj schema cache which manages this instance.
	 *	Should only be used to install overloads of the buff implementation wired specifically to a transport implementation
	 *	that eventually hits a server running a JPA backend.
	 *
	 *	@param schema	ISecurePubSchemaObj schema cache which manages this instance.
	 */
	void setSchema(ISecurePubSchemaObj schema);

	/**
	 *	Get the ISecurePubSecUser instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecurePubSecUser instance which currently backs this object.
	 */
	ISecurePubSecUser getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( ISecurePubSecUser value );

	/**
	 *	Get the ISecurePubSecUser instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecurePubSecUser instance which currently backs this object.
	 */
	ISecurePubSecUser getSecUserRec();

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
	 *	Get the array of optional ISecurePubSecSessionObj array of instances referenced by the SecSess key.
	 *
	 *	@return	The optional ISecurePubSecSessionObj[] array of instances referenced by the SecSess key.
	 */
	List<ISecurePubSecSessionObj> getOptionalComponentsSecSess();

	/**
	 *	Get the array of optional ISecurePubSecSessionObj array of instances referenced by the SecSess key.
	 *
	 *	@return	The optional ISecurePubSecSessionObj[] array of instances referenced by the SecSess key.
	 */
	List<ISecurePubSecSessionObj> getOptionalComponentsSecSess( boolean forceRead );

	/**
	 *	Get the required YCFDbKeyHash256 attribute SecUserId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute SecUserId.
	 */
	YCFDbKeyHash256 getRequiredSecUserId();

	/**
	 *	Get the required String attribute LoginId.
	 *
	 *	@return	The required String attribute LoginId.
	 */
	String getRequiredLoginId();

	/**
	 *	Get the required ISecurePubSchema.SecAccountStatusEnum attribute AccountStatus.
	 *
	 *	@return	The required ISecurePubSchema.SecAccountStatusEnum attribute AccountStatus.
	 */
	ISecurePubSchema.SecAccountStatusEnum getRequiredAccountStatus();

	/**
	 *	Get the optional String attribute DfltSysGrpName.
	 *
	 *	@return	The optional String attribute DfltSysGrpName.
	 */
	String getOptionalDfltSysGrpName();

	/**
	 *	Get the optional String attribute DfltClusGrpName.
	 *
	 *	@return	The optional String attribute DfltClusGrpName.
	 */
	String getOptionalDfltClusGrpName();

	/**
	 *	Get the optional String attribute DfltTentGrpName.
	 *
	 *	@return	The optional String attribute DfltTentGrpName.
	 */
	String getOptionalDfltTentGrpName();

	/**
	 *	Internal use only.
	 */
	void copyPKeyToRec();

	/**
	 *	Internal use only.
	 */
	void copyRecToPKey();

}
