// Description: Java 25 Object interface for SecurePub SysCluster.

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

public interface ISecurePubSysClusterObj
	extends IYCFAnyObj
{
	/**
	 *	Initially, the class code for an object is ISecurePubSysCluster.CLASS_CODE, but the Obj layer relies on class code translation to map those
	 *	backing store entities to a runtime set of front-facing classcodes that the clients download and use when talking to the server implementing this code base.
	 *
	 *	@return The runtime class code used by this object. Only after the system is fully booted are these values stable and reliable.
	 */
	int getClassCode();
	/**
	 *	Realise this instance of a SysCluster.
	 *
	 *	@return	SecurePubSysClusterObj instance which should be subsequently referenced.
	 */
	ISecurePubSysClusterObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecurePubSysClusterObj the reference to the cached or read (realised) instance.
	 */
	ISecurePubSysClusterObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecurePubSysClusterObj the reference to the cached or read (realised) instance.
	 */
	ISecurePubSysClusterObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SysCluster instance.
	 *
	 *	@return	The newly locked ISecurePubSysClusterEditObj edition of this instance.
	 */
	ISecurePubSysClusterEditObj beginEdit();

	/**
	 *	End this edition of this SysCluster instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SysCluster instance.
	 *
	 *	@return	The ISecurePubSysClusterEditObj edition of this instance.
	 */
	ISecurePubSysClusterEditObj getEdit();

	/**
	 *	Get the current edition of this SysCluster instance as a ISecurePubSysClusterEditObj.
	 *
	 *	@return	The ISecurePubSysClusterEditObj edition of this instance.
	 */
	ISecurePubSysClusterEditObj getEditAsSysCluster();

	/**
	 *	Get the ISecurePubSysClusterTableObj table cache which manages this instance.
	 *
	 *	@return	ISecurePubSysClusterTableObj table cache which manages this instance.
	 */
	ISecurePubSysClusterTableObj getSysClusterTable();

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
	 *	Get the ISecurePubSysCluster instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecurePubSysCluster instance which currently backs this object.
	 */
	ISecurePubSysCluster getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( ISecurePubSysCluster value );

	/**
	 *	Get the ISecurePubSysCluster instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecurePubSysCluster instance which currently backs this object.
	 */
	ISecurePubSysCluster getSysClusterRec();

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
	 *	Get the required ISecurePubClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ISecurePubClusterObj instance referenced by the Cluster key.
	 */
	ISecurePubClusterObj getRequiredContainerCluster();

	/**
	 *	Get the required ISecurePubClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ISecurePubClusterObj instance referenced by the Cluster key.
	 */
	ISecurePubClusterObj getRequiredContainerCluster( boolean forceRead );

	/**
	 *	Get the required int attribute SingletonId.
	 *
	 *	@return	The required int attribute SingletonId.
	 */
	int getRequiredSingletonId();

	/**
	 *	Get the required YCFDbKeyHash256 attribute ClusterId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute ClusterId.
	 */
	YCFDbKeyHash256 getRequiredClusterId();

	/**
	 *	Internal use only.
	 */
	void copyPKeyToRec();

	/**
	 *	Internal use only.
	 */
	void copyRecToPKey();

}
