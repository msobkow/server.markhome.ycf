// Description: Java 25 Object interface for IntNet SecSession.

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
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

package server.markhome.ycf.v3_1.intnet.intnetobj;

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public interface IIntNetSecSessionObj
	extends ISecureSecSessionObj
{
	/**
	 *	Initially, the class code for an object is ISecureSecSession.CLASS_CODE, but the Obj layer relies on class code translation to map those
	 *	backing store entities to a runtime set of front-facing classcodes that the clients download and use when talking to the server implementing this code base.
	 *
	 *	@return The runtime class code used by this object. Only after the system is fully booted are these values stable and reliable.
	 */
	int getClassCode();
	/**
	 *	Realise this instance of a SecSession.
	 *
	 *	@return	SecureSecSessionObj instance which should be subsequently referenced.
	 */
	ISecureSecSessionObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureSecSessionObj the reference to the cached or read (realised) instance.
	 */
	ISecureSecSessionObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureSecSessionObj the reference to the cached or read (realised) instance.
	 */
	ISecureSecSessionObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SecSession instance.
	 *
	 *	@return	The newly locked ISecureSecSessionEditObj edition of this instance.
	 */
	ISecureSecSessionEditObj beginEdit();

	/**
	 *	End this edition of this SecSession instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SecSession instance.
	 *
	 *	@return	The ISecureSecSessionEditObj edition of this instance.
	 */
	ISecureSecSessionEditObj getEdit();

	/**
	 *	Get the current edition of this SecSession instance as a ISecureSecSessionEditObj.
	 *
	 *	@return	The ISecureSecSessionEditObj edition of this instance.
	 */
	ISecureSecSessionEditObj getEditAsSecSession();

	/**
	 *	Get the ISecureSecSessionTableObj table cache which manages this instance.
	 *
	 *	@return	ISecureSecSessionTableObj table cache which manages this instance.
	 */
	ISecureSecSessionTableObj getSecSessionTable();

	/**
	 *	Get the ISecureSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ISecureSchemaObj schema cache which manages this instance.
	 */
	ISecureSchemaObj getSchema();

	/**
	 *	Set the ISecureSchemaObj schema cache which manages this instance.
	 *	Should only be used to install overloads of the buff implementation wired specifically to a transport implementation
	 *	that eventually hits a server running a JPA backend.
	 *
	 *	@param schema	ISecureSchemaObj schema cache which manages this instance.
	 */
	void setSchema(ISecureSchemaObj schema);

	/**
	 *	Get the ISecureSecSession instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureSecSession instance which currently backs this object.
	 */
	ISecureSecSession getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( ISecureSecSession value );

	/**
	 *	Get the ISecureSecSession instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureSecSession instance which currently backs this object.
	 */
	ISecureSecSession getSecSessionRec();

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
	 *	Get the required IIntNetSecUserObj instance referenced by the SecUser key.
	 *
	 *	@return	The required IIntNetSecUserObj instance referenced by the SecUser key.
	 */
	ISecureSecUserObj getRequiredContainerSecUser();

	/**
	 *	Get the required ISecureSecUserObj instance referenced by the SecUser key.
	 *
	 *	@return	The required ISecureSecUserObj instance referenced by the SecUser key.
	 */
	ISecureSecUserObj getRequiredContainerSecUser( boolean forceRead );

	/**
	 *	Get the required IIntNetSecUserObj instance referenced by the SecProxy key.
	 *
	 *	@return	The required IIntNetSecUserObj instance referenced by the SecProxy key.
	 */
	ISecureSecUserObj getRequiredParentSecProxy();

	/**
	 *	Get the required ISecureSecUserObj instance referenced by the SecProxy key.
	 *
	 *	@return	The required ISecureSecUserObj instance referenced by the SecProxy key.
	 */
	ISecureSecUserObj getRequiredParentSecProxy( boolean forceRead );

	/**
	 *	Get the required IYCFKeyHash256 attribute SecSessionId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecSessionId.
	 */
	IYCFKeyHash256 getRequiredSecSessionId();

	/**
	 *	Get the required IYCFKeyHash256 attribute SecUserId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecUserId.
	 */
	IYCFKeyHash256 getRequiredSecUserId();

	/**
	 *	Get the required LocalDateTime attribute Start.
	 *
	 *	@return	The required LocalDateTime attribute Start.
	 */
	LocalDateTime getRequiredStart();

	/**
	 *	Get the optional LocalDateTime attribute Finish.
	 *
	 *	@return	The optional LocalDateTime attribute Finish.
	 */
	LocalDateTime getOptionalFinish();

	/**
	 *	Get the optional IYCFKeyHash256 attribute SecProxyId.
	 *
	 *	@return	The optional IYCFKeyHash256 attribute SecProxyId.
	 */
	IYCFKeyHash256 getOptionalSecProxyId();

	/**
	 *	Internal use only.
	 */
	void copyPKeyToRec();

	/**
	 *	Internal use only.
	 */
	void copyRecToPKey();

}
