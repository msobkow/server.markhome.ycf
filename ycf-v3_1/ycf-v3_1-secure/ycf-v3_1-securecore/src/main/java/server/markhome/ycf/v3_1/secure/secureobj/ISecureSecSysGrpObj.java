// Description: Java 25 Object interface for Secure SecSysGrp.

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

public interface ISecureSecSysGrpObj
	extends IYCFAnyObj
{
	/**
	 *	Initially, the class code for an object is ISecureSecSysGrp.CLASS_CODE, but the Obj layer relies on class code translation to map those
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
	 *	Realise this instance of a SecSysGrp.
	 *
	 *	@return	SecureSecSysGrpObj instance which should be subsequently referenced.
	 */
	ISecureSecSysGrpObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureSecSysGrpObj the reference to the cached or read (realised) instance.
	 */
	ISecureSecSysGrpObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ISecureSecSysGrpObj the reference to the cached or read (realised) instance.
	 */
	ISecureSecSysGrpObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SecSysGrp instance.
	 *
	 *	@return	The newly locked ISecureSecSysGrpEditObj edition of this instance.
	 */
	ISecureSecSysGrpEditObj beginEdit();

	/**
	 *	End this edition of this SecSysGrp instance.
	 *
	 *	@throws	YCFNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SecSysGrp instance.
	 *
	 *	@return	The ISecureSecSysGrpEditObj edition of this instance.
	 */
	ISecureSecSysGrpEditObj getEdit();

	/**
	 *	Get the current edition of this SecSysGrp instance as a ISecureSecSysGrpEditObj.
	 *
	 *	@return	The ISecureSecSysGrpEditObj edition of this instance.
	 */
	ISecureSecSysGrpEditObj getEditAsSecSysGrp();

	/**
	 *	Get the ISecureSecSysGrpTableObj table cache which manages this instance.
	 *
	 *	@return	ISecureSecSysGrpTableObj table cache which manages this instance.
	 */
	ISecureSecSysGrpTableObj getSecSysGrpTable();

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
	 *	Get the ISecureSecSysGrp instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureSecSysGrp instance which currently backs this object.
	 */
	ISecureSecSysGrp getRec();

	/**
	 *	Internal use only.
	 */
	void setRec( ISecureSecSysGrp value );

	/**
	 *	Get the ISecureSecSysGrp instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ISecureSecSysGrp instance which currently backs this object.
	 */
	ISecureSecSysGrp getSecSysGrpRec();

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
	 *	Get the array of optional ISecureSecSysGrpIncObj array of instances referenced by the IncByGrp key.
	 *
	 *	@return	The optional ISecureSecSysGrpIncObj[] array of instances referenced by the IncByGrp key.
	 */
	List<ISecureSecSysGrpIncObj> getOptionalComponentsIncByGrp();

	/**
	 *	Get the array of optional ISecureSecSysGrpIncObj array of instances referenced by the IncByGrp key.
	 *
	 *	@return	The optional ISecureSecSysGrpIncObj[] array of instances referenced by the IncByGrp key.
	 */
	List<ISecureSecSysGrpIncObj> getOptionalComponentsIncByGrp( boolean forceRead );

	/**
	 *	Get the array of optional ISecureSecSysGrpMembObj array of instances referenced by the MembByGrp key.
	 *
	 *	@return	The optional ISecureSecSysGrpMembObj[] array of instances referenced by the MembByGrp key.
	 */
	List<ISecureSecSysGrpMembObj> getOptionalChildrenMembByGrp();

	/**
	 *	Get the array of optional ISecureSecSysGrpMembObj array of instances referenced by the MembByGrp key.
	 *
	 *	@return	The optional ISecureSecSysGrpMembObj[] array of instances referenced by the MembByGrp key.
	 */
	List<ISecureSecSysGrpMembObj> getOptionalChildrenMembByGrp( boolean forceRead );

	/**
	 *	Get the array of optional ISecureSecClusGrpObj array of instances referenced by the ImplClusGrp key.
	 *
	 *	@return	The optional ISecureSecClusGrpObj[] array of instances referenced by the ImplClusGrp key.
	 */
	List<ISecureSecClusGrpObj> getOptionalComponentsImplClusGrp();

	/**
	 *	Get the array of optional ISecureSecClusGrpObj array of instances referenced by the ImplClusGrp key.
	 *
	 *	@return	The optional ISecureSecClusGrpObj[] array of instances referenced by the ImplClusGrp key.
	 */
	List<ISecureSecClusGrpObj> getOptionalComponentsImplClusGrp( boolean forceRead );

	/**
	 *	Get the array of optional ISecureSecTentGrpObj array of instances referenced by the ImplTentGrp key.
	 *
	 *	@return	The optional ISecureSecTentGrpObj[] array of instances referenced by the ImplTentGrp key.
	 */
	List<ISecureSecTentGrpObj> getOptionalComponentsImplTentGrp();

	/**
	 *	Get the array of optional ISecureSecTentGrpObj array of instances referenced by the ImplTentGrp key.
	 *
	 *	@return	The optional ISecureSecTentGrpObj[] array of instances referenced by the ImplTentGrp key.
	 */
	List<ISecureSecTentGrpObj> getOptionalComponentsImplTentGrp( boolean forceRead );

	/**
	 *	Get the optional ISecureSecSysRoleObj instance referenced by the ImplSysRole key.
	 *
	 *	@return	The optional ISecureSecSysRoleObj instance referenced by the ImplSysRole key.
	 */
	ISecureSecSysRoleObj getOptionalComponentsImplSysRole();

	/**
	 *	Get the optional ISecureSecSysRoleObj instance referenced by the ImplSysRole key.
	 *
	 *	@return	The optional ISecureSecSysRoleObj instance referenced by the ImplSysRole key.
	 */
	ISecureSecSysRoleObj getOptionalComponentsImplSysRole( boolean forceRead );

	/**
	 *	Get the array of optional ISecureSecClusRoleObj array of instances referenced by the ImplClusRole key.
	 *
	 *	@return	The optional ISecureSecClusRoleObj[] array of instances referenced by the ImplClusRole key.
	 */
	List<ISecureSecClusRoleObj> getOptionalComponentsImplClusRole();

	/**
	 *	Get the array of optional ISecureSecClusRoleObj array of instances referenced by the ImplClusRole key.
	 *
	 *	@return	The optional ISecureSecClusRoleObj[] array of instances referenced by the ImplClusRole key.
	 */
	List<ISecureSecClusRoleObj> getOptionalComponentsImplClusRole( boolean forceRead );

	/**
	 *	Get the array of optional ISecureSecTentRoleObj array of instances referenced by the ImplTentRole key.
	 *
	 *	@return	The optional ISecureSecTentRoleObj[] array of instances referenced by the ImplTentRole key.
	 */
	List<ISecureSecTentRoleObj> getOptionalComponentsImplTentRole();

	/**
	 *	Get the array of optional ISecureSecTentRoleObj array of instances referenced by the ImplTentRole key.
	 *
	 *	@return	The optional ISecureSecTentRoleObj[] array of instances referenced by the ImplTentRole key.
	 */
	List<ISecureSecTentRoleObj> getOptionalComponentsImplTentRole( boolean forceRead );

	/**
	 *	Get the array of optional ISecureSecSysGrpIncObj array of instances referenced by the SysGrpByName key.
	 *
	 *	@return	The optional ISecureSecSysGrpIncObj[] array of instances referenced by the SysGrpByName key.
	 */
	List<ISecureSecSysGrpIncObj> getOptionalChildrenSysGrpByName();

	/**
	 *	Get the array of optional ISecureSecSysGrpIncObj array of instances referenced by the SysGrpByName key.
	 *
	 *	@return	The optional ISecureSecSysGrpIncObj[] array of instances referenced by the SysGrpByName key.
	 */
	List<ISecureSecSysGrpIncObj> getOptionalChildrenSysGrpByName( boolean forceRead );

	/**
	 *	Get the array of optional ISecureSecSysRoleEnablesObj array of instances referenced by the RoleByEnableName key.
	 *
	 *	@return	The optional ISecureSecSysRoleEnablesObj[] array of instances referenced by the RoleByEnableName key.
	 */
	List<ISecureSecSysRoleEnablesObj> getOptionalChildrenRoleByEnableName();

	/**
	 *	Get the array of optional ISecureSecSysRoleEnablesObj array of instances referenced by the RoleByEnableName key.
	 *
	 *	@return	The optional ISecureSecSysRoleEnablesObj[] array of instances referenced by the RoleByEnableName key.
	 */
	List<ISecureSecSysRoleEnablesObj> getOptionalChildrenRoleByEnableName( boolean forceRead );

	/**
	 *	Get the required IYCFKeyHash256 attribute SecSysGrpId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecSysGrpId.
	 */
	IYCFKeyHash256 getRequiredSecSysGrpId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the required ISecurePubSchema.SecLevelEnum attribute SecLevel.
	 *
	 *	@return	The required ISecurePubSchema.SecLevelEnum attribute SecLevel.
	 */
	ISecurePubSchema.SecLevelEnum getRequiredSecLevel();

	/**
	 *	Internal use only.
	 */
	void copyPKeyToRec();

	/**
	 *	Internal use only.
	 */
	void copyRecToPKey();

}
