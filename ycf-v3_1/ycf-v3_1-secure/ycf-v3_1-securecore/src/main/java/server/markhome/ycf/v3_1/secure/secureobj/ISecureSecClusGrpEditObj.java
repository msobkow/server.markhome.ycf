// Description: Java 25 Instance Edit Object interface for Secure SecClusGrp.

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
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

public interface ISecureSecClusGrpEditObj
	extends ISecureSecClusGrpObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecureSecClusGrpObj.
	 */
	ISecureSecClusGrpObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecureSecClusGrpObj.
	 */
	ISecureSecClusGrpObj getOrigAsSecClusGrp();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecureSecClusGrpObj create();

	/*
	 *	Update the instance.
	 */
	SecureSecClusGrpEditObj update();

	/*
	 *	Delete the instance.
	 */
	SecureSecClusGrpEditObj deleteInstance();

	/**
	 *	Set the user who created this instance.
	 *
	 *	@param	value	The ISecureSecUserObj instance who created this instance.
	 */
	void setCreatedBy( ISecureSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was created.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setCreatedAt( LocalDateTime value );

	/**
	 *	Set the user who updated this instance.
	 *
	 *	@param	value	The ISecureSecUserObj instance who updated this instance.
	 */
	void setUpdatedBy( ISecureSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was updated.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setUpdatedAt( LocalDateTime value );

	/**
	 *	Get the ISecureClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The ISecureClusterObj instance referenced by the Cluster key.
	 */
	ISecureClusterObj getRequiredOwnerCluster();

	/**
	 *	Get the required ISecureClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ISecureClusterObj instance referenced by the Cluster key.
	 */
	ISecureClusterObj getRequiredOwnerCluster( boolean forceRead );

	/**
	 *	Set the ISecureClusterObj instance referenced by the Cluster key.
	 *
	 *	@param	value	the ISecureClusterObj instance to be referenced by the Cluster key.
	 */
	void setRequiredOwnerCluster( ISecureClusterObj value );

	/**
	 *	Get the ISecureSecSysGrpObj instance referenced by the SysGrp key.
	 *
	 *	@return	The ISecureSecSysGrpObj instance referenced by the SysGrp key.
	 */
	ISecureSecSysGrpObj getRequiredContainerSysGrp();

	/**
	 *	Get the required ISecureSecSysGrpObj instance referenced by the SysGrp key.
	 *
	 *	@return	The required ISecureSecSysGrpObj instance referenced by the SysGrp key.
	 */
	ISecureSecSysGrpObj getRequiredContainerSysGrp( boolean forceRead );

	/**
	 *	Set the ISecureSecSysGrpObj instance referenced by the SysGrp key.
	 *
	 *	@param	value	the ISecureSecSysGrpObj instance to be referenced by the SysGrp key.
	 */
	void setRequiredContainerSysGrp( ISecureSecSysGrpObj value );

	/**
	 *	Get a list ISecureSecClusGrpMembObj instances referenced by the MembByGrp key.
	 *
	 *	@return	The (potentially empty) list of ISecureSecClusGrpMembObj instances referenced by the MembByGrp key.
	 */
	List<ISecureSecClusGrpMembObj> getOptionalChildrenMembByGrp();

	/**
	 *	Get the required IYCFKeyHash256 attribute SecClusGrpId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecClusGrpId.
	 */
	IYCFKeyHash256 getRequiredSecClusGrpId();

	/**
	 *	Set the required IYCFKeyHash256 attribute SecClusGrpId.
	 *
	 *	@param value The required IYCFKeyHash256 attribute SecClusGrpId value to be applied.
	 */
	void setRequiredSecClusGrpId(IYCFKeyHash256 value);

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

	public void copyRecToOrig();
	public void copyOrigToRec();

}
