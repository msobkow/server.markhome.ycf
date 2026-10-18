// Description: Java 25 Protected Instance Edit Object interface for Secure SecSysGrpInc.

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

public interface ISecureProtSecSysGrpIncEditObj
	extends ISecureProtSecSysGrpIncObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecureProtSecSysGrpIncObj.
	 */
	ISecureProtSecSysGrpIncObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecureProtSecSysGrpIncObj.
	 */
	ISecureProtSecSysGrpIncObj getOrigAsSecSysGrpInc();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecureProtSecSysGrpIncObj create();

	/*
	 *	Update the instance.
	 */
	ISecureProtSecSysGrpIncEditObj update();

	/*
	 *	Delete the instance.
	 */
	ISecureProtSecSysGrpIncEditObj deleteInstance();

	/**
	 *	Set the user who created this instance.
	 *
	 *	@param	value	The ISecureProtSecUserObj instance who created this instance.
	 */
	void setCreatedBy( ISecureProtSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was created.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setCreatedAt( LocalDateTime value );

	/**
	 *	Set the user who updated this instance.
	 *
	 *	@param	value	The ISecureProtSecUserObj instance who updated this instance.
	 */
	void setUpdatedBy( ISecureProtSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was updated.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setUpdatedAt( LocalDateTime value );

	/**
	 *	Get the ISecureProtSecSysGrpObj instance referenced by the Group key.
	 *
	 *	@return	The ISecureProtSecSysGrpObj instance referenced by the Group key.
	 */
	ISecureProtSecSysGrpObj getRequiredContainerGroup();

	/**
	 *	Get the required ISecureProtSecSysGrpObj instance referenced by the Group key.
	 *
	 *	@return	The required ISecureProtSecSysGrpObj instance referenced by the Group key.
	 */
	ISecureProtSecSysGrpObj getRequiredContainerGroup( boolean forceRead );

	/**
	 *	Set the ISecureProtSecSysGrpObj instance referenced by the Group key.
	 *
	 *	@param	value	the ISecureProtSecSysGrpObj instance to be referenced by the Group key.
	 */
	void setRequiredContainerGroup( ISecureProtSecSysGrpObj value );

	/**
	 *	Get the ISecureProtSecSysGrpObj instance referenced by the SubGroup key.
	 *
	 *	@return	The ISecureProtSecSysGrpObj instance referenced by the SubGroup key.
	 */
	ISecureProtSecSysGrpObj getRequiredParentSubGroup();

	/**
	 *	Get the required ISecureProtSecSysGrpObj instance referenced by the SubGroup key.
	 *
	 *	@return	The required ISecureProtSecSysGrpObj instance referenced by the SubGroup key.
	 */
	ISecureProtSecSysGrpObj getRequiredParentSubGroup( boolean forceRead );

	/**
	 *	Set the ISecureProtSecSysGrpObj instance referenced by the SubGroup key.
	 *
	 *	@param	value	the ISecureProtSecSysGrpObj instance to be referenced by the SubGroup key.
	 */
	void setRequiredParentSubGroup( ISecureProtSecSysGrpObj value );

	/**
	 *	Get the required IYCFKeyHash256 attribute SecSysGrpId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecSysGrpId.
	 */
	IYCFKeyHash256 getRequiredSecSysGrpId();

	/**
	 *	Get the required String attribute InclName.
	 *
	 *	@return	The required String attribute InclName.
	 */
	String getRequiredInclName();

	public void copyRecToOrig();
	public void copyOrigToRec();

}
