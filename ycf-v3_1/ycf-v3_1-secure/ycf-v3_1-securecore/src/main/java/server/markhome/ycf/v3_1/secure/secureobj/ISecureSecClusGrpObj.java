// Description: Java 25 Object interface for Secure SecClusGrp.

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

package server.markhome.ycf.v3_1.secure.secureobj;

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
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

public interface ISecureSecClusGrpObj
	extends IYCFAnyObj
{
	/**
	 *	Initially, the class code for an object is ISecureSecClusGrp.CLASS_CODE, but the Obj layer relies on class code translation to map those
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
	 *	Realise this instance of a SecClusGrp.
	 *
	 *	@return	SecureSecClusGrpObj instance which should be subsequently referenced.
	 */
	ISecureSecClusGrpObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureSecClusGrpObj the reference to the cached or read (realised) instance.
	 */
	ISecureSecClusGrpObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureSecClusGrpObj the reference to the cached or read (realised) instance.
	 */
	ISecureSecClusGrpObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SecClusGrp instance.
	 *
	 *	@return	The newly locked ISecureSecClusGrpEditObj edition of this instance.
	 */
	ISecureSecClusGrpEditObj beginEdit();

	/**
	 *	End this edition of this SecClusGrp instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SecClusGrp instance.
	 *
	 *	@return	The ISecureSecClusGrpEditObj edition of this instance.
	 */
	ISecureSecClusGrpEditObj getEdit();

	/**
	 *	Get the current edition of this SecClusGrp instance as a ISecureSecClusGrpEditObj.
	 *
	 *	@return	The ISecureSecClusGrpEditObj edition of this instance.
	 */
	ISecureSecClusGrpEditObj getEditAsSecClusGrp();

	/**
	 *	Get the ISecureSecClusGrpTableObj table cache which manages this instance.
	 *
	 *	@return	ISecureSecClusGrpTableObj table cache which manages this instance.
	 */
	ISecureSecClusGrpTableObj getSecClusGrpTable();

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
	 *	Get the ISecureSecClusGrp instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureSecClusGrp instance which currently backs this object.
	 */
	ISecureSecClusGrp getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( ISecureSecClusGrp value );

	/**
	 *	Get the ISecureSecClusGrp instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureSecClusGrp instance which currently backs this object.
	 */
	ISecureSecClusGrp getSecClusGrpRec();

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
	 *	Get the required ISecureClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ISecureClusterObj instance referenced by the Cluster key.
	 */
	ISecureClusterObj getRequiredOwnerCluster();

	/**
	 *	Get the required ISecureClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ISecureClusterObj instance referenced by the Cluster key.
	 */
	ISecureClusterObj getRequiredOwnerCluster( boolean forceRead );

	/**
	 *	Get the required ISecureSecSysGrpObj instance referenced by the SysGrp key.
	 *
	 *	@return	The required ISecureSecSysGrpObj instance referenced by the SysGrp key.
	 */
	ISecureSecSysGrpObj getRequiredContainerSysGrp();

	/**
	 *	Get the required ISecureSecSysGrpObj instance referenced by the SysGrp key.
	 *
	 *	@return	The required ISecureSecSysGrpObj instance referenced by the SysGrp key.
	 */
	ISecureSecSysGrpObj getRequiredContainerSysGrp( boolean forceRead );

	/**
	 *	Get the array of optional ISecureSecClusGrpMembObj array of instances referenced by the MembByGrp key.
	 *
	 *	@return	The optional ISecureSecClusGrpMembObj[] array of instances referenced by the MembByGrp key.
	 */
	List<ISecureSecClusGrpMembObj> getOptionalChildrenMembByGrp();

	/**
	 *	Get the array of optional ISecureSecClusGrpMembObj array of instances referenced by the MembByGrp key.
	 *
	 *	@return	The optional ISecureSecClusGrpMembObj[] array of instances referenced by the MembByGrp key.
	 */
	List<ISecureSecClusGrpMembObj> getOptionalChildrenMembByGrp( boolean forceRead );

	/**
	 *	Get the required IYCFKeyHash256 attribute SecClusGrpId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecClusGrpId.
	 */
	IYCFKeyHash256 getRequiredSecClusGrpId();

	/**
	 *	Get the required IYCFKeyHash256 attribute ClusterId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute ClusterId.
	 */
	IYCFKeyHash256 getRequiredClusterId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Internal use only.
	 */
	void copyPKeyToRec();

	/**
	 *	Internal use only.
	 */
	void copyRecToPKey();

}
